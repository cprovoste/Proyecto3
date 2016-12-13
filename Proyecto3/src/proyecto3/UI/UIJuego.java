/**
 * Stage principal, tiene un panel en donde se realiza el pintado del juego.
 * Esta es la ventana principal donde ocurre el gameplay.
 */

package proyecto3.UI;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
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
import proyecto3.Partida;
import proyecto3.model.CircusCrushCanvas;
import proyecto3.painter.Cargador;
/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class UIJuego extends Stage implements EventHandler, ChangeListener {

    private Button about;
    private Button puntajes;
    private CircusCrushCanvas paint;
    private ArrayList<Partida> partidas;
    
    public UIJuego(){
        
        
        super.setTitle("Circus Crush");
        StackPane root = new StackPane();

        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);

        BorderPane topPane = new BorderPane();
        topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 71/255.0, 71/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        topPane.setPadding( new Insets(10,0,0,0) );
        
        paint = new CircusCrushCanvas();
        
        Partida partida = this.paint.getCircusCrush().getPartida();

        
        
        Label puntaje = new Label("Circus   Crush" );
        //puntaje.textProperty().bind(new SimpleIntegerProperty(partida.getPuntaje()).asString());
        puntaje.setTextFill(Color.web("#fff8d6"));
        puntaje.setFont(Font.loadFont(getClass().getResourceAsStream("/proyecto3/fonts/DK Canoodle.otf"), 40));
        puntaje.setPadding(new Insets(50,0,0,20));
        
        Image image = Cargador.getImage("about.png");
        //Label about = new Label("", new ImageView(image));
        this.about = new Button();
        this.about.setGraphic(new ImageView(image));
        this.about.setPadding(new Insets(50,0,0,0));
        
        Image image2 = Cargador.getImage("highscores.png");
        this.puntajes = new Button();
        this.puntajes.setGraphic(new ImageView(image2));
        this.puntajes.setPadding(new Insets(50,0,0,0));
        
       
        topPane.setCenter(puntaje);
        topPane.setLeft(this.puntajes);
        topPane.setRight(this.about);
        panelPrincipal.setTop(topPane);

        panelPrincipal.setCenter(paint);

        paint.widthProperty().bind(root.widthProperty());
        paint.heightProperty().bind(root.heightProperty());

        Scene scene = new Scene(root, 400, 400);
        super.setScene(scene);
        
        this.about.setOnAction(this);
        this.puntajes.setOnAction(this);

    }
    
    public int sizePartida() {
        return partidas.size();
    }

    public Partida getPartida(int index) {
        return partidas.get(index);
    }

    public boolean addPartida(Partida e) {
        return partidas.add(e);
    }

    public Partida removePartida(int index) {
        return partidas.remove(index);
    }

    public CircusCrushCanvas getPaint() 
    {
        return paint;
    }

    public void setPaint(CircusCrushCanvas paint) 
    {
        this.paint = paint;
    }
    
    
    
    @Override
    public void handle(Event event) {
        
        
        if (event.getSource() == this.about )
        {
            UIAbout stage = new UIAbout(this);
            stage.show();
        }
        if (event.getSource() == this.puntajes )
        {
            UIPuntajes stage = new UIPuntajes(this);
            stage.show();
        }

    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
