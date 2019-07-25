package Dto;

public class CustomerDto {
    private String cnic;
    private String cname;
    private String contact;
    private String caddress;

    public CustomerDto(){}

    public CustomerDto(String cnic, String cname,String contact,String caddress){
        this.setCnic(cnic);
        this.setCname(cname);
        this.setContact(contact);
        this.setCaddress(caddress);
    }


    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }
}
