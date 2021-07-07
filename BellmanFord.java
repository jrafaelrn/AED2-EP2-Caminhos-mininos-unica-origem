public class BellmanFord { 

	public BellmanFord(){
	}

	// Pesos podem ser negativos
	public boolean Bellman_Ford(Digrafo digrafo, Lista<Integer> pesos){

		int totalVertices = digrafo.getVertices().getQuantidadeItensLista();

		for(int i = 0; i < totalVertices; i++){



		}


		return true;

	/*

	Peseudocódigo Cormen

	Bellman_Ford(G,pesos,inicial)
		para todo vertice ∈ V
			λ[vertice] ← ∞
			π[vertice] ← nulo

		λ[inicial] ← 0

		para i de 1 até |V| -1
			para toda aresta = (u,v) ∈ A
				se λ[v] > λ[u] + pesos(u,v) # relaxamento
				λ[v] ← λ[u] + pesos(u,v)
				π[v] ← u
	*/
	}


	public boolean Bellman_Ford_DAGs(){
		return true;
	}

}