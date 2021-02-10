package g43256.webg5.pae.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @Positive
    private Integer id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*", message = "Le nom est composé que de lettre")
    private String name;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*", message = "Le prénom est composé que de lettre")
    private String firstname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Section section;

    @OneToMany(mappedBy = "programId.studentID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Program> programs;

}