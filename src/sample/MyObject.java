package sample;

public class MyObject {

    private String key;
    private String value;
//MyObject is
    public MyObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key ;
    }

    @Override
    public String toString() {
        return value;
    }
}