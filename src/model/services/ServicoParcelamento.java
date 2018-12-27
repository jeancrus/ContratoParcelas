package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcelas;

public class ServicoParcelamento {
	private ProcessamentoDeTaxa processamentoDeTaxa;
	public ServicoParcelamento(ProcessamentoDeTaxa processamentoDeTaxa) {
		this.processamentoDeTaxa = processamentoDeTaxa;
	}
	
	public void processarContrato (Contrato cont, int parcela) {
		double cotaBasica = cont.getValorTotal() / parcela;
		for (int i = 1; i <= parcela; i++) {
			Date data = addMes(cont.getData() , i);
			double cotaCJ = processamentoDeTaxa.JurosSimples(cotaBasica, i);
			double cotaCT = processamentoDeTaxa.taxaPag(cotaCJ);
			cont.addParcelas(new Parcelas(data, cotaCT));
		}
	}
	
	public Date addMes(Date data, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, i );
		return cal.getTime();
	}
}
