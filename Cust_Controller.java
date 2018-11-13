package sample;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.util.locale.LocaleObjectCache;

import javax.sql.rowset.JoinRowSet;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.util.HashMap;
import java.util.Map;

public class Cust_Controller<event> implements Initializable {

    private FileInputStream fis;

    private File file;
    @FXML
    private ObservableList<CustomerDetails> data;



    //@FXML
    // private TableView tableview;




    @FXML
    private Button menuB, custB, employB, wrkOB, schB, reportB;

    @FXML
    Button viewtx;

    @FXML
    Button updatet;

    @FXML
    private ToggleButton radioR, radioC, RadioActive, RadioIn;


    @FXML
    private ComboBox<Country> cbx;

    @FXML
    private ComboBox<StatePr> stateprov;

    @FXML
    private ComboBox<Postal> addPost;

    @FXML
    private ComboBox<County> addCounty;

    @FXML
    TextField addFirstName, addLastName, addEmail, addOrg, addPhone;

    @FXML
    TextField addCityz;

    @FXML
    TextField mayCity;

    @FXML
    TextField addBill;

    @FXML
    TextField addStreet;

    @FXML
    TextField search;

    @FXML
    TextField custLocID;

    @FXML
    TextField addcustID;

    @FXML
    private TableView<CustomerDetails> tableCustomer;



    @FXML
    private TableColumn<CustomerDetails, String> colCity;




    @FXML
    private TableColumn<CustomerDetails, String> colStreet;

    @FXML
    private TableColumn<CustomerDetails, String> colPostal;

    @FXML
    private TableColumn<CustomerDetails, String> colState;

    @FXML
    private TableColumn<CustomerDetails, String> columnFname;



    @FXML
    private TableColumn<CustomerDetails, String> columnLname;
    @FXML
    private TableColumn<CustomerDetails, String> columnOrg;
    @FXML
    private TableColumn<CustomerDetails, String> columnPh;
    @FXML
    private TableColumn<CustomerDetails, String> columnEm;


    @FXML
    private TableColumn<CustomerDetails, String> columnstatId;

    private Database dc;




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


