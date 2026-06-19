package cl.app.ms_pets_db.service;

import cl.app.ms_pets_db.dto.MascotaDTO;
import cl.app.ms_pets_db.entity.Mascota;
import cl.app.ms_pets_db.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<MascotaDTO> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public MascotaDTO obtenerMascotaPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));
        return convertirADTO(mascota);
    }

    public MascotaDTO crearMascota(MascotaDTO dto) {
        Mascota mascota = convertirAEntidad(dto);
        Mascota mascotaGuardada = mascotaRepository.save(mascota);
        return convertirADTO(mascotaGuardada);
    }

    public MascotaDTO actualizarMascota(Long id, MascotaDTO dto) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));

        mascota.setNombre(dto.getNombre());
        mascota.setTipo(dto.getTipo());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setDuenoNombre(dto.getDuenoNombre());
        mascota.setDuenoEmail(dto.getDuenoEmail());
        mascota.setDuenoTelefono(dto.getDuenoTelefono());

        Mascota mascotaActualizada = mascotaRepository.save(mascota);
        return convertirADTO(mascotaActualizada);
    }

    public void eliminarMascota(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con ID: " + id);
        }
        mascotaRepository.deleteById(id);
    }

    public List<MascotaDTO> obtenerMascotasPorTipo(String tipo) {
        Mascota.TipoMascota tipoMascota = Mascota.TipoMascota.valueOf(tipo.toUpperCase());
        return mascotaRepository.findByTipo(tipoMascota)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Métodos de conversión
    private MascotaDTO convertirADTO(Mascota mascota) {
        return new MascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getTipo(),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getDuenoNombre(),
                mascota.getDuenoEmail(),
                mascota.getDuenoTelefono(),
                mascota.getFechaRegistro()
        );
    }

    private Mascota convertirAEntidad(MascotaDTO dto) {
        Mascota mascota = new Mascota();
        mascota.setId(dto.getId());
        mascota.setNombre(dto.getNombre());
        mascota.setTipo(dto.getTipo());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setDuenoNombre(dto.getDuenoNombre());
        mascota.setDuenoEmail(dto.getDuenoEmail());
        mascota.setDuenoTelefono(dto.getDuenoTelefono());
        return mascota;
    }
}

