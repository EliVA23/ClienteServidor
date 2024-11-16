import java.util.Random;

/**
 *
 * @author Grupo1
 */

public class PracticaProgramadaCS2 {

    public static void main(String[] args) {
        Random random = new Random();
        int pista = 70;
        int posicionLiebre = 1;
        int posicionTortuga =1;
        
        Tortuga tortuga = new Tortuga(pista);
        tortuga.posicion = posicionTortuga;
        
        Liebre liebre = new Liebre(pista);
        liebre.posicion = posicionLiebre;
        
        Thread hiloTortuga = new Thread(tortuga);
        Thread hiloLiebre = new Thread(liebre);

        hiloTortuga.start();
        hiloLiebre.start();

        System.out.println("Comienza la carrera de la liebre y la tortuga!");
        while (posicionLiebre < pista && posicionTortuga < pista) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Movimiento de la tortuga
            int movimientoTortuga = tortuga.calcularMovimientoTortuga(random);
            posicionTortuga = Math.max(1, posicionTortuga + movimientoTortuga);
            // Movimiento de la liebre
            int movimientoLiebre  = liebre.calcularMovimientoLiebre(random);
            posicionLiebre = Math.max(1, posicionLiebre + movimientoLiebre);
            // Imprimir la pista
            imprimirPista(posicionTortuga, posicionLiebre, pista);
        }
        if (posicionTortuga == pista) {
            System.out.println("La tortuga ha ganado la carrera!");
        } else {
            System.out.println("La liebre ha ganado la carrera!");
        }
    }

    private static void imprimirPista(int posicionTortuga, int posicionLiebre, int pista) {
        for (int i = 1; i <= pista; i++) {
            if (i == posicionTortuga) {
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
