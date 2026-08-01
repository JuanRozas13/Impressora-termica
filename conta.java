package Contas;
import java.util.Random;
public class Conta {
	
	//atributos
	//POO - ENCAPSULAMENTO
	//no encapsulamento modificamos as variaveis para "private" e criamos métodos para leitura e gravação (get / set)
	
	//encapsulamento >>>>>>>>>>>>>>>>>>>>>>>>
	private double saldo;
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo; 
	}
	//fim do encapsulamento
	
	//encapsulamento >>>>>>>>>>>>>>>>>>>>>>>>
	private String cliente;
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	//encapsulamento >>>>>>>>>>>>>>>>>>>>>>>>
	private String cpf;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	//construtor
	public Conta() {
//		Random random = new Random();
		//StringBuilder sb
		System.out.println("Agência 0261");
	}
	
	//métodos
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}
	
	
	//o método abaixo cria um parâmetro para modificar o valor da variavel 
	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: " + valor);
	}
	
	//
	void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: " + valor);
	}
	
	//o método abaixo cira um objeto além do parâmetro para definir a conta de destino
	void transferir(Conta destino, double valor) {
		// alinha abaixo faz referência a conta a ser debitada
		//o termo (this) faz referência ao próprio objeto
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferência: R$ " + valor);
	}
		
		
		//o método abaixo cria um objeto para realizar o pix
		void pix(Conta destino, double valor) {
		// alinha abaixo faz referência a conta a ser debitada
		//o termo (this) faz referência ao próprio objeto
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Pix: R$ " + valor);
	}
}
