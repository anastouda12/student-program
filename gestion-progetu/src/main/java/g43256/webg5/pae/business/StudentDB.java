package g43256.webg5.pae.business;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import g43256.webg5.pae.model.Student;

// Integer type de la clé primaire
@Repository
public interface StudentDB extends CrudRepository<Student, Integer> {

}