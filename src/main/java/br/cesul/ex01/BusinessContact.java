package br.cesul.ex01;

public class BusinessContact extends Contact {

    private String company;
    private String businessPhone;
    private String linkedin;
    private String occupation;
    private String sector;

    public BusinessContact(String name, String phone, String email, String address, String instagram, String company, String businessPhone, String linkedin, String occupation, String sector) {
        super(name, phone, email, address, instagram);
        this.company = company;
        this.businessPhone = businessPhone;
        this.linkedin = linkedin;
        this.occupation = occupation;
        this.sector = sector;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
