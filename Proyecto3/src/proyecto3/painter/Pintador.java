
/*
 * Pintador se encarga de "pintar" (mostrar en la ventana) los bloques del juego y también regula las dimensiones de este pintado
 * de forma que las dimensiones del juego se mantengan sin importar los cambios al tamaño de la ventana.
 */
package proyecto3.painter;


import javafx.scene.canvas.GraphicsContext;
import proyecto3.model.Bloque;
import proyecto3.model.Dimension;
import proyecto3.model.CircusCrush;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class Pintador {
    
    static public void pintar( CircusCrush juego, GraphicsContext context, Dimension mundo, Dimension ventana )
    {
        //esto debes cambiarlo para que funcione con arreglos bidimensionales.
        Bloque bloques[][] = juego.getBloques();
        for (int i = 0; i <juego.getCantidadBloquesHorizontales(); i++) 
        {
            for (int j = 0; j < juego.getCantidadBloquesVerticales(); j++) 
            {
                Bloque bloque = bloques[i][j];
                Pintador.dibujar(bloque, context, mundo, ventana);
            }
            
        }
        
    }

    
    static private void dibujar(Bloque bloque, GraphicsContext context, Dimension mundo, Dimension ventana)
    {
        int x = Pintador.convertirXACoordenadasVentana(bloque.getX(), mundo, ventana);
        int y = Pintador.convertirYACoordenadasVentana(bloque.getY(), mundo, ventana);
        int ancho = Pintador.convertirXACoordenadasVentana(bloque.getWidth(), mundo, ventana);
        int alto = Pintador.convertirYACoordenadasVentana(bloque.getHeight(), mundo, ventana);
        context.drawImage(Cargador.getImage( bloque.getTipo().getFilename()), x, y, ancho, alto);
    }
    
    
    static private int convertirXACoordenadasVentana(int x, Dimension mundo, Dimension ventana)
    {
        return x*ventana.getWidth()/mundo.getWidth();
    }
    
    static private int convertirYACoordenadasVentana(int y, Dimension mundo, Dimension ventana)
    {
        return y*ventana.getHeight()/mundo.getHeight();
    }
    
    static private int convertirMagnitudACoordenadasVentana(int magnitud, Dimension mundo, Dimension ventana)
    {
        double diagonalMundo = Math.sqrt( mundo.getWidth()*mundo.getWidth() + mundo.getHeight()*mundo.getHeight() );
        double diagonalVentana = Math.sqrt( ventana.getWidth()*ventana.getWidth() + ventana.getHeight()*ventana.getHeight() );
        return (int)(magnitud*diagonalVentana/diagonalMundo);
    }
    
    static public int convertirXACoordenadasMundo(int x, Dimension mundo, Dimension ventana)
    {
        return x*mundo.getWidth()/ventana.getWidth();
    }
    
    static public int convertirYACoordenadasMundo(int y, Dimension mundo, Dimension ventana)
    {
        return y*mundo.getHeight()/ventana.getHeight();
    }
}
