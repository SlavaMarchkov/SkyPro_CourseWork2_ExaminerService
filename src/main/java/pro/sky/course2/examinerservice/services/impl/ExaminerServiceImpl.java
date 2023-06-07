package pro.sky.course2.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.services.ExaminerService;
import pro.sky.course2.examinerservice.services.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    @Autowired
    public ExaminerServiceImpl(final QuestionService javaQuestionService,
                               final QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions() {
        int amountJava = random.nextInt(javaQuestionService.getAll().size());
        int amountMath = random.nextInt(mathQuestionService.getAll().size());

        List<Question> questionList = new ArrayList<>();

        addRandomQuestionToQuestionList(javaQuestionService, questionList, amountJava);
        addRandomQuestionToQuestionList(mathQuestionService, questionList, amountMath);

        return questionList;
    }

    private void addRandomQuestionToQuestionList(final QuestionService questionService,
                                                 final List<Question> questionList,
                                                 int amount) {
        while (questionList.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (!questionList.contains(question)) {
                questionList.add(question);
            }
        }
    }

}
