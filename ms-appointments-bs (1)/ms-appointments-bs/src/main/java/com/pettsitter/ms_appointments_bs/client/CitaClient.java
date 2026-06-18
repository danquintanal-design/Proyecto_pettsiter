package com.pettsitter.ms_appointments_bs.client;

import com.pettsitter.ms_appointments_bs.dto.CitaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "ms-appointments-db", url = "${ms-appointments-db.url:http://localhost:8092}")
public interface CitaClient {

    @GetMapping("/citas")
    List<CitaDTO> obtenerTodasLasCitas();

    @GetMapping("/citas/{id}")
    CitaDTO obtenerCitaPorId(@PathVariable("id") Long id);

    @PostMapping("/citas")
    CitaDTO crearCita(@RequestBody CitaDTO citaDTO);

    @PutMapping("/citas/{id}")
    CitaDTO actualizarCita(@PathVariable("id") Long id, @RequestBody CitaDTO citaDTO);

    @DeleteMapping("/citas/{id}")
    void eliminarCita(@PathVariable("id") Long id);

    @GetMapping("/citas/mascota/{mascotaId}")
    List<CitaDTO> obtenerCitasPorMascota(@PathVariable("mascotaId") Long mascotaId);

    @GetMapping("/citas/estado/{estado}")
    List<CitaDTO> obtenerCitasPorEstado(@PathVariable("estado") String estado);

    @PatchMapping("/citas/{id}/estado/{nuevoEstado}")
    CitaDTO cambiarEstadoCita(@PathVariable("id") Long id, @PathVariable("nuevoEstado") String nuevoEstado);
}
