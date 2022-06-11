package ooa;

import java.util.Scanner;

public class P0405UsaConversor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite temperatura Celsius: ");
		double tempC = sc.nextDouble();
		sc.close();
		//cria conversor celsius p/ Kelvin e exibe info
		P0403CelsiusKelvin ck = new P0403CelsiusKelvin();
		System.out.println("ck : "+ ck);
		double tempK = ck.converter(tempC);
		System.out.println("tempK = "+ tempK+"°k");
		//cria conversor Kelvin p/ celsius e exibe info
		P0404KelvinCelsius kc = new P0404KelvinCelsius();
		System.out.println("kc : "+kc);
		tempC=kc.converter(tempK);
		System.out.println("TempC = "+tempC+"°C");
	}
}
