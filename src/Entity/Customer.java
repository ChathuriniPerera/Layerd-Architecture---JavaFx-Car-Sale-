package Entity;

public class Customer extends SuperEntity {
    private String custnic;
    private String cname;
    private String custcontact;
    private String custaddress;

    public Customer(){}

    public Customer(String custnic, String cname, String custaddress, String custcontact){
        this.setCustnic(custnic);
        this.setCustaddress(custaddress);
        this.setCustcontact(custcontact);
        this.setCname(cname);
    }


    public String getCustnic() {
        return custnic;
    }

    public void setCustnic(String custnic) {
        this.custnic = custnic;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCustcontact() {
        return custcontact;
    }

    public void setCustcontact(String custcontact) {
        this.custcontact = custcontact;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }
}
