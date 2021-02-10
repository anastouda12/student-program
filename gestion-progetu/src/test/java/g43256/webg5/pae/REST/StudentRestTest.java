package g43256.webg5.pae.REST;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import g43256.webg5.pae.business.StudentDB;
import g43256.webg5.pae.model.Gender;
import g43256.webg5.pae.model.Section;
import g43256.webg5.pae.model.Student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // By default DataJpaTest replaces your DataSource with an embedded
                                                   // database but you don't have one. So, if you want to test with
                                                   // MySQL, replace your test as follows:
public class StudentRestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    StudentDB studentDB;

    @Test
    public void getStudentById() throws Exception {
        int id = 43256;
        Student student = new Student(id, "anas", "touda", Gender.Homme, Section.GESTION, null);
        Mockito.when(studentDB.findById(id).get()).thenReturn(student);
        mvc.perform(get("/api/studentjson/43256")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(43256));
    }
}