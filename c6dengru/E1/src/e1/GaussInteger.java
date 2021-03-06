package e1;

public class GaussInteger {
	private int real, imag;
	
	GaussInteger() {
		this.real = 0;
		this.imag = 0;
	}
	
	GaussInteger(int real, int imag) {
		// your code goes here
		this.real = real;
		this.imag = imag;
	}
	
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImag() {
		return imag;
	}

	public void setImag(int imag) {
		this.imag = imag;
	}

	// define and code the add method below
	public GaussInteger add(GaussInteger other) {
		return new GaussInteger(real + other.real, imag + other.imag);
	}
	
	// define and code the moduleSquared method below
	public int moduleSquared() {
		return real * real + imag * imag;
	}
	
	// define and code the isInvertible method below
	public boolean isInvertible() {
		return moduleSquared() == 1;
	}
	
	// Add the necessary formal parameter
	public boolean equals(Object obj) {
	   boolean result = true;
	   // write code that assigns the correct value to result
	   if (obj == null || !GaussInteger.class.isAssignableFrom(obj.getClass()))
		   result = false;
	   else {
		   GaussInteger other = (GaussInteger) obj;
		   result = real == other.real && imag == other.imag;
	   }
	   return result;
	}
	
	public String toString() {
		String result = "";
		// your code goes here
		if (real != 0)
			result += real;
		if (imag > 0)
			result += "+";
		if (imag == -1)
			result += "-";
		else if (imag != 1 && imag != 0)
			result += imag;
		if (imag != 0)
			result += "i";
		if (result == "")
			result = "0";
		return result;
	}

}