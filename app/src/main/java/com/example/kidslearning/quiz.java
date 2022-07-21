package com.example.kidslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalquestion, questions;
    Button answerA,answerB,answerC,Submitbutton;

    int score=0;
    int totalQuestion= QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        totalquestion = findViewById(R.id.totalquestion);
        questions = findViewById(R.id.questions);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        Submitbutton = findViewById(R.id.Submitbutton);

        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        Submitbutton.setOnClickListener(this);

        totalquestion.setText("Total question : "+totalQuestion);
        loadNewQuestion();
    }



    @Override
    public void onClick(View view) {
        answerA.setBackgroundColor(Color.WHITE);
        answerB.setBackgroundColor(Color.WHITE);
        answerC.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId()==R.id.Submitbutton) {
            if (selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.RED);

        }


    }
    void loadNewQuestion(){
        if(currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;

        }

        questions.setText(QuestionAnswer.question[currentQuestionIndex]);
        answerA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        answerB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        answerC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);

    }

    void finishQuiz() {
        String passStatus = "";
        if(score>totalQuestion*0.60) {
            passStatus = "Passed";
        } else {
            passStatus="Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your score" + score + "out of" + totalQuestion)
                .setPositiveButton("Restart",(dialogInterface,i)->RestartQuiz())
                .setCancelable(false)
                .show();
}

   void RestartQuiz() {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

    }

