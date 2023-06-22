package pro.sky.course2.examinerservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course2.examinerservice.models.Question;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        out.add(QUESTION3);
        out.add(QUESTION4);
        out.add(QUESTION5);
    }

    @Test
    void initTest() {
        assertThat(out.getAll()).isEqualTo(QUESTIONS);
    }

    @Test
    void addTest() {
        int beforeAdd = out.getAll().size();

        Question expected = new Question(NEW_QUESTION, NEW_ANSWER);

        assertThat(out.add(NEW_QUESTION_OBJ))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    void removeTest() {
        int beforeRemove = out.getAll().size();

        Question expected = new Question(QUESTION_1, ANSWER_1);

        assertThat(out.remove(new Question(QUESTION_1, ANSWER_1)))
                .isEqualTo(expected)
                .isNotIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeRemove - 1);
    }

    @Test
    void getAllTest() {
        assertThat(out.getAll().size())
                .isEqualTo(5)
                .isSameAs(QUESTIONS.size());
    }

    @Test
    void getAllNotNullTest() {
        assertThat(out.getAll())
                .isNotNull();
    }

}