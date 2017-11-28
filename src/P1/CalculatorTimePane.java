package P1;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CalculatorTimePane {

	private int year1 = 2017,year2 = 2017;
	private int month1 = 1,month2 = 1;
	private int day1 =1,day2 = 1;
	TextField tf2 = new TextField();
	TextField tf = new TextField();
	
	public  Pane getPane() {
		// TODO Auto-generated method stub
		
		
		VBox vbox = new VBox(30);
		
		HBox hbox1 = new HBox(10);
		ComboBox<Integer> cboYear1 = new ComboBox<>();
		for(int i = 1700;i < 2030;i ++) {
			Integer e = i;
			cboYear1.getItems().add(e);
		}
		cboYear1.setValue(new Integer(2017));
		cboYear1.setVisibleRowCount(10);
		ComboBox<Integer> cboMonth1 = new ComboBox<>();
		for(int i = 1;i < 12;i ++) {
			Integer e = i;
			cboMonth1.getItems().add(e);
		}
		cboMonth1.setValue(new Integer(1));
		ComboBox<Integer> cboDay1 = new ComboBox<>();
		for(int i = 1;i < 31;i ++) {
			Integer e = i;
			cboDay1.getItems().add(e);
		}
		cboDay1.setValue(new Integer(1));
		cboDay1.setVisibleRowCount(10);
		hbox1.setPadding(new Insets(5,5,5,5));
		hbox1.getChildren().addAll(new Label("从时间: "),cboYear1,cboMonth1,cboDay1);
		
		cboYear1.setOnAction(e -> {
			year1 = cboYear1.getValue().intValue();
		});
		cboMonth1.setOnAction(e -> {
			month1 = cboMonth1.getValue().intValue();
		});
		cboDay1.setOnAction(e -> {
			day1 = cboDay1.getValue().intValue();
		});
		
		
		HBox hbox2 = new HBox(10);
		ComboBox<Integer> cboYear2 = new ComboBox<>();
		for(int i = 1700;i < 2030;i ++) {
			Integer e = i;
			cboYear2.getItems().add(e);
		}
		cboYear2.setValue(new Integer(2017));
		cboYear2.setVisibleRowCount(10);
		ComboBox<Integer> cboMonth2 = new ComboBox<>();
		for(int i = 1;i < 12;i ++) {
			Integer e = i;
			cboMonth2.getItems().add(e);
		}
		cboMonth2.setValue(new Integer(1));
		ComboBox<Integer> cboDay2 = new ComboBox<>();
		for(int i = 1;i < 31;i ++) {
			Integer e = i;
			cboDay2.getItems().add(e);
		}
		cboDay2.setValue(new Integer(1));
		cboDay2.setVisibleRowCount(10);
		hbox2.setPadding(new Insets(5,5,5,5));
		hbox2.getChildren().addAll(new Label("到时间: "),cboYear2,cboMonth2,cboDay2);
		
		cboYear2.setOnAction(e -> {
			year2 = cboYear2.getValue().intValue();
		});
		cboMonth2.setOnAction(e -> {
			month2 = cboMonth2.getValue().intValue();
		});
		cboDay2.setOnAction(e -> {
			day2 = cboDay2.getValue().intValue();
		});
		
		GridPane gridpane = new GridPane();
		gridpane.setVgap(20);
		gridpane.setHgap(20);
		
		tf.setEditable(false);
		gridpane.add(new Label("差(年  月  日) : "),0,0);
		gridpane.add(tf,1,0);
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		tf2.setEditable(false);
		gridpane.add(new Label("差(天) : "),0,1);
		gridpane.add(tf2, 1, 1);
		tf2.setAlignment(Pos.BOTTOM_RIGHT);
		
		Button bt = new Button("Calculate");
		gridpane.add(bt, 1, 2);
		GridPane.setHalignment(bt, HPos.RIGHT);
		
		bt.setOnAction( e -> calculate());
		
		vbox.getChildren().addAll(hbox1,hbox2,gridpane);
		
		Pane pane = new Pane();
		pane.getChildren().add(vbox);
		pane.setPadding(new Insets(5,5,5,5));
		
		return pane;
		
	}

	private void calculate() {
		// TODO Auto-generated method stub
		int s = 0,sum = 0,sum1 = 0,sum2 = 0;
		int year3 = year1 < year2 ? year1 : year2;
		int year4 = year1 < year2 ? year2 : year1;
		int [] m ={
				31,28,31,30,31,30,31,31,30,31,30,31
		};
		for(int i = 0;i< month1-1; i++) {
			sum1 += m[i];
		}
		sum1 += day1;
		for(int i = 0;i< month2-1; i++) {
			sum2 += m[i];
		}
		sum2 += day2;
		for(int i = year3; i < year4; i ++) {
			sum += 365;
			if(i%400==0||i%4==0&&i%100!=0) {
				sum ++;
			}
		}
		if(year1>year2) {
			s = sum1 +sum -sum2;
		}
		else {
			s = sum2 + sum -sum1;
		}
		tf2.setText(String.format("%d", s));
		
		int y = 0, m1 = 0, d = 0; 
		y = s / 365;
		m1 = s % 365 / 30;
		d = s % 365 % 30;
		tf.setText(String.format("%d year %d month %d day", y,m1,d));
		
	}

}
