package wordle.wordlegame;

import java.awt.*;
import java.util.*;

public class Tablero {
    private Canvas canvas;
    ArrayList<Rectangulo> cuadros = new ArrayList<>();
    int posX;
    int posY;
    
    public Tablero(){
    canvas = new Canvas("Wordle Game", 1000, 1500, Color.gray);
    canvas.setVisible(true);
}
    
    public void crearTablero() {
        posX = 175;
        posY = 175;
        int renglon = 0;
        GraphicString letraGrafica = new GraphicString(canvas);
        
        letraGrafica.cambiarColor(Color.black);
        letraGrafica.dibujarString("BIENVENIDO A WORDLE", 100, 100);
        
        for (int i = 0; i < 30; i++) {
            Rectangulo cuadro = new Rectangulo(posX, posY, 70, 70, canvas);
            cuadro.changeColor("grey");
            cuadros.add(cuadro);
            cuadros.get(i).makeVisible();
            posX += 85;
            renglon += 1;
            if (renglon == 5) {
                posY += 85;
                posX = 175;
                renglon = 0;
            }
        }
    }

    public ArrayList<Rectangulo> getCuadros() {
        return cuadros;
    }
    
    public void escribirPalabra(String palabra, int rondas){
        palabra = palabra.toUpperCase();
        char [] palabraIngresada = palabra.toCharArray();
        int j=0;
        GraphicString letraGrafica = new GraphicString(canvas);
        
        for (int i=rondas*5; i<(rondas*5)+5; i++){
            posX = cuadros.get(i).getxPosition();
            posY = cuadros.get(i).getyPosition();
            letraGrafica.dibujarChar(palabraIngresada[j], posX + 14, posY + 60);
            j++;
        }
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
}
