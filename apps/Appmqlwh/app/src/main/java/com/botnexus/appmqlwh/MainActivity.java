package com.botnexus.appmqlwh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> apiKeys = new ArrayList<>();
    private Button startButton;
    private FloatingActionButton addApiKeyButton;
    private EditText apiKeyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start_button);
        addApiKeyButton = findViewById(R.id.add_api_key_button);
        apiKeyEditText = findViewById(R.id.api_key_edit_text);

        apiKeys.add("8673596013:AAFSPqZpmUnmdX8ig0X-Jag8kfS64gOpioQ");
        apiKeys.add("8731495504:AAHFqRLAK8uEuMTDLgn7BQw-5h7SOoLf2Vo");
        apiKeys.add("8508009704:AAHlbHdfInNNW5VYZcLpw4L3cS99oBXHXhU");

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Боты запущены", Toast.LENGTH_SHORT).show();
                // Here you would start your bots, but for simplicity, we just show a toast
            }
        });

        addApiKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newApiKey = apiKeyEditText.getText().toString();
                if (!newApiKey.isEmpty()) {
                    apiKeys.add(newApiKey);
                    apiKeyEditText.setText("");
                    Toast.makeText(MainActivity.this, "Новый API-ключ добавлен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Введите API-ключ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}