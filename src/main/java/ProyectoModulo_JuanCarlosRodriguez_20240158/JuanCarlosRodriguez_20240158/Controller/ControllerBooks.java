package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Controller;

import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Models.DTO.DTOBook;
import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Services.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //PUT
    @PutMapping

    //DELETE
    @DeleteMapping("/deleteBook/{idBook}")

}
