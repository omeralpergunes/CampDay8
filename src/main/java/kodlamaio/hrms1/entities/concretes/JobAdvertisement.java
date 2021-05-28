package kodlamaio.hrms1.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "min_wage")
    private double minWage;

    @Column(name = "max_wage")
    private double maxWage;

    @Column(name = "date_of_year")
    @Temporal(TemporalType.DATE)
    private Date dateOfYear= new Date(System.currentTimeMillis());

    @Column(name="date_of_closed")
    private Date dateOfClosed;

    @Column(name = "active")
    private boolean active;

    @ManyToOne()
    @JoinColumn(name="corporation_id")
    private Corporation corporation;

    @ManyToOne()
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
