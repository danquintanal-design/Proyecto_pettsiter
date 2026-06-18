package com.pettsitter.ms_appointments_bff.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDto {
    private Long id;

    @NotNull(message = "El ID de la mascota es obligatorio")
    private Long mascotaId;

    @NotNull(message = "El tipo de servicio es obligatorio")
    private TipoServicio tipoServicio;

    @NotNull(message = "La fecha y hora son obligatorias")
    @Future(message = "La fecha debe ser futura")
    private LocalDateTime fechaHora;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 15, message = "La duración mínima es 15 minutos")
    @Max(value = 480, message = "La duración máxima es 480 minutos (8 horas)")
    private Integer duracionMinutos;

    private EstadoCita estado;

    @Size(max = 1000, message = "Las notas no pueden exceder 1000 caracteres")
    private String notas;

    @NotBlank(message = "El nombre del cuidador es obligatorio")
    @Size(max = 150, message = "El nombre del cuidador no puede exceder 150 caracteres")
    private String cuidadorNombre;

    private LocalDateTime fechaCreacion;

    public enum TipoServicio {
        PASEO, GUARDERIA, ALIMENTACION
    }

    public enum EstadoCita {
        PROGRAMADA, EN_CURSO, COMPLETADA, CANCELADA
    }
}
