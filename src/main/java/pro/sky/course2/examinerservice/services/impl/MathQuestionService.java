package pro.sky.course2.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.repository.MathQuestionRepository;
import pro.sky.course2.examinerservice.services.QuestionService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;
    private final Random random = new Random();

    @Autowired
    public MathQuestionService(final MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        return mathQuestionRepository.add(q);
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(mathQuestionRepository.getAll().size());
        List<Question> questionList = new ArrayList<>(mathQuestionRepository.getAll());
        return questionList.get(randomIndex);
    }

}
