package ar.com.nextfix.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //toString, equals, hashcode, getters y los setters
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "La nacionalidad no puede estar en blanco")
    @Size(min = 3, max = 20)
    private String nacionalidad;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El email no puede estar en blanco")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El formato del email no es válido")
    private String email;

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
    private List<Pelicula> peliculasDirigidas = new ArrayList<>();

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL)
    private Usuario usuario;
}
