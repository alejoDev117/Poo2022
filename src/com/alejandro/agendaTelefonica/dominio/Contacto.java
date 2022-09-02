package com.alejandro.agendaTelefonica.dominio;

public class Contacto implements Comparable<Contacto>{
    private String nombre;
    private String apellido;
    private int numero;
    private String ordenAlfabetico;


    public Contacto(String nombre, String apellido, int numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.ordenAlfabetico = nombre + apellido;
    }
    public String getNombre() {

        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumero() {
        return numero;
    }

    public String getOrdenAlfabetico(){

        return ordenAlfabetico;
    }

    void setNumero(int numero) {

        this.numero = numero;
    }

    @Override
    public int compareTo(Contacto o) {
        return ordenAlfabetico.compareTo(o.ordenAlfabetico);
    }
}
