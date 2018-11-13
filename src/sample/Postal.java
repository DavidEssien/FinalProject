package sample;


public class Postal {

    private String postalKey;
    private String postalCode;
    //MyObject is
    public Postal(String postalKey, String postalCode) {
        this.postalKey = postalKey;
        this.postalCode = postalCode;
    }

    public String getpostalKey(){
        return postalKey ;
    }

    @Override
    public String toString() {
        return postalCode;
    }


}
