package pro.sky.course2.examinerservice.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.repository.MathQuestionRepository;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository repositoryMock;
    @InjectMocks
    private MathQuestionService service;

    @Test
    @DisplayName("Должен добавить вопрос-ответ")
    public void addTest() {
        when(repositoryMock.add(eq(MATH_QUESTION1)))
                .thenReturn(MATH_QUESTION1);
        assertEquals(MATH_QUESTION1, service.add(MATH_QUESTION1));
        verify(repositoryMock, times(1)).add(MATH_QUESTION1);
    }

    @Test
    @DisplayName("Должен добавить вопрос-ответ, переданные в виде строк")
    void addQuestionTest() {
        Question mathQuestion = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);

        when(repositoryMock.add(mathQuestion))
                .thenReturn(mathQuestion);
        assertEquals(mathQuestion, service.add(NEW_MATH_QUESTION, NEW_MATH_ANSWER));
        verify(repositoryMock, times(1)).add(mathQuestion);
    }

    @Test
    @DisplayName("Должен удалить вопрос-ответ")
    public void removeQuestionTest() {
        when(repositoryMock.remove(eq(MATH_QUESTION1)))
                .thenReturn(MATH_QUESTION1);
        assertEquals(MATH_QUESTION1, service.remove(MATH_QUESTION1));
        verify(repositoryMock, times(1)).remove(MATH_QUESTION1);
    }

    @Test
    @DisplayName("Должен получить все элементы коллекции")
    void getAllTest() {
        when(repositoryMock.getAll())
                .thenReturn(MATH_QUESTIONS);
        assertEquals(MATH_QUESTIONS, service.getAll());
    }

    @Test
    @DisplayName("Должен подтвердить, что коллекция пустая")
    void getAllTestWhenCollectionIsEmpty() {
        when(repositoryMock.getAll())
                .thenReturn(emptyList());
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    @DisplayName("Должен получить случайный вопрос")
    void getRandomQuestionTest() {
        when(repositoryMock.getAll())
                .thenReturn(MATH_QUESTIONS);
        Question random = service.getRandomQuestion();
        assertNotNull(random);
    }

}