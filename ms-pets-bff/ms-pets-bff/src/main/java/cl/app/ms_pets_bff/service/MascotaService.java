package cl.app.ms_pets_bff.service;

import cl.app.ms_pets_bff.client.MascotaClient;
import cl.app.ms_pets_bff.dto.MascotaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaClient mascotaClient;

    public MascotaService(MascotaClient mascotaClient) {
        this.mascotaClient = mascotaClient;
    }

    public List<MascotaDTO> obtenerTodasLasMascotas() {
        // Aquí podrías agregar lógica de negocio adicional
        return mascotaClient.obtenerTodasLasMascotas();
    }

    public MascotaDTO obtenerMascotaPorId(Long id) {
        return mascotaClient.obtenerMascotaPorId(id);
    }

    public MascotaDTO crearMascota(MascotaDTO mascotaDTO) {
        // Validaciones de negocio adicionales
        validarDatosNegocio(mascotaDTO);
        return mascotaClient.crearMascota(mascotaDTO);
    }

    public MascotaDTO actualizarMascota(Long id, MascotaDTO mascotaDTO) {
        validarDatosNegocio(mascotaDTO);
        return mascotaClient.actualizarMascota(id, mascotaDTO);
    }

    public void eliminarMascota(Long id) {
        mascotaClient.eliminarMascota(id);
    }

    public List<MascotaDTO> obtenerMascotasPorTipo(String tipo) {
        return mascotaClient.obtenerMascotasPorTipo(tipo);
    }

    // Lógica de negocio personalizada
    private void validarDatosNegocio(MascotaDTO mascotaDTO) {
        // Ejemplo: validar que los perros mayores de 10 años tengan nota especial
        if (mascotaDTO.getTipo() == MascotaDTO.TipoMascota.PERRO && mascotaDTO.getEdad() != null && mascotaDTO.getEdad() > 10) {
            System.out.println("⚠️ Mascota senior detectada - considerar cuidados especiales");
        }
    }
}
