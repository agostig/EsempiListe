package com.example.listadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ListView personeListView;
    private ArrayList<Persona> personeArrayList;
    public static final String LIST_POSITION="list_position";
    private static final String JASON_TEST="JASON_TEST";
    Executor mSingleThreadExecutor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personeListView = findViewById(R.id.personeListView);

        //configureListView();

        personeArrayList=new ArrayList<Persona>();
        createNewThread();
    }

    public void createNewThread() {

        //Executor mSingleThreadExecutor = Executors.newSingleThreadExecutor();
        mSingleThreadExecutor = Executors.newSingleThreadExecutor();

        mSingleThreadExecutor.execute(setRunnable());

    }

        /*private void updateStatus(String msg) {
        //textView.setText(msg);
        }*/

    private Runnable setRunnable()
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //CODICE PER CARICARE I DATI.


                HttpHandler sh=new HttpHandler();


                //String url="https://innovazionetop.com/persone.json";

                String url="https://innovazionetop.com/test_data/persone_2.json";



                String jsonStr=sh.makeServiceCall(url);

                Log.e(JASON_TEST, "Response from url: "+jsonStr);

                if(jsonStr!=null)
                {
                    try
                    {
                        //1.
                        JSONObject jsonObj=new JSONObject(jsonStr);

                        JSONArray persone=jsonObj.getJSONArray("persone");

                        for(int i=0;i<persone.length();i++)
                        {
                            JSONObject e=persone.getJSONObject(i);

                            String id=e.getString("id");
                            String nome=e.getString("nome");
                            String cognome=e.getString("cognome");
                            String anni=e.getString("anni");


                            //Persona persona=new Persona(e.getString("nome"), e.getString("cognome"), e.getString("anni"));

                            Persona persona=new Persona(id, nome, cognome, anni);

                            personeArrayList.add(persona);
                        }

                        //2.
                        //JSONObject jsonObj=new JSONObject(jsonStr);

                        //JSONArray persone=jsonObj.getJSONArray("persone");

                        //personeArrayList = Persona.fromJson(persone);
                    }
                    catch(final JSONException e)
                    {
                        Log.e(JASON_TEST, "Json parsing error 1: " + e.getMessage());


                    }
                }
                else
                {
                    Log.e(JASON_TEST, "Couldn't get json from server.");


                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //Log.e(JASON_TEST, "onPostExecute.");
                        //Log.e(JASON_TEST, String.valueOf(personeArrayList));

                        configureListView();
                    }
                });

            }
        };

        return runnable;
    }
    private void configureListView() {
        //Log.i(MESS, "Ciao");

        // 1.
        /*
        ArrayList<String> nomi = new ArrayList<>();
        nomi.add("Luca");
        nomi.add("Luca 2");
        nomi.add("Luca 3");
        nomi.add("Luca 4");
        nomi.add("Luca 5");
        nomi.add("Luca 6");
        nomi.add("Luca 7");
        nomi.add("Luca 8");
        nomi.add("Luca 9");
        nomi.add("Luca 10");
        nomi.add("Luca 11");
        nomi.add("Luca 12");
        nomi.add("Luca 13");
        nomi.add("Luca 14");
        nomi.add("Luca 15");
        nomi.add("Luca 16");

        ArrayAdapter<String> personaAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                nomi);

         */


        /*
        //2.
        personeArrayList = new ArrayList<>();
        personeArrayList.add(new Persona("0", "Gabriele", "Garavelli", "25"));
        personeArrayList.add(new Persona("1", "Daniele", "Nocito", "46"));
        personeArrayList.add(new Persona("2", "Feifei", "Ye", "32"));
        personeArrayList.add(new Persona("3", "Giovanni", "Agosti", "24"));
        personeArrayList.add(new Persona("4", "Dario", "Arcangeli", "21"));
        personeArrayList.add(new Persona("5", "Matteo", "Filomena", "22"));
        personeArrayList.add(new Persona("6", "Lorenzo", "Fontana", "21"));
        personeArrayList.add(new Persona("7", "Daniel", "Moussine", "27"));
        personeArrayList.add(new Persona("8", "Marianna", "Toscanesi", "20"));
        personeArrayList.add(new Persona("9", "Alessia", "Gulminelli", "19"));
        personeArrayList.add(new Persona("10", "Giacomo", "Melli", "23"));
        personeArrayList.add(new Persona("11", "Fabio", "Cerlini", "21"));
        personeArrayList.add(new Persona("12", "Samuel", "Bighi", "27"));
        personeArrayList.add(new Persona("13", "Mouad", "Ettalibi", "21"));
        personeArrayList.add(new Persona("14", "Leonardo", "Acerbi", "20"));
        personeArrayList.add(new Persona("15", "Simone", "Samaroli", "19"));


        ArrayAdapter<Persona> personaAdapter = new ArrayAdapter<Persona>(this,
            android.R.layout.simple_list_item_1,
            personeArrayList);
        */

        //guarda recycling view e card
        PersonaAdapter personaAdapter=new PersonaAdapter(this,
                R.layout.rowcustom,
                personeArrayList);

        personeListView.setAdapter(personaAdapter);



        AdapterView.OnItemClickListener clickListener=new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter,
                                    View view,
                                    int position, long id)
            {
                Log.d("ONITEMCLICK","ID: "+id);
                Log.d("ONITEMCLICK",String.valueOf(personeArrayList.get(position)));

                Intent intent=new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra(LIST_POSITION, position);
                intent.putExtra("persona", personeArrayList.get(position));
                startActivity(intent);
            }
        };

        personeListView.setOnItemClickListener(clickListener);
    }



}