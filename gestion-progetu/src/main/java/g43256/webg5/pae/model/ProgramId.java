package g43256.webg5.pae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProgramId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8366206438367520096L;

    @JoinColumn(name = "studentID", referencedColumnName = "student.id")
    @Column(name = "studentID")
    private Integer studentID;

    @JoinColumn(name = "courseID", referencedColumnName = "course.id")
    @Column(name = "courseID")
    private String courseID;

}