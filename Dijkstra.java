public class Dijkstra{ 

	private Digrafo digrafo;
	private int verticeOrigem, numVertices;
	private MinHeap filaPrioridade;
	static final int INFINITO = Integer.MAX_VALUE;
  private int[] pai, custo;

	public Dijkstra(Digrafo digrafo, int verticeOrigem){

		this.digrafo = digrafo;
		this.verticeOrigem = verticeOrigem;
		this.numVertices = digrafo.getNumVertices();
		this.custo = new int[numVertices];
		this.filaPrioridade = new MinHeap(numVertices, custo);
		this.pai = new int[numVertices];		

	}


	public void caminhosMinimos(){
	
		//Encontra o caminho mais curto, usar uma estrutura heap	 
		int verticeAtual;
		Link arco;

		//Inicialização		
		for (int i = 0; i < numVertices; i++){
		  custo[i] = INFINITO;	
			pai[i] = -1;
		}  
		 

		//	Ajuste do Vertice Origem    
		custo[verticeOrigem] = 0;
		pai[verticeOrigem] = verticeOrigem;
		filaPrioridade.inserir(verticeOrigem);

		// Percorre todos os Vertices que estao na Fila de Prioridade
		while(!filaPrioridade.estaVazia()){

			verticeAtual = filaPrioridade.delMin();
			arco = digrafo.getArco(verticeAtual);

			while(arco != null)	{
				relaxa(verticeAtual, arco.posVerticeDestino, arco.custo);
				arco = arco.proximo;
			}
			
		}

	}


	private void relaxa(int verticeAtual, int verticeDestino, int custoArco){

		if (custo[verticeDestino] == INFINITO){				

			custo[verticeDestino] = custo[verticeAtual] + custoArco;
			pai[verticeDestino] = verticeAtual;
			filaPrioridade.inserir(verticeDestino);

		}
		else{

			if (custo[verticeDestino] > (custo[verticeAtual] + custoArco)){

				custo[verticeDestino] = custo[verticeAtual] + custoArco;
				pai[verticeDestino] = verticeAtual;
				filaPrioridade.alterarPrioridade(verticeDestino);

			}

		}

	}



	private void imprimeResultados(){

		System.out.println("\n\n------- RESULTADOS DIJKSTRA -------");

		System.out.println("\n------- CUSTOS ------------------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Custo[" + i + "] = " + custo[i]);
		}
		
		System.out.println("\n------- PAIS ------------------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Pai[" + i + "] = " + pai[i]);
		}
		
	}


	public int[] getCustos(){
		return custo;
	}

}