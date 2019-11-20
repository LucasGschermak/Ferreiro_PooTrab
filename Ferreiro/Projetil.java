public class Projetil extends Ranged {

	private String tipoProj;
	
	public Projetil( String tipoProj) {
		this.tipoProj = tipoProj;
	}
	public Projetil(String nome, String hands) {
		super(nome, hands);
	}
	public String getTipoProj() {
		return tipoProj;
	}

	public void setTipoProj(String tipoProj) {
		this.tipoProj = tipoProj;
	}

	public String toString() {
		return "Tipo de projetil: "+ this.getTipoProj()+"\n";
		}

}
