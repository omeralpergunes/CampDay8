package kodlamaio.hrms1.core.utilities.systems;

import java.util.Date;

import kodlamaio.hrms1.core.utilities.results.ErrorResult;
import kodlamaio.hrms1.core.utilities.results.Result;
import kodlamaio.hrms1.core.utilities.results.SuccessResult;

public class SystemController {

	  public static Result checkStringInputIsItEmpty(String input, String label){
	        if(input == null || input.length() == 0){
	            return new ErrorResult(label+" Alanı boş bırakmayınız.");
	        }
	        return new SuccessResult();
	    }
	    public static Result checkIntegerInputIsItEmpty(int input, String label){
	        if(input == 0){
	            return new ErrorResult(label+"Alanı boş bırakmayınız.");
	        }
	        return new SuccessResult();
	    }

	    public static Result checkDateInputIsItEmpty(Date date, String label){
	        if(date.getYear()==1){
	            return new ErrorResult("Doğum Yılını Giriniz");
	        }
	        return new SuccessResult();
	    }
}
