package kodlamaio.hrms1.business.abstracts;

import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

public interface JobSeekerVerificationService {

	public Result validate(JobSeeker jobSeeker);
}
