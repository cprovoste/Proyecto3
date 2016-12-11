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

    public Bloque(int x, int y, int width, int height, Tipo tipo)
    {
        super(x, y, width, height);
        this.tipo = tipo;
        this.eliminado = false;
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
    
}
