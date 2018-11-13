package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmpDetails {

    private final StringProperty Employee_ID;
    private final StringProperty EmpFirstName;
    private final StringProperty EmpLastName;
    private final StringProperty EmpPhone;
    private final StringProperty EmpEmail;
    private final StringProperty StartDate;
    private final StringProperty EndDate;
    private final StringProperty EmpAddress;
    private final StringProperty EmpCity;
    private final StringProperty StateProvinceID;
    private final StringProperty CountryID;
    private final StringProperty EmployeeStatus_ID;
    private final StringProperty EmployeeType_ID;
    private final StringProperty EmployeeTitle_ID;



    public EmpDetails(String Employee_ID, String EmpFirstName, String EmpLastName,String EmpPhone, String EmpEmail,String StartDate, String EndDate,
                      String EmpAddress, String EmpCity, String StateProvinceID, String CountryID,String EmployeeStatus_ID, String EmployeeType_ID, String EmployeeTitle_ID) {

        this.Employee_ID = new SimpleStringProperty(Employee_ID);
        this.EmpFirstName = new SimpleStringProperty(EmpFirstName);
        this.EmpLastName = new SimpleStringProperty(EmpLastName);
        this.EmpEmail = new SimpleStringProperty(EmpEmail);
        this.StartDate = new SimpleStringProperty(StartDate);
        this.EndDate = new SimpleStringProperty(EndDate);
        this.EmpAddress = new SimpleStringProperty(EmpAddress);
        this.EmpCity = new SimpleStringProperty(EmpCity);
        this.StateProvinceID = new SimpleStringProperty(StateProvinceID);
        this.CountryID=new SimpleStringProperty(CountryID);
        this.EmployeeStatus_ID = new SimpleStringProperty(EmployeeStatus_ID);
        this.EmployeeType_ID = new SimpleStringProperty(EmployeeType_ID);
        this.EmployeeTitle_ID = new SimpleStringProperty(EmployeeTitle_ID);
        this.EmpPhone = new SimpleStringProperty(EmpPhone);
    }

    public String getEmployee_ID() {
        return (String)this.Employee_ID.get();
    }

    public String getEmpFirstName() {
        return (String)this.EmpFirstName.get();
    }

    public String getEmpLastName() {
        return (String)this.EmpLastName.get();
    }

    public String getEmpPhone() { return (String)this.EmpPhone.get();}

    public String getEmpEmail() {
        return (String)this.EmpEmail.get();
    }

    public String getStartDate() {
        return (String)this.StartDate.get();
    }

    public String getEndDate() {
        return (String)this.EndDate.get();
    }

    public String getEmpAddress() { return (String)this.EmpAddress.get();}

    public String getEmpCity() {
        return (String)this.EmpCity.get();
    }

    public String getCountryID() {
        return (String)this.CountryID.get();
    }


    public String getStateProvinceID() {
        return (String)this.StateProvinceID.get();
    }

    public String getEmployeeStatus_ID() {
        return (String)this.EmployeeStatus_ID.get();
    }

    public String getEmployeeType_ID() {
        return (String)this.EmployeeType_ID.get();
    }

    public String getEmployeeTitle_ID() {
        return (String)this.EmployeeTitle_ID.get();
    }



}
