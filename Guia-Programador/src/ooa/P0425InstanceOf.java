package ooa;

public class P0425InstanceOf {
	public static void main(String[] args) {
		Object obj =new P0410Triangulo(1.5, 1.5, 2.0);
		System.out.println(obj);
		System.out.printf("%s instancia de P0410Triangulo.\n",obj instanceof P0410Triangulo?"E'":"Nao e'");
		System.out.printf("%s instancia de P0409Retengulo.\n",obj instanceof P0409Retangulo?"E'":"Nao e'");
		System.out.printf("%s instancia de P0407Forma.\n",obj instanceof P0407Forma?"E'":"Nao e'");
		System.out.printf("%s instancia de Object.\n",obj instanceof Object?"E'":"Nao e'");
		System.out.printf("%s instancia de Runnable.\n",obj instanceof Runnable?"E'":"Nao e'");
	}
}
