package sample;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Emp_Controller implements Initializable {
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
    @FXML
    private ComboBox<Country> countryBox;

    @FXML
    private Button updateEmp,clearEmp;

    @FXML
    private ComboBox<StatePr> stateBox;

    @FXML
    private TextField empFn,empLn,empTit,empStatus,startDate, endDate, empPhone, empAddress, empCity, empEmail, empPostal, empId;

    @FXML
    private RadioButton radioFull, radioPart,radioMan, radioOffice, radioRec, radioTech, radioInac,radioAct, radioTerm;

    @FXML
    private Button viewEmployee;

    @FXML
    private Button addEmp, DelEmp;

    @FXML
    private ObservableList<EmpDetails> edata;

    @FXML
    private TableView<EmpDetails> tableEmp;

    @FXML
    private TableColumn<EmpDetails, String> colEmpFirstName;
    @FXML
    private TableColumn<EmpDetails, String> colEmpLastName;
    @FXML
    private TableColumn<EmpDetails, String> colEmpEmail;
    @FXML
    private TableColumn<EmpDetails, String> colDateHired;
    @FXML
    private TableColumn<EmpDetails, String> colEndDate;

    @FXML
    private TableColumn<EmpDetails, String> colEmpPhone;


    public Emp_Controller() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        Scene scene;
        if (event.getSource() == this.menuB) {
            stage = (Stage) this.menuB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/Menu.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.loginB) {
            stage = (Stage) this.loginB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/Login.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.custB) {
            stage = (Stage) this.custB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/CustomerR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.employB) {
            stage = (Stage) this.employB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/EmployeeR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.wrkOB) {
            stage = (Stage) this.wrkOB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/WorkOrderR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.schB) {
            stage = (Stage) this.schB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/ScheduleR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.reportB) {
            stage = (Stage) this.reportB.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/ReportR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.createWO) {
            stage = (Stage) this.createWO.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/CreateWO.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.addWO) {
            stage = (Stage) this.addWO.getScene().getWindow();
            root = (Parent) FXMLLoader.load(this.getClass().getResource("Scenes/WorkOrderR.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (event.getSource() == this.exit) {
            System.exit(0);
        }

    }


    final ObservableList options2 = FXCollections.observableArrayList();


    public void fillComboBoxCountry() {
        Connection c;


        try {
            Connection conn = null;
            Statement stmt = null;
            String queryx = "Select Country_ID, CountryName from Country";

            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            ResultSet jrs = c.createStatement().executeQuery(queryx);

            while (jrs.next()) {

                String countryID = jrs.getString("Country_ID");
                String countryN = jrs.getString("CountryName");


                options2.add(new Country(countryID, countryN));
                countryBox.setItems(options2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    final ObservableList options5 = FXCollections.observableArrayList();

    public void fillComboBoxStateP() {
        Connection c;


        try {
            Connection conn = null;
            Statement stmt = null;
            String queryx = "Select StateProvince_ID, StateProvinceName from StateProvince";

            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            ResultSet jrs = c.createStatement().executeQuery(queryx);

            while (jrs.next()) {

                String spId = jrs.getString("StateProvince_ID");
                String spName = jrs.getString("StateProvinceName");


                options5.add(new StatePr(spId, spName));
                stateBox.setItems(options5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewEmpx(ActionEvent event) {
        Connection c;
        edata=FXCollections.observableArrayList();



        try {
            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            Connection conn = null;
            Statement stmt = null;
            //SQL FOR SELECTING ALL OF CUSTOMER

            //WORKS WITH LOGCIAL DELETE TO SHOW ONLY ACTIVE ATTRIBUTES, no isDeleted(1)
            String SQL2 = "SELECT Employee_ID, EmpFirstName, EmpLastName,EmpPhone, EmpEmail,StartDate, EndDate, EmpAddress, EmpCity,StateProvince_ID,Country_ID,EmployeeStatus_ID,EmployeeType_ID,EmployeeTitle_ID FROM Employee WHERE IsDeleted=0";


            ResultSet jrs2 = c.createStatement().executeQuery(SQL2);



            while (jrs2.next()) {
                edata.add(new EmpDetails (jrs2.getString("Employee_ID"),jrs2.getString("EmpFirstName"),jrs2.getString("EmpLastName"),jrs2.getString("EmpPhone"),jrs2.getString("EmpEmail"),
                        jrs2.getString("StartDate"),jrs2.getString("EndDate"),jrs2.getString("EmpAddress"),jrs2.getString("EmpCity"),jrs2.getString("StateProvince_ID"),
                        jrs2.getString("Country_ID"),jrs2.getString("EmployeeStatus_ID"),jrs2.getString("EmployeeType_ID"),jrs2.getString("EmployeeTitle_ID")));

            }

            colEmpFirstName.setCellValueFactory(new PropertyValueFactory<>("EmpFirstName"));
            colEmpLastName.setCellValueFactory(new PropertyValueFactory<>("EmpLastName"));
            colEmpPhone.setCellValueFactory(new PropertyValueFactory<>("EmpPhone"));
            colEmpEmail.setCellValueFactory(new PropertyValueFactory<>("EmpEmail"));
            colDateHired.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
            colEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));

            // String SQL2 = "SELECT * FROM Customer WHERE IsDeleted=0";

            //  ResultSet jrs2 = c.createStatement().executeQuery(SQL2);

            //  while (jrs2.next()){
            //    data2.add(new CustLocation(jrs2.getString(1),jrs2.getString(2),jrs2.getString(3),jrs2.getString(4)));
            //    }

            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Displays within the tableview to each column ObservableList Data




        tableEmp.setItems(null);
        tableEmp.setItems(edata);

    }
    @FXML
    private void insertEmp (ActionEvent event) {

        final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB";
        //  Database credentials
        final String USER = "cbknight";
        final String PASS = "fuckyou12";

        Connection conn = null;
        Statement stmt = null;

        String employeeStatus = new String();
        ToggleGroup group1 = new ToggleGroup();
        radioAct.setToggleGroup(group1);
        radioInac.setToggleGroup(group1);
        radioTerm.setToggleGroup(group1);
        if (radioTerm.isSelected())
            employeeStatus = "1";
        else if (radioInac.isSelected())
            employeeStatus = "2";
        else if (radioTerm.isSelected())
            employeeStatus = "3";


        String employeeType = new String();
        ToggleGroup group = new ToggleGroup();
        radioFull.setToggleGroup(group);
        radioPart.setToggleGroup(group);
        if (radioFull.isSelected())
            employeeType = "1";
        else if (radioPart.isSelected())
            employeeType = "2";

        String employeeTitle = new String();
        ToggleGroup group2 = new ToggleGroup();
        radioMan.setToggleGroup(group2);
        radioOffice.setToggleGroup(group2);
        radioRec.setToggleGroup(group2);
        radioTech.setToggleGroup(group2);
        if (radioMan.isSelected())
            employeeTitle = "1";
        else if (radioOffice.isSelected())
            employeeTitle = "2";
        else if (radioRec.isSelected())
            employeeTitle = "3";
        else if (radioTech.isSelected())
            employeeTitle = "4";


        //Text field get value added
        String empFname = empFn.getText();
        String empLname = empLn.getText();

        String empPh = empPhone.getText();
        String empEma = empEmail.getText();

        String ecity = empCity.getText();
        String sdate = startDate.getText();
        String edate =endDate.getText();

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            //String sql = "CREATE DATABASE PREDICTOR";
        //    String queryx = "Select CusType_ID, CusTypeName from CustomerType";

        //    ResultSet rsx = conn.createStatement().executeQuery(queryx);

            //get key from CustomerType table


            //get key from Country table



            //get key from County table
            Object countryz = countryBox.getSelectionModel().getSelectedItem();
            String countyz = ((Country)countryz).getcountryKey();

            //get key from StateProvince table
            Object statepr = stateBox.getSelectionModel().getSelectedItem();
            String StP = ((StatePr)statepr).getstatePrKey();



            String sql = "INSERT INTO Employee ([EmpFirstName],[EmpLastName],[EmpPhone],[EmpEmail],[StartDate],[EndDate],[EmpAddress]," +
                    "[EmpCity],[StateProvince_ID],[Country_ID],[EmployeeStatus_ID],[EmployeeType_ID],[EmployeeTitle_ID]) VALUES" +
                    "('" + empFname + "','" + empLname + "','" + empPh + "', '" + empEma + "','" + sdate + "','"+edate+"', '" + empAddress+ "','"+ecity+"','"+StP+"','"+countyz+"','"+employeeStatus+"'," +
                    "'"+employeeType+"','"+employeeTitle+"')";


            System.out.println("Adding Data: Customer Table");

            stmt.executeUpdate(sql);


            System.out.println("Data inserted successfully...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        //end main
    }

    private void setCellValueFromTableToTextField2() {

        //reminds stringTxT

        tableEmp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                EmpDetails p2 = (EmpDetails) tableEmp.getItems().get(tableEmp.getSelectionModel().getSelectedIndex());
                empId.setText(p2.getEmployee_ID());
                empFn.setText(p2.getEmpFirstName());
                empLn.setText(p2.getEmpLastName());
                empPhone.setText(p2.getEmpPhone());
                empAddress.setText(p2.getEmpAddress());
                empCity.setText(p2.getEmpCity());
                empEmail.setText(p2.getEmpEmail());
                startDate.setText(p2.getStartDate());
                endDate.setText(p2.getEndDate());



                if ("1".equals(p2.getEmployeeType_ID())) {
                    radioFull.setSelected(true);
                    radioPart.setSelected(false);
                } else if ("2".equals(p2.getEmployeeType_ID())) {
                    radioPart.setSelected(true);
                    radioFull.setSelected(false);
                }
                else {
                    radioPart.setSelected(false);
                    radioFull.setSelected(false);
                }

                if ("1".equals(p2.getEmployeeStatus_ID())) {
                    radioTerm.setSelected(true);
                    radioInac.setSelected(false);
                    radioAct.setSelected(false);

                } else if ("2".equals(p2.getEmployeeStatus_ID())) {
                    radioInac.setSelected(true);
                    radioAct.setSelected(false);
                    radioTerm.setSelected(false);
                } else if ("3".equals(p2.getEmployeeStatus_ID())){
                    radioAct.setSelected(true);
                    radioInac.setSelected(false);
                    radioTerm.setSelected(false);
                } else {
                    radioAct.setSelected(false);
                    radioInac.setSelected(false);
                    radioTerm.setSelected(false);
                }

                if ("1".equals(p2.getEmployeeTitle_ID())) {
                    radioMan.setSelected(true);
                    radioOffice.setSelected(false);
                    radioRec.setSelected(false);
                    radioTech.setSelected(false);

                } else if ("2".equals(p2.getEmployeeTitle_ID())) {
                    radioOffice.setSelected(true);
                    radioMan.setSelected(false);
                    radioRec.setSelected(false);
                    radioTech.setSelected(false);
                } else if ("3".equals(p2.getEmployeeTitle_ID())){
                    radioRec.setSelected(true);
                    radioMan.setSelected(false);
                    radioTech.setSelected(false);
                    radioOffice.setSelected(false);
                } else if ("4".equals(p2.getEmployeeTitle_ID())){
                    radioTech.setSelected(true);
                    radioRec.setSelected(false);
                    radioMan.setSelected(false);
                    radioOffice.setSelected(false);
                } else {
                    radioTech.setSelected(false);
                    radioRec.setSelected(false);
                    radioMan.setSelected(false);
                    radioOffice.setSelected(false);
                }


            }

        });
    };
    @FXML
    private void updateE (ActionEvent event) {

        final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB";
        //  Database credentials
        final String USER = "cbknight";
        final String PASS = "fuckyou12";

        Connection conn = null;
        Statement stmt = null;
        Object countryz = countryBox.getSelectionModel().getSelectedItem();
        String countyz = ((Country)countryz).getcountryKey();

        //get key from StateProvince table
        Object statepr = stateBox.getSelectionModel().getSelectedItem();
        String StP = ((StatePr)statepr).getstatePrKey();

        String employeeStatus = new String();
        ToggleGroup group1 = new ToggleGroup();
        radioAct.setToggleGroup(group1);
        radioInac.setToggleGroup(group1);
        radioTerm.setToggleGroup(group1);
        if (radioTerm.isSelected())
            employeeStatus = "1";
        else if (radioInac.isSelected())
            employeeStatus = "2";
        else if (radioTerm.isSelected())
            employeeStatus = "3";


        String employeeType = new String();
        ToggleGroup group = new ToggleGroup();
        radioFull.setToggleGroup(group);
        radioPart.setToggleGroup(group);
        if (radioFull.isSelected())
            employeeType = "1";
        else if (radioPart.isSelected())
            employeeType = "2";

        String employeeTitle = new String();
        ToggleGroup group2 = new ToggleGroup();
        radioMan.setToggleGroup(group2);
        radioOffice.setToggleGroup(group2);
        radioRec.setToggleGroup(group2);
        radioTech.setToggleGroup(group2);
        if (radioMan.isSelected())
            employeeTitle = "1";
        else if (radioOffice.isSelected())
            employeeTitle = "2";
        else if (radioRec.isSelected())
            employeeTitle = "3";
        else if (radioTech.isSelected())
            employeeTitle = "4";


        //Text field get value added
        String empFname = empFn.getText();
        String empLname = empLn.getText();

        String empPh = empPhone.getText();
        String empEma = empEmail.getText();

        String ecity = empCity.getText();
        String sdate = startDate.getText();
        String edate =endDate.getText();

        empId.getText();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("updating database...");
            stmt = conn.createStatement();

            //String sql = "CREATE DATABASE PREDICTOR";


            String query = "UPDATE Employee SET EmpFirstName = ? , EmpLastName = ? , EmpPhone = ? , EmpEmail = ? , StartDate = ?, EndDate= ?, EmpAddress = ?, EmpCity =?," +
                    "StateProvince_ID=?, Country_ID=?, EmployeeStatus_ID=?, EmployeeType_ID=?, EmployeeTitle_ID=? WHERE Employee_ID =? ";
            System.out.println("Updating Data: Customer Table");

            PreparedStatement preparedStmt = conn.prepareStatement(query);


            preparedStmt.setString(1, empFname);
            preparedStmt.setString(2, empLname);
            preparedStmt.setString(3, empPh);
            preparedStmt.setString(4, empEma);
            preparedStmt.setString(5, sdate);
            preparedStmt.setString(6, edate);
            preparedStmt.setString(7, empAddress.getText());
            preparedStmt.setString(8, empCity.getText());
            preparedStmt.setString(9, StP);
            preparedStmt.setString(10, countyz);
            preparedStmt.setString(11, employeeStatus);
            preparedStmt.setString(12, employeeType);
            preparedStmt.setString(13, employeeTitle);
            preparedStmt.setString(14, empId.getText());

            preparedStmt.execute();

            preparedStmt.close();
            System.out.println("Data edited successfully...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        //end main
    }

    @FXML
    private void deleteEmp (ActionEvent event) {
        final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB";
        //  Database credentials
        final String USER = "cbknight";
        final String PASS = "fuckyou12";

        Connection conn = null;
        Statement stmt = null;


        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            //String sql = "CREATE DATABASE PREDICTOR";
//LOGICAL DELETE. isDeleted set to 1 to HIDE
            String query = "UPDATE Employee SET isDeleted = 1 WHERE Employee_ID =? ";

            System.out.println("Deleting Data: Customer Table");


            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, empId.getText());




            preparedStmt.execute();
            preparedStmt.close();

            System.out.println("Data deleted successfully...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        //end main
    }
    @FXML
    private void clearEmpButton (ActionEvent event) {
        empId.setText("");
        empFn.setText("");
        empLn.setText("");
        empPhone.setText("");
        startDate.setText("");
        endDate.setText("");
        empAddress.setText("");
        empEmail.setText("");

        radioTech.setSelected(false);
        radioRec.setSelected(false);
        radioOffice.setSelected(false);
        radioMan.setSelected(false);
        radioPart.setSelected(false);
        radioFull.setSelected(false);
        radioTerm.setSelected(false);
        radioAct.setSelected(false);
        radioInac.setSelected(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection c;

        setCellValueFromTableToTextField2();
        fillComboBoxCountry();

        fillComboBoxStateP();
        // TODO
    }
}
