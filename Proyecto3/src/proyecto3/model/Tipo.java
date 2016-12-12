/*
 * Tipo define cada una de los sprites a utilizar, de forma que su uso sea 
 * sencillo dentro de la clase principaldel juego (Circus Crush).
 */

package proyecto3.model;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public enum Tipo {
    CABALLO("circus1.png"),
    SOMBRERO("circus2.png"),
    CARPA("circus3.png"),
    PALOMITA("circus4.png"),
    TICKET("circus5.png"),
    GLOBO("circus6.png");
    
    private final String filename;
    
    private Tipo(String filename)
    {
        this.filename = filename;
    }

    public String getFilename()
    {
        return filename;
    }
}
