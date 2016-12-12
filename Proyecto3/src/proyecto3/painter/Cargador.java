/*
 * Cargador obtiene las imágenes usadas en el proyecto, llamándolas desde la carpeta correspondiente.
 */

package proyecto3.painter;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class Cargador {
     static private final HashMap<String, Image> IMAGENES = new HashMap<>();
    
    static public Image getImage(String filename)
    {
        Image image = Cargador.IMAGENES.get(filename);
        if( image != null )
        {
            return image;
        }
        
        image = new Image(Pintador.class.getResourceAsStream("/proyecto3/images/" + filename));
        Cargador.IMAGENES.put(filename, image);
        return image;
    }
}
