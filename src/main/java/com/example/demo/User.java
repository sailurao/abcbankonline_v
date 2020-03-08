package com.example.demo;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;
        import javax.validation.constraints.Email;
        import javax.validation.constraints.NotBlank;

@Table
@Entity(name="user")
public class User {

    @Id
    private int userId;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String emailId;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String password;

    public User() {
        super();
    }

    public User(int userId, String firstName, String middleName, String lastName, String emailId, String mobileNumber, String address, String password) {
        super();
        this.userId=userId;
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.emailId=emailId;
        this.mobileNumber=mobileNumber;
        this.address=address;
        this.password=password;
    }


    public int getUser_id() {
        return userId;
    }


    public void setUser_id(int userId) {
        this.userId = userId;
    }


    public String getFirst_name() {
        return firstName;
    }


    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddle_name() {
        return middleName;
    }

    public void setMiddle_name(String middleName) {
        this.middleName = middleName;
    }


    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile_number() {
        return mobileNumber;
    }

    public void setMobile_number(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

