
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		URL url = Paths.get("./src/main/java/GUI/ConsultAgencies.fxml").toUri().toURL();
		Parent root = FXMLLoader.load(url);
		 Scene scene = new Scene(root);
         stage.setTitle("VirtualBank");
         stage.setScene(scene);
         stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
