package seguros;
import Contas.Conta;
public class SeguroPessoaFisica extends Conta {

	public static void main(String[] args) {
		
			SeguroPessoaFisica cc3 = new SeguroPessoaFisica();
			cc3.setCliente("Junior da silva");
			cc3.setSaldo(7000);
			System.out.println("Cliente:" + cc3.getCliente());
			cc3.exibirSaldo();
		}



}
