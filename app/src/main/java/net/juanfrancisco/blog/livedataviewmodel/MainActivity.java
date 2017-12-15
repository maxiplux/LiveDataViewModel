package net.juanfrancisco.blog.livedataviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        ListView listView = findViewById(R.id.list);
        ProgressBar progressBar = findViewById(R.id.progressbar);

        progressBar.setVisibility(View.VISIBLE);

        model.getGitUserNames()
                .observe(this, stringList -> {
                    // update UI
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                            android.R.layout.simple_list_item_1, android.R.id.text1, stringList);
                    // Assign adapter to ListView
                    listView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                });
    }
}
