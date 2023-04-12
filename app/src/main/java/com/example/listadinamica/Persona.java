package com.example.listadinamica;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Persona implements Parcelable {
    //Attributi
    private String id;
    private String nome;
    private String cognome;
    private String anni;


    //Coatruttori
    public Persona(String id, String nome, String cognome, String anni)
    {
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.anni=anni;
    }

    //Costruttore per la parcellizzazione
    private Persona(Parcel in)
    {
        id=in.readString();
        nome=in.readString();
        cognome=in.readString();
        anni=in.readString();
    }



    //GET e SET
    public String getID()
    {
        return id;
    }

    public void setID(String id)
    {
        this.id=id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome=nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }

    public String getAnni()
    {
        return anni;
    }


    //Metodi.
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(id);
        out.writeString(nome);
        out.writeString(cognome);
        out.writeString(anni);
    }

    public int describeContents()
    {
        return 0;
    }


    //Override di Object.
    @Override
    public String toString()
    {
        return "ID: " + id + ", NOME: " + nome + ", COGNOME: " + cognome + ", anni: " + anni;
    }


    //Statici.
    public static final Creator<Persona> CREATOR=new Creator<Persona>()
    {
        public Persona createFromParcel(Parcel in)
        {
            return new Persona(in);
        }

        public Persona[] newArray(int size)
        {
            return new Persona[size];
        }
    };


}