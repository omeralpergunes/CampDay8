package kodlamaio.hrms1.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="job_positions")
public class JobPosition {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateOfYear = new Date(System.currentTimeMillis());

    public JobPosition() {

    }

    public JobPosition(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreate() {
        return dateOfYear;
    }

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvertisement> JobAdvertisements;
}
