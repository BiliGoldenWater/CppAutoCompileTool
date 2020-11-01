package io.github.biligoldenwater.cppautocompiletool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CppAutoCompileTool extends Application {
    private static Stage stage = null;
    private static String sourceFile = "";

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("CppAutoCompileTool.fxml"));
        primaryStage.setTitle("Cpp Auto Compile Tool");
        primaryStage.setScene(new Scene(root, 535, 355));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setSourceFilePath(String path){
        sourceFile = path;
    }

    public static String getSourceFilePath(){
        return sourceFile;
    }

    public static Stage getStage(){
        return stage;
    }
}
