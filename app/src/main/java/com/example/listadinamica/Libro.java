package com.example.listadinamica;

import android.os.Parcel;
import android.os.Parcelable;

public class Libro implements Parcelable {
    private String id;
    private String titolo;
    private String autore;
    private String isbn;
    private String editore;
    private String prezzo;

    public Libro(String id, String titolo, String autore, String isbn, String editore, String prezzo) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.editore = editore;
        this.prezzo = prezzo;
    }
    private Libro(Parcel in)
    {
        id=in.readString();
        titolo=in.readString();
        autore=in.readString();
        prezzo=in.readString();
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditore() {
        return editore;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }



    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(id);
        out.writeString(titolo);
        out.writeString(autore);
        out.writeString(prezzo);
    }

    public int describeContents()
    {
        return 0;
    }


    //Override di Object.
    @Override
    public String toString()
    {
        return "ID: " + id + ", TITOLO: " + titolo + ", AUTORE: " + autore + ", PREZZO: " + prezzo;
    }


    //Statici.
    public static final Creator<Libro> CREATOR=new Creator<Libro>()
    {
        public Libro createFromParcel(Parcel in)
        {
            return new Libro(in);
        }

        public Libro[] newArray(int size)
        {
            return new Libro[size];
        }
    };
}
