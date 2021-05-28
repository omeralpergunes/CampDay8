package kodlamaio.hrms1.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {

	    @Id
	    @Column(name = "id")
	    private int id;

	    @Column(name = "code")
	    private int code;

	    @Column(name = "name")
	    private String name;

	    public City(){}

	    public City(int id, int code, String name) {
	        this.id = id;
	        this.code = code;
	        this.name = name;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getCode() {
	        return code;
	    }

	    public void setCode(int code) {
	        this.code = code;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}
