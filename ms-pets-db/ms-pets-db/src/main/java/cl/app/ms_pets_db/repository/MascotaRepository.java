package cl.app.ms_pets_db.repository;

import cl.app.ms_pets_db.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Métodos personalizados
    List<Mascota> findByTipo(Mascota.TipoMascota tipo);
    List<Mascota> findByDuenoEmail(String duenoEmail);
}
