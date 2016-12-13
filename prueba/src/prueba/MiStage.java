
/**
 * Ventana que permite solo el ingreso del nombre, dentro de la partida.
 */

package prueba;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class MiStage extends Stage implements EventHandler {
    
    private Button agregar;
    private TextField nombreTF;
    private Main principal;

    public MiStage() {
        
        this.principal = principal;
        super.setTitle("Registro");
        StackPane root = new StackPane();

        BorderPane panelPrincipal = new BorderPane();


        HBox topPane = new HBox();
        topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 71/255.0, 71/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        Label frase = new Label("¡Buen trabajo!");
        frase.setTextFill(Color.web("#fff8d6"));
       // frase.setFont(Font.loadFont(getClass().getResourceAsStream("/proyecto3/fonts/Lato-Bold.ttf"), 15)); 
        frase.setPadding(new Insets(60,0,0,0));
        topPane.getChildren().add(frase);
        panelPrincipal.setTop(topPane);
        
        BorderPane panelCentral = new BorderPane();

        Label nombre = new Label("Nombre: "); 
        this.nombreTF = new TextField ();
        HBox nombreBox = new HBox();
        nombreBox.getChildren().addAll(nombre, nombreTF);
        nombreBox.setSpacing(10);

        Label score = new Label("Score: "); 
        HBox scoreBox = new HBox();
        scoreBox.getChildren().addAll(score);
        scoreBox.setSpacing(55);

        Label fecha = new Label("Fecha: ");
        HBox fechaBox = new HBox();
        fechaBox.getChildren().addAll(fecha);
        fechaBox.setSpacing(10);

        VBox orden = new VBox();
        orden.getChildren().addAll(nombreBox, scoreBox, fechaBox);
        nombreBox.setPadding(new Insets(5, 0, 10, 0));
        scoreBox.setPadding(new Insets(5, 0, 10, 0));
        fechaBox.setPadding(new Insets(5, 0, 10, 0));

        panelCentral.setTop(orden);
        panelCentral.setPadding( new Insets(50) );

        HBox panelBotones = new HBox(10);
        this.agregar = new Button("Agregar");
        this.agregar.setPrefWidth(100);

        panelBotones.getChildren().addAll(this.agregar);

        BorderPane panelBotonesDerecha = new BorderPane();

        panelBotonesDerecha.setRight(panelBotones);
        panelPrincipal.setBottom(panelBotonesDerecha);
        panelBotonesDerecha.setPadding(new Insets(10, 10, 10, 10));


        panelPrincipal.setCenter(panelCentral);

        root.getChildren().add(panelPrincipal);
        Scene scene = new Scene(root, 600, 400);
        super.setScene(scene);
        
        this.agregar.setOnAction(this);
    }


     public void agregarPartida()
    {
        String nombre = this.nombreTF.getText();
      //  String score =
      // String email = 
      //  this.principal.agregarJugador(jugador);
        
    }
    
    @Override
    public void handle(Event event) {
         if( event.getSource() == this.agregar )
        {
            agregarPartida();
        } 
    }
    
}