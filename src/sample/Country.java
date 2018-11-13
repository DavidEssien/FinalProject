package sample;

public class Country {

    private String countryKey;
    private String countryName;
    //MyObject is
    public Country(String countryKey, String countryName) {
        this.countryKey = countryKey;
        this.countryName = countryName;
    }

    public String getcountryKey(){
        return countryKey ;
    }

    @Override
    public String toString() {
        return countryName;
    }


}
