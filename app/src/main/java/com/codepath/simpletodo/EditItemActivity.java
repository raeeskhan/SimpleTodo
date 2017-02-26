package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.data;
import static android.R.attr.id;
import static com.codepath.simpletodo.R.id.etNewItem;

public class EditItemActivity extends AppCompatActivity {
    private int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        itemPosition = getIntent().getIntExtra("itemPosition", 0);
        String itemText = getIntent().getStringExtra("itemText");
        EditText etItem = (EditText) findViewById(R.id.etItem);
        etItem.setText(itemText);
        etItem.requestFocus();


    }

    public void onUpdateItem(View v) {
        EditText etItem = (EditText) findViewById(R.id.etItem);
        String itemText = etItem.getText().toString();
        Intent i = new Intent();
        // Pass relevant data back as a result
        i.putExtra("itemText", itemText);
        i.putExtra("itemPosition", itemPosition); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, i); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
