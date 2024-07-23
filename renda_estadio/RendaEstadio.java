package renda_estadio;

import java.util.Scanner;

public class RendaEstadio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Quantos Ingressos da Classe 'A' Foram Vendidos?");
	    int a = sc.nextInt();
	    
	    System.out.println("Quantos Ingressos da Classe 'B' Foram Vendidos?");
	    int b = sc.nextInt();
	    
	    System.out.println("Quantos Ingressos da Classe 'C' Foram Vendidos?");
	    int c = sc.nextInt();
	    
	    int rendaTotal = (a * 50) + (b * 30) + (c * 20);
	    System.out.println("A renda total obtida pela venda de ingressos foi: " + rendaTotal);
	    sc.close();
	}
}