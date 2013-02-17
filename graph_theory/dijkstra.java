	// Cada nodo tiene un atributo de distancia que dice cual 
	// es la menor distancia hasta ese nodo y un indice que 
	// lo ubica dentro del arreglo del heap
	public static long dijkstra(nodo[] nodos, int s, int d){
		int N = nodos.length;
		for (int i = 0; i < N; i++)
			nodos[i].dist = Long.MAX_VALUE;
		nodos[s].dist = 0L;
		MinHeap Q = new MinHeap(nodos);
		while(Q.heapSize>0){
			nodo min = Q.removeMin();
			// Busca el nodo con menor distancia 
			// (y que no ha sido visitado)
			for (arco arc: min.vec) { 
				// Entre sus vecinos actualiza 
				// la distancia en caso de ser necesario
				long alt = arc.longit + min.dist;
				nodo vecino = nodos[arc.nod.id];
				if(alt<vecino.dist)
					Q.changeKey(vecino.ind, alt);
			}
		}
		return nodos[d].dist;
	}