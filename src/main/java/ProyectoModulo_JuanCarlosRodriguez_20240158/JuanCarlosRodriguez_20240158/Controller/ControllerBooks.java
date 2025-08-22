package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Controller;

import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Models.DTO.DTOBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Services.ServiceBook;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Controlador con propiedades REST
@RestController
@RequestMapping("/apiBooks")
public class ControllerBooks {
    //Inyección del servicio
    @Autowired
    private ServiceBook objServiceBook;

    //GET
    @GetMapping("/getBooks")
    public List<DTOBook> getBook(){
        return objServiceBook.getBooks();
    }

    //GET por ID
    @GetMapping("/getBooks/{id}")
    public List<DTOBook> getIdBook(@PathVariable int id){
        return objServiceBook.getBooks();
    }

    //POST
    @PostMapping("/postBook")
    public ResponseEntity<?> postBook(@RequestParam DTOBook dtoBook){
        try{
            DTOBook objVerifyBook = objServiceBook.postBook(dtoBook);
            if (objVerifyBook == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Error al ingresar los datos, intentelo denuevo",
                        "error_type", "VALIDATION_ERROR",
                        "message", "Datos mal ingresados"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "Datos del LIBRO ingresados correctamente",
                    "answer", objVerifyBook
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error no controlado",
                    "message", "No se pudo ingresar los datos del libro",
                    "answer", e.getMessage()
            ));
        }
    }

    //PUT
    @PutMapping("/putBook/{id}")
    public ResponseEntity<?> putBook(@RequestParam DTOBook dtoBook, @PathVariable Long id){
        try{
            DTOBook objVerifyBook = objServiceBook.putBook(dtoBook, id);
            if (objVerifyBook == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Error al actualizar los datos, intentelo denuevo",
                        "error_type", "VALIDATION_ERROR",
                        "message", "Datos mal ingresados"
                ));
            }
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "status", "Datos del LIBRO actualizados correctamente",
                    "answer", objVerifyBook
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error no controlado",
                    "message", "No se pudo actualizar los datos del libro",
                    "answer", e.getMessage()
            ));
        }
    }

    //DELETE
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        try{
            if (!objServiceBook.removeBook(id)){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Error al eliminar el libro, intentelo denuevo",
                        "error_type", "VALIDATION_ERROR",
                        "message", "Libro no encontrado"
                ));
            }
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "status", "El libro ha sido eliminado correctamente"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error no controlado",
                    "message", "No se pudo eliminar el libro",
                    "answer", e.getMessage()
            ));
        }
    }
}
