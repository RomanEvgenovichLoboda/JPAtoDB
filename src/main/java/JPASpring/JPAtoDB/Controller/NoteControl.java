package JPASpring.JPAtoDB.Controller;
import JPASpring.JPAtoDB.Model.Note;
import JPASpring.JPAtoDB.Repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller // This means that this class is a Controller
@RequestMapping(path="/note") // This means URL's start with /demo (after Application path)
public class NoteControl {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private NoteRepo noteRepo;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String avtor
            , @RequestParam String text) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Note note = new Note(avtor,text, LocalDateTime.now());

        noteRepo.save(note);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Note> getAllUsers() {
        // This returns a JSON or XML with the users
        return noteRepo.findAll();
    }
}
