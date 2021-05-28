package kodlamaio.hrms1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms1.business.abstracts.CorporationService;
import kodlamaio.hrms1.core.utilities.results.DataResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.entities.concretes.Corporation;

@RestController
@RequestMapping("/api/corporations")
public class CorporationController {
	private CorporationService corporationService;

    @Autowired
    public CorporationController(CorporationService corporationService){
        this.corporationService = corporationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Corporation>> getAll(){return this.corporationService.getAll();}

    @PostMapping("/add")
    public Result add(Corporation corporation){return this.corporationService.add(corporation);}

}
