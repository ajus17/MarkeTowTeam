package com.example.adolfoursa.marketow.objetos;

public class negocio {

    String nombreN;
    int categoriaNegocio;
    String foto;
    int idNegocio;
    int idusuario;

    public negocio(String nombreN, int categoriaNegocio, String foto, int idNegocio, int idusuario) {
        this.nombreN = nombreN;
        this.categoriaNegocio = categoriaNegocio;
        this.foto = foto;
        this.idNegocio = idNegocio;
        this.idusuario = idusuario;
    }

    public String getNombreN() {
        return nombreN;
    }

    public void setNombreN(String nombreN) {
        this.nombreN = nombreN;
    }

    public int getCategoriaNegocio() {
        return categoriaNegocio;
    }

    public void setCategoriaNegocio(int categoriaNegocio) {
        this.categoriaNegocio = categoriaNegocio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(int idNegocio) {
        this.idNegocio = idNegocio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
