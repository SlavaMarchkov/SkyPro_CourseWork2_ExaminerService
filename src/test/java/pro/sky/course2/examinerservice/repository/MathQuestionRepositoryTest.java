package pro.sky.course2.examinerservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course2.examinerservice.models.Question;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pro.sky.course2.examinerservice.services.constants.QuestionConstants.*;

class MathQuestionRepositoryTest {

    private final MathQuestionRepository out = new MathQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(MATH_QUESTION1);
        out.add(MATH_QUESTION2);
        out.add(MATH_QUESTION3);
        out.add(MATH_QUESTION4);
        out.add(MATH_QUESTION5);
    }

    @Test
    void initTest() {
        assertThat(out.getAll()).isEqualTo(MATH_QUESTIONS);
    }

    @Test
    void addTest() {
        int beforeAdd = out.getAll().size();

        Question expected = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);

        assertThat(out.add(NEW_MATH_QUESTION_OBJ))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    void removeTest() {
        int beforeRemove = out.getAll().size();

        Question expected = new Question(MATH_QUESTION_1, MATH_ANSWER_1);

        assertThat(out.remove(new Question(MATH_QUESTION_1, MATH_ANSWER_1)))
                .isEqualTo(expected)
                .isNotIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeRemove - 1);
    }

    @Test
    void getAllTest() {
        assertThat(out.getAll().size())
                .isEqualTo(5)
                .isSameAs(MATH_QUESTIONS.size());
    }

    @Test
    void getAllNotNullTest() {
        assertThat(out.getAll())
                .isNotNull();
    }

}