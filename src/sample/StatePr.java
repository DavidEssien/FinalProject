package sample;


public class StatePr {

    private String statePrKey;
    private String statePrName;
    //MyObject is
    public StatePr(String statePrKey, String statePrName) {
        this.statePrKey = statePrKey;
        this.statePrName = statePrName;
    }

    public String getstatePrKey(){
        return statePrKey ;
    }

    @Override
    public String toString() {
        return statePrName;
    }


}