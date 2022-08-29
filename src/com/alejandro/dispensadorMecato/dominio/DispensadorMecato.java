package com.alejandro.dispensadorMecato.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DispensadorMecato {
    private List<Mecato> contenido;
    private List<String> codigos;

    public DispensadorMecato() {
        this.contenido = new ArrayList<>();
        this.contenido = new ArrayList<>();
        for (int i = 0; i <12 ; i++) {
            String c = "c";
            c += i;
            codigos.add(c);
        }

    }
    public boolean agregarCompletoSnack(String nombre,int precio){
        if(validarCapacidadMaximaSnack()){
            Mecato nuevoMecato = new Mecato(nombre,codigos.get(0),precio);
            codigos.remove(0);
            contenido.add(nuevoMecato);
            return true;
        }
        return false;
    }
    public boolean quitarCompletoSnack(String codigoDel){
        for (Mecato eliminacion: contenido) {
            if(eliminacion.getCodigo() == codigoDel){
                codigos.add(eliminacion.getCodigo());
                contenido.remove(eliminacion);
                return true;
            }
        }
        return false;
    }
    public boolean sacarUnidad(String caracteres){
        if(validarCodigo(caracteres)){
            for (Mecato busqueda:contenido) {
                if(busqueda.getCodigo() == caracteres){
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
        return false;
        }else {
            for (Mecato busqueda : contenido) {
                if (busqueda.getNombre() == caracteres) {
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
        return false;
        }
    }

    public boolean aumentarUnidad(String codigo){
        if(validarCodigo(codigo)){
            for (Mecato busqueda: contenido) {
                if(busqueda.getCodigo() == codigo && busqueda.getCantidad() <= 6){
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        }else {
            for (Mecato busqueda: contenido) {
                if(busqueda.getNombre() == codigo && busqueda.getCantidad() <= 6){
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        }
    }

    public void consultarUnidad(String codigo){
        for (Mecato consulta:contenido) {
            if(consulta.getCodigo() == codigo){
                System.out.println("Cantidad restante: "+consulta.getCantidad());
            }
        }
    }

    public void mostrarLista(int decision) {
        if (decision == 1) {
            for (Mecato mostrar : contenido) {
                System.out.println(mostrar.getNombre() + " precio: "+mostrar.getPrecio()+" cantidad: "+mostrar.getCantidad());
            }
        } else if (decision == 2) {
            for (Mecato mostrar : contenido) {
                if (mostrar.getCantidad() == 0) {
                    System.out.println(mostrar.getNombre() + " precio: "+mostrar.getPrecio()+" cantidad: "+mostrar.getCantidad());
                }
            }
        }
    }
    public void ordenPorValor(){

    }
    public void ordenPorCantidad(){

    }
    private boolean validarCodigo(String codigo){
        if(codigo.length() <=3){
            return true;
        }else {
            return false;
        }
    }
    private boolean validarCapacidadMaximaSnack(){
        if(contenido.size()<12){
            return true;
        }else{
            return false;
        }
    }



}
