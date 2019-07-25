package Entity;

public class Owner extends SuperEntity {
    private String oid;
    private String oname;
    private String ocontact;
    private String oaddress;
    private String ecnumber;

    public Owner(){}

    public Owner(String oid,String oname,String ocontact,String oaddress,String ecnumber){
        this.setOid(oid);
        this.setOname(oname);
        this.setOcontact(ocontact);
        this.setOaddress(oaddress);
        this.setEcnumber(ecnumber);
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOcontact() {
        return ocontact;
    }

    public void setOcontact(String ocontact) {
        this.ocontact = ocontact;
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }

    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }
}
