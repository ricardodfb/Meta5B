package wordle.wordlegame;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Wordle {
    private ArrayList<String> palabras = new ArrayList<>();
    private Random random = new Random();
    private String secreta;
    private String intento;

    public Wordle(){
        try {
            InputStream inputStream = Wordle.class.getResourceAsStream("/palabras.txt");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                
                while ((linea = reader.readLine()) != null) {
                    palabras.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        secreta = palabras.get(random.nextInt(palabras.size()));
    }

    public String getSecreto(){
        return secreta;
    }

public void intento(String intento, Teclado teclado, Tablero tablero, int rondas){
    char[] letras = teclado.getLetras();
    ArrayList<Rectangulo> cuadros = tablero.getCuadros();
    this.intento = intento.toUpperCase(); // Convertir a mayúsculas
    char[] palabraIngresada = this.intento.toCharArray();
    char[] palabraSecreta = secreta.toCharArray();
    boolean[] encontrados = new boolean[palabraSecreta.length]; // Array para llevar seguimiento de letras ya encontradas
    
    for (int i=0; i < palabraIngresada.length; i++) {
        boolean encontrado = false;
        
        for (int j=0; j < palabraSecreta.length; j++) {
            if (palabraIngresada[i] == palabraSecreta[j] && i == j && !encontrados[j]) { // Si la letra está bien colocada y no ha sido encontrada antes
                for (int z = 0; z < letras.length; z++) {
                    if (palabraIngresada[i] == letras[z]) {
                        teclado.cambiarColorTecla(palabraIngresada[i], "green");
                        cuadros.get(rondas*5 + i).changeColor("green");
                        cuadros.get(rondas*5 + i).fill();
                    }
                }
                System.out.println(palabraIngresada[i] + " pertenece a la palabra y está colocada correctamente");
                encontrado = true;
                encontrados[j] = true; // Marcar como encontrada
                break;
            } else if (palabraIngresada[i] == palabraSecreta[j] && !encontrados[j]) { // Si la letra pertenece a la palabra pero no está bien colocada y no ha sido encontrada antes
                for (int z=0; z < letras.length; z++) {
                    if (palabraIngresada[i] == letras[z]) {
                        teclado.cambiarColorTecla(palabraIngresada[i], "yellow");
                        cuadros.get(rondas*5 + i).changeColor("yellow");
                        cuadros.get(rondas*5 + i).fill();
                    }
                }
                System.out.println(palabraIngresada[i] + " La letra pertenece a la palabra, pero no está bien colocada");
                encontrado = true;
                encontrados[j] = true; // Marcar como encontrada
                break;
            }
        }
        
        if (!encontrado) {
            for (int z=0; z < letras.length; z++) {
                if (palabraIngresada[i] == letras[z]) {
                    teclado.cambiarColorTecla(palabraIngresada[i], "");
                    cuadros.get(rondas*5 + i).changeColor("");
                        cuadros.get(rondas*5 + i).fill();
                }
            }
            System.out.println(palabraIngresada[i] + " La letra no pertenece a la palabra");
        }
    }
    
    System.out.println("Fin del intento");
}

}