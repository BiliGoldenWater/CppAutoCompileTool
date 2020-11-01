package io.github.biligoldenwater.cppautocompiletool;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public Button buttonBrowserFile;
    public TextField textFieldSourceFile;

    public void browserFile(ActionEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("选择源文件");
        fileChooser.setInitialFileName("main.cpp");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("所有文件","*.*"),
                new FileChooser.ExtensionFilter("C++", "*.cpp"),
                new FileChooser.ExtensionFilter("C", "*.c"));

        File file = fileChooser.showOpenDialog(CppAutoCompileTool.getStage());
        if(file != null){
            textFieldSourceFile.setText(file.getPath());
            CppAutoCompileTool.setSourceFilePath(file.getPath());
        }
    }
}
