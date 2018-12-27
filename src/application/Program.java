/*	Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
*	um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
*	número de meses desejado.
*	A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
*	Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
*	por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
*	juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
*	Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
*	e valor total do contrato). Em seguida, o programa deve ler o número de meses para
*	parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
*	sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
*	meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.
*
*/

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcelas;
import model.services.ServicoParcelamento;
import model.services.TaxaPaypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a data do contrato");
		System.out.print("Número: ");
		int num = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		Contrato cont = new Contrato(num, data, valorTotal);
		ServicoParcelamento sp = new ServicoParcelamento(new TaxaPaypal());
		System.out.print("Número de parcelas: ");
		int parc = sc.nextInt();
		sp.processarContrato(cont, parc);
		System.out.println("Parcelas:");
		for (Parcelas p : cont.getParc()) {
			System.out.println(p);
		}

		sc.close();

	}

}
