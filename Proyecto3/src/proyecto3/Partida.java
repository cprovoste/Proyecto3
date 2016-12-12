
/*
 * Partida contiene un jugador, las vidas de la partida y el puntaje de ésta.
 * La información de esta clase es la que va a las tablas de highscores.
 */

package proyecto3;

/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class Partida {

    private int vidas;
    
    public Partida(int vidas) {
            
        this.vidas = vidas;
        
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    

}
