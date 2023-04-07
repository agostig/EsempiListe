package com.example.listadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int listPositon=intent.getIntExtra(MainActivity.LIST_POSITION, 0);
        Persona persona = intent.getParcelableExtra("persona");

        String nome = persona.getNome();
        String cognome = persona.getCognome();
        String anni = persona.getAnni();

        TextView listPositionTextView=findViewById(R.id.listPositionTextView);
        TextView personaTextView=findViewById(R.id.personaTextView);

        listPositionTextView.setText(String.valueOf(listPositon));
        personaTextView.setText(nome + " " + cognome + " " + anni);

        Button backButton=findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}