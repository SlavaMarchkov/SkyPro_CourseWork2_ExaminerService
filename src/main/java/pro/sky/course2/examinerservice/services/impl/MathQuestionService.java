package pro.sky.course2.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.services.QuestionService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random = new Random();

    public MathQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomIndex);
    }

}
