package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Label lbl1,lbl2;

    @FXML
    private Button menuB,loginB,exit,custB,employB,wrkOB,schB,reportB,createWO,addWO,custLoc;


    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==menuB)
        {
            stage = (Stage) menuB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==loginB)
        {
            stage = (Stage) loginB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==custB)
        {
            stage = (Stage) custB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/CustomerR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==employB)
        {
            stage = (Stage) employB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/EmployeeR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==wrkOB)
        {
            stage = (Stage) wrkOB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/WorkOrderR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==schB)
        {
            stage = (Stage) schB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/ScheduleR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==reportB)
        {
            stage = (Stage) reportB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/ReportR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==createWO)
        {
            stage = (Stage) createWO.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/CreateWO.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==addWO)
        {
            stage = (Stage) addWO.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/WorkOrderR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==exit)
        {
            System.exit(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}