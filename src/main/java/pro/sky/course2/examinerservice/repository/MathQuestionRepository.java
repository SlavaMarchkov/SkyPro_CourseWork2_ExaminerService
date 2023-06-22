package pro.sky.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.course2.examinerservice.models.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    void init() {
        questions.add(new Question("2 * 3", "6"));
        questions.add(new Question("90 / 5", "18"));
        questions.add(new Question("2 ^ 4", "16"));
        questions.add(new Question("60 - 10", "50"));
        questions.add(new Question("55 + 55", "110"));
        questions.add(new Question("55 - 55", "0"));
        questions.add(new Question("5!", "120"));
        questions.add(new Question("8 * 8", "64"));
        questions.add(new Question("5 % 3", "2"));
        questions.add(new Question("log(2)", "8"));
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
