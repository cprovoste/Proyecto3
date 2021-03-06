
/*
 * Clase principal del juego, aquí se crea el mundo y se define el tamaño de este.
 * Gracias a un método generamos los bloques dependiendo su Tipo, y de esta forma
 * rellenamos el arreglo bidimensional.
 * Además, esta clase cuenta con todas las comprobaciones de los movimientos dentro
 * del juego, y también las comprobaciones de que se deben bajar los bloques y repintar.
 */

package proyecto3.model;

import java.util.ArrayList;
import java.util.Random;
import proyecto3.Partida;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class CircusCrush {
    
    static private final int ANCHO_BLOQUE = 64;
    
    private Dimension mundo;
    private Partida partida;
    private Bloque bloques[][];   
    private int cantidadBloquesHorizontales;
    private int cantidadBloquesVerticales;
    private int x;
    private int y;
    private boolean habemusEliminado = false;
    
    public CircusCrush(int width,  int height)
    {
        this.mundo = new Dimension(width, height);
        
        this.partida = new Partida("", 5,0);
        this.cantidadBloquesHorizontales = 5;
        this.cantidadBloquesVerticales = 5;
        
        this.bloques = new Bloque[cantidadBloquesHorizontales][cantidadBloquesVerticales];
        x = (width - cantidadBloquesHorizontales*ANCHO_BLOQUE)/2;
        y = ANCHO_BLOQUE;
        
        for (int i = 0; i < cantidadBloquesHorizontales; i++)
        {
            for (int j = 0; j < cantidadBloquesVerticales; j++)
            {
                this.bloques[i][j] = this.generateBloque(i, j);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
            this.partida.aumentarPuntaje();
            if(this.existenMovimientos()==false&&this.partida.getVidas()>=1)
            {
                this.partida.reducirVida();
            }
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
    
    public boolean existenMovimientos()
    {
        for(int i=0; i<5; i++)
        {
            for(int j = 0 ; j< 4 ; j++)
            {
                if(this.bloques[i][j].getTipo().equals(this.bloques[i][j+1]))
                {
                    
                    if(this.horizontalA(i, j, i, j+1) == true )
                    {
                        return true;
                    }
                    
                }
                
            }
            
        }
        
        for(int i =0 ; i<5;i++)
        {
            for(int j = 0 ; j < 3  ;j ++)
            {
                if(this.bloques[i][j].getTipo().equals(this.bloques[i][j+2]))
                {
                    
                    if(this.horizontalB(i, j, i, j+2) == true )
                    {
                        return true;
                    }
                }
            }

        }
         for(int j=0; j<5; j++)
        {
            for(int i = 0 ; i< 4 ; i++)
            {
                 if(this.bloques[i][j].getTipo().equals(this.bloques[i+1][j]))
                {
                    
                    if(this.verticalA(i, j, i+1, j) == true )
                    {
                        return true;
                    }
                    
                }
                
            }
            
        }
         
         for(int j=0; j<5; j++)
        {
            for(int i = 0 ; i< 3 ; i++)
            {
                 if(this.bloques[i][j].getTipo().equals(this.bloques[i+2][j]))
                {
                    
                    if(this.verticalB(i, j, i+2, j) == true )
                    {
                        return true;
                    }
                    
                }
                
            }
            
        }
        
        
        return false;
    }
    
    public boolean horizontalA(int a, int b, int c, int d)
    {
        boolean posible = false;
      
        if(a-1>=0&&a-1<=4&&b-1>=0&&b-1<=4)
        {
            if(this.bloques[a][b].getTipo().equals(this.bloques[a-1][b-1]))
            {
                posible = true;
            }
        }
        if(b-2>=0&&b-2<=4){
            if(this.bloques[a][b].getTipo().equals(this.bloques[a][b-2]))
            {
                posible = true;
            }
            
        }
        
        if(a+1>=0&&a+1<=4&&b-1>=0&&b-1<=4){
            
           if( this.bloques[a][b].getTipo().equals(this.bloques[a+1][b-1]))
           {
                posible = true;
           }
        }
        if(c+1>=0&&c+1<=4&&d+1>=0&&d+1<=4)
        {
           if( this.bloques[c][d].getTipo().equals(this.bloques[c+1][d+1]))
           {
               posible = true;
           }
        }
           
        if(d+2>=0&&d+2<=4)
        {
            if( this.bloques[c][d].getTipo().equals(this.bloques[c][d+2]))
            {
                 posible = true;
            }
        }
            
        if(c-1>=0&&c-1<=4&&d+1>=0&&d+1<=4)
        {
            if( this.bloques[c][d].getTipo().equals(this.bloques[c-1][d+1]))
            {
                 posible = true;
            }
        }
           
           
            
        return posible;
        
    }
    
     public boolean horizontalB(int a, int b, int c, int d)
     {
        boolean posible = false;
         
         if(a+1>=0&&a+1<=4&&b+1>=0&&b+1<=4)
         {
             if(this.bloques[a][b].getTipo().equals(this.bloques[a+1][b+1]))
             {
                 posible = true;
             }
         }

         if(c-1>=0&&c-1<=4&&d-1>=0&&d-1<=4)
         {
             
             if(this.bloques[c][d].getTipo().equals(this.bloques[c-1][d-1]))
             {
                  posible = true;
             }
         }
         
         
         
         return posible;
     }
     
     public boolean verticalA(int a, int b, int c, int d)
     {
          boolean posible = false;
          
          if(a+1>=0&&a+1<=4&&b-1>=0&&b-1<=4)
          {
              if( this.bloques[a][b].getTipo().equals(this.bloques[a+1][b-1]))
              {
                  posible = true;
             
              }
          }
          if(a+2>=0&&a+2<=4)
          {
              if(this.bloques[a][b].getTipo().equals(this.bloques[a+2][b]))
              {
                  posible = true;
             
              }
          }
          if(a+1>=0&&a+1<=4&&b+1>=0&&b+1<=4)
          {
              if(  this.bloques[a][b].getTipo().equals(this.bloques[a+1][b+1]))
              {
                  posible = true;
             
              }
          }
          if(c-1>=0&&c-1<=4&&d-1>=0&&d-1<=4)
          {
              if( this.bloques[c][d].getTipo().equals(this.bloques[c-1][d-1]))
              {
                  posible = true;
             
              }
          }
          if(c-2>=0&&c-2<=4)
          {
              if(  this.bloques[c][d].getTipo().equals(this.bloques[c-2][d]))
              {
                  posible = true;
             
              }
          }
          if(c-1>=0&&c-2>=4&&d+1>=0&&d+1<=4)
          {
              if(this.bloques[c][d].getTipo().equals(this.bloques[c-1][d+1]))
              {
                  posible = true;
             
              }
          }
                          
         return posible;
     }
     
      public boolean verticalB(int a, int b, int c, int d)
      {
         boolean posible = false;
          
         if(a-1>=0&&a-1<=4&&b-1>=0&&b-1<=4)
         {
             if(this.bloques[a][b].getTipo().equals(this.bloques[a-1][b-1]))
             {
                 posible = true;
             }
         }
         
         if(c+1>=0&&c+1<=4&&d+1>=0&&d+1<=4)
         {
             if(this.bloques[c][d].getTipo().equals(this.bloques[c+1][d+1]))
             {
                 posible = true;
             }
         }
         
                 
         
          
         return posible;
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
                    Bloque aux = this.bloques[i][j];
                    this.bloques[i][j]=this.bloques[i-1][j];
                    this.bloques[i-1][j] = aux;
                    this.bloques[i-1][j].resetPosicion(i-1, j, x, y);
                    this.bloques[i][j].resetPosicion(i,j,x,y);
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

    public Partida getPartida() 
    {
        return partida;
    }

    public void setPartida(Partida partida) 
    {
        this.partida = partida;
    }
    
}