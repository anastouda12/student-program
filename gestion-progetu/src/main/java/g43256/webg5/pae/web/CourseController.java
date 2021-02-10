package g43256.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import g43256.webg5.pae.business.CourseDB;
import g43256.webg5.pae.business.ProgramDB;
import g43256.webg5.pae.business.StudentDB;
import g43256.webg5.pae.model.Course;
import g43256.webg5.pae.model.Program;
import g43256.webg5.pae.model.Student;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * CourseController
 */
@Controller
public class CourseController {

    @Autowired
    private CourseDB courseDB;
    @Autowired
    private ProgramDB programDB;
    @Autowired
    private StudentDB studentDB;

    @GetMapping("/courses")
    public String showIndex(Model model) {
        Iterable<Course> courses = courseDB.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("courseToAdd", new Course());
        return "courses";
    }

    @GetMapping("/courses/{id}/students")
    public String show(@PathVariable String id, Model model) {
        Optional<Course> course = courseDB.findById(id);
        model.addAttribute("course", course);
        Iterable<Program> programs = programDB.findByProgramIdCourseID(id);
        List<Student> students = new ArrayList<Student>();
        for (Program program : programs) {
            Optional<Student> student = studentDB.findById(program.getProgramId().getStudentID());
            if (student.isPresent()) {
                students.add(student.get()); // On ajoute chaque Student, récupéré grace, au son ID, dans une
                                             // liste
            }
        }
        model.addAttribute("students", students);
        model.addAttribute("programToAdd", new Program());
        model.addAttribute("allStudents", studentDB.findAll());
        return "studentCourse";
    }

    @RequestMapping(value = "/courses/{id}/add/student", method = RequestMethod.POST)
    public String addStudent(@PathVariable String id, @Valid Program programToAdd, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return showIndex(model);
        }
        programToAdd.getProgramId().setCourseID(id);
        programDB.save(programToAdd);
        return "redirect:/courses/{id}/students";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public String doSomething(@Valid Course courseToAdd, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return showIndex(model);
        }
        courseDB.save(courseToAdd);
        return showIndex(model);
    }

    @RequestMapping(value = "/courses/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        Optional<Course> course = courseDB.findById(id);
        if (course.isPresent()) {
            courseDB.deleteById(id);
        }
        return "redirect:/courses";
    }

    @RequestMapping(value = "/courses/{idCourse}/delete/student/{idStudent}", method = RequestMethod.POST)
    public String deleteStudentCourse(@PathVariable String idCourse, @PathVariable Integer idStudent) {
        programDB.delete(programDB.findByProgramIdStudentIDAndProgramIdCourseID(idStudent, idCourse));
        return "redirect:/courses/{idCourse}/students";
    }

}
