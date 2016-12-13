

/**
 * Ventana que muestra dos tablas contenedoras de la información de las partidas.
 * Una es de los puntajes generales y la otra por nivel.
 */

package proyecto3.UI;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import proyecto3.Partida;
import proyecto3.painter.Cargador;
/**
 *
 * @author Claudia Provoste y Samuel Paicil
 */
public class UIPuntajes extends Stage implements EventHandler {
    
    private UIJuego principal;
    private TableView<Partida> tableGeneral;
    private TableView<Partida> tableNivel;
    
    public UIPuntajes(UIJuego ventana) {
        
        this.principal = ventana;
        super.setTitle("Highscores");
        StackPane root = new StackPane();
        
        BorderPane panelPrincipal = new BorderPane();
        
        HBox topPane = new HBox();
        topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 71/255.0, 71/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        Label logo = new Label("", new ImageView(Cargador.getImage("Sin título2.png")));
        topPane.getChildren().add(logo);
        panelPrincipal.setTop(topPane);
        
        HBox panelCentral = new HBox();
        tableGeneral = new TableView<>();
        tableNivel = new TableView<>();
        panelCentral.getChildren().addAll(tableGeneral, tableNivel);
        
        TableColumn nombreGeneral = new TableColumn("Nombre");
        nombreGeneral.setMinWidth(100);
        nombreGeneral.setCellValueFactory(new PropertyValueFactory<>("nombreJugador"));
        TableColumn puntajeGeneral = new TableColumn("Puntaje");
        puntajeGeneral.setMinWidth(200);
        puntajeGeneral.setCellValueFactory(new PropertyValueFactory<>("puntaje"));
        tableGeneral.getColumns().addAll(nombreGeneral, puntajeGeneral);
        
        this.actualizarDatosTabla();
        
        TableColumn nombreNivel = new TableColumn("Nombre");
        nombreNivel.setMinWidth(100);
        nombreNivel.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn puntajeNivel = new TableColumn("Puntaje");
        puntajeNivel.setMinWidth(200);
        puntajeNivel.setCellValueFactory(new PropertyValueFactory<>("puntaje"));
        tableNivel.getColumns().addAll(nombreNivel, puntajeNivel);
    
        panelCentral.setPadding(new Insets(0,0,0,60));
        
        panelPrincipal.setCenter(panelCentral);
        root.getChildren().add(panelPrincipal);
        
        
        Scene scene = new Scene(root, 600, 400);
        super.setScene(scene);
    }

         public void actualizarDatosTabla(){
         
         ObservableList<Partida> items = this.tableGeneral.getItems();
         
         for( int i = 0; i < this.principal.sizePartida() ; i++)
         {
             items.add(this.principal.getPartida(i));
              System.out.println(this.principal.getPartida(i).getNombreJugador());
         }
         
         
     }
     
    
    
    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
