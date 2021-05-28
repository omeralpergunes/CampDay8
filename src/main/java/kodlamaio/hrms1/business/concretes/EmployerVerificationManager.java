package kodlamaio.hrms1.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.core.utilities.systems.SystemController;
import kodlamaio.hrms1.entities.concretes.Employer;

@Service
public class EmployerVerificationManager implements EmployerVerificationService {

	public EmployerVerificationManager(){}

    @Override
    public Result validate(Employer employer) {
        boolean successAll = false;
        Result[] results = {
                SystemController.checkStringInputIsItEmpty(employer.getUserPhoneNumber(),"Telefon Numarası"),
                SystemController.checkStringInputIsItEmpty(employer.getEmailAddress(),"E-Posta"),
                SystemController.checkStringInputIsItEmpty(employer.getPassword(), "Şifreniz"),
                SystemController.checkStringInputIsItEmpty(employer.getPasswordAgain(),"Şifreyi Tekrar Giriniz"),
                SystemController.checkIntegerInputIsItEmpty(employer.getCorporationId(), "Şirket ID'si")
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
