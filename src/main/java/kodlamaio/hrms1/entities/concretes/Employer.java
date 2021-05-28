package kodlamaio.hrms1.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employers")
public class Employer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "corporationId")
    private int corporationId; 

    @Column(name = "userPhoneNumber")
    private String UserPhoneNumber;

    @Column(name="mailAddress")
    private String emailAddress;

    @Column(name="password")
    private String password;

    private String passwordAgain;

    @Column(columnDefinition = "false")
    private boolean emailValidation;

    @Column(columnDefinition = "false")
    private boolean registrationValidation;

    public Employer() {
    }

    public Employer(String emailAddress, String password, int id, int corporationId, String userPhoneNumber) {
        this.id = id;
        this.corporationId = corporationId;
        this.UserPhoneNumber = userPhoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(int companyId) {
        this.corporationId = companyId;
    }

    public String getUserPhoneNumber() {
        return UserPhoneNumber;
    }

    public void setuserPhoneNumber(String phoneNumber) {
        this.UserPhoneNumber = phoneNumber;
    }

    public boolean isRegistrationVerification() {
        return registrationValidation;
    }

    public void setRegistrationVerification(boolean registrationVerification) {
        this.registrationValidation = registrationVerification;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public boolean isEmailValidation() {
        return emailValidation;
    }

    public void setEmailValidation(boolean emailVerification) {
        this.emailValidation = emailVerification;
    }
}
