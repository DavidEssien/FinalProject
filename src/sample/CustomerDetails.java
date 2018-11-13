package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDetails {
    private final StringProperty Customer_ID;
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty Organization;
    private final StringProperty Phone;
    private final StringProperty Email;
    private final StringProperty CusTypeID;
    private final StringProperty CusStatID;
    private final StringProperty CustLocation_ID;
    private final StringProperty StreetAddress;
    private final StringProperty BillingAddress;
    private final StringProperty City;
    private final StringProperty PostalCodeID;

    private final StringProperty StateProvinceID;

    private final StringProperty CountryID;
    private final StringProperty postalCode;
    private final StringProperty state;
    private final StringProperty country;


    public CustomerDetails(String CustLocation_ID, String Customer_ID, String StreetAddress, String BillingAddress,String PostalCodeID, String City, String StateProvinceID, String CountryID, String FirstName, String LastName,String Organization, String Phone, String Email, String CusStatID, String CusTypeID,String postalCode, String state, String country) {
        this.Customer_ID = new SimpleStringProperty(Customer_ID);
        this.FirstName = new SimpleStringProperty(FirstName);
        this.LastName = new SimpleStringProperty(LastName);
        this.Organization = new SimpleStringProperty(Organization);
        this.Phone = new SimpleStringProperty(Phone);
        this.Email = new SimpleStringProperty(Email);
        this.CusTypeID = new SimpleStringProperty(CusTypeID);
        this.CusStatID = new SimpleStringProperty(CusStatID);
        this.CustLocation_ID = new SimpleStringProperty(CustLocation_ID);
        this.StreetAddress = new SimpleStringProperty(StreetAddress);
        this.BillingAddress = new SimpleStringProperty(BillingAddress);
        this.City = new SimpleStringProperty(City);
        this.PostalCodeID= new SimpleStringProperty(PostalCodeID);
        this.StateProvinceID =new SimpleStringProperty(StateProvinceID);
        this.CountryID=new SimpleStringProperty(CountryID);
        this.postalCode=new SimpleStringProperty(postalCode);
        this.state=new SimpleStringProperty(state);
        this.country=new SimpleStringProperty(country);

    }

    public String getCustomer_ID() {
        return (String)this.Customer_ID.get();
    }

    public String getFirstName() {
        return (String)this.FirstName.get();
    }

    public String getLastName() {
        return (String)this.LastName.get();
    }

    public String getOrganization() {
        return (String)this.Organization.get();
    }

    public String getPhone() {
        return (String)this.Phone.get();
    }

    public String getEmail() {
        return (String)this.Email.get();
    }

    public String getCustTypeID() { return (String)this.CusTypeID.get();}

    public String getCusStatID() {
        return (String)this.CusStatID.get();
    }

    public String getCustLocation_ID() {
        return (String)this.CustLocation_ID.get();
    }

    public String getStreetAddress() {
        return (String)this.StreetAddress.get();
    }

    public String getBillingAddress() {
        return (String)this.BillingAddress.get();
    }

    public String getCity() {
        return (String)this.City.get();
    }
    public String getPostalCodeID() {
        return (String)this.PostalCodeID.get();
    }

    public String getStateProvinceID() {
        return (String)this.StateProvinceID.get();
    }

    public String getCountryID() {
        return (String)this.CountryID.get();
    }


    public String getpostalCode() {
        return (String)this.postalCode.get();
    }
    public String getstate() {
        return (String)this.state.get();
    }
    public String getcountry() {
        return (String)this.country.get();
    }



    ///

    public void setCustomer_ID(String value) {
        this.Customer_ID.set(value);
    }

    public void setFirstName(String value) {
        this.FirstName.set(value);
    }

    public void setLastName(String value) {
        this.LastName.set(value);
    }

    public void setOrganization(String value) {
        this.Organization.set(value);
    }

    public void setPhone(String value) {
        this.Phone.set(value);
    }

    public void setEmail(String value) {
        this.Email.set(value);
    }

    public void setCusTypeID(String value) { this.CusTypeID.set(value);}

    public void setCusStatID(String value) {
        this.CusStatID.set(value);
    }

    public void setCustLocation_ID(String value) {
        this.CustLocation_ID.set(value);
    }

    public void setStreetAddress(String value) {
        this.StreetAddress.set(value);
    }

    public void setBillingAddress(String value) {
        this.BillingAddress.set(value);
    }

    public void setCity(String value) {
        this.City.set(value);
    }

    ////

    public StringProperty Customer_IDProperty() {
        return this.Customer_ID;
    }

    public StringProperty FirstNameProperty() {
        return this.FirstName;
    }

    public StringProperty LastNameProperty() {
        return this.LastName;
    }

    public StringProperty OrganizationProperty() {
        return this.Organization;
    }

    public StringProperty PhoneProperty() {
        return this.Phone;
    }

    public StringProperty EmailProperty() {
        return this.Email;
    }

    public StringProperty CusTypeID() {return this.CusTypeID;}

    public StringProperty CusStatID() {return this.CusStatID;}

    public StringProperty CustLocation_IDProperty() {
        return this.CustLocation_ID;
    }

    public StringProperty StreetAddressProperty() {
        return this.StreetAddress;
    }

    public StringProperty BillingAddressProperty() {
        return this.BillingAddress;
    }

    public StringProperty CityProperty() {
        return this.City;
    }

}