package com.example.segundoparciallavov;

import android.widget.TextView;

public class PersonasView {

    public MainActivity activity;
    public TextView contacts;

    public PersonasView( MainActivity activity ) {
        this.activity = activity;
        this.contacts = this.activity.findViewById(R.id.listaPersonas);
    }

    public void actualizaContactos(){
        String contactos = this.activity.prefs.getString("contactos2","[]");
        contacts.setText(contactos);
    }

    public void mostrarContacto( Persona p){
        DialogGenerico dialog = new DialogGenerico("Persona Encontrada", "El telefono es" + " " + p.getTelefono());
        dialog.show(this.activity.getSupportFragmentManager(),"Persona Encontrada");
    }
}
