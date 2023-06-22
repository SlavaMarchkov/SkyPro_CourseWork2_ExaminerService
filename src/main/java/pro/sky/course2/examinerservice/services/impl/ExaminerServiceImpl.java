package pro.sky.course2.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") final QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") final QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions() {
        List<Question> examQuestions = new ArrayList<>();

        int amountJava = random.nextInt(0, javaQuestionService.getAll().size() + 1);
        int amountMath = random.nextInt(0, mathQuestionService.getAll().size() + 1);

        while (examQuestions.size() < (amountJava + amountMath)) {
            addRandomQuestionToQuestionList(javaQuestionService, examQuestions);
            addRandomQuestionToQuestionList(mathQuestionService, examQuestions);
        }

        return examQuestions;
    }

    private void addRandomQuestionToQuestionList(final QuestionService questionService,
                                                 final List<Question> examQuestions
    ) {
            Question question = questionService.getRandomQuestion();
            if (!examQuestions.contains(question)) {
                examQuestions.add(question);
            }
    }

}
