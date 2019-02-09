package com.example.android.braintrainer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private TextView playAgain;
    private TextView finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        finalScore = findViewById(R.id.finalScore);
        String score = getIntent().getStringExtra("Final score");
        Log.e("received extra: ", score);

        finalScore.setText(score);
    }

    public void onReceive(Context context, Intent intent) {

    }
}
