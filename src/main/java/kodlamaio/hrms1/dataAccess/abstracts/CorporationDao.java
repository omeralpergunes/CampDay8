package kodlamaio.hrms1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms1.entities.concretes.Corporation;

public interface CorporationDao extends JpaRepository<Corporation, Integer>{

	Corporation getById(int id);

}
