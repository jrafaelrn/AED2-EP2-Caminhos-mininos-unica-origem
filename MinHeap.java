 public class MinHeap {

	private int[] Heap, custo, qp;
	private int quantidadesDeElementos;
	private static final int PRIMEIRO = 1;
  

	public MinHeap(int maxTamanho, int[] custo){
		this.quantidadesDeElementos = 0;
		this.custo = custo;
		Heap = new int[maxTamanho+1];
		qp = new int[maxTamanho];
		
	}
  


	//	Precisa inicializar com 0, depois em inserir faço o pós-incremento.
	public void inicializar(){
		this.quantidadesDeElementos = 0;
	}
  
  

	private void trocar(int primeiraPosicao, int segundaPosicao){

		int auxiliar;
		auxiliar = Heap[primeiraPosicao];
		Heap[primeiraPosicao] = Heap[segundaPosicao];
		Heap[segundaPosicao] = auxiliar;

		qp[Heap[primeiraPosicao]] = primeiraPosicao;
		qp[Heap[segundaPosicao]] = segundaPosicao;

	}



  public void inserir(int elemento){
		
		qp[elemento] = quantidadesDeElementos + 1;

		Heap[++quantidadesDeElementos] = elemento;
		fixUp(quantidadesDeElementos);

	}



	private void fixUp(int posicao){
		
		int paiAtual;

		if(posicao/2 < 1) return;
		
		paiAtual = Heap[pai(posicao)];
		int atual = Heap[posicao];

		while(pai(posicao) > 0 && custo[paiAtual] > custo[atual]){
			trocar(posicao, pai(posicao));
			posicao = pai(posicao);
		}

	}


	private void fixDown(int posicao){

		int posicaoFilho;

		while(filhoEsquerda(posicao) <= quantidadesDeElementos){

			int verticeFilhoEsquerda = Heap[filhoEsquerda(posicao)];
			posicaoFilho = filhoEsquerda(posicao);

			if (filhoEsquerda(posicao) < quantidadesDeElementos && custo[verticeFilhoEsquerda] > custo[Heap[filhoDireita(posicao)]])
				posicaoFilho = filhoDireita(posicao);

			if(custo[Heap[posicao]] <= custo[Heap[posicaoFilho]])
				break;

			trocar(posicao, posicaoFilho);
			posicao = posicaoFilho;

		}


	}



	public int delMin(){

		trocar(PRIMEIRO, quantidadesDeElementos);
		quantidadesDeElementos--;
		fixDown(PRIMEIRO);

		return Heap[quantidadesDeElementos+1];

	}



	public void alterarPrioridade(int posicaoVerticeDestino){
		
		fixUp(qp[posicaoVerticeDestino]);
		
	}




	///////////////////////////////
	//     IMPRESSÃO / DEBUG     //
	//////////////////////////////
		
	public void imprimeMinHeap(){
		
		System.out.println("\n\n\n -------------- IMPRIMINDO HEAP -------------- ");
		System.out.println("QUANTIDADE DE ELEMENTOS: " + this.quantidadesDeElementos);
			
		for (int i = 1; i <= this.quantidadesDeElementos/2; i++) {
				System.out.print("Pai : " + Heap[i]  
								+ "\tFilho Esquerda : " + Heap[2 * i]
								+ "\tFilho Direita : " + Heap[2 * i + 1]);
				System.out.println("\n");
			}
		
		
		for(int i = 1; i <= this.quantidadesDeElementos; i++){
			System.out.println("Vertice: " + Heap[i] + " - CustoAcumulado: " + custo[Heap[i]]);
		}

		System.out.println(" ---------------------------------------------------- \n\n");

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

}