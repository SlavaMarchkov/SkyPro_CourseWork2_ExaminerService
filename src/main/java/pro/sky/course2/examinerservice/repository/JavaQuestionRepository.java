package pro.sky.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.course2.examinerservice.models.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    void init() {
        for (int i = 1; i <= 10; i++) {
            questions.add(new Question("Question" + i, "Answer" + i));
        }
    }

    @Override
    public Question add(final Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(final Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

}
