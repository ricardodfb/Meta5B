package wordle.wordlegame;

import java.util.*;

public class Teclado {

    ArrayList<Rectangulo> teclas = new ArrayList();
    private char[] letras = new char[26];
    private int posX;
    private int posY;
    private int renglon;
    private Canvas canvas;

    public Teclado(Canvas canvas) {
        this.canvas = canvas;
    }

    public void dibujarTeclado() {
        posX = 175;
        posY = 700;
        renglon = 0;
        char letra = 'A';
        GraphicString letraGrafica = new GraphicString(canvas);
        
        for (int i = 0; i < 26; i++) {
            teclas.add(new Rectangulo(posX, posY, 60, 80, canvas));
            teclas.get(i).changeColor("grey");
            teclas.get(i).fill();
            teclas.get(i).makeVisible();
            
            letras[i] = letra; // Guardar la letra dibujada en el arreglo letras
            letraGrafica.dibujarChar(letra, posX+14, posY+60);
            posX += 65; // Ajustar la distancia horizontal entre teclas
            letra++;
            renglon++;
            if (renglon == 9) {
                posY += 95; // Ajustar la distancia vertical entre filas
                posX = 175;
                renglon = 0;
            }
        }
    }
    
    public void cambiarColorTecla(char letra, String color){
        GraphicString letraGrafica = new GraphicString(canvas);
        for (int i=0; i<letras.length; i++ ){
            if (letra == letras[i]){
                int index = i ;
                teclas.get(i).changeColor(color);
                teclas.get(i).fill();
            
                posX = teclas.get(i).getxPosition();
                posY = teclas.get(i).getyPosition();
                letraGrafica.dibujarChar(letra, posX+14, posY+60);
            }
        }
    }

    public ArrayList<Rectangulo> getTeclas() {
        return teclas;
    }

    public char[] getLetras() {
        return letras;
    }

    public boolean contieneElemento(char[] arreglo, char elemento) {
        for (char c : arreglo) {
            if (c == elemento) {
                return true;
            }
        }
        return false;
    }
}
