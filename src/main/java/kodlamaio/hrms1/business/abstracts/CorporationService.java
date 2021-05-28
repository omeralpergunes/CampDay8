package kodlamaio.hrms1.business.abstracts;

import java.util.List;

import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.Corporation;

public interface CorporationService {

    DataResult<List<Corporation>> getAll();
    DataResult<Corporation> getCorporationById(int id);
    Result add(Corporation corporation);
}
