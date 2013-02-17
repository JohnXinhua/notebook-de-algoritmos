public class Heap<T extends Comparable<T>> {

	public T[] A;
	
	private int heapSize;
	
	// Constructor
	public Heap(T[] X) {
		A = X;
		heapSize = A.length;
		for (int i = (int)Math.floor(heapSize/2); i >=0; i--)
			maxHeapify(i);
	}

	//Indice del padre de i
	public int parent(int i){
		return (int)Math.floor(i/2);
	}
	
	//Indice del hijo izquierdo de i
	public int left(int i){
		return 2*i;
	}
	
	//Indice del hijo derecho de i
	private int right(int i){
		return 2*i+1;
	}
	
	private void maxHeapify(int i){
		int l = left(i);
		int r = right(i);
		int largest = l< heapSize && A[l].compareTo(A[i])>0 ? l : i;
		if( r< heapSize && A[r].compareTo(A[largest])>0)
			largest = r;
		if( largest!=i ){
			T temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(largest);
		}
	}
	
	//Devuelve el maximo elemento del Heap y lo quita
	public T removeMax(){
		T temp = A[0];
		A[0] = A[heapSize-1];
		heapSize--;
		maxHeapify(0);
		return temp;
		
	}
	
	//Ordena A de menor a mayor	
	public void heapsort(){
		for (int i = heapSize-1; i >=0; i--) {
			T temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize--;
			maxHeapify(0);
		}
	}
	
}
