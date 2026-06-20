package com.botnexus.appmqlvs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start_button);
        statusTextView = findViewById(R.id.status_text_view);

        startButton.setOnClickListener(v -> {
            statusTextView.setText("Боты запущены и не будут выключаться");
            startButton.setEnabled(false);
        });
    }
}