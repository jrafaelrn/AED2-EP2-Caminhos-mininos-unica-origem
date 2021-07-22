public class BellmanFord { 

  private int[] pai, custo;
	private int numVertices, verticeOrigem;
	private Digrafo digrafo;
	private MinHeap filaPrioridade;
	static final int INFINITO = Integer.MAX_VALUE;


	public BellmanFord(Digrafo digrafo, int verticeOrigem){

		numVertices = digrafo.getNumVertices();
		custo = new int[numVertices];
		pai = new int[numVertices];
		this.verticeOrigem = verticeOrigem;
		this.digrafo = digrafo;
		this.filaPrioridade = new MinHeap(numVertices, custo);

		//Instancia o objeto e já executa o algoritmo de Bellman-Ford
		if (bellman_Ford())	
			System.out.println("\nBellmanFord = OK");
		else
			System.out.println("\nBellmanFord = CICLO NEGATIVO LOCALIZADO !!!!");

		imprimeResultados();

	}


	
	//	Pesos podem ser negativos
	//	Retorna TRUE se o algoritmo foi executado corretamente, ou seja, nao existe ciclo negativo
	//	Retorna FALSE se o resultado nao eh confiavel, ou seja, existe ciclo negativo

	private boolean bellman_Ford(){

		System.out.println("\n\t........ Iniciando BELLMAN-FORD ........");
		int verticeAtual;
    
		//Etapa 1: preencha a matriz de distânciae a matriz pai
		for(int v = 0; v < numVertices; v++){
    	custo[v] = INFINITO;
			pai[v] = -1;
		}

		filaPrioridade.inicializar(); 

		custo[verticeOrigem] = 0;    
  	Link arco;
		filaPrioridade.inserir(verticeOrigem);  


    //Etapa 2: relaxar as arestas | V | - 1 vez
		System.out.println("\n\n --------- Etapa 2");
		
		// Percorre todos os Vertices que estao na Fila de Prioridade
		while(!filaPrioridade.estaVazia()){

			verticeAtual = filaPrioridade.delMin();		
			System.out.println("\n\t xxxxxxxxxx  MIN-HEAP retirado - Vertice " + verticeAtual);
			arco = digrafo.getArco(verticeAtual);

			while(arco != null)	{
				relaxa(verticeAtual, arco.posVerticeDestino, arco.custo);
				arco = arco.proximo;
			}

		}


		// Etapa 3: detectar o ciclo negativo
		// se o valor mudar, então temos um ciclo negativo no grafo
		// e não podemos encontrar as distâncias mais curta

		System.out.println("\n\n --------- Etapa 3");

		for(verticeAtual = 0; verticeAtual < numVertices; verticeAtual++){			
			
				arco = digrafo.getArco(verticeAtual);

				while(arco != null)	{
				
					if (custo[arco.posVerticeDestino] > custo[verticeAtual] + arco.custo)
						return false;

					arco = arco.proximo;

				}

		}

		System.out.println("\n\t........ Finalizando BELLMAN-FORD .......\n");
		return true;		

	}



	private void relaxa(int verticeAtual, int verticeDestino, int custoArco){

		System.out.println("\nRelaxando Vertice INICIAL " + verticeAtual + " - Vertice DESTINO: " + verticeDestino + " - Custo: " + custoArco);

		if (custo[verticeDestino] == INFINITO){				

			System.out.println("\n\n\t\t!! Marcando primeira visita !! - Custo acumulado: " + (custo[verticeAtual] + custoArco) + "\n");	
			custo[verticeDestino] = custo[verticeAtual] + custoArco;
			pai[verticeDestino] = verticeAtual;
			filaPrioridade.inserir(verticeDestino);

		}
		else{

			if (custo[verticeDestino] > (custo[verticeAtual] + custoArco)){

				System.out.println("\n\n\t\t!! Atualizando Custo !! - Custo acumulado: " + (custo[verticeAtual] + custoArco) + "\n");	
				custo[verticeDestino] = custo[verticeAtual] + custoArco;
				pai[verticeDestino] = verticeAtual;
				filaPrioridade.alterarPrioridade(verticeDestino);

			}

		}

	}



	private void imprimeResultados(){

		System.out.println("\n\n******* RESULTADOS *******");

		System.out.println("\n------- CUSTOS -------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Custo[" + i + "] = " + custo[i]);
		}

		System.out.println("\n------- PAIS -------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Pai[" + i + "] = " + pai[i]);
		}

	}


}