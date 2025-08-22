package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Services;

import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Entities.EntityBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Models.DTO.DTOBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Repositories.RepositoryBook;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    //Método GET por ID
    public EntityBook getBookByID(Long id) {
        Optional<EntityBook> objBookOptional = objRepositoryBook.findById(id);
        return objBookOptional.orElse(null);
    }

    //Método POST
    public DTOBook postBook (DTOBook dtoBook){
        if (dtoBook == null){
            throw new IllegalArgumentException("Los datos no pueden estar vacíos");
        }
        try {
            EntityBook objPostBook = objRepositoryBook.save(convertTOEntity(dtoBook));
            return convertTODTO(objPostBook);
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    //Método PUT
    public DTOBook putBook(DTOBook dtoBook, Long id) {
        if(dtoBook == null){
            throw new IllegalArgumentException("No pueden haber campos vacíos");
        }

        //Creamos variable entidad de valores existentes de los libros
        EntityBook bookExists = objRepositoryBook.findById(id).orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con el id: " + id));

        //Variables que se pueden actualizar
        bookExists.setTitulo(dtoBook.getTitulo());
        bookExists.setIsbn(dtoBook.getIsbn());
        bookExists.setAño_publicacion(dtoBook.getAño_publicacion());
        bookExists.setGenero(dtoBook.getGenero());
        bookExists.setAutor_id(dtoBook.getAutor_id());

        EntityBook area = objRepositoryBook.save(bookExists);

        return convertTODTO(area);
    }

    //Método DELETE
    public boolean removeBook(Long id){
        try{
            //Verificamos que el ID no sea nulo
            if (id == null) {
                throw new IllegalArgumentException("El ID del libro no puede ser nulo o vacío");
            }

            //Verificamos la existencia
            boolean existsIdBook = objRepositoryBook.existsById(id);
            if (!existsIdBook) {
                throw new EntityNotFoundException("No se encontró el área con ID: " + id);
            }

            //Removemos el libro
            objRepositoryBook.deleteById(id);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se encontró el libro registrado");
        }
    }

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
