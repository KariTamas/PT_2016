import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Polynomial {

	private List<Term> terms;
	
	

	public Polynomial() {
		terms = new ArrayList<Term>();
	}

	public Polynomial(Polynomial p) {
		terms = new ArrayList<Term>();
		for (Term t : p.getTerms()) {
			this.terms.add(new Term(t.getCoefficient(), t.getDegree()));
		}
	}
	public Term getFirst(){
		if (!terms.isEmpty())
			return terms.get(0);
		return new Term(-Integer.MAX_VALUE, -Integer.MAX_VALUE);
	}


	public void addTerm(Term t) {
		boolean termExists = false;
		for (Term currentTerm : terms) {
			if (currentTerm.getDegree() == t.getDegree()) {
				float coeff = currentTerm.getCoefficient();
				if (coeff + t.getCoefficient() != 0) {
					currentTerm.setCoefficient(coeff + t.getCoefficient());
				}
				else{
					terms.remove(currentTerm);					
				}
				termExists = true;
				break;
			}
		}
		if (!termExists) {
			terms.add(new Term(t));
		}
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}
	
	// read polynomials
	public Polynomial(String s){
		terms = new ArrayList<Term>();
		String[] s2 = s.split("\\+");
			for (int i=0; i<s2.length; i++){
				if (s2[i].contains("-")) {
					int coeff = 1;
					if (s2[i].charAt(0) == '-') 
						coeff = -1;
					String[] s3 = s2[i].split("-");
					terms.add(new Term(s3[0],coeff));
					for (int j=1; j<s3.length; j++)
						terms.add(new Term(s3[j],-1));
				}
				else terms.add(new Term(s2[i],1));
			}
			
	}
	
	//create a string from polynomial, so that we can print it
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Term t : terms) {
			if (t.getCoefficient() > 0) {
				sb.append("+");
			}/* else if (t.getCoefficient()<0){
				sb.append("-");
			}*/
			//if (t.getCoefficient()!=0){
				sb.append(t.getCoefficient());
				sb.append("x^");
				sb.append(t.getDegree());
			//}
		}
		return sb.toString();
	}
	public void sort(){
		Collections.sort(terms, new TermComparator());
	}
	
	//check if obj is Polynomial or not
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		
		if(!(obj instanceof Polynomial)){
			return false;
		}
		
		Polynomial that = (Polynomial)obj;
		
		return that.terms.equals(this.terms);
	}
}
	

