package com.example.adolfoursa.marketow.objetos;

public class negocio {


    String categoria_negocio_id;
    String foto;
    String id;
    String nombre;
    String usuarios_idUsuario;

    public negocio(String categoria_negocio_id, String foto, String id, String nombre, String usuarios_idUsuario) {
        this.categoria_negocio_id = categoria_negocio_id;
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.usuarios_idUsuario = usuarios_idUsuario;
    }

    public String getCategoria_negocio_id() {
        return categoria_negocio_id;
    }

    public void setCategoria_negocio_id(String categoria_negocio_id) {
        this.categoria_negocio_id = categoria_negocio_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarios_idUsuario() {
        return usuarios_idUsuario;
    }

    public void setUsuarios_idUsuario(String usuarios_idUsuario) {
        this.usuarios_idUsuario = usuarios_idUsuario;
    }
}
