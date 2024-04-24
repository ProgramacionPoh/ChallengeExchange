package com.aluracursos.exchange.monedas;

import com.aluracursos.exchange.conexion.Connection;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Exchange {

    public void change() {

        //Llamado del scanner, el metodo y creacion de variable para poder almacenar en una variable
        Scanner scanner = new Scanner(System.in);
        Connection conection = new Connection();
        String coin;

        /* Bloque do-while para poder lograr la ejecucion del programa en un bucle y se pueda hacer mas de una
        consulta a la api sin tener que volver a ejecutarlo */
        do {
            System.out.println("""
                   *******************************************************************
                   Sea bienvenido/a al Conversor de Moneda =]

                   Elija la opción de cambio:\s
                   1. Dólar =>> Peso Argentino
                   2. Argentino =>> Peso Dólar
                   3. Dólar =>> Real brasileño
                   4. Real brasileño =>> Dólar
                   5. Dólar =>> Peso colombiano
                   6. Peso colombiano =>> Dólar

                   7. Salir
                   *******************************************************************
                   """);
            coin = scanner.nextLine();

            /* Se crea un switch para que en cada caso se ejecute la aplicacion como corresponde con los datos
            almacenados dentro de la api */
            switch (coin) {
                case "1":
                    JsonObject jsonObject = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates1 = jsonObject.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos [USD] quiere pasar a [ARS]");
                    String input1 = scanner.nextLine();
                    double operation1 = Double.parseDouble(input1);
                    System.out.println("La conversion de " + input1 + " " + "USD a ARS es: " +
                            operation1 * conversionRates1.get("ARS").getAsDouble());
                    break;

                case "2":
                    JsonObject jsonObject2 = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates2 = jsonObject2.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos ARS quiere pasar a USD");
                    String input2 = scanner.nextLine();
                    double operation2 = Double.parseDouble(input2);
                    System.out.println("La conversion de " + input2 + " " + "[ARS] a [USD] es: " +
                            operation2 * conversionRates2.get("USD").getAsDouble() + "\n");
                    break;

                case "3":
                    JsonObject jsonObject3 = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates3 = jsonObject3.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos [USD] quiere pasar a [BRL]");
                    String input3 = scanner.nextLine();
                    double operation3 = Double.parseDouble(input3);
                    System.out.println("La conversion de " + input3 + " " + "[USD] a [BRL] es: " +
                            operation3 * conversionRates3.get("BRL").getAsDouble());
                    break;

                case "4":
                    JsonObject jsonObject4 = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates4 = jsonObject4.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos [BRL] quiere pasar a [USD]");
                    String input4 = scanner.nextLine();
                    double operation4 = Double.parseDouble(input4);
                    System.out.println("La conversion de " + input4 + " " + "[BRL] a [USD] es: " +
                            operation4 * conversionRates4.get("USD").getAsDouble());
                    break;

                case "5":
                    JsonObject jsonObject5 = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates5 = jsonObject5.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos [USD] quiere pasar a [COP]");
                    String input5 = scanner.nextLine();
                    double operation5 = Double.parseDouble(input5);
                    System.out.println("La conversion de " + input5 + " " + "[USD] a [COP] es: " +
                            operation5 * conversionRates5.get("COP").getAsDouble());
                    break;

                case "6":
                    JsonObject jsonObject6 = conection.tipomonedas(coin);

                    // Acceso a las distintas propiedades del objeto JsonObject según la estructura de la respuesta JSON
                    JsonObject conversionRates6 = jsonObject6.getAsJsonObject("conversion_rates");

                    System.out.println("Cuantos [COP] quiere pasar a [USD]");
                    String input6 = scanner.nextLine();
                    double operation6 = Double.parseDouble(input6);
                    System.out.println("La conversion de " + input6 + " " + "[COP] a [USD] es: " +
                            operation6 * conversionRates6.get("USD").getAsDouble());
                    break;
                case "7":
                    System.out.println("Gracias por elegirnos ");
                    break;

            }
        } while (!coin.equals("7"));

    }
    }
