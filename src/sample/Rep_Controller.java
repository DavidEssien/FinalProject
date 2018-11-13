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

public class Rep_Controller implements Initializable {
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Button menuB;
    @FXML
    private Button loginB;
    @FXML
    private Button exit;
    @FXML
    private Button custB;
    @FXML
    private Button employB;
    @FXML
    private Button wrkOB;
    @FXML
    private Button schB;
    @FXML
    private Button reportB;
    @FXML
    private Button createWO;
    @FXML
    private Button addWO;

    public Rep_Controller() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        Scene scene;
        if (event.getSource() == this.menuB) {
            stage = (Stage)this.menuB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/Menu.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.loginB) {
            stage = (Stage)this.loginB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/Login.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.custB) {
            stage = (Stage)this.custB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/CustomerR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.employB) {
            stage = (Stage)this.employB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/EmployeeR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.wrkOB) {
            stage = (Stage)this.wrkOB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/WorkOrderR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.schB) {
            stage = (Stage)this.schB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/ScheduleR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.reportB) {
            stage = (Stage)this.reportB.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/ReportR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.createWO) {
            stage = (Stage)this.createWO.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/CreateWO.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.addWO) {
            stage = (Stage)this.addWO.getScene().getWindow();
            root = (Parent)FXMLLoader.load(this.getClass().getResource("Scenes/WorkOrderR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.exit) {
            System.exit(0);
        }

    }

    public void initialize(URL url, ResourceBundle rb) {
    }
}