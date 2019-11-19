public class Empunhadura extends Melee {

	private String tipoEmp;

	private String matEmp;

	public Empunhadura(String nome, String hands, String tipoEmp, String matEmp) {
		super(nome,hands);
		this.matEmp = matEmp;
		this.tipoEmp = tipoEmp;
	}
	public String getTipoEmp() {
		return tipoEmp;
	}
	public void setTipoEmp(String tipoEmp) {
		this.tipoEmp = tipoEmp;
	}
	public String getMatEmp() {
		return matEmp;
	}
	public void setMatEmp(String matEmp) {
		this.matEmp = matEmp;
	}
	public String toString() {
		return super.toString()+"Material da Empunhadura: "+ this.getMatEmp()
							   +"Tipo de Empunhadura: "+ this.getTipoEmp();
	}

}
