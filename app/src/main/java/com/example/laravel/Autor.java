package com.example.laravel;


public class Autor {
    private int id;
    private String nombre;
    private String apellidos;
    private String edad;
    private String id_libro;
    private String created_at;
    private String updated_at;
    public Autor() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getId_libro() {
        return id_libro;
    }
    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    @Override
    public String toString() {
        return this.id+"\n "+"nombre: "+this.nombre+"\n "+"apellidos: "+this.apellidos+"\n"+"edad: "+edad+"\n"+"id_libro: "+this.id_libro+"\n ";
    }
}