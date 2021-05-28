package kodlamaio.hrms1.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.EMailService;
import kodlamaio.hrms1.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms1.business.abstracts.JobSeekerService;
import kodlamaio.hrms1.business.abstracts.JobSeekerVerificationService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private JobSeekerVerificationService jobSeekerVerificationService;
    private EMailService emailService;
    private JobSeekerCheckService jobSeekerCheckService;

    public JobSeekerManager (JobSeekerDao jobSeekerDao){
        this.jobSeekerDao = jobSeekerDao;
    }

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,
                            JobSeekerVerificationService jobSeekerVerificationService,
                            EMailService emailService,
                            JobSeekerCheckService jobSeekerCheckService){
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.jobSeekerVerificationService = jobSeekerVerificationService;
        this.emailService = emailService;
        this.jobSeekerCheckService = jobSeekerCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş Arayan Kişiler listelendi");
    }

    @Override
    public Result register(JobSeeker jobSeeker) {
        for(JobSeeker registeredJobSeeker : this.jobSeekerDao.findAll()) {
            if (registeredJobSeeker.gettcKn().equals(jobSeeker.gettcKn()) || registeredJobSeeker.getEmailAddress().equals(jobSeeker.getEmailAddress())) {
                return new ErrorResult("Adınıza Kayıtlı bir hesap bulundu. Giriş yapınız.");
            }
        }
        if(this.jobSeekerCheckService.checkIfRealPerson(jobSeeker).isSuccess() && this.jobSeekerVerificationService.validate(jobSeeker).isSuccess()){
            this.emailService.sendEmail(jobSeeker.getEmailAddress());
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Kayıt onaylandı. E-mail adresinizden hesabınızı doğrulama işlemine geçiniz.");
        }
        return new ErrorResult();
    }}

