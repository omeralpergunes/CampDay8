package kodlamaio.hrms1.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.JobSeekerVerificationService;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.core.utilities.systems.SystemController;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

@Service
public class JobSeekerVerificationManager implements JobSeekerVerificationService {

	@Override
	public Result validate(JobSeeker jobSeeker) {
		boolean successAll = false;
        Result[] results = {
                SystemController.checkStringInputIsItEmpty(jobSeeker.getEmailAddress(), "e-mail"),
                SystemController.checkStringInputIsItEmpty(jobSeeker.gettcKn(),"TC NO "),
                SystemController.checkStringInputIsItEmpty(jobSeeker.getFirstName(), "isim"),
                SystemController.checkStringInputIsItEmpty(jobSeeker.getLastName(),"soyadı"),
                SystemController.checkStringInputIsItEmpty(jobSeeker.getPassword(),"sifre"),
                SystemController.checkStringInputIsItEmpty(jobSeeker.getPasswordAgain(),"tekrar şifre giriniz")
        };
        for(Result result : results){
            successAll = result.isSuccess();
        }
        if(successAll){
            return new SuccessResult();
        }else{
            return new ErrorResult();
        }
    }
	
	
}
