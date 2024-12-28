package com.foliaco.proyecciones.entity;

import java.util.List;

import com.foliaco.proyecciones.dto.AutorDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NamedNativeQuery(
    name = "AutorDto.getAutoresDto",
    query = "SELECT nombre, apellido, nacionalidad, sexo FROM autores WHERE id = :id",
    resultSetMapping = "AutorDtoMapping"
)
@SqlResultSetMapping(
    name = "AutorDtoMapping",
    classes = {
        @ConstructorResult(
            targetClass = AutorDto.class,
            columns = {
                @ColumnResult(name = "nombre", type = String.class),
                @ColumnResult(name = "apellido", type = String.class),
                @ColumnResult(name = "nacionalidad", type = String.class),
                @ColumnResult(name = "sexo", type = String.class)
            }
        )
    }
)
public class AutorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String nacionalidad;

    @Column(nullable = false)
    private String fechaNacimiento;

    @Column(nullable = false)
    private String sexo;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibroEntity> libros;

}
