package kodlamaio.hrms1.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_seekers")
public class JobSeeker {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tcKn;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="password")
    private String password;

    private String passwordAgain;

    @Column(columnDefinition = "boolean false")
    private boolean emailValidation;

    public JobSeeker(){
        super();
    }

    public JobSeeker(int id, String firstName, String lastName, String tcKn, Date dateOfBirth, String emailAddress, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcKn = tcKn;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String gettcKn() {
        return tcKn;
    }

    public void setTcKn(String tcKn) {
        this.tcKn = tcKn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public void setEmailValidation(boolean emailValidation) {
        this.emailValidation = emailValidation;
    }

}
