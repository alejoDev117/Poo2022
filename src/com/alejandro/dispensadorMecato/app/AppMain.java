package com.alejandro.dispensadorMecato.app;

import com.alejandro.dispensadorMecato.dominio.DispensadorMecato;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        DispensadorMecato maquina = new DispensadorMecato();
        String menu ="Menu de opciones\n" + "1.Ver lista de productos\n" + "2.Agregar snack\n" + "3.Quitar snack\n"
                +"4.Sacar unidad\n" + "5.Agregar unidad\n" + "6.Consultar snack\n"+"7.Ver lista de precios\n"+"8.Ver lista de unidades\n9.Salir"
                +"\n->R?";
        int decision = 0;
        while (decision != 9){
            System.out.println(menu);
            decision = input.nextInt();
            switch (decision){
                case 1:
                    maquina.mostrarLista(1);
                    break;
                case 2:
                    System.out.println("Ingrese nombre\n");
                    input.nextLine();
                    String nombreSnackNuevo = input.nextLine();
                    System.out.println("Ingrese precio\n");
                    float precioSnackNuevo = input.nextFloat();
                    if(maquina.agregarSnackCompleto(nombreSnackNuevo,precioSnackNuevo)){
                        System.out.println("Snack Agregado con exito\n");
                    }else{
                        System.out.println("Error maquina llena\n");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese codigo para poder retirarlo\n");
                    input.nextLine();
                    String codigoRetiro = input.nextLine();
                    if(maquina.quitarSnackCompleto(codigoRetiro)){
                        System.out.println("Snack retirado con exito\n");
                    }else {
                        System.out.println("Error codigo incorrecto\n");
                    }
                    break;
                case 4:
                    System.out.println("Sacar por:\n1.Nombre\n2.Codigo\n->R?");
                    int decisionBusqueda = input.nextInt();
                    switch (decisionBusqueda){
                        case 1:
                            System.out.println("Ingrese el nombre del producto\n");
                            input.nextLine();
                            String nombreSacar = input.nextLine();
                            System.out.println("Ingrese dinero\n");
                            float dinero = input.nextFloat();
                            if(maquina.sacarPorUnidad(nombreSacar,dinero)){
                                System.out.println("Exito en la operacion");
                            }else {
                                System.out.println("Error nombre desconocido o dinero insuficiente\n");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese codigo del producto\n");
                            input.nextLine();
                            String codigoSacar = input.nextLine();
                            System.out.println("Ingrese dinero\n");
                            float money = input.nextFloat();
                            if(maquina.sacarPorUnidad(codigoSacar,money)){
                                System.out.println("Exito en la operacion");
                            }else {
                                System.out.println("Error nombre desconocido o dinero insuficiente\n");
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Agregar por:\n1.Nombre\n2.Codigo\n->R?");
                    int decisionAgregar = input.nextInt();
                    switch (decisionAgregar){
                        case 1:
                            System.out.println("Ingrese nombre\n");
                            input.nextLine();
                            String nombreAgregar = input.nextLine();
                            if(maquina.aumentarUnidad(nombreAgregar)){
                                System.out.println("Exito en la operacion\n");
                            }else {
                                System.out.println("Error nombre incorrecto o espacio insuficiente para agregar\n");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese codigo\n");
                            input.nextLine();
                            String codigoAgregar = input.nextLine();
                            if(maquina.aumentarUnidad(codigoAgregar)){
                                System.out.println("Exito en la operacion\n");
                            }else {
                                System.out.println("Error codigo incorrecto o espacio insuficiente para agregar\n");
                            }
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Consultar por:\n1.Unidades restantes de un snack\n2.Lista de snacks que estan agotados\n->R?");
                    int decisionConsulta = input.nextInt();
                    switch (decisionConsulta){
                        case 1:
                            System.out.println("Ingrese Codigo\n");
                            input.nextLine();
                            String codigoDeConsulta = input.nextLine();
                            System.out.println("Cantidad restante: "+maquina.consultarUnidadesRestantes(codigoDeConsulta));
                            break;
                        case 2:
                            maquina.mostrarLista(2);
                            break;
                    }
                    break;
                case 7:
                    maquina.ordenarPorValor();
                    break;
                case 8:
                    maquina.ordenarPorCantidad();
                    break;
                case 9:
                    decision = 9;
                    break;
            }
        }
    }
}
