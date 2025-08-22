package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Entities;

import jakarta.persistence.*;
import lombok.*;

//Declaración de variables de ENTIDAD
@Entity
@Table(name = "LIBROS")
@Getter @Setter @ToString @EqualsAndHashCode
public class EntityBook {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libros")
    @SequenceGenerator(name = "seq_libros", sequenceName = "seq_libros", allocationSize = 1)
    @Column(name = "ID")
    private int id;
    //Titulo
    @Column(name = "TITULO")
    private String titulo;
    //ISBN
    @Column(name = "ISBN")
    private String isbn;
    //Año de la publicación
    @Column(name = "AÑO_PUBLICACION")
    private int año_publicacion;
    //Genero
    @Column(name = "GENERO")
    private String genero;
    //ID del autor
    @Column(name = "AUTOR_ID")
    private int autor_id;
}
