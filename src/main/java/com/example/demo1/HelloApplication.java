package com.example.demo1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button button = new Button("Add to base");
        button.setTranslateX(60);
        button.setTranslateY(320);
        Button button2 = new Button("Get data");
        button2.setTranslateX(60);
        button2.setTranslateY(370);
        Text text=new Text();
        text.setTranslateX(40);
        text.setTranslateY(50);
        text.setText("release year");
        TextField textField=new TextField();
        textField.setTranslateX(40);
        textField.setTranslateY(60);
        Text text2=new Text();
        text2.setTranslateX(40);
        text2.setTranslateY(110);
        text2.setText("Brand");
        TextField textField2=new TextField();
        textField2.setTranslateX(40);
        textField2.setTranslateY(120);
        Text text3=new Text();
        text3.setTranslateX(40);
        text3.setTranslateY(170);
        text3.setText("Model");
        TextField textField3=new TextField();
        textField3.setTranslateX(40);
        textField3.setTranslateY(180);
        Text text4=new Text();
        text4.setTranslateX(40);
        text4.setTranslateY(230);
        text4.setText("Engine volume");
        TextField textField4=new TextField();
        textField4.setTranslateX(40);
        textField4.setTranslateY(240);

        Group root = new Group();
        button.setOnAction(actionEvent -> {
            int date = Integer.parseInt(textField.getText());
            String make = textField2.getText();
            String model = textField3.getText();
            int eng = Integer.parseInt(textField4.getText());
            CarsUtil.insert(new Cars(date,make,model,eng));
            textField.clear();
            textField2.clear();
            textField3.clear();
            textField4.clear();
        });
        PieChart pieChart = new PieChart();
        pieChart.setTranslateX(100);
        pieChart.setTranslateY(200);

        button2.setOnAction(actionEvent -> {
            CarsUtil.getAllCars().stream().forEach(data -> System.out.println(data.model));
            System.out.println(CarsUtil.getAllCars());
            pieChart.setData(getData());
        });








        root.getChildren().add(button);
        root.getChildren().add(textField);
        root.getChildren().add(textField2);
        root.getChildren().add(textField3);
        root.getChildren().add(textField4);
        root.getChildren().add(text);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(button2);
        root.getChildren().add(pieChart);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
    private ObservableList<PieChart.Data> getData(){
        ArrayList<String> destinations = new ArrayList<String>();
        ArrayList<Integer> seats = new ArrayList<Integer>();


        CarsUtil.getAllCars().stream().forEach(data -> destinations.add(data.getMake()));
        CarsUtil.getAllCars().stream().forEach(data -> seats.add(data.getEngineVolume()));
        System.out.println(destinations);
        String dest1 = destinations.get(0);
        String dest2 = destinations.get(1);
        String dest3 = destinations.get(2);
        int seats1 = seats.get(0);
        int seats2 = seats.get(1);
        int seats3 = seats.get(2);


        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
                new PieChart.Data(dest1, seats1),
                new PieChart.Data(dest2,seats2),
                new PieChart.Data(dest3, seats3)

        );
        return observableList;
    }
}