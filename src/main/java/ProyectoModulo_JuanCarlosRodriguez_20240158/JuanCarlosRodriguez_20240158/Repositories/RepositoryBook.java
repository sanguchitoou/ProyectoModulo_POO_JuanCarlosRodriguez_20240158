package ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Repositories;

import ProyectoModulo_JuanCarlosRodriguez_20240158.JuanCarlosRodriguez_20240158.Entities.EntityBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio de referencia a la tabla del CRUD
@Repository
public interface RepositoryBook extends JpaRepository<EntityBook, Long> {
}
