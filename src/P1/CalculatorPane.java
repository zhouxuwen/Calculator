package P1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CalculatorPane {
	final int C = 50;
	final int R = 40;
 
	
	public BorderPane getPane() {
		
		BorderPane pane = new BorderPane();
		
		Pane pane1 = new Pane();
		TextField text = new TextField();
		text.setAlignment(Pos.BOTTOM_RIGHT);
		pane1.getChildren().add(text);
		pane.setPadding(new Insets(10,10,10,10));
		text.setPrefWidth(230);
		
		GridPane gridpane = new GridPane();
        Button bt1 = new Button("1");
        Button bt2 = new Button("2");
        Button bt3 = new Button("3");
        Button bt4 = new Button("4");
        Button bt5 = new Button("5");
        Button bt6 = new Button("6");
        Button bt7 = new Button("7");
        Button bt8 = new Button("8");
        Button bt9 = new Button("9");
        Button bt0 = new Button("0");
        Button btMultication = new Button("X");
        Button btDivide = new Button("¡Â");
        Button btMod = new Button("¡Â");
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        Button btEmpty = new Button("C");
        Button btCE = new Button("CE");
        Button btDelete = new Button("¡û");
        Button btDot = new Button(".");
        Button btEqual = new Button("=");
   
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        bt1.setPrefSize(C, R);
        bt2.setPrefSize(C, R);
        bt3.setPrefSize(C, R);
        bt4.setPrefSize(C, R);
        bt5.setPrefSize(C, R);
        bt6.setPrefSize(C, R);
        bt7.setPrefSize(C, R);
        bt8.setPrefSize(C, R);
        bt9.setPrefSize(C, R);
        bt0.setPrefSize(C, R);
        btMultication.setPrefSize(C, R);
        btDivide.setPrefSize(C, R);
        btMod.setPrefSize(C, R);
		btDelete.setPrefSize(C, R);
		btAdd.setPrefSize(C, R);
		btSubtract.setPrefSize(C, R);
		btEmpty.setPrefSize(C, R);
		btCE.setPrefSize(C, R);
		btDelete.setPrefSize(C, R);
		btDot.setPrefSize(C, R);
		btEqual.setPrefSize(C, R);
		
		gridpane.addRow(0, btCE,btEmpty,btDelete,btDivide);
		gridpane.addRow(1, bt7,bt8,bt9,btMultication);
		gridpane.addRow(2, bt4,bt5,bt6,btAdd);
		gridpane.addRow(3,bt1,bt2,bt3,btSubtract);
		gridpane.addRow(4, btMod,bt0,btDot,btEqual);
//		pane.setTop();
		pane.setCenter(pane1);
		pane.setBottom(gridpane);
		BorderPane.setAlignment(gridpane, Pos.CENTER);
		
		return pane;
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
