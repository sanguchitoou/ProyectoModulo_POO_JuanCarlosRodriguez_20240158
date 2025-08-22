package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Services;

import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Entities.EntityBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Models.DTO.DTOBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Repositories.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Indicamos que es el SERVICIO
@Service
public class ServiceBook {
    @Autowired
    RepositoryBook objRepositoryBook;

    //Método GET
    public List<DTOBook> getBooks(){
        List<EntityBook> getAllBooks = objRepositoryBook.findAll();
        return getAllBooks.stream().map(this::convertTODTO).collect(Collectors.toList());
    }

    //Método POST


    //Método PUT


    //Método DELETE


    //Convertir a DTO
    private DTOBook convertTODTO(EntityBook entityBook){
        DTOBook objConvertDTO = new DTOBook();
        objConvertDTO.setId(entityBook.getId());
        objConvertDTO.setTitulo(entityBook.getTitulo());
        objConvertDTO.setIsbn(entityBook.getIsbn());
        objConvertDTO.setAño_publicacion(entityBook.getAño_publicacion());
        objConvertDTO.setGenero(entityBook.getGenero());
        objConvertDTO.setAutor_id(entityBook.getAutor_id());
        return objConvertDTO;
    }

    //Convertir a Entity
    private EntityBook convertTOEntity(DTOBook dtoBook){
        EntityBook objConvertEntity = new EntityBook();
        objConvertEntity.setId(dtoBook.getId());
        objConvertEntity.setTitulo(dtoBook.getTitulo());
        objConvertEntity.setIsbn(dtoBook.getIsbn());
        objConvertEntity.setAño_publicacion(dtoBook.getAño_publicacion());
        objConvertEntity.setGenero(dtoBook.getGenero());
        objConvertEntity.setAutor_id(dtoBook.getAutor_id());
        return objConvertEntity;
    }
}
