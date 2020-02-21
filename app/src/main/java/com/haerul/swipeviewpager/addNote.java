package com.haerul.swipeviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addNote extends AppCompatActivity {
    private EditText title;
    private EditText Desc;
    private Button addnote;
    private SharedPrefsManager sharedPrefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title= findViewById(R.id.titlee);
        Desc = findViewById(R.id.descc);
        addnote = findViewById(R.id.add);
        sharedPrefsManager=SharedPrefsManager.getInstance();

         addnote.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 final String pureTitle = title.getText().toString();
                 final String pureDesc = Desc.getText().toString();

                 Intent x = new Intent(getApplicationContext(), MainActivity.class);
                 x.putExtra("title", pureTitle);
                 x.putExtra("description", pureDesc);
                 sharedPrefsManager.setString("title",pureTitle);
                 startActivity(x);
                 finish();
             }
         });
    }
}
