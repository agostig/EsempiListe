package com.example.listadinamica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter<Persona>
{
    private int layoutId;

    public PersonaAdapter(Context context,
                          int layoutId,
                          List<Persona> objects)
    {
        super(context, layoutId, objects);

        this.layoutId=layoutId;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent)
    {
        //LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Persona persona=getItem(position);

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rowcustom, null);
        }

        TextView nome=convertView.findViewById(R.id.textViewName);
        TextView anni=convertView.findViewById(R.id.textViewAge);

        //Persona persona=getItem(position);
        nome.setText(persona.getNome()+" "+persona.getCognome()+" 2");
        anni.setText(persona.getAnni());

        return convertView;
    }
}
