package org.example;

import java.util.Random;

public class Liebre extends Thread {
    private int posicion;
    private final int pista;
    private final Random random = new Random();

    public Liebre(int pista) {
        this.posicion = 1;
        this.pista = pista;
    }

    public int getPosicion() {
        return posicion;
    }

    private int calcularMovimiento() {
        int numeroAleatorio = random.nextInt(100) + 1;
        if (numeroAleatorio <= 20) {
            return 0; // duerme
        } else if (numeroAleatorio <= 40) {
            return 9; // gran salto
        } else if (numeroAleatorio <= 50) {
            return -12; // resbalon grande
        } else if (numeroAleatorio <= 80) {
            return 1; // pequeno salto
        } else {
            return -2; // pequeno resbalon
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
