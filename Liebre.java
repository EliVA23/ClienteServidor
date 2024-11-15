import java.util.Random;

/**
 *
 * @author elian
 */

public class Liebre extends Thread {
    static public int posicion;
    static public int pista;
    private Random random = new Random();
    
    public Liebre(int pista) {
        this.posicion = 1;
        this.pista = pista;
    }
    
    int calcularMovimientoLiebre(Random random) {
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
    
    @Override
    public void run() {
        while (posicion < pista) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int movimiento = calcularMovimientoLiebre(random);
            posicion = Math.max(1, posicion + movimiento);
        }
        System.out.println("¡La liebre ha ganado!");
    }
    
    
}
