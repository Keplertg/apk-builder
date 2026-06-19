import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.appmql74.Appmql74Adapter;
import com.appmql74.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Appmql74Adapter adapter;
    private List<Task> tasks = new ArrayList<>();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Appmql74Adapter(tasks, this);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName = editText.getText().toString();
                if (!taskName.isEmpty()) {
                    tasks.add(new Task(taskName));
                    adapter.notifyItemInserted(tasks.size() - 1);
                    editText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Введите название задачи", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteTask(int position) {
        tasks.remove(position);
        adapter.notifyItemRemoved(position);
    }
}