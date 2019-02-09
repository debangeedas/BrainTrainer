package com.example.android.braintrainer;

import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 30000; //30 seconds

    private TextView questionText, scoreText, rightWrongText;
    private TextView option1, option2, option3, option4;
    private String scoretext, correctAnswer;

    private Integer numberOfQuestionsAttempted = 0 , numberOfAnswersCorrect = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();

        countdownText = findViewById(R.id.countdownText);
        questionText = findViewById(R.id.questionText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        scoreText = findViewById(R.id.scoreText);
        rightWrongText = findViewById(R.id.rightWrongText);

        setQuestionandUpdateScore();
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFinish() {
                Intent intent2Finish = new Intent(MainActivity.this, FinishActivity.class);

                String score = setQuestionandUpdateScore();
                Log.e("Final score:", score);

                intent2Finish.putExtra("Final score", score);
                startActivity(intent2Finish);
                sendBroadcast(intent2Finish);

            }
        }.start();
    }

    public void updateTimer() {
        int seconds = (int) (timeLeftInMilliseconds % 60000) / 1000;

        String timeLeftText;
        timeLeftText = "";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds + "s";

        countdownText.setText(timeLeftText);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public String setQuestionandUpdateScore(){
        Integer rand1, rand2;

        rand1 = ThreadLocalRandom.current().nextInt(-99, 99);
        rand2 = ThreadLocalRandom.current().nextInt(-99, 99);

        Log.e("random number 1 is", rand1.toString());
        Log.e("random number 2 is", rand2.toString());

        String questionString = rand1.toString() + " + " + rand2.toString();
        questionText.setText(questionString);

        //Finding out the correct answer

        Integer correct = rand1 + rand2;
        correctAnswer = correct.toString();
        Log.e("The Correct Answer is:", correctAnswer);

        //Set text for correct option to a random box
        Integer optionContainingCorrectAnswer = ThreadLocalRandom.current().nextInt(1, 5);
        Integer randomInteger2 = ThreadLocalRandom.current().nextInt(-198, 198);
        Integer randomInteger3 = ThreadLocalRandom.current().nextInt(-198, 198);
        Integer randomInteger4 = ThreadLocalRandom.current().nextInt(-198, 198);
        Log.e("Option number selected:", optionContainingCorrectAnswer.toString());

        String ri2 = randomInteger2.toString();
        String ri3 = randomInteger3.toString();
        String ri4 = randomInteger4.toString();

        switch (optionContainingCorrectAnswer) {

            case 1:
                option1.setText(correctAnswer);
                option2.setText(ri2);
                option3.setText(ri3);
                option4.setText(ri4);
                break;

            case 2:
                option2.setText(correctAnswer);
                option1.setText(ri2);
                option3.setText(ri3);
                option4.setText(ri4);
                break;

            case 3:
                option3.setText(correctAnswer);
                option2.setText(ri2);
                option1.setText(ri3);
                option4.setText(ri4);
                break;

            case 4:
                option4.setText(correctAnswer);
                option2.setText(ri2);
                option3.setText(ri3);
                option1.setText(ri4);
                break;
        }

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateScore
                String selectedAnswer = option1.getText().toString();
                Log.e("Selected Answer:", selectedAnswer);

                if (selectedAnswer.equals(correctAnswer.trim())){
                    numberOfAnswersCorrect++;
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("CORRECT");
                } else {
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("WRONG");
                }

                scoretext = numberOfAnswersCorrect +"/"+ numberOfQuestionsAttempted;
                scoreText.setText(scoretext);

                setQuestionandUpdateScore();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateScore
                String selectedAnswer = option2.getText().toString();
                Log.e("Selected Answer:", selectedAnswer);

                if (selectedAnswer.equals(correctAnswer)){
                    numberOfAnswersCorrect++;
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("CORRECT");
                } else {
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("WRONG");
                }

                scoretext = numberOfAnswersCorrect +"/"+ numberOfQuestionsAttempted;
                scoreText.setText(scoretext);

                setQuestionandUpdateScore();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateScore
                String selectedAnswer = option3.getText().toString();
                Log.e("Selected Answer:", selectedAnswer);

                if (selectedAnswer.equals(correctAnswer)){
                    numberOfAnswersCorrect++;
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("CORRECT");
                } else {
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("WRONG");
                }

                scoretext = numberOfAnswersCorrect +"/"+ numberOfQuestionsAttempted;
                scoreText.setText(scoretext);

                setQuestionandUpdateScore();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateScore
                //updateScore
                String selectedAnswer = option4.getText().toString();
                Log.e("Selected Answer:", selectedAnswer);

                if (selectedAnswer.equals(correctAnswer)){
                    numberOfAnswersCorrect++;
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("CORRECT");
                } else {
                    numberOfQuestionsAttempted++;
                    rightWrongText.setText("WRONG");
                }

                scoretext = numberOfAnswersCorrect +"/"+ numberOfQuestionsAttempted;
                scoreText.setText(scoretext);

                setQuestionandUpdateScore();
            }
        });
        return scoretext;
    }

}
