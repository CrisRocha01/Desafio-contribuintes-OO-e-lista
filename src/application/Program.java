package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		List<TaxPayer>list = new ArrayList<>();
		
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.printf("Digite os dados do %do contibuinte:%n", i + 1);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double CapitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: : ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: : ");
			double educationSpending = sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, CapitalIncome, healthSpending, educationSpending);
			list.add(taxPayer);
			System.out.println();
		}
		
		for(TaxPayer payer : list) {
			int counter = 1;
			System.out.printf("Resumo do %do contribuinte:%n", counter);
			System.out.printf("Imposto bruto total: %.2f%n", payer.grossTax() );
			System.out.printf("Abatimento: %.2f%n", payer.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", payer.netTax());
			counter++;
			System.out.println();
		}
		
		sc.close();

	}

}
