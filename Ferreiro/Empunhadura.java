public class Empunhadura extends Melee {

	private String matEmp;

	public Empunhadura(String nome, String hands) {
		super(nome,hands);
		}
	public Empunhadura(String matEmp) {
		this.matEmp = matEmp;
	}
	public String getMatEmp() {
		return matEmp;
	}
	public void setMatEmp(String matEmp) {
		this.matEmp = matEmp;
	}
	public String toString() {
		return super.toString()+"Material da Empunhadura: "+ this.getMatEmp();
	}

}
