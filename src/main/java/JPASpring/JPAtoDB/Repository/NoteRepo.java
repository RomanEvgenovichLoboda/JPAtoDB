package JPASpring.JPAtoDB.Repository;

import org.springframework.data.repository.CrudRepository;
import JPASpring.JPAtoDB.Model.Note;
public interface NoteRepo extends CrudRepository<Note, Integer> {

}
