package kodlamaio.hrms1.business.abstracts;

import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

public interface JobSeekerService {

	 DataResult<List<JobSeeker>> getAll();
	    Result register(JobSeeker jobSeeker);
}
