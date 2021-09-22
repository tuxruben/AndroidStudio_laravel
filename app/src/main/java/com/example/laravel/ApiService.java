package com.example.laravel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    public static final String URL="http://192.168.1.71:8888/laracrud/public/";

    @GET("api/v1/libros/{id}")
    public Call<List<Libro>> obteneRregistro(@Path("id") String id);
    @GET("api/v1/libros/crear/{nombre}/{resumen}/{npagina}/{edicion}/{autor}/{precio}")
    public Call<List<Libro>> obteneRregistro2(@Path("nombre") String nombre, @Path("resumen") String resumen, @Path("npagina") String npagina, @Path("edicion") String edicion, @Path("autor") String autor, @Path("precio") String precio);
    @GET("api/v1/libros/actualizar/{id}/{nombre}/{resumen}/{npagina}/{edicion}/{autor}/{precio}")
    public Call<List<Libro>> actualizar(@Path("id") String id,@Path("nombre") String nombre, @Path("resumen") String resumen, @Path("npagina") String npagina, @Path("edicion") String edicion, @Path("autor") String autor, @Path("precio") String precio);
    @GET("api/v1/libros/eliminar/{id}/")
    public Call<List<Libro>> eliminar(@Path("id") String id);

    @GET("api/v1/libros")
    Call<List<Libro>> listaLibros();
    @GET("api/v1/autores/{id}")
    public Call<List<Autor>> obteneRregistro1(@Path("id") String id);
    @GET("api/v1/autores")
    Call<List<Autor>> listaAutores();

}