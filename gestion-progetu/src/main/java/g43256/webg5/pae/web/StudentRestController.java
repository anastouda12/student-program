package g43256.webg5.pae.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g43256.webg5.pae.business.StudentDB;
import g43256.webg5.pae.model.Student;

@RestController
@RequestMapping(path = "/api/studentjson/{id}")
/**
 * Controller Rest des étudiants
 */
public class StudentRestController {

    @Autowired
    StudentDB studentDB;

    @GetMapping
    public Optional<Student> getAStudent(@PathVariable int id) {
        return studentDB.findById(id);
    }

}
