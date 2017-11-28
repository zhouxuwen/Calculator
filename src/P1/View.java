package P1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		CalculatorTimePane calculatetime = new CalculatorTimePane();
		CalculatorPane calculator = new CalculatorPane();
		BorderPane paneall = new BorderPane();
		BorderPane pane1 = calculator.getPane();
		Pane pane2 = calculatetime.getPane();
		
		paneall.setLeft(pane1);
		paneall.setRight(pane2);
		
		Scene scene = new Scene(paneall,600,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
