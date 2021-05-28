package kodlamaio.hrms1.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	 List<JobAdvertisement> getByDateOfYear(Date dateOfYear);
	 List<JobAdvertisement> getByCorporation_Id	(int corporationId);

}
