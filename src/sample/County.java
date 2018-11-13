package sample;


public class County {

    private String countyKey;
    private String countyName;
    //MyObject is
    public County(String countyKey, String countyName) {
        this.countyKey = countyKey;
        this.countyName = countyName;
    }

    public String getcountyKey(){
        return countyKey ;
    }

    @Override
    public String toString() {
        return countyName;
    }


}
