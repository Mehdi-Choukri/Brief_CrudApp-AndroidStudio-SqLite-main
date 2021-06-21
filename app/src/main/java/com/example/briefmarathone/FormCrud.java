package com.example.briefmarathone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FormCrud extends AppCompatActivity {


    DatabaseHelper db = new DatabaseHelper(this);

    EditText name, email, phone,ID;
    Button add, edit, delete;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_crud);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        phone = findViewById(R.id.editPhone);
        ID = findViewById(R.id.idUser);
        lst=findViewById(R.id.list);
        showData();
    }

    public void add_btn(View view) {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Phone = phone.getText().toString();

        Boolean result = db.insertData(Name, Email, Phone);
        if (result == true) {
            Toast.makeText(FormCrud.this, "bien enregistré", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(FormCrud.this, "Erreur", Toast.LENGTH_SHORT).show();


        }
        showData();
    }

    public void showData()
    {
        ArrayList<String> listData = db.getAllUsers();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,listData);
        lst.setAdapter(arrayAdapter);

    }

    public void delete_btn(View view){

        String id=ID.getText().toString();
        Integer result=db.Delete(id);

        if(result>0)
        {
            Toast.makeText(FormCrud.this, "bien Supprimé", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(FormCrud.this, "Erreur", Toast.LENGTH_SHORT).show();


        }
        showData();

    }

    public void edit_btn( View view){

        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Phone = phone.getText().toString();
        String id=ID.getText().toString();

        Boolean result = db.update(id,Name,Email,Phone);
        if (result == true) {
            Toast.makeText(FormCrud.this, "bien enregistré", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(FormCrud.this, "Erreur", Toast.LENGTH_SHORT).show();


        }
        showData();
    }


}
