package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//Getter y Setter (DTO)
@Getter @Setter
public class DTOBook {

    //ID
    private int id;
    @NotBlank
    //Título del libro
    private String titulo;
    @NotBlank
    //ISBN
    private String isbn;
    private int año_publicacion;
    //Género
    private String genero;
    private int autor_id;
}
