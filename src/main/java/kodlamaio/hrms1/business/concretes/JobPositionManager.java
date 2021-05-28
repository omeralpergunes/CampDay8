package kodlamaio.hrms1.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.JobPositionService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms1.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	 private JobPositionDao jobPositionDao;

	    @Autowired
	    public JobPositionManager(JobPositionDao jobPositionDao){
	        super();
	        this.jobPositionDao = jobPositionDao;
	    }

	    @Override
	    public DataResult<List<JobPosition>> getAll() {
	        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Belirlenen Pozisyonlar Listelendi");
	    }

	    @Override
	    public Result add(JobPosition jobPosition) {
	        for(JobPosition position : this.jobPositionDao.findAll()) {
	            if (position.getName().toLowerCase().equals(jobPosition.getName().toLowerCase())) {
	                return new ErrorResult("girilen pozisyon sistemde kayitli");
	            } else {
	                this.jobPositionDao.save(jobPosition);
	                return new SuccessResult("pozisyon basariyla kayit edildi");
	            }
	        }
	        return null;
	    }
}
