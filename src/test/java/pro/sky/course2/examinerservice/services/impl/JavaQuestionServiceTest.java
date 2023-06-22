package pro.sky.course2.examinerservice.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.repository.JavaQuestionRepository;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository repositoryMock;
    @InjectMocks
    private JavaQuestionService service;

    @Test
    @DisplayName("Должен добавить вопрос-ответ")
    public void addTest() {
        when(repositoryMock.add(eq(QUESTION1)))
                .thenReturn(QUESTION1);
        assertEquals(QUESTION1, service.add(QUESTION1));
        verify(repositoryMock, times(1)).add(QUESTION1);
    }

    @Test
    @DisplayName("Должен добавить вопрос-ответ, переданные в виде строк")
    void addQuestionTest() {
        Question question = new Question(NEW_QUESTION, NEW_ANSWER);

        when(repositoryMock.add(question))
                .thenReturn(question);
        assertEquals(question, service.add(NEW_QUESTION, NEW_ANSWER));
        verify(repositoryMock, times(1)).add(question);
    }

    @Test
    @DisplayName("Должен удалить вопрос-ответ")
    public void removeQuestionTest() {
        when(repositoryMock.remove(eq(QUESTION1)))
                .thenReturn(QUESTION1);
        assertEquals(QUESTION1, service.remove(QUESTION1));
        verify(repositoryMock, times(1)).remove(QUESTION1);
    }

    @Test
    @DisplayName("Должен получить все элементы коллекции")
    void getAllTest() {
        when(repositoryMock.getAll())
                .thenReturn(QUESTIONS);
        assertEquals(QUESTIONS, service.getAll());
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
                .thenReturn(QUESTIONS);
        Question random = service.getRandomQuestion();
        assertNotNull(random);
    }

}