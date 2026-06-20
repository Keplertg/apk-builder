package com.botnexus.appmqlve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button addButton;
    private TextInputEditText apiEditText;
    private ArrayList<String> apiList;
    private ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        addButton = findViewById(R.id.add_button);
        apiEditText = findViewById(R.id.api_edit_text);

        apiList = new ArrayList<>();
        apiAdapter = new ApiAdapter(apiList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(apiAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String api = apiEditText.getText().toString();
                if (!api.isEmpty()) {
                    apiList.add(api);
                    apiAdapter.notifyItemInserted(apiList.size() - 1);
                    apiEditText.setText("");
                }
            }
        });
    }

    private class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

        private ArrayList<String> apiList;

        public ApiAdapter(ArrayList<String> apiList) {
            this.apiList = apiList;
        }

        @Override
        public ApiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.api_item, parent, false);
            return new ApiViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ApiViewHolder holder, int position) {
            holder.apiTextView.setText(apiList.get(position));
        }

        @Override
        public int getItemCount() {
            return apiList.size();
        }

        public class ApiViewHolder extends RecyclerView.ViewHolder {
            public android.widget.TextView apiTextView;

            public ApiViewHolder(View itemView) {
                super(itemView);
                apiTextView = itemView.findViewById(R.id.api_text_view);
            }
        }
    }
}