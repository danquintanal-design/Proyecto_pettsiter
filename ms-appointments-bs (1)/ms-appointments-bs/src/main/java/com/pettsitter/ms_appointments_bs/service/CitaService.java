package com.pettsitter.ms_appointments_bs.service;

import com.pettsitter.ms_appointments_bs.client.CitaClient;
import com.pettsitter.ms_appointments_bs.dto.CitaDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    private final CitaClient citaClient;

    public CitaService(CitaClient citaClient) {
        this.citaClient = citaClient;
    }

    public List<CitaDTO> obtenerTodasLasCitas() {
        return citaClient.obtenerTodasLasCitas();
    }

    public CitaDTO obtenerCitaPorId(Long id) {
        return citaClient.obtenerCitaPorId(id);
    }

    public CitaDTO crearCita(CitaDTO citaDTO) {
        validarCita(citaDTO);
        return citaClient.crearCita(citaDTO);
    }

    public CitaDTO actualizarCita(Long id, CitaDTO citaDTO) {
        validarCita(citaDTO);
        return citaClient.actualizarCita(id, citaDTO);
    }

    public void eliminarCita(Long id) {
        citaClient.eliminarCita(id);
    }

    public List<CitaDTO> obtenerCitasPorMascota(Long mascotaId) {
        return citaClient.obtenerCitasPorMascota(mascotaId);
    }

    public List<CitaDTO> obtenerCitasPorEstado(String estado) {
        return citaClient.obtenerCitasPorEstado(estado);
    }

    public CitaDTO cambiarEstadoCita(Long id, String nuevoEstado) {
        return citaClient.cambiarEstadoCita(id, nuevoEstado);
    }

    private void validarCita(CitaDTO citaDTO) {
        if (citaDTO.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La fecha de la cita no puede ser en el pasado");
        }

        int hora = citaDTO.getFechaHora().getHour();
        if (hora < 8 || hora >= 20) {
            throw new RuntimeException("Las citas solo pueden ser entre las 8:00 AM y las 8:00 PM");
        }

        if (citaDTO.getTipoServicio() == CitaDTO.TipoServicio.PASEO) {
            if (citaDTO.getDuracionMinutos() < 30) {
                throw new RuntimeException("Los paseos deben durar al menos 30 minutos");
            }
        }

        if (citaDTO.getTipoServicio() == CitaDTO.TipoServicio.GUARDERIA) {
            if (citaDTO.getDuracionMinutos() < 120) {
                throw new RuntimeException("La guardería debe durar al menos 2 horas (120 minutos)");
            }
        }

        System.out.println("✅ Validaciones de negocio superadas con éxito.");
    }
}
