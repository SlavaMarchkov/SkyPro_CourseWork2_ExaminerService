package pro.sky.course2.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.course2.examinerservice.services.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;
    private final Random random = new Random();

    @Autowired
    public JavaQuestionService(final JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }


    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        return javaQuestionRepository.add(q);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(javaQuestionRepository.getAll().size());
        List<Question> questionList = new ArrayList<>(javaQuestionRepository.getAll());
        return questionList.get(randomIndex);
    }

}
