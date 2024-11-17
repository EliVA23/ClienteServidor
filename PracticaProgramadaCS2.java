package org.example;

public class Main {

    public static void main(String[] args) {
        int pista = 70;

        // crear hilos
        Tortuga tortuga = new Tortuga(pista);
        Liebre liebre = new Liebre(pista);

        System.out.println("Comienza la carrera de la liebre y la tortuga!");

        // iniciar hilos
        tortuga.start();
        liebre.start();

        // monitorizar la carrera
        while (tortuga.getPosicion() < pista && liebre.getPosicion() < pista) {
            imprimirPista(tortuga.getPosicion(), liebre.getPosicion(), pista);

            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // determinar el ganador
        if (tortuga.getPosicion() >= pista && liebre.getPosicion() >= pista) {
            System.out.println("Es un empate!");
        } else if (tortuga.getPosicion() >= pista) {
            System.out.println("La tortuga ha ganado la carrera!");
        } else {
            System.out.println("La liebre ha ganado la carrera!");
        }
    }

    private static void imprimirPista(int posicionTortuga, int posicionLiebre, int pista) {
        for (int i = 1; i <= pista; i++) {
            if (i == posicionTortuga && i == posicionLiebre) {
                System.out.print("TL"); // si estan en la misma casilla
                i++; // aaltar un espacio adicional
            } else if (i == posicionTortuga) {
                System.out.print("T");
            } else if (i == posicionLiebre) {
                System.out.print("L");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
