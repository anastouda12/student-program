package g43256.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g43256.webg5.pae.business.CourseDB;
import g43256.webg5.pae.model.Course;

@RestController
@RequestMapping(path = "/api/coursesjson")

/**
 * Controller Rest des cours
 */
public class CourseRestController {

    @Autowired
    private CourseDB courseService;

    @GetMapping
    public Iterable<Course> course() {
        return courseService.findAll();
    }

}