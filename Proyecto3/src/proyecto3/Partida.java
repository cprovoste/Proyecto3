
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

    private String nombreJugador;
    private int vidas;
    private int puntaje;
    
    public Partida(int vidas) {
            
        this.nombreJugador = nombreJugador;
        this.vidas = vidas;
        this.puntaje = puntaje;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void aumentarPuntaje()
    {
        this.puntaje =+ 100;
    }

}
