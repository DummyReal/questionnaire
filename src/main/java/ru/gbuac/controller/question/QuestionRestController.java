package ru.gbuac.controller.question;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.Question;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = QuestionRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionRestController extends AbstractQuestionRestController {

    public static final String REST_URL = "/rest/profile/quests/{questId}/questions";
    @Override
    @GetMapping(value = "/{id}")
    public Question get(@PathVariable("id") int id, @PathVariable("id") int questId) {
        return super.get(id, questId);
    }

    @Override
    @GetMapping("/getAllById")
    public List<Question> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Question updateOrCreate(@Valid @RequestBody Question question) {
        if (question.isNew()) {
            return super.create(question);
        } else {
            return super.update(question, question.getId());
        }
    }

    @Override
    @GetMapping
    public List<Question> getAll(@PathVariable("questId") int questId) {
        return super.getAll(questId);
    }
}
