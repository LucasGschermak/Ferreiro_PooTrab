import javax.swing.JOptionPane;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	public void salvaArmas() {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\arma.wpn"));
			for(Armas a :arma) {
				outputStream.writeObject(arma);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(outputStream != null) {
					outputStream.close();
					outputStream.flush();
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	public void recuperarArmas() {
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream (new FileInputStream("c:\\temp\\arma.wpn"));
			Object obj = null;
			while((obj = inputStream.readObject()) != null) {
				if(obj instanceof Melee) 
					this.arma.add((Melee)obj);
				else if (obj instanceof Ranged)
					this.arma.add((Ranged)obj);
			}
		} catch (EOFException ex) {
			System.out.println("End of file reached - Cabou...");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(inputStream != null) {
					inputStream.close();
					System.out.println("Arma Recuperada com sucesso;\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
		
	

	public boolean menuNum(String x) {
		

	}

	public static void main(String[] args) {

	}

}
