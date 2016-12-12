/**
 * En esta clase comienza la ejecución del programa y muestra UIJuego, que hace
 * que comience todo el gameplay.
 */
package proyecto3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Claudia
 */
public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        UIJuego stage = new UIJuego();
        stage.show();
    }

}