                options2.add(new Country(countryID,countryN));
                cbx.setItems(options2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    final ObservableList options3 = FXCollections.observableArrayList();

    public void fillComboBoxPostal() {
        Connection c;


        try {
            Connection conn = null;
            Statement stmt = null;
            String queryx = "Select PostalCode_ID, PostalCode from PostalCode";

            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            ResultSet jrs = c.createStatement().executeQuery(queryx);

            while (jrs.next()) {

                String postID = jrs.getString("PostalCode_ID");
                String postC = jrs.getString("PostalCode");


                options3.add(new Postal(postID,postC));
                addPost.setItems(options3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    final ObservableList options4 = FXCollections.observableArrayList();

    public void fillComboBoxCounty() {
        Connection c;


        try {
            Connection conn = null;
            Statement stmt = null;
            String queryx = "Select County_ID, County_Name from County";

            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            ResultSet jrs = c.createStatement().executeQuery(queryx);

            while (jrs.next()) {

                String countyid = jrs.getString("County_ID");
                String countyname = jrs.getString("County_Name");


                options4.add(new County(countyid,countyname));
                addCounty.setItems(options4);
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


                options5.add(new StatePr(spId,spName));
                stateprov.setItems(options5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == menuB) {
            stage = (Stage) menuB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == custB) {
            stage = (Stage) custB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/CustomerR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == employB) {
            stage = (Stage) employB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/EmployeeR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == wrkOB) {
            stage = (Stage) wrkOB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/WorkOrderR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == schB) {
            stage = (Stage) schB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/ScheduleR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == reportB) {
            stage = (Stage) reportB.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Scenes/ReportR.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

    //Adding Customer Data-----------------------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonAction1(ActionEvent event) {

        final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB";
        //  Database credentials
        final String USER = "cbknight";
        final String PASS = "fuckyou12";

        Connection conn = null;
        Statement stmt = null;

        String customerStatus = new String();
        ToggleGroup group1 = new ToggleGroup();
        RadioActive.setToggleGroup(group1);
        RadioActive.setSelected(true);
        RadioActive.requestFocus();
        RadioIn.setToggleGroup(group1);
        if (RadioActive.isSelected())
            customerStatus = "1";
        else if (RadioIn.isSelected())
            customerStatus = "2";

        String customerType = new String();
        ToggleGroup group = new ToggleGroup();
        radioR.setToggleGroup(group);
        radioR.setSelected(true);
        radioR.requestFocus();
        radioC.setToggleGroup(group);
        if (radioC.isSelected())
            customerType = "2";
        else if (radioR.isSelected())
            customerType = "1";

        //Text field get value added
        String aFname = addFirstName.getText();
        String aLname = addLastName.getText();
        String aOrgName = addOrg.getText();
        String aPhone = addPhone.getText();
        String aEm = addEmail.getText();

        String stAdd = addStreet.getText();
        String bAdd = addBill.getText();
        String addCity =addCityz.getText();

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
            String queryx = "Select CusType_ID, CusTypeName from CustomerType";

            ResultSet rsx = conn.createStatement().executeQuery(queryx);

            //get key from CustomerType table


            Object postalc = addPost.getSelectionModel().getSelectedItem();
            String pcID = ((Postal)postalc).getpostalKey();

            //get key from Country table
            Object countryx = cbx.getSelectionModel().getSelectedItem();
            String cn = ((Country)countryx).getcountryKey();


            //get key from County table
            Object county = addCounty.getSelectionModel().getSelectedItem();
            String countyz = ((County)county).getcountyKey();

            //get key from StateProvince table
            Object statepr = stateprov.getSelectionModel().getSelectedItem();
            String StP = ((StatePr)statepr).getstatePrKey();



            String sql = "INSERT INTO Customer ([FirstName],[LastName],[OrgName],[Phone],[Email],[CustStat_ID],[CustomerType_ID]) VALUES" +
                    "('" + aFname + "','" + aLname + "','" + aOrgName + "', '" + aPhone + "','" + aEm + "','"+customerStatus+"', '" + customerType+ "')";

            String sqlc = "INSERT INTO CustLocation ([Customer_ID],[StreetAddress],[BillingAddress],[PostalCode_ID],[City],[StateProvince_ID],[Country_ID]) VALUES" +
                    "(scope_identity(),'" + stAdd + "','" + bAdd + "','" + pcID + "', '" + addCity + "','" + StP + "','" + cn+ "')";

            System.out.println("Adding Data: Customer Table");

            stmt.executeUpdate(sql);

            stmt.executeUpdate(sqlc);
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

    @FXML
    private void deleteRow (ActionEvent event) {
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
            String query = "UPDATE Customer SET isDeleted = 1 WHERE Customer_ID =? ";
            String query2 = "UPDATE CustLocation SET  isDeleted = 1 WHERE CustLocation_ID =? ";
            System.out.println("Deleting Data: Customer Table");


            PreparedStatement preparedStmt = conn.prepareStatement(query);
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt.setString(1, custLocID.getText());


            preparedStmt2.setString(1, custLocID.getText());

            preparedStmt.execute();
            preparedStmt.close();
            preparedStmt2.execute();
            preparedStmt2.close();
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
    private void updateTable (ActionEvent event) {

        final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB";
        //  Database credentials
        final String USER = "cbknight";
        final String PASS = "fuckyou12";

        Connection conn = null;
        Statement stmt = null;
        Object postalc = addPost.getSelectionModel().getSelectedItem();
        String pcID = ((Postal)postalc).getpostalKey();

        Object statepr = stateprov.getSelectionModel().getSelectedItem();
        String StP = ((StatePr)statepr).getstatePrKey();

        Object countryx = cbx.getSelectionModel().getSelectedItem();
        String cn = ((Country)countryx).getcountryKey();

        String customerStatus = new String();
        ToggleGroup group1 = new ToggleGroup();
        RadioActive.setToggleGroup(group1);
        RadioActive.setSelected(true);
        RadioActive.requestFocus();
        RadioIn.setToggleGroup(group1);
        if (RadioActive.isSelected())
            customerStatus = "1";
        else if (RadioIn.isSelected())
            customerStatus = "2";

        String customerType = new String();
        ToggleGroup group = new ToggleGroup();
        radioR.setToggleGroup(group);
        radioR.setSelected(true);
        radioR.requestFocus();
        radioC.setToggleGroup(group);
        if (radioC.isSelected())
            customerType = "2";
        else if (radioR.isSelected())
            customerType = "1";

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

            String query = "UPDATE Customer SET FirstName = ? , LastName = ? , OrgName = ? , Phone = ? , Email = ?, CustStat_ID = ?, CustomerType_ID = ? WHERE Customer_ID = ? ";
            String query2 = "UPDATE CustLocation SET StreetAddress = ? , BillingAddress = ? , PostalCode_ID = ? , City = ? , StateProvince_ID = ?, Country_ID =? WHERE CustLocation_ID=? ";
            System.out.println("Updating Data: Customer Table");

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

            preparedStmt.setString(1, addFirstName.getText());
            preparedStmt.setString(2, addLastName.getText());
            preparedStmt.setString(3, addOrg.getText());
            preparedStmt.setString(4, addPhone.getText());
            preparedStmt.setString(5, addEmail.getText());
            preparedStmt.setString(6, customerStatus);
            preparedStmt.setString(7, customerType);
            preparedStmt.setString(8, custLocID.getText());

            preparedStmt2.setString(1, addStreet.getText());
            preparedStmt2.setString(2, addBill.getText());
            preparedStmt2.setString(3, pcID);
            preparedStmt2.setString(4, addCityz.getText());
            preparedStmt2.setString(5, StP);
            preparedStmt2.setString(6, cn);
            preparedStmt2.setString(7, custLocID.getText());

            preparedStmt.execute();
            preparedStmt2.execute();

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
    private void viewtablex(ActionEvent event) {
        Connection c;
        data=FXCollections.observableArrayList();


        // data2=FXCollections.observableArrayList();


        try {
            c = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=DemoX_ParagonTechDB", "cbknight", "fuckyou12");
            Connection conn = null;
            Statement stmt = null;
            //SQL FOR SELECTING ALL OF CUSTOMER

            //WORKS WITH LOGCIAL DELETE TO SHOW ONLY ACTIVE ATTRIBUTES, no isDeleted(1)
            String SQL2 = "SELECT CustLocation_ID, Customer_ID, StreetAddress, BillingAddress,PostalCode_ID, City, StateProvince_ID FROM CustLocation WHERE IsDeleted=0";

            String SQL = "SELECT FirstName, LastName, OrgName, Phone, Email, CustStat_ID, CustomerType_ID FROM Customer WHERE IsDeleted=0";

        //   String SQL3 = "SELECT CustLocation.Country_ID, Country.CountryName FROM CustLocation, Country WHERE CustLocation.Country_ID = Country.Country_ID";
           String SQL4 = "SELECT CustLocation.PostalCode_ID, PostalCode.PostalCode FROM CustLocation, PostalCode WHERE CustLocation.PostalCode_ID = PostalCode.PostalCode_ID";
            String SQL5 = "SELECT CustLocation.StateProvince_ID, StateProvince.StateProvinceName FROM CustLocation, StateProvince WHERE CustLocation.StateProvince_ID = StateProvince.StateProvince_ID";
            //Trying to get multiple tables into 1 tableview
            //ResultSet
            ResultSet jrs2 = c.createStatement().executeQuery(SQL2);

            ResultSet jrs = c.createStatement().executeQuery(SQL);

       //     ResultSet jrs3 = c.createStatement().executeQuery(SQL3);

            ResultSet jrs4 = c.createStatement().executeQuery(SQL4);

            ResultSet jrs5 = c.createStatement().executeQuery(SQL5);


            while (jrs2.next() & jrs.next() & jrs5.next() & jrs4.next()) {
                data.add(new CustomerDetails(jrs2.getString("CustLocation_ID"),jrs2.getString("Customer_ID"),jrs2.getString("StreetAddress"),jrs2.getString("BillingAddress"),jrs2.getString("PostalCode_ID"),
                        jrs2.getString("City"),jrs2.getString("StateProvince_ID"),
                        jrs.getString("FirstName"),jrs.getString("LastName"), jrs.getString("OrgName"),
                        jrs.getString("Phone"), jrs.getString("Email"),jrs.getString("CustStat_ID"),
                        jrs.getString("CustomerType_ID"),jrs5.getString("StateProvinceName"),jrs4.getString("PostalCode")));

            }


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
        columnFname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        columnLname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        columnOrg.setCellValueFactory(new PropertyValueFactory<>("Organization"));
        columnEm.setCellValueFactory(new PropertyValueFactory<>("Email"));
        columnPh.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colStreet.setCellValueFactory(new PropertyValueFactory<>("StreetAddress"));
        colState.setCellValueFactory(new PropertyValueFactory<>("StateProvinceName"));
        colPostal.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));







        tableCustomer.setItems(data);



    }



    private void setCellValueFromTableToTextField() {

        //reminds stringTxT

        tableCustomer.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                CustomerDetails pl = (CustomerDetails) tableCustomer.getItems().get(tableCustomer.getSelectionModel().getSelectedIndex());
                addcustID.setText(pl.getCustomer_ID());
                custLocID.setText(pl.getCustLocation_ID());



                if ("1".equals(pl.getCustTypeID())) {
                    radioR.setSelected(true);
                    radioC.setSelected(false);
                } else if ("2".equals(pl.getCustTypeID())) {
                    radioC.setSelected(true);
                    radioR.setSelected(false);
                } else {
                    radioC.setSelected(false);
                    radioR.setSelected(false);
                }

                if ("1".equals(pl.getCusStatID())){
                    RadioActive.setSelected(true);
                    RadioIn.setSelected(false);
                } else if ("2".equals(pl.getCusStatID())){
                    RadioIn.setSelected(true);
                    RadioActive.setSelected(false);
                }else{
                    RadioActive.setSelected(false);
                    RadioActive.setSelected(false);
                }


            }

        });
    };

    @FXML
    private void clearButton (ActionEvent event) {
        addcustID.setText("");
        addFirstName.setText("");
        addLastName.setText("");
        addOrg.setText("");
        addEmail.setText("");
        addPhone.setText("");
        addCityz.setText("");
        addBill.setText("");
        addStreet.setText("");
        custLocID.setText("");

    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection c;
        //Gets text from tableview
        setCellValueFromTableToTextField();
        //dropdown box for Country


        //dropdown box for State

        radioR.requestFocus();
        search.requestFocus();
        fillComboBoxCountry();
        fillComboBoxPostal();
        fillComboBoxCounty();
        fillComboBoxStateP();
        // TODO
    }



}
