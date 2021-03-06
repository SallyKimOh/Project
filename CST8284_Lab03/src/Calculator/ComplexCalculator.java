package Calculator;

public class ComplexCalculator {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;
	private String errorMsg = "";
	
	public ComplexCalculator(Complex c1, Complex c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
		char mathOp = op.nextLine().charAt(0);
		
		switch (mathOp){
		   case '+':
		      c = plus(c1, c2);
		      break;
		   case '-':
			  //TODO: Call the method for the subtraction of two complex numbers here
		      c = subtract(c1, c2);
		      break;
		   case '*':
			  //TODO: Call the method for the multiplication of two complex numbers here
		      c = multiply(c1, c2);
		      break;
		   case '/':
		      //TODO: Call the method for the division of two complex numbers here
//		      c = divide(c1, c2);
		      c = multiplication(c1, c2);
		      break;
		   default:
			  System.out.println("Unknown operation requested");
		}
		
	}
	
	private Complex plus(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();
		double imag = c1.getImag() + c2.getImag();
		
		return(new Complex(real, imag));
	}

	
	private Complex subtract(Complex c1, Complex c2){
		return (new Complex(c1.getReal()-c2.getReal(),c1.getImag()-c2.getImag()));
	}
	
	private Complex multiply(Complex c1, Complex c2){
		double real = (c1.getReal() * c2.getReal())-(c1.getImag() * c2.getImag());
		double imag = (c1.getReal()*c2.getImag()) + (c2.getReal()*c1.getReal());
		
		return(new Complex(real, imag));

	}
	
	private Complex divide(Complex c1, Complex c2){		
	 //TODO: check for possible division by 0 and output an error message to the screen
	 //return a constructor with value 0 + 0i);
		double div = Math.pow(c2.getReal(),2) + Math.pow(c2.getImag(), 2);
		double real,imag;
		if (div == 0.0) {
			real = 0;imag = 0;
			errorMsg = "Divide-by-zero error detected";
		} else {	
			real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/div;
			imag = ((c2.getReal() * c1.getImag())-(c1.getReal() * c2.getImag()))/div;
	//		double real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/(c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag());
	//		double imag = ((c2.getReal() * c1.getImag())-(c1.getReal() * c2.getImag()))/(c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag());
		}
		return(new Complex(real, imag));
	} 


	private Complex multiplication(Complex c1, Complex c2){		
		double div = c2.getReal() * c2.getReal() + conjugate(c2).getImag()*conjugate(c2).getImag();
		double real,imag;
		if (div == 0.0) {
			real = 0;imag = 0;
		} else {	
			real = ((c1.getReal() * c2.getReal())-(c1.getImag() * conjugate(c2).getImag()))/div;
			imag = ((c1.getReal() * conjugate(c2).getImag())-(c1.getImag() * c2.getImag()))/div;
//			imag = ((c1.getReal() * conjugate(c2).getImag())+(c2.getImag() * c1.getImag()))/div;
		}	
		return (new Complex(real, imag));
	} 

	
	
	public Complex conjugate(Complex c2){
		return new Complex(c2.getReal(), -c2.getImag());
	}
	

	private Complex modulus(Complex c1,Complex c2){
		
		return new Complex(String.valueOf((Math.sqrt(Math.pow(c1.getReal(),2) + Math.pow(c1.getImag(),2)))));
//		return new Complex(String.valueOf(Math.sqrt(c.getReal()*c.getReal() + c.getImag()*c.getImag())));
	}
	
	
	public Complex getComplexResult(){
		return c;
	}


	public String toString(){
		if (c.toString().matches(".*-.*")) {
			return c.toString().replace("+ -", "- ");
		}
		return errorMsg + "\n"+c.toString();
		
	}

}
