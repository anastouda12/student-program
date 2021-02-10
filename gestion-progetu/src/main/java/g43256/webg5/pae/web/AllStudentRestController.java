package g43256.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g43256.webg5.pae.business.StudentDB;
import g43256.webg5.pae.model.Student;

@RestController
@RequestMapping(path = "/api/studentsjson")
/**
 * Controller Rest des étudiants
 */
public class AllStudentRestController {

    @Autowired
    StudentDB studentDB;

    @GetMapping
    public Iterable<Student> getAStudent() {
        return studentDB.findAll();
    }

}
