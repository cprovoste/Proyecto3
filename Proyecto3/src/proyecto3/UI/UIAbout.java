/*
 * Ventana que muestra las instrucciones y desarrolladores.
 */
package proyecto3.UI;


import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import proyecto3.model.CircusCrushCanvas;
import proyecto3.painter.Cargador;
/**
 *
 * @author Claudia
 */
public class UIAbout extends Stage implements EventHandler {
    
    private UIJuego ventana;
    
    public UIAbout(UIJuego ventana)
    {
        
        super.setTitle("Ayuda");
        StackPane root = new StackPane();
        Label background = new Label("", new ImageView(Cargador.getImage("background.png")));
        Label ayuda = new Label("", new ImageView(Cargador.getImage("ayuda.png")));
        root.getChildren().addAll(background, ayuda);
 
         
         
        Scene scene = new Scene(root, 600, 400);
        super.setScene(scene);
    }
    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
