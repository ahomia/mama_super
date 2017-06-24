package model;

/**
 * Created by axomia on 24.06.2017.
 */
public class Account {
    private String taxId;
    private String firstname;
    private String lastname;
    private String address1;
    private String postcode;
    private String city;
    private String phone;
    private String email;

    public String getEmail() {
        return email;
    }

    public Account withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account withPassword(String password) {
        this.password = password;
        return this;
    }

    private String password;

    public Account(String taxId, String firstname, String lastname, String address1, String postcode, String city, String phone,
                   String email, String password) {
        this.taxId = taxId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address1 = address1;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.email=email;
        this.password=password;
    }

    public Account(Account customer) {
    }

    public Account() {

    }

    public Account withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Account withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Account withTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public Account withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public Account withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public Account withCity(String city) {
        this.city = city;
        return this;
    }

    public Account withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress1() {
        return address1;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
}
