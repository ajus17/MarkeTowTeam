package com.example.adolfoursa.marketow.objetos;

public class negocio {


    int categoria_negocio_id;
    String foto;
    int id;
    String nombre;
    int usuarios_idUsuario;

    public negocio(int categoria_negocio_id, String foto, int id, String nombre, int usuarios_idUsuario) {
        this.categoria_negocio_id = categoria_negocio_id;
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.usuarios_idUsuario = usuarios_idUsuario;
    }

    public int getCategoria_negocio_id() {
        return categoria_negocio_id;
    }

    public void setCategoria_negocio_id(int categoria_negocio_id) {
        this.categoria_negocio_id = categoria_negocio_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public int getUsuarios_idUsuario() {
        return usuarios_idUsuario;
    }

    public void setUsuarios_idUsuario(int usuarios_idUsuario) {
        this.usuarios_idUsuario = usuarios_idUsuario;
    }
}
