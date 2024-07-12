package com.example.dsproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private TableView<Data> table = new TableView<Data>();
    private final ObservableList<Data> data =
            FXCollections.observableArrayList(
                    new Data("1", "DataStrucure"),
                    new Data("2", "Mathematics"),
                    new Data("3", "SoftwareEngineering"),
                    new Data("4", "Java"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Subject Registration");
        stage.setWidth(450);
        stage.setHeight(550);
        final Label label = new Label("Subject List");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Index");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Data, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Subjects");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Data, String>("lastName"));



        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Enter Subject Number");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Enter Subject");


        final Button addButton = new Button("Add");
        final Button delButton = new Button("Remove");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Data(
                        addFirstName.getText(),
                        addLastName.getText()));
                addFirstName.clear();
                addLastName.clear();

            }
        });
        delButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Data selectedItem = table.getSelectionModel().getSelectedItem();
                table.getItems().remove(selectedItem);
                if(selectedItem==null)
                {
                  table.getItems().remove(table.getItems().size()-1);
                }
            }
        });
        hb.getChildren().addAll(addFirstName, addLastName, addButton, delButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}