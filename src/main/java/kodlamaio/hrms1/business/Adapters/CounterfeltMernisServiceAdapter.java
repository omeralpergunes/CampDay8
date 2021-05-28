package kodlamaio.hrms1.business.Adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

@Service
public class CounterfeltMernisServiceAdapter implements JobSeekerCheckService{

	  @Override
	    public Result checkIfRealPerson(JobSeeker jobSeeker) {
	        if(jobSeeker.gettcKn().length() == 11){
	            return new SuccessResult();
	        }
	        return new ErrorResult("Mernis Doğrulaması Başarısız Olmuştur");
}}
