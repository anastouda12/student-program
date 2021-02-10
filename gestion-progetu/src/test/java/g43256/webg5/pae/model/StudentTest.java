package g43256.webg5.pae.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import g43256.webg5.pae.BeanValidationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private BeanValidationUtil<Student> validator;

    @Test
    public void studentValid() {
        Student student = new Student(990, "brik", "bob", Gender.Femme, Section.INDUSTRIEL, null);
        validator.assertIsValid(student);

    }

    @Test
    public void studentNotValidWithNegative() {
        Student student = new Student(-1, "touda", "anas", Gender.Homme, Section.GESTION, null);
        validator.assertHasError(student, "id", Positive.class);

    }

    @Test
    public void studentNotValidWithBlankName() {
        Student student = new Student(1, "", "anas", Gender.Homme, Section.GESTION, null);
        validator.assertHasError(student, "name", NotBlank.class);

    }

    @Test
    public void studentNotValidWithNameWithNotOnlyLetters() {
        Student student = new Student(1, "12**!", "anas", Gender.Homme, Section.GESTION, null);
        validator.assertHasError(student, "name", Pattern.class);

    }

    @Test
    public void studentNotValidWithBlankFirstName() {
        Student student = new Student(1, "to", "", Gender.Homme, Section.GESTION, null);
        validator.assertHasError(student, "firstname", NotBlank.class);

    }

    @Test
    public void studentNotValidWithFirstNameWithNotOnlyLetters() {
        Student student = new Student(1, "to", "1+/..", Gender.Homme, Section.GESTION, null);
        validator.assertHasError(student, "firstname", Pattern.class);

    }

}