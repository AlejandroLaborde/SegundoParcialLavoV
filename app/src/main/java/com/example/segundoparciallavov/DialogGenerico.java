package com.example.segundoparciallavov;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {

    public String titulo;
    public String mensaje;

    public DialogGenerico(String titulo, String mensaje ){
        this.titulo = titulo;
        this.mensaje = mensaje;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.titulo);
        builder.setMessage(this.mensaje);


        builder.setPositiveButton("Aceptar",null);
        return builder.create();

    }
}
