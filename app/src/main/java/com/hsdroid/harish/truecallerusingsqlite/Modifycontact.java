package com.hsdroid.harish.truecallerusingsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modifycontact extends AppCompatActivity {

    private Model model;
    private EditText etname, etcourse, etemail, etphone;
    private Button btnupdate, btndelete;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_teachers);

        Intent intent = getIntent();
        model = (Model) intent.getSerializableExtra("teachers");

        databaseHelper = new DatabaseHelper(this);

        etname = (EditText) findViewById(R.id.etname);
        etphone = (EditText) findViewById(R.id.etphone);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etname.setText(model.getName());
        etphone.setText(model.getPhone());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateTeachers(model.getId(),etname.getText().toString(), etphone.getText().toString());
                Toast.makeText(Modifycontact.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Modifycontact.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(model.getId());
                Toast.makeText(Modifycontact.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Modifycontact.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
