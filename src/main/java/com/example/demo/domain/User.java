package com.example.demo.domain;

        import com.fasterxml.jackson.annotation.JsonProperty;

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
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

