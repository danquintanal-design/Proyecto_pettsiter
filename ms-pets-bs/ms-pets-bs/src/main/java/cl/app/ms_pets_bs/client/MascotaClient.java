package cl.app.ms_pets_bs.client;

import cl.app.ms_pets_bs.dto.MascotaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-pets-db", url = "${ms-pets-db.url}")

public interface MascotaClient {

    @GetMapping("/mascotas")
    List<MascotaDTO> obtenerTodasLasMascotas();

    @GetMapping("/mascotas/{id}")
    MascotaDTO obtenerMascotaPorId(@PathVariable Long id);

    @PostMapping("/mascotas")
    MascotaDTO crearMascota(@RequestBody MascotaDTO mascotaDTO);

    @PutMapping("/mascotas/{id}")
    MascotaDTO actualizarMascota(@PathVariable Long id, @RequestBody MascotaDTO mascotaDTO);

    @DeleteMapping("/mascotas/{id}")
    void eliminarMascota(@PathVariable Long id);

    @GetMapping("/mascotas/tipo/{tipo}")
    List<MascotaDTO> obtenerMascotasPorTipo(@PathVariable String tipo);
}
