package kodlamaio.hrms1.business.abstracts;

import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.Employer;

public interface EmployerVerificationService {

	public Result validate(Employer employer);
}
