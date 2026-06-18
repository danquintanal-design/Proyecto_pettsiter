package com.pettsitter.ms_appointments_db.repository;

import com.pettsitter.ms_appointments_db.entity.Cita;
import com.pettsitter.ms_appointments_db.entity.Cita.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface CitaRepository extends JpaRepository<Cita, Long> {

    // Buscar citas por mascota
    List<Cita> findByMascotaId(Long mascotaId);

    // Buscar citas por estado
    List<Cita> findByEstado(EstadoCita estado);

    // Buscar citas por cuidador
    List<Cita> findByCuidadorNombre(String cuidadorNombre);

    // Buscar citas en un rango de fechas
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
}