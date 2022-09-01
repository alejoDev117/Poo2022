package com.alejandro.dispensadorMecato.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DispensadorMecato {
    private List<Mecato> contenido;
    private List<String> codigos;


    public DispensadorMecato() {
        this.contenido = new ArrayList<>();
        this.codigos = new ArrayList<>();
        for (int i = 1; i <=12; i++) {
            String c = "c";
            c += i;
            this.codigos.add(c);
        }

    }

    public boolean agregarCompletoSnack(String nombre, float precio) {
        if (validarCapacidadMaximaSnack()) {
            Mecato nuevoMecato = new Mecato(nombre, codigos.get(0), precio);
            codigos.remove(0);
            contenido.add(nuevoMecato);
            return true;
        }
        return false;
    }

    public boolean quitarCompletoSnack(String codigoDel) {
        if (validarCodigo(codigoDel)) {
            for (Mecato eliminacion : contenido) {
                if (eliminacion.getCodigo().equals(codigoDel)) {
                    codigos.add(eliminacion.getCodigo());
                    contenido.remove(eliminacion);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sacarUnidad(String inputDelTeclado, float pago) {
        if (validarCodigo(inputDelTeclado)) {
            for (Mecato busqueda : contenido) {
                if (busqueda.getCodigo().equals(inputDelTeclado) && busqueda.getPrecio() <= pago){
                    pago -= busqueda.getPrecio();
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
            return false;
        } else {
            for (Mecato busqueda : contenido) {
                if (busqueda.getNombre().equals(inputDelTeclado)) {
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean aumentarUnidad(String inputDelTeclado) {
        if (validarCodigo(inputDelTeclado)) {
            for (Mecato busqueda : contenido) {
                if (busqueda.getCodigo().equals(inputDelTeclado) && busqueda.getCantidad() < 6) {
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        } else {
            for (Mecato busqueda : contenido) {
                if (busqueda.getNombre().equals(inputDelTeclado) && busqueda.getCantidad() < 6) {
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        }
    }

    public int consultarUnidad(String codigo) {
        for (Mecato consulta : contenido) {
            if (consulta.getCodigo().equals(codigo)) {
                return consulta.getCantidad();
            }
        }
        return 7;
    }

    public void mostrarLista(int decision) {
        if (decision == 1) {//muestra toda la lista
            for (Mecato mostrar : contenido) {
                System.out.println(mostrar.getNombre() + " precio: " + mostrar.getPrecio() + " cantidad: " + mostrar.getCantidad());
            }
        } else if (decision == 2) {//muestra solo los snacks agotados
            for (Mecato mostrar : contenido) {
                if (mostrar.getCantidad() == 0) {
                    System.out.println(mostrar.getNombre() + " precio: " + mostrar.getPrecio() + " cantidad: " + mostrar.getCantidad());
                }
            }
        }
    }

    public void ordenPorValor() {

    }

    public void ordenPorCantidad() {

    }

    private boolean validarCodigo(String codigo) {
        if (codigo.length() == 3 && validarExistenciaDeCodigo(codigo)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarExistenciaDeCodigo(String codigo) {
        for (String codigoExistente : codigos) {
            if (codigoExistente.equals(codigo)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarCapacidadMaximaSnack() {
        if (contenido.size() < 12) {
            return true;
        } else {
            return false;
        }
    }

}
