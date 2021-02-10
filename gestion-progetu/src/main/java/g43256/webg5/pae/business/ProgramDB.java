package g43256.webg5.pae.business;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import g43256.webg5.pae.model.Program;
import g43256.webg5.pae.model.ProgramId;

@Repository
public interface ProgramDB extends CrudRepository<Program, ProgramId> {

    List<Program> findByProgramIdCourseID(String courseID);

    List<Program> findByProgramIdStudentID(Integer studentID);

    Program findByProgramIdStudentIDAndProgramIdCourseID(Integer studentID, String courseID);

}