package Entity;

public class Car extends SuperEntity {
    private String mname;
    private String ecnumber;
    private String distance;
    private String color;
    private String number;
    private String price;

    public Car(){}

    public Car(String mname,String ecnumber, String distance, String color, String number,String price){
        this.mname=mname;
        this.ecnumber=ecnumber;
        this.distance=distance;
        this.color=color;
        this.number=number;
        this.price=price;
    }


    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }
}
