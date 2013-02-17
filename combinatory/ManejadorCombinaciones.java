public class ManejadorCombinaciones{

	//Donde se guardan las combinaciones/ Triangulo de Pascal		
	private long [][] comb;

	//Constructor
	public ManejadorCombinaciones(int N) {
		comb = new long[N + 1][];
		comb[0] = new long[1];
		comb[0][0] = 1L;
		comb[1] = new long[2];
		comb[1][0] = 1L;
		comb[1][1] = 1L;
		for (int i = 2; i <= N ; i++) {
			comb[i] = new long[i/2 + 1];
			comb[i][0] = 1L;
			for (int j = 1; j < i/2; j++) 
				comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
			comb[i][i/2] = i%2==0 ? 2*comb[i-1][i/2-1]: comb[i-1][i/2]+comb[i-1][i/2-1]; 
		}
	}
	
	//Retorna n combinado k	
	public long darCombinacion(int n, int k) {
		if (k > n / 2)
			return comb[n][n - k];
		return comb[n][k];
	}
}