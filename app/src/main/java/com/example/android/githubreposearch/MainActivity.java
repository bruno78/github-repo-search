package com.example.android.githubreposearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    EditText mSearchBoxEditText;

    TextView mUrlDisplayTextView;
    TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);
    }

    public void makeGithubSearchQuery() {
        String query = mSearchBoxEditText.getText().toString();
        String url = NetworkUtils.buildUrl(query).toString();

        mUrlDisplayTextView.setText(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_search) {
            // Toast.makeText(this, "Search clicked!", Toast.LENGTH_SHORT).show();
            makeGithubSearchQuery();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
