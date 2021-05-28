package kodlamaio.hrms1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms1.business.abstracts.JobSeekerService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody JobSeeker jobSeeker){return this.jobSeekerService.register(jobSeeker);}
}
