/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.model;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class CircusCrush {
    
    static private final int SEPARACION = 50;
    static private final int ANCHO_BLOQUE = 64;
    
    private Dimension mundo;
    private Bloque bloques[][];   
    private int cantidadBloquesHorizontales;
    private int cantidadBloquesVerticales;
    private int x;
    private int y;
    public CircusCrush(int width,  int height)
    {
        this.mundo = new Dimension(width, height);
        
        this.cantidadBloquesHorizontales = 9;
        this.cantidadBloquesVerticales = 9;
        
        this.bloques = new Bloque[cantidadBloquesHorizontales][cantidadBloquesVerticales];
        x = (width - cantidadBloquesHorizontales*ANCHO_BLOQUE)/2;
        y = 2*ANCHO_BLOQUE;
        
        for (int i = 0; i < cantidadBloquesHorizontales; i++)
        {
            for (int j = 0; j < cantidadBloquesVerticales; j++)
            {
                
                Tipo tipo = Tipo.CABALLO;
                switch(i)
                {
                    case 0: case 6: tipo = Tipo.SOMBRERO; break;
                    case 1: case 7: tipo = Tipo.CARPA; break;
                    case 2: case 8: tipo = Tipo.CABALLO; break;
                    case 3: tipo = Tipo.PALOMITA; break;
                    case 4: tipo = Tipo.TICKET; break;
                    case 5: tipo = Tipo.GLOBO; break;
                }
                
                Bloque bloque = new Bloque(x + j*ANCHO_BLOQUE, y + i*ANCHO_BLOQUE, ANCHO_BLOQUE, ANCHO_BLOQUE, tipo);
                this.bloques[i][j] = bloque;
            }
        }
    }
    
     public Dimension getMundo()
    {
        return this.mundo;
    }

     public void mover()
    {
        
    }

    public Bloque[][] getBloques() 
    {
        return bloques;
    }

    public void setBloques(Bloque[][] bloques) 
    {
        this.bloques = bloques;
    }

    public int getCantidadBloquesHorizontales() 
    {
        return cantidadBloquesHorizontales;
    }

    public void setCantidadBloquesHorizontales(int cantidadBloquesHorizontales) 
    {
        this.cantidadBloquesHorizontales = cantidadBloquesHorizontales;
    }

    public int getCantidadBloquesVerticales() 
    {
        return cantidadBloquesVerticales;
    }

    public void setCantidadBloquesVerticales(int cantidadBloquesVerticales)
    {
        this.cantidadBloquesVerticales = cantidadBloquesVerticales;
    }
    
    public void calculoMovimientos(Punto p, Punto p1)
    {
        int b = (p.getX()-this.x)/ANCHO_BLOQUE;
        int a = (p.getY()-this.y)/ANCHO_BLOQUE;
        
        System.out.println(a + "," + b);
        
        int d = (p1.getX()-this.x)/ANCHO_BLOQUE;
        int c = (p1.getY()-this.y)/ANCHO_BLOQUE;
        
        System.out.println(c + "," + d);
        
        if(c-a!=d-b)
        {
            if (c - a >= 1)
            {
                
            } else if (c - a <= -1)
            {
                
            } else if (d - b >= 1)
            {
                
            } else if (d - b <= -1)
            {
                
            }
        }
    }
}
     
    