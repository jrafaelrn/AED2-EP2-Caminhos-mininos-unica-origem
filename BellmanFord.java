public class BellmanFord { 

	private int[] pai, custo;
	private int numVertices, verticeOrigem;
	private Digrafo digrafo;
	static int INFINITO;


	public BellmanFord(Digrafo digrafo, int verticeOrigem, int custoMaximo){

		numVertices = digrafo.getNumVertices();
		custo = new int[numVertices];
		pai = new int[numVertices];
		this.verticeOrigem = verticeOrigem;
		this.digrafo = digrafo;
		//INFINITO = Integer.MAX_VALUE - custoMaximo;
		//INFINITO = Integer.MAX_VALUE/numVertices;
		INFINITO = Integer.MAX_VALUE;

	}



	public void caminhosMinimos(){
	
		//Etapa 1: preencha a matriz de distânciae a matriz pai
		for(int v = 0; v < numVertices; v++){
			custo[v] = INFINITO;
			pai[v] = -1;
		}

		custo[verticeOrigem] = 0;   
		pai[verticeOrigem] = verticeOrigem;
		Link arco;

		//Etapa 2: relaxar as arestas | V | - 1 vez		
		for(int k = 1; k < numVertices; k++){

			for(int verticeAtual = 0; verticeAtual < numVertices; verticeAtual++){

				arco = digrafo.getArco(verticeAtual);

				while(arco != null)	{					  
					relaxa(verticeAtual, arco.posVerticeDestino, arco.custo);
					arco = arco.proximo;  
				}

			}
			
		}				

	}


	private void relaxa(int verticeAtual, int verticeDestino, int custoArco){

		if (custo[verticeAtual] == INFINITO) return;

		if (custo[verticeDestino] > (custo[verticeAtual] + custoArco)){

			custo[verticeDestino] = custo[verticeAtual] + custoArco;
			pai[verticeDestino] = verticeAtual;

		}

	}



	private void imprimeResultados(){

		System.out.println("\n\n------- RESULTADOS BELLMAN-FORD ----------");

		System.out.println("\n----------------- CUSTOS ------------------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Custo[" + i + "] = " + custo[i]);
		}
		
		System.out.println("\n----------------- PAIS ----------------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Pai[" + i + "] = " + pai[i]);
		}
		
	}


	public int[] getCustos(){
		return custo;
	}


}