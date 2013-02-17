/**
 * Realiza la descomposicion LUP de una matriz cuadrada
 */
public class LUPdescomposition {

	// n es la dimension de la matriz	
	private int n;
	
	// A es la matriz que contiene a L y a U de la matriz que inicializa la clase
	// A[i][j] = L[i][j] si i>j
	// A[i][j] = U[i][j] si i<=j
	private double[][] A;

	// perm es el arreglo que representa la matriz de permutacion P
	// perm[i] indica que P[i][ perm[i] ]=1 y P[i][j]=0 para j!=perm[i]
	private short [] perm;
	
	// Inicializa los atributos de forma que quede listo para resolver sistemas de ecuaciones
	// Arroja excepcion si la matriz es singular
	public LUPdescomposition(double[][] matriz) throws Exception {
		n = matriz.length;
		perm = new short[n];

		A = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = matriz[i][j];

		for (short i = 0; i < perm.length; i++)
			perm[i] = i;

		for (int k = 0; k < n; k++) {
			double p = 0.0;
			int kp = -1;
			for (int i = k; i < n; i++)
				if (Math.abs(A[i][k]) > p) {
					p = Math.abs(A[i][k]);
					kp = i;
				}
			if (p == 0.0)
				throw new Exception("La matriz es singular");
			short temp = perm[k];
			perm[k] = perm[kp];
			perm[kp] = temp;
			
			for (int i = 0; i < n; i++) {
				double tem = A[k][i];
				A[k][i] = A[kp][i];
				A[kp][i] = tem;
			}
			
			for (int i = k + 1; i < n; i++) {
				A[i][k] /= A[k][k];
				for (int j = k + 1; j < n; j++)
					A[i][j] -= A[i][k] * A[k][j];
			}
		}
	}
	
	// Dado un vector de dimension n devuelve el vector solucion del sistema de ecuaciones
	public double[] LUPsolve(double [] b)
	{
		double [] x = new double[n];
		double [] y = new double[n];
		for (int i = 0; i < n; i++) {
			double sum = 0.0;
			for (int j = 0; j <= i-1; j++)
				sum+=A[i][j]*y[j];
			y[i]= b[perm[i]] - sum; 
		}
		for (int i = n-1; i >=0; i--) {
			double sum = 0.0;
			for (int j = i+1; j < n; j++)
				sum+=A[i][j]*x[j];
			x[i]=(y[i]-sum)/A[i][i];
		}
		return x;
	}
}
