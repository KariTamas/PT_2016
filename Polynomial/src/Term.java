public class Term {
	private float coeff;
	private int degree;

	public Term(float coeff, int degree) {
		super();
		this.coeff = coeff;
		this.degree = degree;
	}
	
	public Term(Term t) {
		super();
		this.coeff = t.coeff;
		this.degree = t.degree;
	}
	
	//for reading polynomials
	public Term(String s, int coefficient){
		if (s.contains("x^")) {
			String[] s2 = s.split("x");
			if (s2[0].equals("")) 
				this.coeff = coefficient;
			else 
				this.coeff = coefficient*Integer.parseInt(s2[0]);
			s2[1]=s2[1].substring(1,s2[1].length());
			this.degree = Integer.parseInt(s2[1]);
		}
		else if (s.contains("x")){
			String[] s2 = s.split("x");
			if (s2.length==0)
				this.coeff =(float)coefficient;
			else 
				this.coeff = coefficient*Integer.parseInt(s2[0]);
			this.degree = 1;
		}
		else if (!s.isEmpty()){
			this.coeff=coefficient*Integer.parseInt(s);
			this.degree=0;
		}
	}

	public float getCoefficient() {
		return coeff;
	}

	public void setCoefficient(float coeff) {
		this.coeff = coeff;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Term)){
			return false;
		}
		
		Term that = (Term)obj;
		
		return that.coeff == this.coeff && that.degree == this.degree;
	}
}