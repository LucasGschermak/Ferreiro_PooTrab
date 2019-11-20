public class Estilo extends Ranged {

	private String matE;

	private String tamanhoE;

	public Estilo(String nome, String hands, String tamE, String matE) {
		super(nome,hands);
		this.matE = matE;
		this.tamanhoE = tamE;
	}
	public String getMatE() {
		return matE;
	}
	public void setMatE(String matE) {
		this.matE = matE;
	}
	public String getTamanhoE() {
		return tamanhoE;
	}
	public void setTamanhoE(String tamE) {
		this.tamanhoE = tamE;
	}
	public String toString() {
		return super.toString() + "Material do "+this.getNome()+": "+ this.getMatE()
								+ "Tamanho do "+this.getNome()+": "+ this.getTamanhoE();
	}

}
