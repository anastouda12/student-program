package g43256.webg5.pae.business;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import g43256.webg5.pae.model.Course;

// String type de la clé primaire
@Repository
public interface CourseDB extends CrudRepository<Course, String> {

}