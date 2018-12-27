package model.services;

public class TaxaPaypal implements ProcessamentoDeTaxa{
	
	private static final double JUROS_SIMPLES = 0.01;
	private static final double TAXA_PAG = 0.02;
	
	@Override
	public double JurosSimples(double total, int meses) {
		return total + (total*JUROS_SIMPLES) * meses;
	}

	@Override
	public double taxaPag(double total) {
		return total + (total*TAXA_PAG);
	}

}
