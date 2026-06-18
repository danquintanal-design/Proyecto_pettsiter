package com.pettsitter.ms_appointments_bff.client;

import com.pettsitter.ms_appointments_bff.dto.CitaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "ms-appointments-bs", url = "${ms-appointments-bs.url}")
public interface CitaClient {

    @GetMapping("/citas")
    List<CitaDto> obtenerTodasLasCitas();

    @GetMapping("/citas/{id}")
    CitaDto obtenerCitaPorId(@PathVariable("id") Long id);

    @PostMapping("/citas")
    CitaDto crearCita(@RequestBody CitaDto citaDTO);

    @PutMapping("/citas/{id}")
    CitaDto actualizarCita(@PathVariable("id") Long id, @RequestBody CitaDto citaDTO);

    @DeleteMapping("/citas/{id}")
    void eliminarCita(@PathVariable("id") Long id);

    @GetMapping("/citas/mascota/{mascotaId}")
    List<CitaDto> obtenerCitasPorMascota(@PathVariable("mascotaId") Long mascotaId);

    @GetMapping("/citas/estado/{estado}")
    List<CitaDto> obtenerCitasPorEstado(@PathVariable("estado") String estado);

    @PatchMapping("/citas/{id}/estado/{nuevoEstado}")
    CitaDto cambiarEstadoCita(@PathVariable("id") Long id, @PathVariable("nuevoEstado") String nuevoEstado);
}
