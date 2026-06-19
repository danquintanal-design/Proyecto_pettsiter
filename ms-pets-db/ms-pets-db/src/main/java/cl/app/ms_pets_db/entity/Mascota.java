package cl.app.ms_pets_db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "mascota")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMascota tipo;

    @Column(length = 100)
    private String raza;

    private Integer edad;

    @Column(name = "dueno_nombre", nullable = false, length = 150)
    private String duenoNombre;

    @Column(name = "dueno_email", nullable = false, length = 150)
    private String duenoEmail;

    @Column(name = "dueno_telefono", length = 20)
    private String duenoTelefono;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public enum TipoMascota {
        PERRO, GATO
    }
}
