package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private Integer num;
	private Date data;
	private Double valorTotal;
	
	List<Parcelas> parc = new ArrayList<>();
	
	public Contrato(Integer num, Date data, Double valorTotal) {
		this.num = num;
		this.data = data;
		this.valorTotal = valorTotal;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getData() {
		return data;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Parcelas> getParc() {
		return parc;
	}
	
	public void addParcelas(Parcelas parcela) {
		parc.add(parcela);
	}
	
	public void remParcelas(Parcelas parcela) {
		parc.remove(parcela);
	}
	
}
