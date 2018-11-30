package com.example.adolfoursa.marketow.objetos;

public class usuarios {

    String apellido;
    String cedula;
    String contrasena;
    String correo;
    String direccion;
    String foto;
    String nombre;
    String telefono;
    int tipo_usuario_id;

    public usuarios(String apellido, String cedula, String contrasena, String correo, String direccion, String foto, String nombre, String telefono, int tipo_usuario_id) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.correo = correo;
        this.direccion = direccion;
        this.foto = foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo_usuario_id = tipo_usuario_id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipo_usuario_id() {
        return tipo_usuario_id;
    }

    public void setTipo_usuario_id(int tipo_usuario_id) {
        this.tipo_usuario_id = tipo_usuario_id;
    }
}
