package com.gumenniy.stair;


import com.gumenniy.stair.sqlFunc.SQLBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/сontroller/GUI/MainGui.fxml"));
        primaryStage.setTitle("StairBase");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        File f = new File("./dbstair01.mv.db");
        if(f.exists() && f.isFile()) {
            launch(args);
        } else {
            SQLBuilder.buildDB();
            launch(args);
        }
    }
}
