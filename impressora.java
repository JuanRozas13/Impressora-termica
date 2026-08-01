package impressora;
 
//Socket(biblioteca usada para estabelecer uma conexão com a rede)
import java.net.Socket;
 
//outputstream (biblioteca usada para enviar e receber dados)
import java.io.OutputStream;
 
//localDateTime (biblioteca para trabalhar com data e hora)
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
public class Impressora {
 
	public static void main(String[] args) {
		// tartamento de exceções
		try {
			// criar objetos
			Socket impressora = new Socket("10.26.49.35", 9100);
			OutputStream saida = impressora.getOutputStream();
			// "linguagem de programação pata impressoras de cupom"
			// A LINHA ABAIXO ATIVA A IMPRESSORA PARA RECEBER COMANDOS ESC/POS
			saida.write(new byte[] { 0x1B, 0x40 });
 
			// imprimir data e hora
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			//Criar uma variavel para armazenar a data e hora formatada
			String datahora = "Data: " + agora.format(formato) + "\n\n";
			//imprimirm o conteúdo da variável
			saida.write(datahora.getBytes("CP850"));
			// Aumentar a fonte
			// Atenção o último byte determina o tamanho 0x11 (2x) 0x22(3x)
			saida.write(new byte[] { 0x1D, 0x21, 0x11 });
 
			// Centralizaar o texto
			saida.write(new byte[] { 0x1B, 0x61, 0x01 });
 
			// só o titulo grande e centralizado
			saida.write("SENACBANK!\n\n".getBytes("CP850"));// CP850 = UTF-8
			// retornar ao tamanho normal
			saida.write(new byte[] { 0x1D, 0x21, 0x00 });
			// alinhar a esquerda
			saida.write(new byte[] { 0x1B, 0x61, 0x00 });
 
			// alinhar a direita
			// saida.write(new byte[] { 0x1B, 0x61, 0x02 });
 
			// negrito
			saida.write(new byte[] { 0x1B, 0x45, 0x01 });
 
			saida.write("Extrato Bancário\n".getBytes("CP850"));// CP850 = UTF-8
			// texto normal (desativar negrito)
			saida.write(new byte[] { 0x1B, 0x45, 0x00 });
 
			saida.write("Diego \n\n".getBytes("CP850"));// CP850 = UTF-8
			String extrato =
				    "================================\n" +
				    "         EXTRATO BANCARIO       \n" +
				    "================================\n" +
 
				    "Agencia : 0261\n" +
				    "Cliente : Leandro\n" +
				    "Saldo   : R$ 2.000,00\n" +
				    "Debito  : R$   150,00\n" +
				    "Saldo   : R$ 1.850,00\n" +
				    "CPF     : 231.420.448-20\n" +
				    "--------------------------------\n" +
 
				    "Agencia : 0261\n" +
				    "Cliente : Sirleine\n" +
				    "Saldo   : R$ 3.000,00\n" +
				    "Credito : R$ 1.000,00\n" +
				    "Saldo   : R$ 4.000,00\n" +
				    "CPF     : 291.480.448-10\n" +
				    "--------------------------------\n" +
 
				    "Agencia : 0261\n" +
				    "Cliente : Diego\n" +
				    "Saldo   : R$     1,00\n" +
				    "Credito : R$ 20.000,00\n" +
				    "Saldo   : R$ 20.001,00\n" +
				    "CPF     : 234.490.418-90\n" +
				    "--------------------------------\n\n" +
 
				    "        TRANSFERENCIA\n" +
				    "--------------------------------\n" +
				    "Cliente     : Diego\n" +
				    "Favorecido  : Leandro\n" +
				    "Debito      : R$ 10.000,00\n" +
				    "Credito     : R$ 10.000,00\n" +
				    "Transferido : R$ 10.000,00\n\n" +
 
				    "Cliente : Diego\n" +
				    "Saldo   : R$ 10.001,00\n\n" +
 
				    "Cliente : Leandro\n" +
				    "Saldo   : R$ 11.850,00\n" +
				    "--------------------------------\n\n" +
 
				    "       TRANSFERENCIA VIA PIX\n" +
				    "--------------------------------\n" +
				    "Cliente     : Diego\n" +
				    "Favorecido  : Sirleine\n" +
				    "Debito      : R$   500,00\n" +
				    "Credito     : R$   500,00\n" +
				    "Transferido : R$   500,00\n\n" +
 
				    "Cliente : Diego\n" +
				    "Saldo   : R$ 9.501,00\n\n" +
 
				    "Cliente : Sirleine\n" +
				    "Saldo   : R$ 4.500,00\n" +
				    "--------------------------------\n\n" +
 
				    " SALDO BANCARIO DOS CORRETISTAS\n" +
				    "--------------------------------\n" +
				    "Leandro : R$ 11.850,00\n" +
				    "Sirleine: R$  4.500,00\n" +
				    "Diego    : R$  9.501,00\n" +
				    "================================\n\n";
 
				saida.write(extrato.getBytes("CP850"));
			// Avançar o papel
			// Atenção o último byte determina o número de linhas
			// 0x01 (1 linha) 0x05 (5 linhas) 0x06 (6 linhas)
			saida.write(new byte[] { 0x1B, 0x64, 0x05 });
			// Corte
			saida.write(new byte[] { 0x1D, 0x56, 0x00 });
			// IMPRIMIR
			saida.flush();
			// ENCERRAR A CONEXÃO
			impressora.close();
		} catch (Exception e) {
			System.out.println(e);
		}
 
	}
 
}
