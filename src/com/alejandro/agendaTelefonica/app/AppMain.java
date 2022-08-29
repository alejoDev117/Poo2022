package com.alejandro.agendaTelefonica.app;

import com.alejandro.agendaTelefonica.dominio.AgendaTelefonica;
import com.alejandro.agendaTelefonica.dominio.Contacto;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        String menu;
        Scanner input = new Scanner(System.in);
        menu = "Menu de opciones\n" + "1.Visualizar lista de contactos\n2.Agregar un nuevo contacto\n3.Eliminar un contacto\n4.Buscar\n5.Cambiar numero\n6.Salir";
        int decision = 0;
        while (decision != 6) {
            System.out.println(menu);
            decision = input.nextInt();
            switch (decision) {
                case 1:
                    agenda.mostrarListaContacto();
                    break;
                case 2:
                    System.out.println("Ingrese nombre\n");
                    input.nextLine();
                    String nombre = input.nextLine();
                    System.out.println("Ingrese Primer apellido\n");
                    String apellido = input.nextLine();
                    System.out.println("Ingrese numero unico\n");
                    int numero = input.nextInt();
                    if (agenda.crearNuevoContacto(nombre, apellido, numero)) {
                        System.out.println("Contacto agregado con exito :)");
                    } else {
                        System.out.println("Error contacto ya existente o almacenamiento maximo alcanzado");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese numero del contacto\n");
                    int numeroEliminacion = input.nextInt();
                    if (agenda.eliminarContacto(numeroEliminacion)) {
                        System.out.println("Contacto eliminado con exito\n");
                    } else {
                        System.out.println("Error contacto no encontrado\n");
                    }
                    break;
                case 4:
                    Scanner inputBusqueda = new Scanner(System.in);
                    System.out.println("Buscar por:\n1.nombre\n2.apellido\n3.numero");
                    String decisionBusqueda = inputBusqueda.nextLine();
                    switch (decisionBusqueda){
                        case "1":
                            System.out.println("Ingrese nombre");
                            String nombreBusqueda = inputBusqueda.nextLine();
                            agenda.buscarNombre(nombreBusqueda);
                            break;
                        case "2":
                            System.out.println("Ingrese apellido");
                            String apellidoBusqueda = inputBusqueda.nextLine();
                            agenda.buscarApellido(apellidoBusqueda);
                            break;
                        case "3":
                            System.out.println("Ingrese numero");
                            int numeroBusqueda = inputBusqueda.nextInt();
                            agenda.buscarNumero(numeroBusqueda);
                            break;
                        default:
                            System.out.println("Error opcion no valida\n");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el numero de contacto actual\n");
                    int numeroActual = input.nextInt();
                    System.out.println("Ingrese el nuevo numero\n");
                    int nuevoNumero = input.nextInt();
                    agenda.cambioCelular(nuevoNumero, numeroActual);
                    break;
                case 6:
                    decision = 6;
                    break;
                default:
                    System.out.println("Error opcion no valida\n");
            }
        }
    }
}
