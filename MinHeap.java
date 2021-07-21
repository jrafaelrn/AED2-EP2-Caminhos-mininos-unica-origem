public class MinHeap {

	private Vertice[] Heap;
	private int quantidadesDeElementos;
	private static final int PRIMEIRO = 1;
  

	public MinHeap(int maxTamanho){
		this.quantidadesDeElementos = 0;
		Heap = new Vertice[maxTamanho];
	}
  


   	//	Precisa inicializar com 0, depois em inserir faço o pós-incremento.
  	public void inicializar(){
		this.quantidadesDeElementos = 0;
	}
  


  	private boolean ehFolha(int posicao){

  		//	Para ser folha, precisa está depois que a quantidade/2
		if (posicao >= (quantidadesDeElementos / 2) && posicao <= quantidadesDeElementos) {
			return true;
		}

		return false;

  	}

  

	private void trocar(int primeiraPosicao, int segundaPosicao){

		//System.out.println("\n ----- ENTROU EM TROCAR ----- \n");
		Vertice auxiliar;
		auxiliar = Heap[primeiraPosicao];
		Heap[primeiraPosicao] = Heap[segundaPosicao];
		Heap[segundaPosicao] = auxiliar;

	}



	private void minHeapify(int posicao){
	
		//System.out.println("MANUTENÇÃO USANDO O MINHEAPIFY");

		if (!ehFolha(posicao)) {
		
      		if(Heap[filhoEsquerda(posicao)] == null || Heap[posicao] == null || Heap[filhoDireita(posicao)] == null) return;
      
			if (Heap[posicao].custoVertice > Heap[filhoEsquerda(posicao)].custoVertice
				|| Heap[posicao].custoVertice > Heap[filhoDireita(posicao)].custoVertice) {


				if (Heap[filhoEsquerda(posicao)].custoVertice < Heap[filhoDireita(posicao)].custoVertice) {
					trocar(posicao, filhoEsquerda(posicao));
					minHeapify(filhoEsquerda(posicao));
				}
			
				else {
					trocar(posicao, filhoDireita(posicao));
					minHeapify(filhoDireita(posicao));
				}
			
			}
		
		}

	}



  	public void inserir(Vertice elemento){
	
		//System.out.println("\n +++++++++  Inserindo no Heap... Elemento: " + elemento);
		
		Heap[++quantidadesDeElementos] = elemento;
		fixUp(quantidadesDeElementos);

	}



	private void fixUp(int posicao){
		
		//System.out.println("\nFIX-UP a partir da posicao " + posicao);
		Vertice paiAtual;

		if(posicao/2 < 1) return;
		
		paiAtual = Heap[pai(posicao)];
		Vertice atual = Heap[posicao];

		while(pai(posicao) > 0 && paiAtual.getCustoVertice() > atual.getCustoVertice()){
			trocar(posicao, pai(posicao));
			posicao = pai(posicao);
		}

	}



    //Acha o menor Vértice
  	public Vertice minHeap(){
	   	
		//System.out.println("------ REMOVER O PRIMEIRO ELEMENTO ------");
	    //Passo o primeiro elemento que é o menor e decremento o heap
		Vertice endPrimeiro = Heap[PRIMEIRO];
    
    	int quantidadeAtualizarPosVazia = quantidadesDeElementos;
		Heap[PRIMEIRO] = Heap[quantidadesDeElementos--];
		
		/*Quando passo o último elemento para a primeira posição, preciso colocar null 
		na última posição, se não estou apenas passando uma cópia para a primeira posição
		e o objeto real ficará na última*/
		Heap[quantidadeAtualizarPosVazia] = null;
    
        
		//Faço a manutenção da árvore heap
		minHeapify(PRIMEIRO);
		return endPrimeiro;
		
	}




	public void alterarPrioridade(Vertice v){

		int posicao = getPosicao(v);

		if (posicao == -1) return;

		minHeapify(posicao);  

	}



  
	public void imprimeMinHeap(){
		
		System.out.println("\n -------------- IMPRIMINDO HEAP -------------- ");
		System.out.println("QUANTIDADE DE ELEMENTOS: " + this.quantidadesDeElementos);
			
		for (int i = 1; i <= this.quantidadesDeElementos / 2; i++) {
				System.out.print("Pai : " + Heap[i]  
								+ " Filho Esquerda : " + Heap[2 * i]
								+ " Filho Direita : " + Heap[2 * i + 1]);
				System.out.println("\n");
			}
		
		
		for(int i = 1; i <= this.quantidadesDeElementos; i++){
			System.out.println(Heap[i]+" CustoAcumulado: " + Heap[i].custoVertice);
		}

	}



    ///////////////////////////
    //      GETs e SETs     //
    //////////////////////////

	public boolean estaVazia(){
		return quantidadesDeElementos == 0;
	}


	private int pai(int posicao){
		return posicao / 2;
	}


	private int filhoEsquerda(int posicao){
		return (2 * posicao);
	}


	private int filhoDireita(int posicao){
		return (2 * posicao) + 1;
	}

	
	
	// ???????????????????????????????????????????
	//	O(n) != O(log(V))

	private int getPosicao(Vertice vertice){

		//Faz um loop por todos os elementos válidos do HEAP
		for(int i = 1; i <= quantidadesDeElementos; i++){

			if (Heap[i] == vertice)	
				return i;

		}

		// Caso nao encontre
		return -1;

	}


}