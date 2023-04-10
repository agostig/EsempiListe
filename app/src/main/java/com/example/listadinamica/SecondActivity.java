package com.example.listadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    private int[] locandine = new int[]{R.drawable.uno,
        R.drawable.due,
        R.drawable.tre,
        R.drawable.quattro,
        R.drawable.cinque,
        R.drawable.sei,
        R.drawable.sette,
        R.drawable.otto,
        R.drawable.nove,
        R.drawable.dieci,
        R.drawable.undici,
        R.drawable.dodici,
        R.drawable.tredici,
        R.drawable.quattordici,
        R.drawable.quindici,
        R.drawable.sedici,
        R.drawable.disciassette,
        R.drawable.diciotto,
        R.drawable.diciannove,
        R.drawable.venti };
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
        ImageView imageView = findViewById(R.id.imageView2);


        listPositionTextView.setText(String.valueOf(listPositon));
        personaTextView.setText(nome + " " + cognome + " " + anni);
        imageView.setImageResource(locandine[listPositon]);


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