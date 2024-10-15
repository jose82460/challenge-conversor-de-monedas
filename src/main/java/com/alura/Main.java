package com.alura;

import com.alura.Service.ExchangeService;


import java.util.Scanner;

public class Main {

    static int opcion = -1;
    static Scanner currenciesToSearch = new Scanner(System.in);


    public static void main(String[] args) {
        while (opcion != 8) {
            menu();
            opciones();
        }
        currenciesToSearch.close();
    }

    static void menu() {
        System.out.println("""
                
                Conversor de moneda
                
                1.- Dolar Americano =>> Peso Colombiano
                2.- Peso Colombiano =>> Dolar Americano
                3.- Euro =>> Dolar Americano
                4.- Dolar Americano =>> Euro
                5.- Peso Colombiano =>> Real Brasileño
                6.- Real Brasileño =>> Peso Colombiano
                7.- Elegir un par de monedas personalizado
                8.- Salir
                Elija una opción válida:
                
                """);

        try {
            opcion = Integer.parseInt(currenciesToSearch.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            opcion = -1;
        }
    }

    static void opciones() {
        switch (opcion) {
            case 1 -> tasaConversion("USD", "COP");
            case 2 -> tasaConversion("COP", "USD");
            case 3 -> tasaConversion("EUR", "USD");
            case 4 -> tasaConversion("USD", "EUR");
            case 5 -> tasaConversion("COP", "BRL");
            case 6 -> tasaConversion("BRL", "COP");
            case 7 -> conPersonalizado();
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida. Intentelo de nuevo.");
        }
    }

    static void tasaConversion(String deDivisa, String aDivisa) {
        System.out.println("Ingresa el monto a convertir:");
        try {
            double amount = Double.parseDouble(currenciesToSearch.nextLine());
            double convertedAmount = ExchangeService.convertmonto(deDivisa, aDivisa, amount);
            System.out.printf("%.2f %s es igual a %.2f %s%n", amount, deDivisa, convertedAmount, aDivisa);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un monto válido.");
        }
    }

    static void conPersonalizado() {
        System.out.println("Para Saber los Tipos de Divisas Soportados :");
        System.out.println("https://www.exchangerate-api.com/docs/supported-currencies ");
        System.out.println("Introduce el codigo de la Divisa 1:");

        String pairSearch1 = currenciesToSearch.nextLine().toUpperCase();
        System.out.println("Introduce el codigo de la Divisa 2:");
        String pairSearch2 = currenciesToSearch.nextLine().toUpperCase();
        tasaConversion(pairSearch1, pairSearch2);
    }
}
