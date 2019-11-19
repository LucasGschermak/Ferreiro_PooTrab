public class Corda extends Ranged {

	private String matC;

	public Corda(String nome, String hands, String matC) {
		super(nome,hands);
		this.matC = matC;
	}
	public String getMatC() {
		return matC;
	}
	public void setMatC(String matC) {
		this.matC = matC;
	}
	public String toString() {
		return super.toString()+"Material da Corda: "+ this.getMatC();
	}

}
