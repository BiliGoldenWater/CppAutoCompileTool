package indi.biligoldenwater.cppautocompiletool;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class CppAutoCompileToolController {
    public Button buttonBrowserFile;
    public TextField textFieldSourceFile;

    public void buttonBrowserFileClicked(ActionEvent mouseEvent) {
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
            String filePath = file.getPath();

            textFieldSourceFile.setText(filePath);
            CppAutoCompileTool.setSourceFilePath(filePath);
        }
    }

    public void textFieldSourceFileDragDropped(DragEvent dragEvent) {
        if(dragEvent.isAccepted()){
            List<File> filesDropped = dragEvent.getDragboard().getFiles();
            if(filesDropped != null && filesDropped.size()>0){
                String filePath = filesDropped.get(0).getPath();

                textFieldSourceFile.setText(filePath);
                CppAutoCompileTool.setSourceFilePath(filePath);
            }
        }
    }

    public void textFieldSourceFileDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.COPY);
    }
}
