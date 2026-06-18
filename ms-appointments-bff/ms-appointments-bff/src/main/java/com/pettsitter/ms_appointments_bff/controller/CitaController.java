package com.pettsitter.ms_appointments_bff.controller;


import com.pettsitter.ms_appointments_bff.dto.CitaDto;
import com.pettsitter.ms_appointments_bff.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaDto>> obtenerTodasLasCitas() {
        return ResponseEntity.ok(citaService.obtenerTodasLasCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> obtenerCitaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.obtenerCitaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CitaDto> crearCita(@Valid @RequestBody CitaDto citaDTO) {
        CitaDto citaCreada = citaService.crearCita(citaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDto> actualizarCita(
            @PathVariable Long id,
            @Valid @RequestBody CitaDto citaDTO) {
        return ResponseEntity.ok(citaService.actualizarCita(id, citaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<CitaDto>> obtenerCitasPorMascota(@PathVariable Long mascotaId) {
        return ResponseEntity.ok(citaService.obtenerCitasPorMascota(mascotaId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CitaDto>> obtenerCitasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(citaService.obtenerCitasPorEstado(estado));
    }

    @PatchMapping("/{id}/estado/{nuevoEstado}")
    public ResponseEntity<CitaDto> cambiarEstadoCita(
            @PathVariable Long id,
            @PathVariable String nuevoEstado) {
        return ResponseEntity.ok(citaService.cambiarEstadoCita(id, nuevoEstado));
    }
}
