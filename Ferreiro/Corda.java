public class Corda extends Ranged {

	private String matC;
	
	public Corda(String nome, String hands) {
		super(nome,hands);
	}
	public Corda(String matC) {
		this.matC = matC;
	}
	public String getMatC() {
		return matC;
	}
	public void setMatC(String matC) {
		this.matC = matC;
	}
	public String toString() {
		return "Material da Corda: "+ this.getMatC();
	}

}
