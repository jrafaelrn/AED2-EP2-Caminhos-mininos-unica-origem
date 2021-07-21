  public class Dijkstra{ 

	private Digrafo digrafo;
	private Vertice verticeOrigem, raiz;
	private MinHeap filaPrioridade;
	static final int INFINITO = Integer.MAX_VALUE;



	public Dijkstra(Digrafo digrafo, Vertice verticeOrigem){

		this.digrafo = digrafo;
		this.verticeOrigem = verticeOrigem;
		this.filaPrioridade = new MinHeap(digrafo.getNumVertices());

		//	Instancia o objeto e já executa o algoritmo de Dijkstra
		dijkstra();
	}




	private void dijkstra(){

		//System.out.println("\n\t........ Iniciando DIJKSTRA ........\n");
	
		//	Encontra o caminho mais curto, usar uma estrutura heap	 
		Vertice verticeAtual, verticeDestino;
		Arco p;


		//	Inicialização
		int numVertices = digrafo.getNumVertices();
		Lista<Vertice> vertices = digrafo.getVertices();
		
		for (int i = 0; i < numVertices; i++){
			Vertice v = vertices.getPelaPosicao(i);
			v.setCusto(INFINITO);
			v.setPai(null);
		}  


		filaPrioridade.inicializar();

		verticeOrigem.setCusto(0);
		verticeOrigem.setPai(verticeOrigem);

		filaPrioridade.inserir(verticeOrigem);


		// Percorre todos os Vertices que estao na Fila de Prioridade
		while(!filaPrioridade.estaVazia()){

		verticeAtual = filaPrioridade.minHeap();

			//System.out.println("\n\t xxxxxxxxxx  MIN-HEAP retirado: " + verticeAtual);
			Lista<Arco> arcos = verticeAtual.getListaArcos();
			int qtdArcos = arcos.getQuantidadeItensLista();
	
			
			//	Laço para passar por todos os arcos de cada Vertice
			for(int i = 0; i < qtdArcos; i++){

				Arco arcoAtual = arcos.getPelaPosicao(i);
				verticeDestino = arcoAtual.getVerticeDestino();
				//System.out.println("...Avaliando arco para: " + verticeDestino);
				
				int custoArco = arcoAtual.getCusto();
				int custoVerticeAtual = verticeAtual.getCustoVertice();
				int custoVerticeDestino = verticeDestino.getCustoVertice();


				// Relaxamento
				if (!verticeDestino.jaFoiVisitado()){				
					//System.out.println("\n\n\t\t!! Marcando primeira visita !! - Custo acumulado: " + (custoVerticeAtual + custoArco) + "\n");	
					verticeDestino.setCusto(custoVerticeAtual + custoArco);
					verticeDestino.setPai(verticeAtual);
					filaPrioridade.inserir(verticeDestino);
 				}
				else{

					if (custoVerticeDestino > custoVerticeAtual + custoArco){
						//System.out.println("\n\n\t\t!! Atualizando Custo !! - Custo acumulado: " + (custoVerticeAtual + custoArco) + "\n");		
						verticeDestino.setCusto(custoVerticeAtual + custoArco);
						verticeDestino.setPai(verticeAtual);
						filaPrioridade.alterarPrioridade(verticeDestino);
					}

				}
 				

			}

		}

		//System.out.println("\n\t........ Finalizando DIJKSTRA ........\n");

	}


}