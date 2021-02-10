package g43256.webg5.pae.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // Obligatoire pour une entité

public class Course {

    @Id
    @NotEmpty
    @Size(min = 3, max = 7)
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "L'id est composé de lettre et chiffre")
    private String id;

    @NotEmpty
    @Size(min = 3, max = 30)
    private String libe;

    @NotEmpty
    @Pattern(regexp = "[1-9]*", message = "Les ects est composé que de chiffre")
    private String ects;

    @OneToMany(mappedBy = "programId.courseID",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<Program> programs;

}