package kodlamaio.hrms1.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	 private JobAdvertisementDao jobAdvertisementDao;

	    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
	        this.jobAdvertisementDao = jobAdvertisementDao;
	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getAll() {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Mevcut Pozisyonlar Listelendi.");
	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getByDateOfYear(Date dateOfYear) {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByDateOfYear(dateOfYear),"Mevcut Tarihe göre listelendi.");
	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getByCorporationId(int corporationId) {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCorporation_Id(corporationId),"Şirkete gore listelendi.");
	    }

	    @Override
	    public Result add(JobAdvertisement jobAdvertisement) {
	        this.jobAdvertisementDao.save(jobAdvertisement);
	        return new SuccessResult("İş İlanı Yayınlandı");
	    }

	    @Override
	    public Result close(JobAdvertisement jobAdvertisement) {
	        if(jobAdvertisement.isActive()){
	            jobAdvertisement.setActive(false);
	            return new SuccessResult("Çıkış Yapıldı");
	        }
	        return new ErrorResult("Mevcut İlanın Süresi Dolmuştur");
	    }
	}