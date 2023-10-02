package com.example.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_CURRENT_INDEX = "KEY_USER_ENTRY";
    public static final String KEY_EXTRA_ANSWER = "";
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private Button podpowiedzButton;

    private Question[] questions = new Question[]{
            new Question(R.string.q_activity, true),
            new Question(R.string.q_version, false),
            new Question(R.string.q_age, false),
            new Question(R.string.q_meaning, false),
            new Question(R.string.q_future, false)
    };
    private int currentIndex = 0;
    private void checkAnswerCorrectnes(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageID = 0;
        if(userAnswer == correctAnswer){
            resultMessageID = R.string.correctAnswer;
        } else {
            resultMessageID = R.string.falseAnswer;
        }
        Toast.makeText(this, resultMessageID, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mess", "stworzono co nieco");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        }

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);
        podpowiedzButton = findViewById(R.id.podpowiedz_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswerCorrectnes(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswerCorrectnes(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questions.length;
                setNextQuestion();
            }
        });
        podpowiedzButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PromptActivity.class);
                boolean correctAnswer = questions[currentIndex].isTrueAnswer();
                intent.putExtra(KEY_EXTRA_ANSWER, correctAnswer);
                startActivity(intent);
            }
        }));

        setNextQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mess", "SIEMANKO, witam w mojej apce");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mess", "Trzymaj sie byq");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mess", "Juz wruciles?");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mess", "Hasta la vista, baby");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mess", "Pause, hammer time");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("mess", "Wywyolano onSaveInstanceState");
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
    }

    private void setNextQuestion(){
            questionTextView.setText(questions[currentIndex].getQuestionID());
        }
}
