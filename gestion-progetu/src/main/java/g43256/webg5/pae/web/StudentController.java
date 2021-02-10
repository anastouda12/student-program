package g43256.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import g43256.webg5.pae.business.CourseDB;
import g43256.webg5.pae.business.ProgramDB;
import g43256.webg5.pae.business.StudentDB;
import g43256.webg5.pae.model.Course;
import g43256.webg5.pae.model.Gender;
import g43256.webg5.pae.model.Program;
import g43256.webg5.pae.model.Section;
import g43256.webg5.pae.model.Student;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * StudentController
 */
@Controller
public class StudentController {

    @Autowired
    private StudentDB studentDB;

    @Autowired
    private ProgramDB programDB;

    @Autowired
    private CourseDB courseDB;

    @GetMapping("/students")
    public String showIndex(Model model) {
        Iterable<Student> students = studentDB.findAll();
        model.addAttribute("students", students);
        model.addAttribute("studentToAdd", new Student());
        model.addAttribute("sectionList", Section.values()); // Values des sections
        model.addAttribute("genderList", Gender.values()); // Gender des sections
        return "students";
    }

    @GetMapping("/students/{id}/courses")
    public String showProgram(@PathVariable Integer id, Model model) {
        Optional<Student> student = studentDB.findById(id);
        model.addAttribute("student", student);
        Iterable<Program> programs = programDB.findByProgramIdStudentID(id);
        List<Course> courses = new ArrayList<Course>();
        int totalEcts = 0; // total crédits du programme
        for (Program program : programs) {
            Optional<Course> course = courseDB.findById(program.getProgramId().getCourseID());
            if (course.isPresent()) {
                courses.add(course.get()); // On ajoute chaque cours, récupéré grace, au son ID, dans une
                                           // liste
                totalEcts += Integer.parseInt(course.get().getEcts());
            }
        }
        model.addAttribute("courses", courses);
        model.addAttribute("programToAdd", new Program());
        model.addAttribute("totalCreditProg", totalEcts);
        model.addAttribute("allCourses", courseDB.findAll());
        return "studentProgram";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String doSomething(@Valid Student studentToAdd, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return showIndex(model);
        }
        studentDB.save(studentToAdd);
        return showIndex(model);
    }

    @RequestMapping(value = "/students/{id}/add/courses", method = RequestMethod.POST)
    public String addCourseToProg(@PathVariable Integer id, @Valid Program programToAdd, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return showIndex(model);
        }
        programToAdd.getProgramId().setStudentID(id);
        programDB.save(programToAdd);
        return "redirect:/students/{id}/courses";
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        studentDB.deleteById(id);
        redirectAttributes.addFlashAttribute("succes", true);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/{idStudent}/delete/courses/{idCourse}", method = RequestMethod.POST)
    public String deleteCourseOfProg(@PathVariable String idCourse, @PathVariable Integer idStudent) {
        programDB.delete(programDB.findByProgramIdStudentIDAndProgramIdCourseID(idStudent, idCourse));
        return "redirect:/students/{idStudent}/courses";
    }

}