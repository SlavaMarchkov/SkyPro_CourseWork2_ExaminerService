package pro.sky.course2.examinerservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.examinerservice.exceptions.RequestOverSizeException;
import pro.sky.course2.examinerservice.services.impl.ExaminerServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.QUESTION1;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.QUESTIONS;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении запроса")
    void getQuestionsOverSizeTest() {
        assertThatExceptionOfType(RequestOverSizeException.class)
                .isThrownBy(() -> examinerService.getQuestions(10));
    }

    @Test
    @DisplayName("Должен подтвердить, что генерируется рандомный вопрос")
    void containsQuestionTest() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION1);
        assertThat(examinerService.getQuestions(1))
                .contains(QUESTION1);
    }

}