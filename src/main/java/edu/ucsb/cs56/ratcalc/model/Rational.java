package edu.ucsb.cs56.ratcalc.model;
/** A class to represent a rational number
    with a numerator and denominator

    @author Abby Wysopal
    @author Bella Yua

*/

public class Rational {

    private int num;
    private int denom;

    /**
		greatest common divisor of a and b
		@param a first number
		@param b second number
		@return gcd of a and b
    */

    public static int gcd(int a, int b) {
		if (a==0)
		    return b;
		else if (b==0)
		    return a;
		else{
			if(a < 0)
				a *= -1;
			if(b < 0)
				b *= -1;

		    return gcd(b%a, a);
		}
	}
	    
	
	public Rational() {
		this.num = 1;
		this.denom = 1;
    }

    /** 
		Rational of a over b
		@param num numerator
		@param denom deonminator
    */

    public Rational(int num, int denom) {
		if (denom == 0)
		    throw new IllegalArgumentException("denominator may not be zero");

		this.num = num;
		this.denom = denom;

		if (num != 0) {
		    int gcd = Rational.gcd(num,denom);
		    this.num /= gcd;
		    this.denom /= gcd;
		}

		if(denom < 0){
			this.num *= -1;
			this.denom *= -1;
		}
    }

    public String toString() {
		if (denom == 1 || num == 0)
		    return "" + num;
		
		return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    /** 
		this times Rational r
		@param r Rational Object
		@return this times Rational r
    */
    public Rational times(Rational r) {
		return new Rational(this.num * r.num, this.denom * r.denom);
    }

    /** 
		product of Rational a and Rational b
		@param a Rational Object
		@param b Rational Object
		@return Rational a times Rational b
    */
    public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num, a.denom * b.denom);
    }

    /**
		least common multiple of a and b
		@param a first number
		@param b second number
		@return lcm of a and b
    */
	//returns least common multiple of a and b. See wikipedia discussion
    public static int lcm(int a, int b){
    	if(a == 0 || b == 0)
			throw new java.lang.ArithmeticException("denominator may not be zero");

    	if(a < 0)
    		a *= -1;
    	if(b < 0)
    		b *= -1;

    	int max = a;
    	int min = b;
    	if (b > a){
    		max = b;
    		min = a;
    	}

    	for(int i = 1; i <=  min; i++){
    		if( (i * max) % min == 0){
    			return i * max;
    		}
    	}

    	return a * b;
    }

    /** 
		this plus Rational r
		@param r Rational Object
		@return this plus Rational r
    */
    //returns sum of this number plus r
	public Rational plus(Rational r){
		int lcm = lcm(this.denom, r.denom);
		return new Rational( ((lcm/this.denom)*this.num) + ((lcm/r.denom)*r.num), lcm);
	}	

    /** 
		sum of Rational a and Rational b
		@param a Rational Object
		@param b Rational Object
		@return Rational a plus Rational b
    */
	//returns a+b
	public static Rational sum(Rational a, Rational b){
		return a.plus(b);
	}	

    /** 
		this minus Rational r
		@param r Rational Object
		@return this minus Rational r
    */
	//returns this number minus r
	public Rational minus(Rational r){
		Rational newR = new Rational((-1*r.num), r.denom);
		return plus(newR);
	}	

    /** 
		difference of Rational a and Rational b
		@param a Rational Object
		@param b Rational Object
		@return Rational a minus Rational b
    */
	//returns a-b
	public static Rational difference(Rational a, Rational b){
		return a.minus(b);
	}	

    /**
		reciprocal of this
		@return reciprocal of this

		returns reciprocal (swap numerator and denominator). If numerator if zero, throws an instance of 
		java.lang.ArithmeticException. To review exceptions, see cs56-rational-ex07
	*/
	public Rational reciprocalOf(){
		if (this.num== 0)
		    throw new java.lang.ArithmeticException("denominator may not be zero");

		int newDenom = this.num;
		int newNum = this.denom;
		
		//may be able to take this out. because we call the constructor of Rational which does this already
		if (newNum != 0) {
		    int gcd = Rational.gcd(newNum,newDenom);
		    newNum /= gcd;
		    newDenom /= gcd;
		}

		return new Rational(newNum, newDenom);

	}	

    /** 
		this dividedBy Rational r
		@param r Rational Object
		@return this dividedBy Rational r
    */
	//returns this number divided by r
	public Rational dividedBy(Rational r){
		return times(r.reciprocalOf());
	}	
	
	/** 
		quotient of Rational a and Rational b
		@param a Rational Object
		@param b Rational Object
		@return Rational a dividedBy Rational b
    */
	//returns a divided by b
	public static Rational quotient(Rational a, Rational b){
		return product(a, b.reciprocalOf());
	}	

    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
