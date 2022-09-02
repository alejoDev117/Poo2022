package com.alejandro.dispensadorMecato.dominio;

import java.util.ArrayList;
import java.util.List;

public class DispensadorMecato {
    private List<Mecato> snacks;
    private List<String> codigos;


    public DispensadorMecato() {
        this.snacks = new ArrayList<>();
        this.codigos = new ArrayList<>();
        for (int i = 1; i <=12; i++) {
            String c = "c";
            c += i;
            this.codigos.add(c);
        }

    }

    public boolean agregarSnackCompleto(String nombre, float precio) {
        if (validarCapacidadMaximaMaquina()) {
            Mecato nuevoMecato = new Mecato(nombre, codigos.get(0), precio);
            codigos.remove(0);
            snacks.add(nuevoMecato);
            return true;
        }
        return false;
    }

    public boolean quitarSnackCompleto(String codigoParaEliminar) {
        if (validarCodigo(codigoParaEliminar)) {
            for (Mecato eliminacion : snacks) {
                if (eliminacion.getCodigo().equals(codigoParaEliminar)) {
                    codigos.add(eliminacion.getCodigo());
                    snacks.remove(eliminacion);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sacarPorUnidad(String inputDelTeclado, float pago) {
        if (validarCodigo(inputDelTeclado)) {
            for (Mecato busqueda : snacks) {//saca unidad por codigo
                if (busqueda.getCodigo().equals(inputDelTeclado) && busqueda.getPrecio() <= pago && busqueda.cantidadValoresPositivo()){
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
            return false;
        } else {
            for (Mecato busqueda : snacks) {//saca unidad por nombre
                if (busqueda.getNombre().equals(inputDelTeclado) && busqueda.getPrecio() <= pago && busqueda.cantidadValoresPositivo()) {
                    busqueda.setCantidad(busqueda.getCantidad() - 1);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean aumentarUnidad(String inputDelTeclado) {
        if (validarCodigo(inputDelTeclado)) {//aumenta por codigo
            for (Mecato busqueda : snacks) {
                if (busqueda.getCodigo().equals(inputDelTeclado) && busqueda.getCantidad() < 6) {
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        } else {
            for (Mecato busqueda : snacks) {//aumenta por nombre
                if (busqueda.getNombre().equals(inputDelTeclado) && busqueda.getCantidad() < 6) {
                    busqueda.setCantidad(busqueda.getCantidad() + 1);
                    return true;
                }
            }
            return false;
        }
    }

    public int consultarUnidadesRestantes(String codigo) {
        if(validarExistenciaDelCodigo(codigo)) {
            for (Mecato consulta : snacks) {
                if (consulta.getCodigo().equals(codigo)) {
                    return consulta.getCantidad();
                }
            }
        }
        return 10;
    }

    public void mostrarLista(int decision) {
        if (decision == 1) {//muestra toda la lista
            for (Mecato mostrar : snacks) {
                System.out.println(mostrar.getNombre() + " precio: " + mostrar.getPrecio() + " cantidad: " + mostrar.getCantidad()+" Codigo: "+mostrar.getCodigo());
            }
        } else if (decision == 2) {//muestra solo los snacks agotados
            for (Mecato mostrar : snacks) {
                if (mostrar.getCantidad() == 0) {
                    System.out.println(mostrar.getNombre() + " precio: " + mostrar.getPrecio() + " Agotado "+" Codigo: "+mostrar.getCodigo());
                }
            }
        }
    }

    public void ordenPorValor() {

    }

    public void ordenPorCantidad() {

    }

    private boolean validarCodigo(String codigo) {
        if (codigo.length() <= 3 && validarExistenciaDelCodigo(codigo)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarExistenciaDelCodigo(String codigo) {
        for (String codigoExistente : codigos) {
            if (codigoExistente.equals(codigo)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarCapacidadMaximaMaquina() {
        if (snacks.size() < 12) {
            return true;
        } else {
            return false;
        }
    }

}
