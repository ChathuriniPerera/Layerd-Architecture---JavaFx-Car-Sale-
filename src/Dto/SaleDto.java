package Dto;

public class SaleDto {
    private String bid;
    private String bdate;
    private String bprice;
    private String custnic;
    private String ecnumber;

    public SaleDto(){}

    public SaleDto(String bid, String bdate, String bprice, String custnic,String ecnumber){
        this.setBid(bid);
        this.setBdate(bdate);
        this.setBprice(bprice);
        this.setCustnic(custnic);
        this.setEcnumber(ecnumber);
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
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
