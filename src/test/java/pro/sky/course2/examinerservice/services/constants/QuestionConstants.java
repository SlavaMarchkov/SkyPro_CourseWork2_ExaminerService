package pro.sky.course2.examinerservice.services.constants;

import pro.sky.course2.examinerservice.models.Question;

public class QuestionConstants {

    public static final String QUESTION_1 = "Question1";
    public static final String QUESTION_2 = "Question2";
    public static final String QUESTION_3 = "Question3";
    public static final String QUESTION_4 = "Question4";
    public static final String QUESTION_5 = "Question5";
    
    public static final String ANSWER_1 = "Answer1";
    public static final String ANSWER_2 = "Answer2";
    public static final String ANSWER_3 = "Answer3";
    public static final String ANSWER_4 = "Answer4";
    public static final String ANSWER_5 = "Answer5";

    public static final Question QUESTION1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question QUESTION3 = new Question(QUESTION_3, ANSWER_3);
    public static final Question QUESTION4 = new Question(QUESTION_4, ANSWER_4);
    public static final Question QUESTION5 = new Question(QUESTION_5, ANSWER_5);

}
