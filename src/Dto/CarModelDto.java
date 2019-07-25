package Dto;

public class CarModelDto {
    private String mname;
    private String brand;

    private CarModelDto(){}

    public CarModelDto(String mname, String brand){
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
