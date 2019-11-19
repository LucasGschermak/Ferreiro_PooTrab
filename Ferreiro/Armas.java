import java.io.Serializable;

public class Armas implements Serializable {

	private String nome;
	private String hands;
	private String grupoArma;

	public Armas(String nome, String hands, String gArma) {
		this.nome=nome;
		this.hands=hands;
		this.grupoArma=gArma;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setHands(String hands) {
		this.hands = hands;
	}
	public String getHands() {
		return hands;
	}
	public String getGrupoArma() {
		return grupoArma;
	}
	public void setGrupoArma(String gArma) {
		this.grupoArma = gArma;
	}
	public String toString() {
		String geral;
		
		geral =   "**********************************" + 
			      "Categoria: " + this.getGrupoArma() +  
				  "**********************************\n" +
				  "Nome: " + this.getNome() +  "\n" +
				  "Arma One Handed(1) ou Two Handed(2): " + this.getHands() + "Mão(s)\n";
		
		return geral;
	}

}
