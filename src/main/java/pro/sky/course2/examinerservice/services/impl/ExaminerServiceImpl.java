package pro.sky.course2.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.exceptions.RequestOverSizeException;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.services.ExaminerService;
import pro.sky.course2.examinerservice.services.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new RequestOverSizeException("Запрошено большее количество вопросов, чем хранится в сервисе");
        }
        List<Question> questionList = new ArrayList<>();
        while (questionList.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (!questionList.contains(question)) {
                questionList.add(question);
            }
        }
        return questionList;
    }

}
