package com.pettsitter.ms_appointments_db.service;

import com.pettsitter.ms_appointments_db.dto.CitaDTO;
import com.pettsitter.ms_appointments_db.entity.Cita;
import com.pettsitter.ms_appointments_db.entity.Cita.EstadoCita;
import com.pettsitter.ms_appointments_db.repository.CitaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<CitaDTO> obtenerTodasLasCitas() {
        return citaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CitaDTO obtenerCitaPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
        return convertirADTO(cita);
    }

    public CitaDTO crearCita(CitaDTO dto) {
        Cita cita = convertirAEntidad(dto);
        Cita citaGuardada = citaRepository.save(cita);
        return convertirADTO(citaGuardada);
    }

    public CitaDTO actualizarCita(Long id, CitaDTO dto) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

        cita.setMascotaId(dto.getMascotaId());
        cita.setTipoServicio(dto.getTipoServicio());
        cita.setFechaHora(dto.getFechaHora());
        cita.setDuracionMinutos(dto.getDuracionMinutos());
        cita.setEstado(dto.getEstado());
        cita.setNotas(dto.getNotas());
        cita.setCuidadorNombre(dto.getCuidadorNombre());

        Cita citaActualizada = citaRepository.save(cita);
        return convertirADTO(citaActualizada);
    }

    public void eliminarCita(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada con ID: " + id);
        }
        citaRepository.deleteById(id);
    }

    public List<CitaDTO> obtenerCitasPorMascota(Long mascotaId) {
        return citaRepository.findByMascotaId(mascotaId)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<CitaDTO> obtenerCitasPorEstado(String estado) {
        EstadoCita estadoCita = EstadoCita.valueOf(estado.toUpperCase());
        return citaRepository.findByEstado(estadoCita)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CitaDTO cambiarEstadoCita(Long id, String nuevoEstado) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

        EstadoCita estadoCita = EstadoCita.valueOf(nuevoEstado.toUpperCase());
        cita.setEstado(estadoCita);

        Cita citaActualizada = citaRepository.save(cita);
        return convertirADTO(citaActualizada);
    }

    private CitaDTO convertirADTO(Cita cita) {
        return new CitaDTO(
                cita.getId(),
                cita.getMascotaId(),
                cita.getTipoServicio(),
                cita.getFechaHora(),
                cita.getDuracionMinutos(),
                cita.getEstado(),
                cita.getNotas(),
                cita.getCuidadorNombre(),
                cita.getFechaCreacion()
        );
    }

    private Cita convertirAEntidad(CitaDTO dto) {
        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setMascotaId(dto.getMascotaId());
        cita.setTipoServicio(dto.getTipoServicio());
        cita.setFechaHora(dto.getFechaHora());
        cita.setDuracionMinutos(dto.getDuracionMinutos());
        cita.setEstado(dto.getEstado());
        cita.setNotas(dto.getNotas());
        cita.setCuidadorNombre(dto.getCuidadorNombre());
        return cita;
    }
}