package com.example.segundoparciallavov;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;


public class onClickAddDialog implements DialogInterface.OnClickListener {

    public View viewAlert;
    public MainActivity activity;

    public onClickAddDialog(View viewAlert, MainActivity activity){
        this.viewAlert = viewAlert;
        this.activity = activity;
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        PersonasControler personasControler = new PersonasControler(this.activity);
        PersonasView personasView = new PersonasView(this.activity);

        EditText nombre = this.viewAlert.findViewById(R.id.editNombre);
        EditText telefono = this.viewAlert.findViewById(R.id.editTelefono);

        Persona p = new Persona( nombre.getText().toString(),telefono.getText().toString() );
        if (personasControler.esValidaPersona(p)){
            personasControler.agregarContacto(p);
            personasView.actualizaContactos();
        }

        dialog.dismiss();




    }
}
