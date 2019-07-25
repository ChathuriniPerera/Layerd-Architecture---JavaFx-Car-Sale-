package Entity;

public class CarModel extends SuperEntity {
    private String mname;
    private String brand;

    public CarModel(String mname, String brand){}

    public CarModel(String mname,String brand,String year){
        this.setMname(mname);
        this.setBrand(brand);
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
