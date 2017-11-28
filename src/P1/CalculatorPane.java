package P1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CalculatorPane {
	
	TextField text = new TextField();
	final int C = 50;
	final int R = 40;
	private double Num1 = 0;
	private int NumDot1 = 0;
	private double Num2 = 0;
	private int NumDot2 = 0;
	private char Dot =' ';
	private char c = ' ';
	String s;
	
	public BorderPane getPane() {
		
		BorderPane pane = new BorderPane();
		
		Pane pane1 = new Pane();
		text.setAlignment(Pos.BOTTOM_RIGHT);
		pane1.getChildren().add(text);
		pane.setPadding(new Insets(10,10,10,10));
		text.setPrefWidth(230);
		text.setEditable(false);
		
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
        Button btMod = new Button("%");
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
		
		bt0.setOnAction(e -> setNum(0));
		bt1.setOnAction(e -> setNum(1));
		bt2.setOnAction(e -> setNum(2));
		bt3.setOnAction(e -> setNum(3));
		bt4.setOnAction(e -> setNum(4));
		bt5.setOnAction(e -> setNum(5));
		bt6.setOnAction(e -> setNum(6));
		bt7.setOnAction(e -> setNum(7));
		bt8.setOnAction(e -> setNum(8));
		bt9.setOnAction(e -> setNum(9));
		btDot.setOnAction(e -> {
			Dot = '.';
			s = s + ".";
			text.setText(s);
			System.out.print(".");
		});
		btMultication.setOnAction(e -> calcuate('X'));
		btDivide.setOnAction(e -> calcuate('¡Â'));
		btMod.setOnAction(e -> calcuate('%'));
		btAdd.setOnAction(e -> calcuate('+'));
		btSubtract.setOnAction(e -> calcuate('-'));
		btEqual.setOnAction(e -> calcuate('='));
		return pane;
	}
	
	private void calcuate(char ch) {
//		System.out.println(ch);
		int i = 0,j = 0;
		int Dot1,Dot2;
		Dot1 = NumDot1;
		Dot2 = NumDot2;
		while(Dot1 % 10 != 0) {
			i ++;
			Dot1 /= 10;
		}
		while(Dot2 % 10 != 0) {
			j ++;
			Dot2 /= 10;
		}
		
		Num1 += NumDot1*Math.pow(0.1, i);
		Num2 += NumDot2*Math.pow(0.1, j);
		if(c == '+') {
			Num1 = Num1 + Num2;
		}
		if(c == '-') {
			Num1 = Num1 - Num2;
		}
		if(c == 'X') {
			Num1 = Num1 * Num2;
		}
		if(c == '¡Â') {
			Num1 = Num1 / Num2;
		}
		if(c == '%') {
			Num1 = Num1 % Num2;
		}
		System.out.print(ch);
		s = String.valueOf(Num1);
		s = Delete(s);
		if(ch == '=') {
			System.out.println(s);
		}
		text.setText(s);
		c = ch;
		Dot = ' ';
		Num2 = 0;
		NumDot2 = 0;
	}

	public void setNum(int n) {
		System.out.print(n);
		if(c == '=') {
			Num1 = 0;
			c = ' ';
		}
		if(Dot == '.') {
			if(c == ' ') {
				NumDot1 = NumDot1*10 + n;
				s = s + String.valueOf(NumDot1);
				text.setText(s);
			}
			else {
				NumDot2 = NumDot2*10 + n;
				s = s  + String.valueOf(NumDot2);
				text.setText(s);
			}
		}
		else {
			if(c == ' ') {
				Num1 = Num1*10 + n;
				s = String.valueOf(Num1);
				s = Delete(s);
				text.setText(s);
			}
			else {
				Num2 = Num2*10 + n;
				s = String.valueOf(Num2);
				s = Delete(s);
				text.setText(s);
			}
		}	
	}

	private String Delete(String s) {
		// TODO Auto-generated method stub
		int len;
		char c;
		len = s.length() - 1;
		while(len != 0) {
			c = s.charAt(len);
			if(c == '0') {
				len --;
			}
			else {
				break;
			}
		}
		if(s.charAt(len) == '.') {
			len --;
		}
		s = s.substring(0, len + 1);
		return s;
	}
	

}
