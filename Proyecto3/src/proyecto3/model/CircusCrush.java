
/*
 * Clase principal del juego, aquí se crea el mundo y se define el tamaño de este.
 * Gracias a un método generamos los bloques dependiendo su Tipo, y de esta forma
 * rellenamos el arreglo bidimensional.
 * Además, esta clase cuenta con todas las comprobaciones de los movimientos dentro
 * del juego, y también las comprobaciones de que se deben bajar los bloques y repintar.
 */

package proyecto3.model;

import java.util.Random;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class CircusCrush {
    
    static private final int ANCHO_BLOQUE = 64;
    
    private Dimension mundo;
    private Bloque bloques[][];   
    private int cantidadBloquesHorizontales;
    private int cantidadBloquesVerticales;
    private int x;
    private int y;
    private boolean habemusEliminado = false;
    public CircusCrush(int width,  int height)
    {
        this.mundo = new Dimension(width, height);
        
        this.cantidadBloquesHorizontales = 5;
        this.cantidadBloquesVerticales = 5;
        
        this.bloques = new Bloque[cantidadBloquesHorizontales][cantidadBloquesVerticales];
        x = (width - cantidadBloquesHorizontales*ANCHO_BLOQUE)/2;
        y = 2*ANCHO_BLOQUE;
        
        for (int i = 0; i < cantidadBloquesHorizontales; i++)
        {
            for (int j = 0; j < cantidadBloquesVerticales; j++)
            {
                this.bloques[i][j] = this.generateBloque(i, j);
            }
        }
    }
    
     public Dimension getMundo()
    {
        return this.mundo;
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
        
        System.out.println(a + " " + b);
        
        int d = (p1.getX()-this.x)/ANCHO_BLOQUE;
        int c = (p1.getY()-this.y)/ANCHO_BLOQUE;
        
        System.out.println(c + " " + d);
        int m = 0;      
        
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
                
                
                if(!this.comprobacionLineas(a,b)&&!this.comprobacionLineas(a, b+1))
                {
                    aux = this.bloques[a][b];
                    this.bloques[a][b] = this.bloques[a][b+1];
                    this.bloques[a][b+1] = aux;
                    this.bloques[a][b+1].resetPosicion(a, b+1,x,y);
                    this.bloques[a][b].resetPosicion(a, b,x,y);
                }
                else
                {
                    this.habemusEliminado = true;
                }
                break;
                
                
            case 1:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a][b-1];
                this.bloques[a][b-1] = aux;
                this.bloques[a][b-1].resetPosicion(a, b-1,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                
                if(!this.comprobacionLineas(a,b)&&!this.comprobacionLineas(a, b-1))
                {
                    aux = this.bloques[a][b];
                    this.bloques[a][b] = this.bloques[a][b-1];
                    this.bloques[a][b-1] = aux;
                    this.bloques[a][b-1].resetPosicion(a, b-1,x,y);
                    this.bloques[a][b].resetPosicion(a, b,x,y);
                }
                else
                {
                    this.habemusEliminado = true;
                }
                break;
            case 3:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a-1][b];
                this.bloques[a-1][b] = aux;
                this.bloques[a-1][b].resetPosicion(a-1, b,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                
                
                if(!this.comprobacionLineas(a,b)&&!this.comprobacionLineas(a-1, b))
                {
                    aux = this.bloques[a][b];
                    this.bloques[a][b] = this.bloques[a-1][b];
                    this.bloques[a-1][b] = aux;
                    this.bloques[a-1][b].resetPosicion(a-1, b,x,y);
                    this.bloques[a][b].resetPosicion(a, b,x,y);
                }
                else
                {
                    this.habemusEliminado = true;
                }
                break;
            case 2:
                aux = this.bloques[a][b];
                this.bloques[a][b] = this.bloques[a+1][b];
                this.bloques[a+1][b] = aux;
                this.bloques[a+1][b].resetPosicion(a+1, b,x,y);
                this.bloques[a][b].resetPosicion(a, b,x,y);
                
                if(!this.comprobacionLineas(a,b)&&!this.comprobacionLineas(a+1, b))
                {
                    aux = this.bloques[a][b];
                    this.bloques[a][b] = this.bloques[a+1][b];
                    this.bloques[a+1][b] = aux;
                    this.bloques[a+1][b].resetPosicion(a+1, b,x,y);
                    this.bloques[a][b].resetPosicion(a, b,x,y);
                    System.out.println(this.comprobacionLineas(a,b));
                    System.out.println(this.comprobacionLineas(a+1,b));
                }
                else
                {
                    this.habemusEliminado = true;
                }
                break;
            case -1:
                break;
        }
        if(this.habemusEliminado==true)
        {
            this.eliminadorBloques();
            this.limpiadorBloques();
            this.rellenarBloques();
            this.habemusEliminado = false;
        }
    }   
    public boolean comprobacionLineas(int a, int b)
    {
        boolean correcto = false;
    
        if(a==0)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a+1][b].getTipo())&&this.bloques[a+1][b].getTipo().equals(this.bloques[a+2][b].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a+1][b].setEliminado(true);
                this.bloques[a+2][b].setEliminado(true);
            }
        }
        if(a==4)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a-1][b].getTipo())&&this.bloques[a-1][b].getTipo().equals(this.bloques[a-2][b].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a-1][b].setEliminado(true);
                this.bloques[a-2][b].setEliminado(true);
            }
        }
        if(a>0&&a<4)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a-1][b].getTipo())&&this.bloques[a][b].getTipo().equals(this.bloques[a+1][b].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a-1][b].setEliminado(true);
                this.bloques[a+1][b].setEliminado(true);
            }
            if(a<3&&this.bloques[a][b].getTipo().equals(bloques[a+1][b].getTipo())&&this.bloques[a+1][b].getTipo().equals(this.bloques[a+2][b].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a+1][b].setEliminado(true);
                this.bloques[a+2][b].setEliminado(true);
            }
            if(a>1&&this.bloques[a][b].getTipo().equals(bloques[a-1][b].getTipo())&&this.bloques[a-1][b].getTipo().equals(this.bloques[a-2][b].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a-1][b].setEliminado(true);
                this.bloques[a-2][b].setEliminado(true);
            }
        }
        if(b==0)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a][b+1].getTipo())&&this.bloques[a][b+1].getTipo().equals(this.bloques[a][b+2].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a][b+1].setEliminado(true);
                this.bloques[a][b+2].setEliminado(true);
            }
        }
        if(b==4)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a][b-1].getTipo())&&this.bloques[a][b-1].getTipo().equals(this.bloques[a][b-2].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a][b-1].setEliminado(true);
                this.bloques[a][b-2].setEliminado(true);
            }
        }
        else if(b>0&&b<4)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a][b-1].getTipo())&&this.bloques[a][b].getTipo().equals(this.bloques[a][b+1].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a][b-1].setEliminado(true);
                this.bloques[a][b+1].setEliminado(true);
            }
            if(b>1&&this.bloques[a][b].getTipo().equals(this.bloques[a][b-1].getTipo())&&this.bloques[a][b-1].getTipo().equals(this.bloques[a][b-2].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a][b-1].setEliminado(true);
                this.bloques[a][b-2].setEliminado(true);
            }
            if(b<3&&this.bloques[a][b].getTipo().equals(this.bloques[a][b+1].getTipo())&&this.bloques[a][b+1].getTipo().equals(this.bloques[a][b+2].getTipo()))
            {
                correcto = true;
                this.bloques[a][b].setEliminado(true);
                this.bloques[a][b+1].setEliminado(true);
                this.bloques[a][b+2].setEliminado(true);
            }
        }
        return correcto;
    }
    
    public void eliminadorBloques()
    {
        for(int i=0 ; i<this.cantidadBloquesHorizontales;i++)
        {
            for(int j= 0; j<this.cantidadBloquesVerticales;j++)
            {
                if(this.bloques[i][j].getEliminado()==false)
                {
                    boolean b = this.comprobacionLineas(i, j);
                }
            }
        }
    }
    
    public void limpiadorBloques()
    {
        for(int i=4;i>0;i--)
        {
            for(int j=4;j>=0;j--)
            {
                if(this.bloques[i][j].getEliminado()==true)
                {
                    this.bloques[i][j]=this.bloques[i-1][j];
                    this.bloques[i-1][j].setEliminado(true);
                }
            }
        }
    }
    
    public void rellenarBloques()
    {
        for(int i=0;i<this.cantidadBloquesHorizontales;i++)
        {
            for(int j=0; j<this.cantidadBloquesVerticales;j++)
            {
                if(this.bloques[i][j].getEliminado()==true)
                {
                    this.bloques[i][j] = this.generateBloque(i, j);
                }
            }
        }
    }
    
    public Bloque generateBloque(int i, int j)
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
        return bloque;
    }

    public boolean isHabemusEliminado() 
    {
        return habemusEliminado;
    }

    public void setHabemusEliminado(boolean habemusEliminado) 
    {
        this.habemusEliminado = habemusEliminado;
    }
    
}