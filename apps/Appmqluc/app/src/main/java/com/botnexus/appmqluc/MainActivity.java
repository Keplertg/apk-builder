import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.appmqluc.BotRunner;
import com.appmqluc.TelegramBot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText apiEditText;
    private Button addButton;
    private Button startButton;
    private List<TelegramBot> bots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiEditText = findViewById(R.id.api_edit_text);
        addButton = findViewById(R.id.add_button);
        startButton = findViewById(R.id.start_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String api = apiEditText.getText().toString();
                if (!api.isEmpty()) {
                    bots.add(new TelegramBot(api));
                    apiEditText.setText("");
                    Toast.makeText(MainActivity.this, "Бот добавлен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Введите API", Toast.LENGTH_SHORT).show();
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bots.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Добавьте ботов", Toast.LENGTH_SHORT).show();
                } else {
                    BotRunner botRunner = new BotRunner(bots);
                    botRunner.start();
                    Toast.makeText(MainActivity.this, "Боты запущены", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}