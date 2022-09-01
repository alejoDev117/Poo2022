package com.alejandro.dispensadorMecato.dominio;

public class Mecato {
    private String nombre;
    private String codigo;
    private float precio;
    private int cantidad;

    public Mecato(String nombre, String codigo, float precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = 6;
    }

    protected boolean validarCantidadUnidadesActual(){
        if(this.cantidad >= 0){
            return true;
        }
        return false;
    }

    public String getNombre() {

        return nombre;
    }

    public String getCodigo() {

        return codigo;
    }

    public float getPrecio() {

        return precio;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }


}
