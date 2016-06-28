package com.example.android.wifedub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculateScore(View view) {
        /**
         * @variable it's better to declare the variable inside the method and not as a global method since its not used outside this method.
         * everytime start calculating the score from 0
         */
        int TotalScore = 0;
        String  correctAnswers = "You answered Q No.";
        /**
         *  Validate answer for question number 1
         */
        RadioButton radioQues_1 = (RadioButton) findViewById(R.id.radio_ques1_ans);
        boolean quesAnswered = radioQues_1.isChecked();
        // If Correct answer is checked add 10 points
        if (radioQues_1.isChecked()) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 1,";
        }

        /**
         * check question number 2
         */
        RadioButton radioQues_2 = (RadioButton) findViewById(R.id.radio_ques2_ans);
        if (radioQues_2.isChecked()) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 2,";
        }

        /**
         * Validate answer for question number 3
         */
        RadioButton radioQues_3 = (RadioButton) findViewById(R.id.radio_ques3_ans);
        if (radioQues_3.isChecked()) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 3,";
        }

        /**
         * Validate answer for question number 4
         */
        CheckBox checkQues4_ans1 = (CheckBox) findViewById(R.id.checkbox_ques4_choice1);
        CheckBox checkQues4_ans2 = (CheckBox) findViewById(R.id.checkbox_ques4_choice2);
        CheckBox checkQues4_ans3 = (CheckBox) findViewById(R.id.checkbox_ques4_choice3);

        // Award 10 points only if all the three options are selected
        if (checkQues4_ans1.isChecked() && checkQues4_ans2.isChecked() && checkQues4_ans3.isChecked()) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 4,";
        }

        /**
         * Validate answer for question number 5
         */
        EditText editQues5 = (EditText) findViewById(R.id.edit_ques5);
        //Get text from edit box, convert to String and then to Lowercase so that cases doesn't matter in the answer
        String ques_5_Ans = editQues5.getText().toString().toLowerCase();
        // Since String is an object and not an true data type, we need .equals method to compare two different strings
        if (ques_5_Ans.equals("kitkat")) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 5,";
        }

        //Check answer for Question 6
        RadioButton radioQues_6 = (RadioButton) findViewById(R.id.radio_ques6_ans);
        if (radioQues_6.isChecked()) {
            TotalScore += 10;
            correctAnswers = correctAnswers + " 6";
        }

        correctAnswers = correctAnswers + " Correctly!! And your score is "+ TotalScore ;
        //Frame Toast Notification Message
        //String totalScoreMsg = "Your Score is " + TotalScore + " out of 60";

        //Make the toast to appear for longer period using LENGTH_LONG
        Toast.makeText(getApplicationContext(), correctAnswers, Toast.LENGTH_LONG).show();

    }
}
