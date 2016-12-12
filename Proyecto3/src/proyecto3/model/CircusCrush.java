/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.model;

import java.util.Random;
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
                Random random = new Random();
                int number = random.nextInt(5);
                switch(number)
                {
                    case 0: tipo = Tipo.SOMBRERO; break;
                    case 1: tipo = Tipo.CARPA; break;
                    case 2: tipo = Tipo.CABALLO; break;
                    case 3: tipo = Tipo.PALOMITA; break;
                    case 4: tipo = Tipo.TICKET; break;
                    case 5: tipo = Tipo.GLOBO; break;
                }
                
                Bloque bloque = new Bloque(x + j*ANCHO_BLOQUE, y + i*ANCHO_BLOQUE, ANCHO_BLOQUE, ANCHO_BLOQUE, tipo,number);
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
        
        int m = 0;
        System.out.println(d - b);
        System.out.println(c - a);       
        
        if(c-a!=d-b)
        {
            if (d - b >= 1)
            {
                m = 0;
            } else if (d - b <= -1)
            {
                m=1;
            } else if (c - a >= 1)
            {
                m=2;
            } else if (c - a <= -1)
            {
                m=3;
            }
        }
        else
        {
            m=-1;
        }
        Bloque aux;
        switch(m)
        {
            case 0:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a][b+1];
                this.bloques[a][b+1] = aux;
                this.bloques[a][b+1].resetPosicion(a, b+1,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                break;
            case 1:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a][b-1];
                this.bloques[a][b-1] = aux;
                this.bloques[a][b-1].resetPosicion(a, b-1,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                break;
            case 3:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a-1][b];
                this.bloques[a-1][b] = aux;
                this.bloques[a-1][b].resetPosicion(a-1, b,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                break;
            case 2:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a+1][b];
                this.bloques[a+1][b] = aux;
                this.bloques[a+1][b].resetPosicion(a+1, b,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                break;
            case -1:
                break;
        }
    }
}
     
    