package kodlamaio.hrms1.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	    DataResult<List<JobAdvertisement>> getAll();
	    DataResult<List<JobAdvertisement>> getByDateOfYear(Date dateOfYear);
	    DataResult<List<JobAdvertisement>> getByCorporationId(int corporationId);
	    Result add(JobAdvertisement jobAdvertisement);
	    Result close(JobAdvertisement jobAdvertisement);
}
