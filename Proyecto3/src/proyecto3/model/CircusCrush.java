/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Claudia
 */
public class CircusCrush {
    
    static private final int SEPARACION = 50;
    static private final int ANCHO_BLOQUE = 64;
    
    private Dimension mundo;
    private ArrayList<Bloque> bloques;   
    
    private boolean iniciado;
    
    public CircusCrush(int width,  int height)
    {
        this.mundo = new Dimension(width, height);
        
        int cantidadBloquesHorizontales = 9;
        int cantidadBloquesVerticales = 8;
        
        this.bloques = new ArrayList<>();
        int x = (width - cantidadBloquesHorizontales*ANCHO_BLOQUE)/2;
        int y = (width - cantidadBloquesHorizontales*ANCHO_BLOQUE)/2;
        
        for (int i = 0; i < cantidadBloquesVerticales; i++)
        {
            for (int j = 0; j < cantidadBloquesHorizontales; j++)
            {
                
                Tipo tipo = Tipo.CABALLO;
                switch(i)
                {
                    case 0: case 6: tipo = Tipo.SOMBRERO; break;
                    case 1: case 7: tipo = Tipo.CARPA; break;
                    case 2: tipo = Tipo.CABALLO; break;
                    case 3: tipo = Tipo.PALOMITA; break;
                    case 4: tipo = Tipo.TICKET; break;
                    case 5: tipo = Tipo.GLOBO; break;
                }
                
                Bloque bloque = new Bloque(x + j*ANCHO_BLOQUE, y + i*ANCHO_BLOQUE, ANCHO_BLOQUE, ANCHO_BLOQUE, tipo);
                this.bloques.add(bloque);
            }
        }
        
        
        this.iniciado = false;
    }
    
     public Dimension getMundo()
    {
        return this.mundo;
    }

    public boolean isIniciado()
    {
        return iniciado;
    }

    public void setIniciado(boolean iniciado)
    {
        this.iniciado = iniciado;
    }

    public Iterator<Bloque> iterator()
    {
        return bloques.iterator();
    }

     public void mover()
    {
        
    }
}
