package indi.biligoldenwater.cppautocompiletool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CppAutoCompileTool extends Application {
    private static Stage mainStage;
    private static String sourceFile;

    @Override
    public void start(Stage mainStage) throws Exception{
        CppAutoCompileTool.mainStage = mainStage;

        Parent root = FXMLLoader.load(getClass().getResource("CppAutoCompileTool.fxml"));
        mainStage.setTitle("Cpp Auto Compile Tool");
        mainStage.setScene(new Scene(root));
        mainStage.setResizable(false);
        mainStage.show();
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
        return mainStage;
    }
}
