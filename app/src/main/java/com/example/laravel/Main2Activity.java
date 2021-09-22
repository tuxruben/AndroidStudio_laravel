package com.example.laravel;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ApiService apiService;
    Retrofit cliente;
    EditText txtNombre;
    EditText txtResumen;
    EditText txtNpagina;
    EditText txtEdicion;
    EditText txtAutor;
    EditText txtPrecio;
    EditText txtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtNombre=findViewById(R.id.editText);
        txtResumen =findViewById(R.id.editText2);
        txtNpagina =findViewById(R.id.editText3);

        txtEdicion  = findViewById(R.id.editText4);
        txtAutor  = findViewById(R.id.editText5);
        txtPrecio  = findViewById(R.id.editText6);
        txtId  = findViewById(R.id.editText7);
    }

    public void Crear(View view) {
        String nombre = txtNombre.getText().toString();
        String resumen = txtResumen.getText().toString();
            String npagina = txtNpagina.getText().toString();
        String edicion = txtEdicion.getText().toString();
        String autor = txtAutor.getText().toString();
        String precio = txtPrecio.getText().toString();
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.obteneRregistro2(nombre,resumen,npagina,edicion,autor,precio).enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call,
                                   Response<List<Libro>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){

                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void Actuzlizar(View view) {
        String id = txtId.getText().toString();
        String nombre = txtNombre.getText().toString();
        String resumen = txtResumen.getText().toString();
        String npagina = txtNpagina.getText().toString();
        String edicion = txtEdicion.getText().toString();
        String autor = txtAutor.getText().toString();
        String precio = txtPrecio.getText().toString();
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.actualizar(id,nombre,resumen,npagina,edicion,autor,precio).enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call,
                                   Response<List<Libro>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){

                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void Eliminar(View view) {
        String id = txtId.getText().toString();

        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.eliminar(id).enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call,
                                   Response<List<Libro>> response) {
                Log.i("Cliente","Cliente Android");

                if (response.isSuccessful()){

                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
