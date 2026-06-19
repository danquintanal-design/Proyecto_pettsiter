package cl.app.ms_pets_db.controller;

import cl.app.ms_pets_db.dto.MascotaDTO;
import cl.app.ms_pets_db.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> obtenerTodasLasMascotas() {
        return ResponseEntity.ok(mascotaService.obtenerTodasLasMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerMascotaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.obtenerMascotaPorId(id));
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> crearMascota(@Valid @RequestBody MascotaDTO mascotaDTO) {
        MascotaDTO mascotaCreada = mascotaService.crearMascota(mascotaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> actualizarMascota(
            @PathVariable Long id,
            @Valid @RequestBody MascotaDTO mascotaDTO) {
        return ResponseEntity.ok(mascotaService.actualizarMascota(id, mascotaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MascotaDTO>> obtenerMascotasPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(mascotaService.obtenerMascotasPorTipo(tipo));
    }
}
