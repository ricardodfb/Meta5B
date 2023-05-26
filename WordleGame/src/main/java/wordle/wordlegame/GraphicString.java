package wordle.wordlegame;
import java.awt.*;

public class GraphicString{
    private Canvas canvas;
    private Color color;
    
    public GraphicString(Canvas canvas){
        this.canvas = canvas;
        color = Color.white;
    }
    
    public void dibujarChar(char texto, int x, int y){
        Graphics2D graphic = canvas.getGraphic();
        graphic.setColor(color);
        graphic.setFont(new Font("Arial", Font.PLAIN, 50));
        graphic.drawString(String.valueOf(texto), x, y);
        graphic.setColor(Color.white);
    }
    
    public void dibujarString(String texto, int x, int y){
        Graphics2D graphic = canvas.getGraphic();
        graphic.setColor(color);
        graphic.setFont(new Font("Arial", Font.PLAIN, 50));
        graphic.drawString(texto, x, y);
        graphic.setColor(Color.white);
    }
    
    public void cambiarColor(Color color){
        this.color = color;
    }
}
