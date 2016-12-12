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
public class Bloque extends Cuadrado {
    
    private Tipo tipo;
    private boolean eliminado;
    private int number;

    public Bloque(int x, int y, int width, int height, Tipo tipo, int n)
    {
        super(x, y, width, height);
        this.tipo = tipo;
        this.eliminado = false;
        this.number = n;
    }

    public int getNumber() 
    {
        return number;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }

    public Tipo getTipo()
    {
        return tipo;
    }

    public void setTipo(Tipo tipo)
    {
        this.tipo = tipo;
    }

    public boolean getEliminado() 
    {
        return this.eliminado;
    }

    public void setEliminado(boolean eliminado)
    {
        this.eliminado = eliminado;
    }
    
    public void resetPosicion(int a, int b, int c, int d)
    {
        this.setX(c + b*64);
        this.setY(d + a*64);
    }
}
