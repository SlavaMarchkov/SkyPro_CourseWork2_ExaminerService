package pro.sky.course2.examinerservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.course2.examinerservice.models.Question;
import pro.sky.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.course2.examinerservice.services.impl.JavaQuestionService;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

class JavaQuestionServiceTest {

    private final QuestionService service = new JavaQuestionService(new JavaQuestionRepository());

    @BeforeEach
    void setUp() {
        Stream.iterate(1, integer -> integer + 1)
                .limit(10)
                .map(number -> new Question(
                        "Question" + number,
                        "Answer" + number)
                )
                .forEach(question -> service.add(
                        question.getQuestion(),
                        question.getAnswer()
                ));
    }

    @Test
    @DisplayName("Должен добавить вопрос-ответ")
    void addTest() {
        int beforeAdd = service.getAll().size();

        Question expected = new Question("Question11", "Answer11");

        assertThat(service.add("Question11", "Answer11"))
                .isEqualTo(expected)
                .isIn(service.getAll());

        assertThat(service.getAll()).hasSize(beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен добавить вопрос-ответ, переданные в виде нового объекта")
    void addQuestionTest() {
        int beforeAdd = service.getAll().size();

        Question expected = new Question("Question11", "Answer11");

        assertThat(service.add(new Question("Question11", "Answer11")))
                .isEqualTo(expected)
                .isIn(service.getAll());

        assertThat(service.getAll()).hasSize(beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен удалить вопрос-ответ")
    void removeTest() {
        int beforeRemove = service.getAll().size();

        Question removed = new Question("Question1", "Answer1");

        assertThat(service.remove(new Question("Question1", "Answer1")))
                .isEqualTo(removed)
                .isNotIn(service.getAll());

        assertThat(service.getAll()).hasSize(beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен получить все элементы коллекции")
    void getAllTest() {
        assertThat(service.getAll())
                .hasSize(10)
                .containsAnyOf(QUESTION1, QUESTION2, QUESTION3, QUESTION4, QUESTION5);
    }

    @Test
    @DisplayName("Должен подтвердить, что коллекция не равна NULL")
    void getAllNotNullTest() {
        assertThat(service.getAll())
                .isNotNull();
    }

    @Test
    @DisplayName("Должен получить случайный вопрос")
    void getRandomQuestionTest() {
        Question random = service.getRandomQuestion();
        assertThat(service.getAll())
                .containsAnyOf(random);
    }

}