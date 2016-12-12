
package proyecto3;
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
import javafx.stage.Stage;
import proyecto3.model.CircusCrushCanvas;
import proyecto3.painter.Cargador;
/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class UIJuego extends Stage implements EventHandler, ChangeListener {

    private Button about;
    private Button registro;
    private Button puntaje;
    
    public UIJuego(){
        
        
        super.setTitle("Circus Crush");
        StackPane root = new StackPane();

        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);

        HBox topPane = new HBox();
        topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 71/255.0, 71/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
       // Image image = Cargador.getImage("banner.png");
       // Label logo = new Label("", new ImageView(image));
       // topPane.getChildren().addAll(logo);
        panelPrincipal.setTop(topPane);

        HBox panelBotones = new HBox(10);
        this.registro = new Button("registro");
        this.registro.setPrefWidth(100);
        this.puntaje = new Button("puntaje");
        this.puntaje.setPrefWidth(100);
        panelBotones.getChildren().addAll( this.registro, this.puntaje);
        panelPrincipal.setBottom(panelBotones);

        CircusCrushCanvas paint = new CircusCrushCanvas();
        panelPrincipal.setCenter(paint);

        paint.widthProperty().bind(root.widthProperty());
        paint.heightProperty().bind(root.heightProperty());

        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);

        this.registro.setOnAction(this);
        this.puntaje.setOnAction(this);
    }
    
    public void agregarJugador(Jugador jugador) {
       //
    }

    @Override
    public void handle(Event event) {
        
        if( event.getSource() == this.registro )
        {
            UIRegistro stage = new UIRegistro(this);
            stage.show();
        }

    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
