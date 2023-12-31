package com.example.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PromptActivity extends AppCompatActivity {
    private boolean correctAnswer;
    private Button showCorrectAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        showCorrectAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = correctAnswer ? R.string.button_true : R.string.button_false;
                //answerTextView.
            }
        });
    }

}