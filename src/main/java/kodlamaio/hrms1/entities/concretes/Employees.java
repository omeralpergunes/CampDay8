package kodlamaio.hrms1.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employees {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.DATE)
    private Date yearOfDate;

    public Employees(){}

    public Employees(int id, String mailAddress, String password, Date yearOfDate) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.password = password;
        this.yearOfDate = yearOfDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmailAddress() {
        return mailAddress;
    }

    public void setmailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getYearOfDate() {
        return yearOfDate;
    }

    public void setYearOfDate(Date yearOfDate) {
        this.yearOfDate = yearOfDate;
    }

}
