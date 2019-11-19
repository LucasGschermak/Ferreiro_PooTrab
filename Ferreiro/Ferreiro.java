import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Ferreiro {

	private ArrayList<Armas> arma;
	public String[] leValores(String[] dadosIn) {
		String [] dadosOut = new String[dadosIn.length];
		for(int i = 0;i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i]+":");
		
		return dadosOut;
	}

	public Melee leMelee() {
		return null;
	}

	public Ranged leRanged() {
		return null;
	}

	public void menuLoja() {
		ArrayList<Armas> arma = new ArrayList<Armas>();
	}

	public void mostrarArmas(String dados) {

	}

	public void salvaArmas(ArrayList<Armas> arma) {

	}

	public ArrayList<Armas> recuperarArmas() {
		ArrayList<Armas> arma = new ArrayList<Armas>();
		
	}

	public boolean menuNum(String x) {
		
		
	}

	public static void main(String[] args) {

	}

}
