public class BellmanFord { 

  private int[] custo;
	private Vertice[] pais;
	private int totalVertices, totalArcos;
	private int verticeOrigem;
	private Digrafo digrafo;
	static final int INFINITO = Integer.MAX_VALUE;


	public BellmanFord(Digrafo digrafo, int verticeOrigem){

		/*totalVertices = digrafo.getVertices().getQuantidadeItensLista();
		custo = new int[totalVertices];
		pais = new Vertice[totalVertices];
		this.verticeOrigem = verticeOrigem;
		this.digrafo = digrafo;


		//Instancia o objeto e já executa o algoritmo de Bellman-Ford
		if (bellman_Ford())	
			System.out.println("\nBellmanFord = OK");
		else
			System.out.println("\nBellmanFord = CICLO NEGATIVO LOCALIZADO !!!!");

	}


	
	//	Pesos podem ser negativos
	//	Retorna TRUE se o algoritmo foi executado corretamente, ou seja, nao existe ciclo negativo
	//	Retorna FALSE se o resultado nao eh confiavel, ou seja, existe ciclo negativo

	private boolean bellman_Ford(){

		System.out.println("\n\t........ Iniciando BELLMAN-FORD ........\n");

    
		//Etapa 1: preencha a matriz de distância e a matriz pai
		for(int i = 0; i < totalVertices; i++){
    	custo[i] = INFINITO;
			pais[i] = null;
		}


		int posicaoVerticeOrigem_ListaVertices = digrafo.getVertices().getPosicaoLista(verticeOrigem);
		Vertice verticeDestino;

		custo[posicaoVerticeOrigem_ListaVertices] = 0;    
  

    //Etapa 2: relaxar as arestas | V | - 1 vez
		System.out.println("\n\n --------- Etapa 2");

		for(int i = 0; i < totalVertices; i++){

			Vertice verticeAtual = digrafo.getVertices().getPelaPosicao(i);
			int posicaoVerticeAtual =  digrafo.getVertices().getPosicaoLista(verticeOrigem);

			Lista<Arco> arcos = verticeAtual.getListaArcos();
			int qtdArcos = arcos.getQuantidadeItensLista();
	
			
			//	Laço para passar por todos os arcos de cada Vertice
			for(int j = 0; j < qtdArcos; j++){

				Arco arcoAtual = arcos.getPelaPosicao(j);
				verticeDestino = arcoAtual.getVerticeDestino();
				System.out.println("...Avaliando arco para: " + verticeDestino);
				
				int custoArco = arcoAtual.getCusto();
				int custoVerticeAtual = custo[posicaoVerticeAtual];
				int posicaoVerticeDestino = digrafo.getVertices().getPosicaoLista(verticeDestino);
				int custoVerticeDestino = custo[posicaoVerticeDestino];


				// Relaxamento
				if (!verticeDestino.jaFoiVisitado()){				
					System.out.println("\n\n\t\t!! Marcando primeira visita !! - Custo acumulado: " + (custoVerticeAtual + custoArco) + "\n");	
					custo[posicaoVerticeAtual] = custoVerticeAtual + custoArco;
					pais[posicaoVerticeAtual] = verticeAtual;
 				}
				else{

					if (custoVerticeDestino > custoVerticeAtual + custoArco){
						System.out.println("\n\n\t\t!! Atualizando Custo !! - Custo acumulado: " + (custoVerticeAtual + custoArco) + "\n");		
						custo[posicaoVerticeAtual] = custoVerticeAtual + custoArco;
						pais[posicaoVerticeAtual] = verticeAtual;
					}

				}
 				

			}

		}


		// Etapa 3: detectar o ciclo negativo
    	// se o valor mudar, então temos um ciclo negativo no grafo
    	// e não podemos encontrar as distâncias mais curta

		System.out.println("\n\n --------- Etapa 3");

		totalArcos = digrafo.getNumArcos();

		for(int i = 0; i < totalArcos; i++){

			Arco arcoAtual = digrafo.getArcos().getPelaPosicao(i);

			Vertice v = arcoAtual.getVerticeOrigem();
			Vertice w = arcoAtual.getVerticeDestino();
			
			w = arcoAtual.getVerticeDestino();
			System.out.println("...Avaliando arco para: " + w);
			
			int custoArco = arcoAtual.getCusto();
			int custoVerticeAtual = v.getCustoVertice();
			int custoVerticeDestino = w.getCustoVertice();
			System.out.println("\tCustoVerticeDestino: " + custoVerticeDestino + " > " + custoVerticeAtual + " + " + custoArco);

			if (custoVerticeDestino > custoVerticeAtual + custoArco){
				return false;
			}
	
		}		

		System.out.println("\n\t........ Finalizando BELLMAN-FORD .......\n");
		return true;
		*/

	}


/*
int totalArestas = digrafo.numArcos;

//Etapa 1: preencha a matriz de distância e a matriz pai
for(int i = 0; i < totalVertices; i++){
custo[i] = INFINITO;
//pais[i] = null;
}

int custoArco = arcoAtual.getCusto();
int custoVerticeAtual = verticeAtual.getCustoVertice();

//Marque o vértice de origem como custo 0, porque, foi iniciado como infinito
verticeOrigem.setCusto(0);

//Etapa 2: relaxar as arestas | V | - 1 vez
for(int i = 0; i < totalVertices - 1; i++){
for(int j = 0; j < totalArestas; j++){
verticeDestino.setCusto(custoVerticeAtual + custoArco);
verticeDestino.setPai(verticeAtual);
}
}

// Etapa 3: detectar o ciclo negativo
// se o valor mudar, então temos um ciclo negativo no grafo
// e não podemos encontrar as distâncias mais curta
for(int j = 0; j < numArestas ; j++){
if (custoVerticeDestino > custoVerticeAtual + custoArco){
return false;
}
}
return true
*/


}