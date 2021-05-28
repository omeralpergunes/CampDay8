package kodlamaio.hrms1.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "corporation")
public class Corporation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fsname")
    private String fsname;

    @Column(name = "web_adres")
    private String webAdres;

    @Column(name = "web_domain")
    private String domain;

    public Corporation(){}
    public Corporation(int id, String fsname, String webAdres, String domain){
        this.id = id;
        this.fsname = fsname;
        this.webAdres = webAdres;
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fsname;
    }

    public void setName(String name) {
        this.fsname = name;
    }

    public String getWebAddress() {
        return webAdres;
    }

    public void setWebAddress(String webAddress) {
        this.webAdres = webAddress;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @OneToMany(mappedBy = "corporation")
    private List<JobAdvertisement> jobPostings;
}
