package com.example.segundoparciallavov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SharedPreferences prefs;
    PersonasControler personasControler;
    PersonasView personasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.personasControler = new PersonasControler(this);
        this.personasView = new PersonasView(this);
        this.prefs= getSharedPreferences("SharedContactos", Context.MODE_PRIVATE);
        personasView.actualizaContactos();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.opcionBuscar);
        SearchView sv =(SearchView) menuItem.getActionView();
        sv.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if( item.getItemId()== R.id.add){
            DialogAdd dialog = new DialogAdd("Nuevo Contacto", this);
            dialog.show(getSupportFragmentManager(),"add contacto");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Persona result = this.personasControler.buscarPersona(query);
        if (result == null){
            DialogGenerico dialog = new DialogGenerico("No Encontrada", "La persona que busco no esta dentro de la lista");
            dialog.show(getSupportFragmentManager(),"No encontrada");
        }else{
            this.personasView.mostrarContacto(result);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }
}