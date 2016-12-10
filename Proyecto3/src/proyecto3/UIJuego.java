/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
/**
 *
 * @author Claudia
 */
public class UIJuego  extends Stage implements EventHandler, ChangeListener {

    private Button about;
    private int score;
    

    public UIJuego(Button about, int score) {
        this.about = about;
        this.score = score;
    }
    
    public UIJuego(){
        
        
    super.setTitle("Circus Crush");
    StackPane root = new StackPane();
        
    BorderPane panelPrincipal = new BorderPane();
    root.getChildren().add(panelPrincipal);
    
     HBox topPane = new HBox();
    topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 0, 102/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
    Image image = new Image(getClass().getResourceAsStream("Sin título1.png"));
    Label logo = new Label("", new ImageView(image));
    topPane.getChildren().add(logo);
    panelPrincipal.setTop(topPane);

    BorderPane panelCentral = new BorderPane();
    
    
    
      BorderPane panelTabla = new BorderPane();
    // panelTabla.setCenter(table);
     panelTabla.setPadding(new Insets(0, 0, 10, 0));
     panelCentral.setCenter(panelTabla);

     panelPrincipal.setCenter(panelCentral);

     Scene scene = new Scene(root, 800, 600);
     super.setScene(scene);
    }
    
    void agregarJugador(Jugador jugador) {
       //
    }
    
    

    
    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
