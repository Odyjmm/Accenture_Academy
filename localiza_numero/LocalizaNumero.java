package localiza_numero;

public class LocalizaNumero {
	public static void main(String[] args) {
		int vetor[] = {1,2,3,4,5,6,7,8,9,10};
				
		int i;
		boolean achou = false;
		for (i = 0; i < 10; i++) {
			if (vetor[i] == 8){
				achou = true;
				break;
			}
		}
		
		if (achou) {
			System.out.println("Achei");
			System.out.printf("Na Posicao %d esta localizado do numero %d.", i, vetor[i]);			
		}
	}
}