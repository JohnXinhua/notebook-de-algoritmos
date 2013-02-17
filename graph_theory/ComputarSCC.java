import java.util.ArrayList;
import java.util.Stack;

import p4.Grafo;
import p4.Nodo;

public class ComputarSCC {

	public Grafo G;
	
	public Nodo s; //Nodo de origen
	
	public int t; //Tiempo actual
	
	public boolean[] explorados;
	
	public Nodo[] ordenamiento; //Ordenamiento de los nodos
	
	public ArrayList<Integer> tamaniosSCCs; //Tamanio de cada una de las SCC
	
	public int SCC; //Tamanio de la SCC explorada en el momento

	public ComputarSCC(Grafo g) {
		super();
		G = g;
		t = 0;
	}
	
	
	public void SCC(){
		explorados = new boolean[ G.nodos.length ];
		ordenamiento = new Nodo[ G.nodos.length ];
		
		DFS_loop_inv();
		
		explorados = new boolean[ G.nodos.length ];
		tamaniosSCCs = new ArrayList<Integer>();
		
		DFS_loop();	
	}
	
	public void DFS_loop_inv(){
		for(Nodo n:G.nodos)
			if(!explorados[n.id])
				DFS_inv(n);
	}
	
	public void DFS_inv(Nodo i){
		Stack<Nodo> stack = new Stack<Nodo>();
		Stack<Nodo> stack2 = new Stack<Nodo>();
		stack.push(i);
		while(stack.size()>0){
			Nodo j = stack.pop();
			if(!explorados[j.id]){
				stack2.push(j);
				explorados[j.id] = true;
				for(Nodo k:j.vecinosInversos)
					if(!explorados[k.id])
						stack.push(k);
			}
			
		}
		while(!stack2.isEmpty()){
				ordenamiento[t] = stack2.pop();
				t++;
		}
	}	
	
	public void DFS_loop(){
		for (int i = ordenamiento.length-1; i >= 0; i--) {
			Nodo n = ordenamiento[i];
			if(!explorados[n.id])
				DFS(n);
			if(SCC!=0){
				tamaniosSCCs.add( SCC );
				SCC=0;
			}
		}
		if(SCC!=0)
			tamaniosSCCs.add( SCC );
	}
	
	public void DFS(Nodo i){
		Stack<Nodo> stack = new Stack<Nodo>();
		stack.push(i);
		while(stack.size()>0){
			Nodo j = stack.pop();
			if(!explorados[j.id]){
				SCC++;
				explorados[j.id] = true;
				for(Nodo k:j.vecinos)
					if(!explorados[k.id])
						stack.push(k);
			}		
		}
	}

}
