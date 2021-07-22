public class DagMin{

/*
Grafo acíciclo direcionado, seria um grafo sem ciclo, se
existir um caminho entre o vértice A até o B, os vértices são
relaxados na ordem da Topologia, vai um por um.

https://www.youtube.com/watch?v=xUZzMGQlhgY&t=779s

VAMOS USAR UMA PILHA PARA FAZER A ORDENAÇÃO TOPOLÓGICA E
PRECISA PEGAR VÉRTICE POR VÉRTICE SEGUINDO ESSA ORDENAÇÃO

VAI MELHORANDO O CUSTO SEGUINDO A ORDENAÇÃO TOPOLÓGICA


*/

private int[] custo;
private boolean[] visitados;
private int[] pai;
private int totalVertices, totalArcos;
private int verticeOrigem;
private Digrafo digrafo;
private int[] pilha;
static final int INFINITO = Integer.MAX_VALUE;


public DagMin(Digrafo digrafo, int verticeOrigem){
custo = new int[totalVertices];
this.verticeOrigem = verticeOrigem;
this.digrafo = digrafo;
this.pilha = new int[totalVertices];
this.pai = new int[totalVertices];
//dagMin(verticeOrigem);
}

 /*  
    void ordemTopologica(int vertices) {
        visitados[vertices] = true;//verificado
		
        //Percorrer todos os vértices na lista de adjacecia

            if (!visitados[vertice]) {
                ordemTopologica(vertice);
            }
        
       //No final empilhar os vértices no vetor pilha 
       criando uma ordenação topologica
    } 
	

     void dagMin(int vertice_origem) {
     Link p;
     int j, v;

      1° PARTE
        //Classifique topologicamente os vértices
        for(int i = 0; i < totalVertices; i++) {
        if (!visitados[i]) {
        ordemTopologica(i);
      }

      
      2° PARTE
      //Inicializar o custo do vértice de origem para todos os outros vértices como INFINITO.
      
      for(v = 0; v < totalVertices; v++){
      custo[v] = INFINITO;
      }

      //A distância / custo do vértice de origem até ele mesmo é 0.
      custo[vertice_origem] = 0;


      3° PARTE 
      //Apartir da ordem topologica 
      //Enquanto a pilha não estiver vazia, pegue o vértice do topo
      //No final para cada vértice A adjacente a B relaxe a aresta de B->A


        }



   private void relaxa(int verticeAtual, int verticeDestino, int custoArco){

		if (custo[verticeDestino] == INFINITO){				
		custo[verticeDestino] = custo[verticeAtual] + custoArco;
		pai[verticeDestino] = verticeAtual;
		}
		else{
		if (custo[verticeDestino] > (custo[verticeAtual] + custoArco)){		
		custo[verticeDestino] = custo[verticeAtual] + custoArco;
		pai[verticeDestino] = verticeAtual;

			}

		}

	}
*/

}