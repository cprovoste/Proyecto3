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
public class Dimension {
    
     private int width;
    private int height;

    public Dimension(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    Dimension(int i) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
    
    
}
