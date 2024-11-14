import java.util.Random;

/**
 *
 * @author elian
 */

public class PracticaProgramadaCS2 {

    public static void main(String[] args) {
        int pista = 70;
        int posicionLiebre = 1;
        int posicionTortuga = 1;
        Random random = new Random();

        System.out.println("¡Comienza la carrera de la liebre y la tortuga!");

        while (posicionLiebre < pista && posicionTortuga < pista) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Movimiento de la tortuga
            int movimientoTortuga = calcularMovimientoTortuga(random);
            posicionTortuga = Math.max(1, posicionTortuga + movimientoTortuga);

            // Movimiento de la liebre
            int movimientoLiebre = calcularMovimientoLiebre(random);
            posicionLiebre = Math.max(1, posicionLiebre + movimientoLiebre);

            // Imprimir la pista
            imprimirPista(posicionTortuga, posicionLiebre, pista);
        }

        if (posicionTortuga == pista) {
            System.out.println("¡La tortuga ha ganado la carrera!");
        } else {
            System.out.println("¡La liebre ha ganado la carrera!");
        }
    }

    private static int calcularMovimientoTortuga(Random random) {
        int numeroAleatorio = random.nextInt(100) + 1;
        if (numeroAleatorio <= 50) {
            return 3; // Avance rápido
        } else if (numeroAleatorio <= 70) {
            return -6; // Resbaló
        } else {
            return 1; // Avance lento
        }
    }

    private static int calcularMovimientoLiebre(Random random) {
        int numeroAleatorio = random.nextInt(100) + 1;
        if (numeroAleatorio <= 20) {
            return 0; // Duerme
        } else if (numeroAleatorio <= 40) {
            return 9; // Gran salto
        } else if (numeroAleatorio <= 50) {
            return -12; // Resbalón grande
        } else if (numeroAleatorio <= 80) {
            return 1; // Pequeño salto
        } else {
            return -2; // Pequeño resbalón
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
