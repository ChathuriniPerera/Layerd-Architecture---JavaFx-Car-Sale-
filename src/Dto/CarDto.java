package Dto;

public class CarDto{
    private String ecnumber;
    private String number;
    private String distance;
    private String colour;
    private String mname;
    private String price;

    public CarDto(){}

    public CarDto(String mname,String ecnumber, String number, String distance, String colour,String price){
        this.mname=mname;
        this.ecnumber=ecnumber;
        this.number=number;
        this.distance=distance;
        this.colour=colour;
        this.price=price;
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

    public void setnumber(String number) {
        this.number = number;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
