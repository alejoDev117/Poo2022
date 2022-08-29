package com.alejandro.agendaTelefonica.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgendaTelefonica {
    private String version;
    private List<Contacto> contactos;

    public AgendaTelefonica() {
        this.contactos = new ArrayList<>();
        this.version = "1.0";
    }

    public boolean crearNuevoContacto(String nombre, String apellido, int numero) {
        if (validarCantidadContactos() && validarContactoNoRepetido(numero)) {
            Contacto nuevo = new Contacto(nombre, apellido, numero);
            contactos.add(nuevo);
            ordenAlfabetico();
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarContacto(int numero) {
        if (validarExistenciaContacto(numero)) {
            for (Contacto eliminacion : contactos) {
                if (eliminacion.getNumero() == numero) {
                    contactos.remove(eliminacion);
                    ordenAlfabetico();
                    return true;
                }
            }
        }
        return false;
    }

    public void buscarNombre(String nombre) {
        for (Contacto comparador : contactos) {
            if (comparador.getNombre().equals(nombre)) {
                System.out.println("Nombre:" + comparador.getNombre() + " Apellido:" + comparador.getApellido() + " Numero:" + comparador.getNumero());
            }
        }
    }

    public void buscarApellido(String apellido) {
        for (Contacto comparador : contactos) {
            if (comparador.getApellido().equals(apellido)) {
                System.out.println("Nombre:" + comparador.getNombre() + " Apellido:" + comparador.getApellido() + " Numero:" + comparador.getNumero());
            }
        }
    }

    public void buscarNumero(int numero) {
        for (Contacto comparador : contactos) {
            if (comparador.getNumero() == numero) {
                System.out.println("Nombre:" + comparador.getNombre() + " Apellido:" + comparador.getApellido() + " Numero:" + comparador.getNumero());
            }
        }
    }

    public boolean cambioCelular(int nuevoNumero, int numeroActual) {
        if (validarExistenciaContacto(numeroActual)) {
            for (Contacto recorrido : contactos) {
                if (recorrido.getNumero() == numeroActual) {
                    recorrido.setNumero(nuevoNumero);
                    return true;
                    }
                }
            }
        return false;
    }

    private void ordenAlfabetico() {
        Collections.sort(contactos);
    }

    public void mostrarListaContacto() {
        for (Contacto mostrar : contactos) {
            System.out.println("Nombre: " + mostrar.getNombre() + " Apellido: " + mostrar.getApellido() + " Numero: " + mostrar.getNumero());
        }
    }

    private boolean validarCantidadContactos() {
        if (contactos.size() < 50) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarExistenciaContacto(int numero) {
        for (Contacto validacion : contactos) {
            if (validacion.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    private boolean validarContactoNoRepetido(int numero) {
        for (Contacto validacionRepeticion : contactos) {
            if (validacionRepeticion.getNumero() == numero) {
                return false;
            }
        }
        return true;
    }

    public String getVersion() {
        return version;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }
}
