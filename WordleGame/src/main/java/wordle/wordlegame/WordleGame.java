package wordle.wordlegame;

import java.util.*;
import java.awt.*;

public class WordleGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rondas = 0;
        boolean win = false;
        Wordle juego = new Wordle();
        Tablero tablero = new Tablero();
        tablero.crearTablero();
        Teclado teclado = new Teclado(tablero.getCanvas());
        teclado.dibujarTeclado();
        GraphicString letraGrafica = new GraphicString(tablero.getCanvas());
        
        System.out.println("                       WORDLE");
        System.out.println("Trata de encontrar la palabra correcta en 6 intentos!");
        System.out.println("       El largo de la palabra es de 6 letras.\n\n");
        System.out.println("Empezamos...");

        while (rondas < 6 && !win) {
            System.out.println("Ingresa tu respuesta: ");
            String intento = scanner.nextLine();
            
            if (intento.length() > juego.getSecreto().length() || intento.length() < juego.getSecreto().length()) {
                System.out.println("La palabra ingresada es demasiado larga o demasiado corta. Inténtalo de nuevo.");
                continue;
            }
            
            juego.intento(intento, teclado, tablero, rondas);
            tablero.escribirPalabra(intento, rondas);

            if (intento.toUpperCase().equals(juego.getSecreto().toUpperCase())) {
                win = true;
                System.out.println("¡Felicidades! Ganaste el juego.");
                letraGrafica.cambiarColor(Color.green);
                letraGrafica.dibujarString("VICTORIA", 270, 150);
            } else {
                rondas++;
                System.out.println("\nTe quedan " + (6-rondas) + " intentos.");
            }
        }

        if (!win) {
            System.out.println("Lo siento, has perdido. La palabra secreta era: " + juego.getSecreto());
            letraGrafica.cambiarColor(Color.red);
            letraGrafica.dibujarString("DERROTA", 270, 150);
        }
    }
}