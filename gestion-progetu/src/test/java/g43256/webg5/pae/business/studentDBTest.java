package g43256.webg5.pae.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import g43256.webg5.pae.model.Gender;
import g43256.webg5.pae.model.Section;
import g43256.webg5.pae.model.Student;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // By default DataJpaTest replaces your DataSource with an embedded
                                                   // database but you don't have one. So, if you want to test with
                                                   // MySQL, replace your test as follows:
public class studentDBTest {

    @Autowired
    StudentDB studentDB;

    @Test
    public void findById() {
        Student student = new Student(123, "Touda", "Anas", Gender.Homme, Section.GESTION, null);
        studentDB.save(student);
        Student found = studentDB.findById(student.getId()).get();
        assertEquals(student, found);
    }

}