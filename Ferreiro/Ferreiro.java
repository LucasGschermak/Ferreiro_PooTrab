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
	public Lamina leLamina() {
		String [] valores = new String [5];
		String [] nomeVal = {"Nome","Arma One Handed(1) ou Two Handed(2):",
				"Tamanho do(a) "+valores[0],"Material do(a) "+valores[0],
				"Tipo da Lamina"};
		valores = leValores(nomeVal);

		Lamina laminaArma = new Lamina(valores[0],valores[1],
								valores[2],valores[3],valores[4]);
		return laminaArma;
		
	}
	public Empunhadura leEmpunhadura() {
		String [] valores = new String [1];
		String [] nomeVal = {"Material da empunhadura"};
		valores = leValores(nomeVal);

		Empunhadura empArma = new Empunhadura(valores[0]);
		return empArma;
	}
	public Estilo leEstilo() {
		String [] valores = new String [4];
		String [] nomeVal = {"Nome","Arma One Handed(1) ou Two Handed(2):",
				"Material do(a) "+ valores[0],"Tamanho do(a) "+ valores[0]};
		valores = leValores(nomeVal);

		Estilo estArma = new Estilo(valores[0],valores[1],valores[2],valores[3]);
		return estArma;
	}
	public Corda leCorda() {
		String [] valores = new String [1];
		String [] nomeVal = {"Material da corda"};
		valores = leValores(nomeVal);

		Corda cordaArma = new Corda(valores[0]);
		return cordaArma;
	}
	public Projetil leProjetil() {
		String [] valores = new String [1];
		String [] nomeVal = {"Projetil"};
		valores = leValores(nomeVal);

		Projetil projArma = new Projetil(valores[0]);
		return projArma;
	}

	public void menuLoja() {
		ArrayList<Armas> arma = new ArrayList<Armas>();

		String menu = "";
		String entrada;
		int opcEscolhida = 0;
		int opc1, opc2;

		do {
			menu = "Ferraria\n" +
					"Opções:\n" + 
					"1. Entrar com a Arma\n" +
					"2. Exibir Arma\n" +
					"3. Destruir Arma\n" +
					"4. Salvar Arma\n" +
					"5. Recuperar Arma\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");

			while (!menuNumValido(entrada)) {
				entrada = JOptionPane.showInputDialog(null, menu + 
						"\n\nEntrada inválida! Digite um número inteiro.");
			}
			opc1 = new Integer(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Produto\n" +
						"Opções:\n" + 
						"1. Melee\n" +
						"2. Ranged\n";
						

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				while (!menuNumValido(entrada)) {
					entrada = JOptionPane.showInputDialog(null, menu + 
							"\n\nEntrada inválida! Digite um número inteiro.");
				}
				opc2 = new Integer(entrada);

				switch (opc2){
				case 1: opcEscolhida = 1;
				break;
				case 2: opcEscolhida = 2;
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Arma para entrada NÃO escolhida!");
				break;
				}
				if (opcEscolhida == 1) {
					arma.add((Armas)leLamina());
					arma.add((Armas)leEmpunhadura());
				}else if(opcEscolhida == 2) {
					arma.add((Armas)leEstilo());
					arma.add((Armas)leCorda());
					arma.add((Armas)leProjetil());
				}
			

			case 2: // Exibir dados
				if (arma.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com a Arma primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < arma.size(); i++)	{
					dados += arma.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (arma.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com a Arma primeiramente");
					break;
				}
				arma.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (arma.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com a Arma primeiramente");
					break;
				}
				salvaArmas(arma);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				arma = recuperarArmas();
				if (arma.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Ferreiro");
				break;
			}
		} while (opc1 != 9);
	}

	public void mostrarArmas(String dados) {
		JOptionPane.showMessageDialog(null,"Armas\n--------\n" + dados);
	}

	public void salvaArmas(ArrayList<Armas> arma) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\arma.wpn"));
			for(int a=0; a < arma.size();a++) {
				outputStream.writeObject(arma.get(a));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	@SuppressWarnings("finally")
	public ArrayList<Armas> recuperarArmas() {
		ArrayList<Armas> arma = new ArrayList<Armas>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream (new FileInputStream("c:\\temp\\arma.wpn"));
			Object obj = null;
			while((obj = inputStream.readObject()) != null) {
				if(obj instanceof Armas) {
					arma.add((Armas)obj);
				}
			}
		} catch (EOFException ex) {
			System.out.println("End of file reached - Cabou...");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return arma;
		}
	}



	public boolean menuNumValido(String x) {
		 boolean resultado;
	        try {
	            Integer.parseInt(x);
	            resultado = true;
	        } catch (NumberFormatException e) {
	            resultado = false;
	        }
	        return resultado;
	}

	public static void main(String[] args) {
		Ferreiro f = new Ferreiro();
		f.menuLoja();
	}

}
