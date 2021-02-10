package g43256.webg5.pae.website;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import g43256.webg5.pae.web.StudentController;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class) // la class testé
@AutoConfigureTestDatabase(replace = Replace.NONE) // By default DataJpaTest replaces your DataSource with an embedded
                                                   // database but you don't have one. So, if you want to test with
                                                   // MySQL, replace your test as follows:
public class TestStudentWeb {

    @Autowired
    private MockMvc mockMvc; // Permet de simuler le navigateur

    @Test
    public void testStudentPage() throws Exception {
        mockMvc.perform(get("/students")) // L’url à tester
                .andExpect(status().isOk()) // La page est retournée
                .andExpect(view().name("students")) // Générée à partir du template welcome
                // Elle contient le texte attendu
                .andExpect(content().string(Matchers.containsString("Etudiants inscrits")));
    }

}