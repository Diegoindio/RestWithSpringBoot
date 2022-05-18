package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double sum = convertDouble(numberOne)+ convertDouble(numberTwo); 
		return sum;
	}
	
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double subtraction = convertDouble(numberOne)- convertDouble(numberTwo); 
		return subtraction;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double division = convertDouble(numberOne)/ convertDouble(numberTwo); 
		return division;
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double multiplication = convertDouble(numberOne)* convertDouble(numberTwo); 
		return multiplication;
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double mean = (convertDouble(numberOne)+ convertDouble(numberTwo))/2; 
		return mean;
	}
	
	@RequestMapping(value="/sqrt/{numberOne}", method=RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne)throws Exception {
		if (!isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double sqrt = Math.sqrt(convertDouble(numberOne)); 
		return sqrt;
	}
	
	private Double convertDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if (isNumeric(number))return Double.parseDouble(number); 
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");//regex que verifica se é um numero.
	}
}
