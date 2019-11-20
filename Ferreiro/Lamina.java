public class Lamina extends Melee {

	private String tamanhoL;

	private String matL;

	private String tipoL;

	public Lamina(String nome, String hands, String tamL, String matL, String tipoL) {
		super(nome, hands);
		this.tamanhoL = tamL;
		this.matL = matL;
		this.tipoL = tipoL;
	}
	public String getMatL() {
		return matL;
	}

	public void setMatL(String matL) {
		this.matL = matL;
	}

	public String getTipoL() {
		return tipoL;
	}

	public void setTipoL(String tipoL) {
		this.tipoL = tipoL;
	}

	public String getTamL() {
		return tamanhoL;
	}

	public void setTamL(String tamL) {
		this.tamanhoL = tamL;
	}

	public String toString() {
		return super.toString() + "Material da lamina: "+ this.getMatL()
								+ "Tamanho da lamina: "+ this.getTamL()
								+ "Tipo da lamina: "+ this.getTipoL();
	}

}
