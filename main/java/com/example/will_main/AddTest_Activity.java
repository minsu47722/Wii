package com.example.will_main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddTest_Activity extends AppCompatActivity {

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_);

        //아이디 정의
        Button add_savebtn = (Button) findViewById(R.id.button);
        final EditText add_id = (EditText) findViewById(R.id.username2);
        final EditText add_password = (EditText) findViewById(R.id.password2);

        //온클릭리스너
        add_savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edittext에 저장된 텍스트 Strig에 저장
                String get_id = add_id.getText().toString();
                String get_password = add_password.getText().toString();

                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("ID", get_id);
                result.put("Password", get_password);

                //firebase 정의
                mDatabase = FirebaseDatabase.getInstance().getReference();
                //firebase에 저장
                mDatabase.child("User").push().setValue(result);
            }
        });

    }

}