package ooa;

public class P0409Retangulo extends P0407Forma{

	public P0409Retangulo(double altura, double largura) {
		super(2);
		setMedida(0, altura);
		setMedida(1, largura);
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getMedida(0)*getMedida(1);
	}
	
	public double perimetro() {
		return 2*(getMedida(0)+getMedida(1));
	}
	
}
