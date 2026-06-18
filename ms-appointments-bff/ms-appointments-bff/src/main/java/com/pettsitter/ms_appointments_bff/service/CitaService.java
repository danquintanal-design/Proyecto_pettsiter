package com.pettsitter.ms_appointments_bff.service;

import com.pettsitter.ms_appointments_bff.client.CitaClient;
import com.pettsitter.ms_appointments_bff.dto.CitaDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    private final CitaClient citaClient;

    public CitaService(CitaClient citaClient) {
        this.citaClient = citaClient;
    }

    public List<CitaDto> obtenerTodasLasCitas() {
        return citaClient.obtenerTodasLasCitas();
    }

    public CitaDto obtenerCitaPorId(Long id) {
        return citaClient.obtenerCitaPorId(id);
    }

    public CitaDto crearCita(CitaDto citaDTO) {
        return citaClient.crearCita(citaDTO);
    }

    public CitaDto actualizarCita(Long id, CitaDto citaDTO) {
        return citaClient.actualizarCita(id, citaDTO);
    }

    public void eliminarCita(Long id) {
        citaClient.eliminarCita(id);
    }

    public List<CitaDto> obtenerCitasPorMascota(Long mascotaId) {
        return citaClient.obtenerCitasPorMascota(mascotaId);
    }

    public List<CitaDto> obtenerCitasPorEstado(String estado) {
        return citaClient.obtenerCitasPorEstado(estado);
    }

    public CitaDto cambiarEstadoCita(Long id, String nuevoEstado) {
        return citaClient.cambiarEstadoCita(id, nuevoEstado);
    }
}