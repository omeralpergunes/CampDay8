package kodlamaio.hrms1.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.CorporationService;
import kodlamaio.hrms1.business.abstracts.EmployerCheckService;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.entities.concretes.Employer;

@Service	
public class EmployerCheckManager implements EmployerCheckService{

	private CorporationService corporationService;

    public EmployerCheckManager(CorporationService corporationService){
        this.corporationService = corporationService;
    }

    @Override
    public Result checkPerson(Employer employer) {
            if(!employer.getEmailAddress().contains(this.corporationService.getCorporationById(employer.getCorporationId()).getData().getDomain())){
                return new ErrorResult("Girmiş olduğunuz mail sistemdeki domain ile uyum sağlayamadı.");
            }
        return new SuccessResult();
}

}
