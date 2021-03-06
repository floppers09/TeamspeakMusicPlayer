import com.sun.javafx.css.StyleManager;
import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        StyleManager.getInstance().addUserAgentStylesheet("CSS/main.css");
        MainController mc = new MainController(primaryStage);
        primaryStage.setOnCloseRequest(e -> mc.onApplicationClosed());
    }

    public static void main(String[] args) {
        launch();
    }
}
