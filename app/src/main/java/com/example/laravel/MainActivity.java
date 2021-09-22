package com.example.laravel;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Libro> listaLibros;
    List<Autor> listaAutore;
    Retrofit cliente;
    EditText txtNombre;
    ApiService apiService;
    Tabla tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
  txtNombre=findViewById(R.id.txtNombre);
        Button btn = (Button) findViewById(R.id.botonact1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Main2Activity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    public void Libros(View view) {
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaLibros().enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call,
                                   Response<List<Libro>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){
                    listaLibros=response.body();
                    tabla.agregarCabecera(R.array.cabecera_tabla);
                    for (Libro libro:listaLibros){
                        Log.i("Libro",libro.toString());
                        ArrayList<String> elementos = new ArrayList<String>();
                        elementos.add(""+libro.getId()+"");
                        elementos.add(libro.getNombre());
                        elementos.add(libro.getResumen());
                        elementos.add(libro.getNpagina());
                        elementos.add(libro.getEdicion());
                        elementos.add(libro.getAutor());
                        elementos.add(libro.getPrecio());
                        tabla.agregarFilaTabla(elementos);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void ObtenerUsuario(View view) {
        String id = txtNombre.getText().toString();
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.obteneRregistro(id).enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call,
                                   Response<List<Libro>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){
                    listaLibros=response.body();
                    tabla.agregarCabecera(R.array.cabecera_tabla);
                    for (Libro libro:listaLibros){
                        Log.i("Libro",libro.toString());
                        ArrayList<String> elementos = new ArrayList<String>();
                        elementos.add(""+libro.getId()+"");
                        elementos.add(libro.getNombre());
                        elementos.add(libro.getResumen());
                        elementos.add(libro.getNpagina());
                        elementos.add(libro.getEdicion());
                        elementos.add(libro.getAutor());
                        elementos.add(libro.getPrecio());
                        tabla.agregarFilaTabla(elementos);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void ObtenerRegistro(View view) {
        String id = txtNombre.getText().toString();
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.obteneRregistro1(id).enqueue(new Callback<List<Autor>>() {
            @Override
            public void onResponse(Call<List<Autor>> call,
                                   Response<List<Autor>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){
                    listaAutore=response.body();
                    tabla.agregarCabecera(R.array.cabecera_tabla1);
                    for (Autor libro:listaAutore){
                        Log.i("Libro",libro.toString());
                        ArrayList<String> elementos = new ArrayList<String>();
                        elementos.add(""+libro.getId()+"");
                        elementos.add(libro.getNombre());
                        elementos.add(libro.getApellidos());
                        elementos.add(libro.getEdad());
                        elementos.add(libro.getId_libro());

                        tabla.agregarFilaTabla(elementos);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Autor>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void Autores(View view) {
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaAutores().enqueue(new Callback<List<Autor>>() {
            @Override
            public void onResponse(Call<List<Autor>> call,
                                   Response<List<Autor>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listaAutore=response.body();
                    tabla.agregarCabecera(R.array.cabecera_tabla1);
                    for (Autor libro:listaAutore){
                        Log.i("Libro",libro.toString());
                        ArrayList<String> elementos = new ArrayList<String>();
                        elementos.add(""+libro.getId()+"");
                        elementos.add(libro.getNombre());
                        elementos.add(libro.getApellidos());
                        elementos.add(libro.getEdad());
                        elementos.add(libro.getId_libro());
                        tabla.agregarFilaTabla(elementos);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Autor>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
