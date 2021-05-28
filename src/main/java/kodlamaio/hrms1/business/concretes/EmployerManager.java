package kodlamaio.hrms1.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.EMailService;
import kodlamaio.hrms1.business.abstracts.EmployerCheckService;
import kodlamaio.hrms1.business.abstracts.EmployerService;
import kodlamaio.hrms1.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms1.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {


    private EmployerDao employerDao;
    private EmployerCheckService employerCheckService;
    private EmployerVerificationService employerVerificationService;
    private EMailService eMailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService, EmployerVerificationService employerVerificationService, EMailService emailService){
        super();
        this.employerDao = employerDao;
        this.employerCheckService = employerCheckService;
        this.employerVerificationService = employerVerificationService;
        this.eMailService = emailService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşveren Kişiler Listelenmiştir.");
    }

    @Override
    public Result register(Employer employer) {
        for(Employer registeredEmployer : this.employerDao.findAll()){
            if(registeredEmployer.getEmailAddress().equals(employer.getEmailAddress())){
                return new ErrorResult("Bu email ile kayitli bir hesap bulduk.");
            }
        }
        if(this.employerCheckService.checkPerson(employer).isSuccess() && this.employerVerificationService.validate(employer).isSuccess()){
            this.eMailService.sendEmail(employer.getEmailAddress());
            this.employerDao.save(employer);
            return new SuccessResult("Kayıt İşlemi Başarıyla Gerçekleşti");
        }
        return new ErrorResult();
    }
}
