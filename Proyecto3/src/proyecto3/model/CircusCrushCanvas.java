
/*
 * En este Canvas se mantiene actualizado el pintado de los bloques y se manejan
 * todos los eventos del mouse. Además, se mantienen los márgenes clickeables por
 * el usuario.
 */
package proyecto3.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import proyecto3.model.Dimension;
import proyecto3.model.CircusCrush;
import proyecto3.painter.Cargador;
import proyecto3.painter.Pintador;
/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class CircusCrushCanvas extends javafx.scene.canvas.Canvas implements EventHandler, ChangeListener {

    private CircusCrush circusCrush;
    private final GraphicsContext context;
    private Punto punto;
    private Punto punto1;
    
    public CircusCrushCanvas()
    {
        this.circusCrush = new CircusCrush(500, 500);
        this.context = super.getGraphicsContext2D();
        
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
        this.addEventHandler(MouseEvent.MOUSE_MOVED, this);
        
        this.widthProperty().addListener(this);
        this.heightProperty().addListener(this);
        
        Timeline timer = new Timeline( new KeyFrame(Duration.millis(5), this));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }
    @Override
    public void handle(Event event) {
         if( event.getSource() instanceof KeyFrame )
        {
            this.repintar();
        }
        if( event.getEventType() == MouseEvent.MOUSE_PRESSED )
        {
            MouseEvent me = (MouseEvent)event;
            int x = (int)me.getX();
            int y = (int)me.getY();
            if(x>81&&x<322&&y>110&&y<349)
            {
                int nx = Pintador.convertirXACoordenadasMundo(x, circusCrush.getMundo(),new Dimension((int)this.getWidth(), (int)this.getHeight()));
                int ny = Pintador.convertirYACoordenadasMundo(y, circusCrush.getMundo(),new Dimension((int)this.getWidth(), (int)this.getHeight()));
                this.punto = new Punto(nx, ny);
            }
             
        }
        else if( event.getEventType() == MouseEvent.MOUSE_DRAGGED )
        {
            MouseEvent me = (MouseEvent)event;
            int x = (int)me.getX();
            int y = (int)me.getY();
            if(x>76&&x<322&&y>110&&y<355)
            {
                int nx = Pintador.convertirXACoordenadasMundo(x, circusCrush.getMundo(),new Dimension((int)this.getWidth(), (int)this.getHeight()));
                int ny = Pintador.convertirYACoordenadasMundo(y, circusCrush.getMundo(),new Dimension((int)this.getWidth(), (int)this.getHeight()));
                this.punto1 = new Punto(nx, ny);
            }
            this.circusCrush.calculoMovimientos(punto, punto1);
             try {
                 Thread.sleep(400);
             } catch (InterruptedException ex) {
                 Logger.getLogger(CircusCrushCanvas.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
       
        this.repintar();
        
    }
    
    private void repintar()
    {
        this.context.clearRect(0, 0, (int)this.getWidth(), (int)this.getHeight());
    
        this.context.drawImage(Cargador.getImage("background.png"), 0, 0, this.getWidth(), this.getHeight());
        
        
        
        if(this.circusCrush != null)
        {
            Pintador.pintar(this.circusCrush, this.context, circusCrush.getMundo(), new Dimension((int)this.getWidth(), (int)this.getHeight()));
        }
    }
    
}
