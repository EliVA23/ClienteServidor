package org.example;

import java.util.Random;

public class Tortuga extends Thread {
    private int posicion;
    private final int pista;
    private final Random random = new Random();

    public Tortuga(int pista) {
        this.posicion = 1;
        this.pista = pista;
    }

    public int getPosicion() {
        return posicion;
    }

    private int calcularMovimiento() {
        int numeroAleatorio = random.nextInt(100) + 1;
        if (numeroAleatorio <= 50) {
            return 3; // avance rapido
        } else if (numeroAleatorio <= 70) {
            return -6; // resbalon
        } else {
            return 1; // avance lento
        }
    }

    @Override
    public void run() {
        while (posicion < pista) {
            try {
                Thread.sleep(1000); // esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            posicion = Math.max(1, posicion + calcularMovimiento());
        }
    }
}
