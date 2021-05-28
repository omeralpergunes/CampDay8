package kodlamaio.hrms1.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;
import kodlamaio.hrms1.dataAccess.abstracts.CorporationDao;
import kodlamaio.hrms1.entities.concretes.Corporation;

@Service
public class CorporationManager {

	private CorporationDao corporationDao;

    public CorporationManager(CorporationDao corporationDao){
        this.corporationDao = corporationDao;
    }

    public DataResult<List<Corporation>> getAll() {
        return new SuccessDataResult<List<Corporation>>(this.corporationDao.findAll(), "Kurumlar Listelenmiştir.");
    }

    public DataResult<Corporation> getByCorporationId(int id) {
        return new SuccessDataResult<Corporation>(this.corporationDao.getById(id),"Kurumlar Listelenmiştir.");
    }

    public Result add(Corporation corporation) {
        this.corporationDao.save(corporation);
        return new SuccessResult("Şirket eklendi");
    }
}
