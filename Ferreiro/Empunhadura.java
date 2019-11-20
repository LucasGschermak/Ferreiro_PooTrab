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
		return "Material da Empunhadura: "+ this.getMatEmp()+"\n";
	}

}
