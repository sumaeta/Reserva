package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Número do Quarto: ");
		int n = sc.nextInt();
		System.out.print("Data de chegada(dd/MM/yyyy): ");
		Date chegada = sdf.parse(sc.next());
		System.out.println("Data de saída(dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		
	
		if(!saida.after(chegada)) {
			System.out.println("Erro na reserva, por favor rever as DATAS!");
		}
		else {
			Reserva reserva = new Reserva(n, chegada, saida);
			System.out.println("Reserva " + reserva);
			System.out.println("");
			System.out.println("Entre com os dados para atualizar as reservas: ");
			System.out.print("Número do Quarto: ");
			n = sc.nextInt();
			System.out.print("Data de chegada(dd/MM/yyyy): ");
			chegada = sdf.parse(sc.next());
			System.out.println("Data de saída(dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			String erro = reserva.dataAtualizada(chegada, saida);
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			System.out.println("Reserva " + reserva);
		}
		
		
		
		sc.close();
	}

}}
