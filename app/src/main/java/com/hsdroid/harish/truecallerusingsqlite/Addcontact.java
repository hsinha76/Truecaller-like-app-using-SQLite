package com.hsdroid.harish.truecallerusingsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addcontact extends AppCompatActivity {

    private Button btnStore;
    private EditText etphone;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_teachers);

        databaseHelper = new DatabaseHelper(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        final EditText etname = (EditText) findViewById(R.id.et_name);
        etphone = (EditText) findViewById(R.id.et_phone);



        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                if (TextUtils.isEmpty(name)){
                    etname.setError("Enter Name");
                    etname.requestFocus();
                    return;
                }

                String phone = etphone.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    etphone.setError("Enter phoneno");
                    etphone.requestFocus();
                    return;
                }

                databaseHelper.addTeachersDetail(
                        etname.getText().toString(),
                        etphone.getText().toString());

                etphone.setText("");

                Toast.makeText(Addcontact.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Addcontact.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}