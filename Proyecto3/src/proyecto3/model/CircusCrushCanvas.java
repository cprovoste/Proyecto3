/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
    
    public CircusCrushCanvas()
    {
        this.circusCrush = new CircusCrush(1366, 768);
        this.context = super.getGraphicsContext2D();
        
         //agrego eventos del mouse
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
        this.addEventHandler(MouseEvent.MOUSE_MOVED, this);
        
        //agrego eventos de cambios del tamano 
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
            this.mover();
            this.repintar();
        }
        
        
        if( event.getEventType() == MouseEvent.MOUSE_PRESSED )
        {
            MouseEvent me = (MouseEvent)event;
            this.circusCrush.setIniciado(true);
        }
        else if( event.getEventType() == MouseEvent.MOUSE_DRAGGED )
        {
            MouseEvent me = (MouseEvent)event;
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
    
    private void mover()
    {
        this.circusCrush.mover();
    }
    
    
    
}
