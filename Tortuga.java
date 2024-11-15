import java.util.Random;

/**
 *
 * @author elian
 */

public class Tortuga extends Thread{
    static public int posicion;
    static public int pista;
    private Random random = new Random();
    
    public Tortuga(int pista) {
        this.posicion = 1;
        this.pista = pista;
    }

    int calcularMovimientoTortuga(Random random) {
        int numeroAleatorio = random.nextInt(100) + 1;
        if (numeroAleatorio <= 50) {
            return 3; // Avance rápido
        } else if (numeroAleatorio <= 70) {
            return -6; // Resbaló
        } else {
            return 1; // Avance lento
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

            int movimiento = calcularMovimientoTortuga(random);
            posicion = Math.max(1, posicion + movimiento);
        }
        System.out.println("¡La tortuga ha ganado!");
    }
}
