package com.alejandro.dispensadorMecato.app;

import com.alejandro.dispensadorMecato.dominio.DispensadorMecato;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        DispensadorMecato maquina = new DispensadorMecato();
        String menu ="Menu de opciones\n" + "1.Ver lista de productos\n" + "2.Agregar snack\n" + "3.Quitar snack\n"
                +"4.Sacar unidad\n" + "5.Agregar unidad\n" + "6.Consultar snack\n"+"7.Ver lista de precios\n"+"8.Ver lista de unidades\n";
        int decision = 0;
        while (decision != 8){
            System.out.println(menu);
            decision = input.nextInt();
            switch (decision){
                case 1:
                    maquina.mostrarLista(1);
                    break;
                case 2:
                    System.out.println("Ingrese nombre\n");
                    String nombreSnackNuevo = input.nextLine();
                    System.out.println("Ingrese precio\n");
                    float precioSnackNuevo = input.nextFloat();
                    if(maquina.agregarCompletoSnack(nombreSnackNuevo,precioSnackNuevo)){
                        System.out.println("Snack Agregado con exito\n");
                    }else{
                        System.out.println("Error maquina llena\n");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese codigo para poder retirarlo\n");
                    String codigoRetiro = input.nextLine();
                    if(maquina.quitarCompletoSnack(codigoRetiro)){
                        System.out.println("Snack retirado con exito\n");
                    }else {
                        System.out.println("Error codigo incorrecto\n");
                    }
                    break;
                case 4:
                    System.out.println("Sacar por:\n1.Nombre\n2.Codigo");
                    int decisionBusqueda = input.nextInt();
                    switch (decisionBusqueda){
                        case 1:
                            System.out.println("Ingrese el nombre del producto\n");
                            String nombreSacar = input.nextLine();
                            System.out.println("Ingrese dinero\n");
                            float dinero = input.nextFloat();
                            if(maquina.sacarUnidad(nombreSacar,dinero)){
                                System.out.println("Exito en la operacion");
                            }else {
                                System.out.println("Error nombre desconocido o dinero insuficiente\n");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese codigo del producto\n");
                            String codigoSacar = input.nextLine();
                            System.out.println("Ingrese dinero\n");
                            float money = input.nextFloat();
                            if(maquina.sacarUnidad(codigoSacar,money)){
                                System.out.println("Exito en la operacion");
                            }else {
                                System.out.println("Error nombre desconocido o dinero insuficiente\n");
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Agregar por:\n1.Nombre\n2.Codigo\n");
                    int decisionAgregar = input.nextInt();
                    switch (decisionAgregar){
                        case 1:
                            System.out.println("Ingrese nombre\n");
                            String nombreAgregar = input.nextLine();
                            if(maquina.aumentarUnidad(nombreAgregar)){
                                System.out.println("Exito en la operacion\n");
                            }else {
                                System.out.println("Error nombre incorrecto\n");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese codigo\n");
                            String codigoAgregar = input.nextLine();
                            if(maquina.aumentarUnidad(codigoAgregar)){
                                System.out.println("Exito en la operacion\n");
                            }else {
                                System.out.println("Error codigo incorrecto\n");
                            }
                            break;
                    }
                    break;
                case 6:
                    break;
            }
        }
    }
}
