public class DagMin{

/*
Grafo acíciclo direcionado, seria um grafo sem ciclo, se
existir um caminho entre o vértice A até o B, os vértices são
relaxados na ordem da Topologia, vai um por um.



VAMOS USAR UMA PILHA PARA FAZER A ORDENAÇÃO TOPOLÓGICA E
PRECISA PEGAR VÉRTICE POR VÉRTICE SEGUINDO ESSA ORDENAÇÃO

VAI MELHORANDO O CUSTO SEGUINDO A ORDENAÇÃO TOPOLÓGICA


*/

	private int[] custo, pai, in, ts, pilha;
	private int numVertices, verticeOrigem, ultimoPilha;
	private Digrafo digrafo;
	static final int INFINITO = Integer.MAX_VALUE;


	public DagMin(Digrafo digrafo, int verticeOrigem){
		
		this.verticeOrigem = verticeOrigem;
		this.digrafo = digrafo;
		numVertices = digrafo.getNumVertices();
		custo = new int[numVertices];
		pilha = new int[numVertices];
		pai = new int[numVertices];
		in = new int[numVertices];
		ts = new int[numVertices];
		ultimoPilha = 0;

		//	1° PARTE - Classifique topologicamente os vértices
		gerarOrdenacaoTopologica();

	}



	public void caminhosMinimos() {
			
		Link p;
		int i, v;

		//	2° PARTE - Inicializar o custo do vértice de origem para todos os outros vértices como INFINITO.		
		for(v = 0; v < numVertices; v++){
			custo[v] = INFINITO;
			pai[v] = -1;
		}
		

		//A distância / custo do vértice de origem até ele mesmo é 0.
		custo[verticeOrigem] = 0;
		pai[verticeOrigem] = verticeOrigem;


		//	3° PARTE 
		//Apartir da ordem topologica 
		//Enquanto a pilha não estiver vazia, pegue o vértice do topo
		//No final para cada vértice A adjacente a B relaxe a aresta de B->A
		for (v = ts[i=0]; i < numVertices; v = ts[i++]){

			if (custo[v] == INFINITO) continue;

			Link arco = digrafo.getArco(v);

			while (arco != null){				
				relaxa(v, arco.posVerticeDestino, arco.custo);
				arco = arco.proximo;
			}

		}

	}


	private void gerarOrdenacaoTopologica(){

		int v;

		//	Zera os graus de entrada de todos os vertices
		for(v = 0; v < numVertices; v++)
			in[v] = 0;

		
		//	Calcula o grau de entrada de cada vertice
		for(v = 0; v < numVertices; v++){
			
			Link arco = digrafo.getArco(v);

			while(arco != null){
				in[arco.posVerticeDestino]++;
				arco = arco.proximo;
			}

		}


		//	Empilha todos os vertices "FONTES"
		for(v = 0; v < numVertices; v++)
			if(in[v] == 0)
				empilha(v);


		//		Retira da pilha os vertices fontes e decrementa os graus de entrada dos vertices de destino
		for(int i = 0; ultimoPilha > 0; i++){

			ts[i] = v = desempilha();
			Link arco = digrafo.getArco(v);

			while(arco != null){
		
				if (--in[arco.posVerticeDestino] == 0)
					empilha(arco.posVerticeDestino);
				
				arco = arco.proximo;

			}			

		}

	}
	


	private void relaxa(int verticeAtual, int verticeDestino, int custoArco){

		if (custo[verticeDestino] > (custo[verticeAtual] + custoArco)){		
			custo[verticeDestino] = custo[verticeAtual] + custoArco;
			pai[verticeDestino] = verticeAtual;
		}

	}



	public void empilha(int vertice){

		pilha[ultimoPilha] = vertice;
		ultimoPilha++;

	}


	public int desempilha(){

		int retorno = pilha[ultimoPilha-1];
		ultimoPilha--;
		return retorno;

	}




	private void imprimePilha(){

		System.out.println("\nUltimoPilha = " + ultimoPilha);

		for(int i = 0; i < numVertices; i++)
			System.out.println("Pilha[" + i + "] = " + pilha[i]);

	}


	private void imprimirGrausEntrada(){
		
		System.out.println("\n --> --> Graus de ENTRADA CALCULADOS");
		
		for(int x = 0; x < numVertices; x++)
			System.out.println("IN[" + x + "] = " + in[x]);

	}


	private void imprimeResultados(){

		System.out.println("\n\n------- RESULTADOS DAGMIN -------");

		System.out.println("\n------- CUSTOS -------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Custo[" + i + "] = " + custo[i]);
		}
		
		System.out.println("\n------- PAIS-------");
		for(int i = 0; i < numVertices; i++){
			System.out.println("Pai[" + i + "] = " + pai[i]);
		}
		
	}


	
	public int[] getCustos(){
		return custo;
	}

}