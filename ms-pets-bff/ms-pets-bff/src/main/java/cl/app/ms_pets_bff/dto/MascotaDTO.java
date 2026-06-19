package cl.app.ms_pets_bff.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {

    private Long id;

    @NotBlank(message = "El nombre de la mascota es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombre;

    @NotNull(message = "El tipo de mascota es obligatorio")
    private TipoMascota tipo;

    @Size(max = 100, message = "La raza no puede exceder 100 caracteres")
    private String raza;

    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 30, message = "La edad no puede exceder 30 años")
    private Integer edad;

    @NotBlank(message = "El nombre del dueño es obligatorio")
    @Size(max = 150, message = "El nombre del dueño no puede exceder 150 caracteres")
    private String duenoNombre;

    @NotBlank(message = "El email del dueño es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    private String duenoEmail;

    @Pattern(regexp = "^[0-9+\\-\\s()]*$", message = "El teléfono solo puede contener números y caracteres especiales")
    private String duenoTelefono;

    private LocalDateTime fechaRegistro;

    public enum TipoMascota {
        PERRO, GATO
    }
}
