package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date chegada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date chegada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.chegada = chegada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getChegada() {
		return chegada;
	}


	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long calc = saida.getTime() - chegada.getTime();
		return TimeUnit.DAYS.convert(calc, TimeUnit.MILLISECONDS);
	}
	
	
	public String dataAtualizada(Date chegada, Date saida) {
		Date agora = new Date();
		if(chegada.before(agora) || saida.before(agora)) {
			return "Erro na reserva! as datas de reservas devem ser Datas Futuras";
		} 
		if(!saida.after(chegada)) {
			return "Erro na reserva, por favor rever as DATAS!";
		}
		this.chegada = chegada;
		this.saida = saida;
		return null;
	}
	
	@Override
	public String toString() {
		return " Quarto: "
		+ numeroQuarto
		+ ", Chegada: "
		+ sdf.format(chegada)
		+ ", Saida: "
		+ sdf.format(saida)
		+ ", "
		+ duracao()
		+ " Noites";
	}
}




