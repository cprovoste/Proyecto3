
/*
 * Un jugador solo tiene un nombre, que luego se agrega a una partida
 */
package proyecto3;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class Jugador {
    
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
