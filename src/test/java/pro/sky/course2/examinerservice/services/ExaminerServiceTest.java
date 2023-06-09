package pro.sky.course2.examinerservice.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.course2.examinerservice.repository.MathQuestionRepository;
import pro.sky.course2.examinerservice.services.impl.ExaminerServiceImpl;
import pro.sky.course2.examinerservice.services.impl.JavaQuestionService;
import pro.sky.course2.examinerservice.services.impl.MathQuestionService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {

    @Mock
    private JavaQuestionRepository javaRepositoryMock;
    @Mock
    private MathQuestionRepository mathRepositoryMock;

    @InjectMocks
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    @DisplayName("Должен подтвердить, что генерируется рандомный JAVA-вопрос")
    void containsJavaQuestionTest() {
        when(javaRepositoryMock.getAll()).thenReturn(QUESTIONS);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1);
        assertThat(examinerService.getQuestions())
                .contains(QUESTION1);
    }

    @Test
    @DisplayName("Должен подтвердить, что генерируется рандомный Math-вопрос")
    void containsMathQuestionTest() {
        when(mathRepositoryMock.getAll()).thenReturn(MATH_QUESTIONS);
        when(mathQuestionService.getRandomQuestion())
                .thenReturn(MATH_QUESTION1);
        assertThat(examinerService.getQuestions())
                .contains(MATH_QUESTION1);
    }

}