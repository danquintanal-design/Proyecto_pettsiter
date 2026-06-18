package com.pettsitter.ms_appointments_bs.controller;

import com.pettsitter.ms_appointments_bs.dto.CitaDTO;
import com.pettsitter.ms_appointments_bs.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> obtenerTodasLasCitas() {
        return ResponseEntity.ok(citaService.obtenerTodasLasCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> obtenerCitaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(citaService.obtenerCitaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crearCita(@Valid @RequestBody CitaDTO citaDTO) {
        CitaDTO citaCreada = citaService.crearCita(citaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizarCita(
            @PathVariable("id") Long id,
            @Valid @RequestBody CitaDTO citaDTO) {
        return ResponseEntity.ok(citaService.actualizarCita(id, citaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable("id") Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<CitaDTO>> obtenerCitasPorMascota(@PathVariable("mascotaId") Long mascotaId) {
        return ResponseEntity.ok(citaService.obtenerCitasPorMascota(mascotaId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CitaDTO>> obtenerCitasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(citaService.obtenerCitasPorEstado(estado));
    }

    @PatchMapping("/{id}/estado/{nuevoEstado}")
    public ResponseEntity<CitaDTO> cambiarEstadoCita(
            @PathVariable("id") Long id,
            @PathVariable String nuevoEstado) {
        return ResponseEntity.ok(citaService.cambiarEstadoCita(id, nuevoEstado));
    }
}
