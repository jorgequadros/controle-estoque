package ooa;

public class P0401Conversor {
	protected double kProp, kLin;

	public P0401Conversor(double kProp, double kLin) {
		this.kProp = kProp;
		this.kLin = kLin;
	}

	public double getkProp() {
		return kProp;
	}

	public void setkProp(double kProp) {
		this.kProp = kProp;
	}

	public double getkLin() {
		return kLin;
	}

	public void setkLin(double kLin) {
		this.kLin = kLin;
	}
	
	public double converter(double valor) {
		return valor*kProp + kLin;
	}
	
	public String toString() {
		return "P041Conversor [kProp: "+kProp+", kLin: "+kLin+"]";
	}
	
}
