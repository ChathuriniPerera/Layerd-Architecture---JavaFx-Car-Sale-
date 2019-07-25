package util;

public class SalesTM {
    private String bid;
    private String date;
    private String price;
    private String custnic;
    private String ecnumber;

    public SalesTM(){}

    public SalesTM(String bid,String date,String price,String custnic,String ecnumber){
        this.setBid(bid);
        this.setDate(date);
        this.setPrice(price);
        this.setCustnic(custnic);
        this.setEcnumber(ecnumber);
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCustnic() {
        return custnic;
    }

    public void setCustnic(String custnic) {
        this.custnic = custnic;
    }


    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }
}
