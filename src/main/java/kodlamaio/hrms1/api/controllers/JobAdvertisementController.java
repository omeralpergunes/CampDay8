package kodlamaio.hrms1.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms1.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){return this.jobAdvertisementService.getAll();}

    @GetMapping("/getByDateOfCreate")
    public DataResult<List<JobAdvertisement>> getByDateOfYear(@RequestParam Date dateOfYear){
        return this.jobAdvertisementService.getByDateOfYear(dateOfYear);
    }

    @GetMapping("/getByCompanyId")
    public DataResult<List<JobAdvertisement>> getByCorporationId(@RequestParam int corporationId){
        return this.jobAdvertisementService.getByCorporationId(corporationId);
    }

    @PutMapping("/close")
    public Result close(JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.close(jobAdvertisement);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }
}
