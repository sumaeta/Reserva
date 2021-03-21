package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			//entrar com valores corretos
			System.out.print("Número do Quarto: ");
			int n = sc.nextInt();
			System.out.print("Data de chegada(dd/MM/yyyy): ");
			Date chegada = sdf.parse(sc.next());
			System.out.println("Data de saída(dd/MM/yyyy): ");
			Date saida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(n, chegada, saida);
			System.out.println("Reserva " + reserva);
			//entrar com valores errados
			System.out.println();
			System.out.println("Entre com os dados para atualizar as reservas: ");
			System.out.print("Data de chegada(dd/MM/yyyy): ");
			chegada = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
		
			reserva.dataAtualizada(chegada, saida);	
			System.out.print("Reserva " + reserva); 
		}
		catch (ParseException e) {
			System.out.println("Data Inválida!");
		}
		catch (DomainException e) {
			System.out.println("Erro! " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
		
	}
}

