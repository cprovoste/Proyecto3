/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
