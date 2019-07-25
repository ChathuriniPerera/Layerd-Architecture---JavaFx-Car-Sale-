package util;

public class CarTM {
    private String ecnumber;
    private String number;
    private String distance;
    private String color;
    private String model;
    private String price;

    public CarTM() {
    }

    public CarTM(String ecnumber, String number, String distance, String color, String model, String price) {
        this.ecnumber = ecnumber;
        this.number = number;
        this.distance = distance;
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
