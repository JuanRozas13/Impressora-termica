  package Contas;

public class PessoaFisica {

	public static void main(String[] args) {
		//objeto 1
		Conta cc1 = new Conta();
		cc1.setCliente( "Leandro");
		cc1.setCpf("231.420.448-20");
		cc1.setSaldo(2000);
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		cc1.sacar(150);
		cc1.exibirSaldo();
		System.out.println("CPF: "+ cc1.getCpf());
		System.out.println("--------------------------------");
		
		//objeto2
		Conta cc2 = new Conta();
		cc2.setCliente("Sirleine");
		cc2.setCpf("291.480.448-10");
		cc2.setSaldo(3000);
		System.out.println("Cliente: " + cc2.getCliente());
		cc2.exibirSaldo();
		cc2.depositar(1000);
		cc2.exibirSaldo();
		System.out.println("CPF: "+ cc2.getCpf());
		System.out.println("--------------------------------");
		
		//objeto3
		Conta cc3 = new Conta();
		cc3.setCliente("Juan");
		cc3.setCpf("234.490.418-90");
		cc3.setSaldo(1);
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
		cc3.depositar(20000);
		cc3.exibirSaldo();
		System.out.println("CPF: "+ cc3.getCpf());
		System.out.println("--------------------------------");
		System.out.println("");
		
		//Transferencia Juan > Leandro
		System.out.println("TRANSFERÊNCIA");
		System.out.println("Cliente: " + cc3.getCliente());
		System.out.println("Favorecido: " + cc1.getCliente());
		cc3.transferir(cc1, 10000);
		System.out.println("");
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
		System.out.println("");
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		System.out.println("--------------------------------");
		System.out.println("");
		
//		Transferencia Leandro > Sirlene
//		System.out.println("Transferência");
//		System.out.println("Cliente: " + cc1.getCliente());
//		System.out.println("Favorecido: " + cc2.getCliente());
//		cc1.transferir(cc2, 1999);
//		System.out.println("");
//		System.out.println("Cliente: " + cc1.getCliente());
//		cc1.exibirSaldo();
//		System.out.println("");
//		System.out.println("Cliente: " + cc2.getCliente());
//		cc2.exibirSaldo();
		
		
		
		//TRANSFERENCIA VIA PIX
		System.out.println("TRANSFRÊNCIA VIA PIX");
		System.out.println("Cliente: " + cc3.getCliente());
		System.out.println("Favorecido: " + cc2.getCliente());
		cc3.transferir(cc2, 500);
		System.out.println("");
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
		System.out.println("");
		System.out.println("Cliente: " + cc2.getCliente());
		cc2.exibirSaldo();
		System.out.println("--------------------------------");
		System.out.println("");
		
		
		//EXIBIR ESTRATO BANCARIO DOS CORRETISTA
		System.out.println("SALDO BANCARIO DOS CORRETISTA");
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		System.out.println("Cliente: " + cc2.getCliente());
		cc2.exibirSaldo();
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
	}
	
	

}
