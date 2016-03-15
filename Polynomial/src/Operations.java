public class Operations {

	//add
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial(p1);
		for (Term term : p2.getTerms()) {
			result.addTerm(term);
		}
		result.sort();
		return result;
	}
	
	//sub
	public static Polynomial sub(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial(p1);
		for (Term term : p2.getTerms()) {
			float coeff = term.getCoefficient();
			term.setCoefficient((-1)*coeff);
			result.addTerm(term);
		}
		result.sort();
		return result;
	}
	//multiply element with element
	public static Polynomial mul(Polynomial p1, Polynomial p2){
		Polynomial result = new Polynomial();
		for (Term term : p1.getTerms())
			for (Term term1 : p2.getTerms()){
				float coeff=term.getCoefficient()*term1.getCoefficient();
				int degree=term.getDegree()+term1.getDegree();
				Term resultT=new Term(0, 0);
				resultT.setCoefficient(coeff);
				resultT.setDegree(degree);
				result.addTerm(resultT);
			}
		result.sort();
		return result;
	}
	//division
	//negate(p1) returns -p1
	public static Polynomial negate(Polynomial p1){
		Polynomial result=new Polynomial();
		for (Term term : p1.getTerms()){
			float coefficient=term.getCoefficient();
			term.setCoefficient((-1)*(coefficient));
			result.addTerm(term);
		}
		return p1;
	}
	
	public static Polynomial div(Polynomial p1, Polynomial p2) {
		Polynomial blank = new Polynomial();
		Term t = new Term(0, 0);
		blank.addTerm(t);
		Polynomial remainder = new Polynomial(p1);
		Term p1First = p1.getTerms().get(0);
		if (p2.equals(blank)) {throw new RuntimeException("Divide by zero polynomial");}		
		if (p1First.getDegree() < p2.getTerms().get(0).getDegree()) {return blank;}
		Term quotent = new Term(0,0);
		Polynomial finalResult = new Polynomial();
		Polynomial partialresult=new Polynomial();

		while ((p2.getFirst().getDegree() <= remainder.getFirst().getDegree()) && !(remainder.equals(blank))) {
			quotent.setDegree(remainder.getTerms().get(0).getDegree() - p2.getTerms().get(0).getDegree());
			quotent.setCoefficient(remainder.getTerms().get(0).getCoefficient() / p2.getTerms().get(0).getCoefficient());
			partialresult.addTerm(quotent);
			finalResult.addTerm(quotent);

			Polynomial product = Operations.mul(partialresult, p2);
			remainder = Operations.sub(remainder, product);
			
			remainder.sort();
		}
		finalResult.sort();
		return finalResult;
	}
	
	//differentiation
	public static Polynomial deriv(Polynomial p1){
		Polynomial result = new Polynomial();
		for (Term term : p1.getTerms()){
			if(term.getDegree()!=0) {
				term.setCoefficient(term.getCoefficient()*term.getDegree());
				term.setDegree(term.getDegree()-1);
				result.addTerm(term);
			}
		}
		
		return result;
	}
	//integration
	public static Polynomial integ(Polynomial p1){
		Polynomial result = new Polynomial();
		for (Term term : p1.getTerms()){
			float coeff=term.getCoefficient();
			int degree=term.getDegree();
			degree++;
			term.setCoefficient(coeff/degree);
			term.setDegree(degree);
			result.addTerm(term);
		}	
		
		return result;
	}
}
