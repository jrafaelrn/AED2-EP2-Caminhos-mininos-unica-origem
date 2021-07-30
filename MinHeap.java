 public class MinHeap {

	private int[] heap, custo, qp;
	private int qtdElementos;
	private static final int PRIMEIRO = 1;
  

	public MinHeap(int maxTamanho, int[] custo){
		this.qtdElementos = 0;
		this.custo = custo;
		heap = new int[maxTamanho+1];
		qp = new int[maxTamanho];
	}
  
  

	private void trocar(int i, int j){

		int auxiliar;
		auxiliar = heap[i];
		heap[i] = heap[j];
		heap[j] = auxiliar;

		qp[heap[i]] = i;
		qp[heap[j]] = j;

	}



  public void inserir(int v){
		
		qp[v] = ++qtdElementos;
		heap[qtdElementos] = v;
		fixUp(qtdElementos);

	}



	private void fixUp(int i){

		while(i > 1 && custo[heap[pai(i)]] > custo[heap[i]]){
			trocar(pai(i), i);
			i = pai(i);
		}

	}


	private void fixDown(int i){

		while(filhoEsquerda(i) <= qtdElementos){

			int j = filhoEsquerda(i);

			if (j < qtdElementos && custo[heap[j]] > custo[heap[j+1]])
				j++;

			if(custo[heap[i]] <= custo[heap[j]]) break;

			trocar(i, j);
			i = j;

		}

	}



	public int delMin(){

		trocar(PRIMEIRO, qtdElementos);
		--qtdElementos;
		fixDown(PRIMEIRO);

		return heap[qtdElementos+1];

	}



	public void alterarPrioridade(int posicaoVerticeDestino){
		
		fixUp(qp[posicaoVerticeDestino]);
		
	}




	///////////////////////////////
	//     IMPRESSÃO / DEBUG     //
	//////////////////////////////
		
	public void imprimeMinheap(){
		
		System.out.println("\n\n\n -------------- IMPRIMINDO HEAP -------------- ");
		System.out.println("QUANTIDADE DE ELEMENTOS: " + this.qtdElementos);
			
		for (int i = 1; i <= this.qtdElementos/2; i++) {
				System.out.print("Pai : " + heap[i]  
								+ "\tFilho Esquerda : " + heap[2 * i]
								+ "\tFilho Direita : " + heap[2 * i + 1]);
				System.out.println("\n");
			}
		
		
		for(int i = 1; i <= this.qtdElementos; i++){
			System.out.println("Vertice: " + heap[i] + " - CustoAcumulado: " + custo[heap[i]]);
		}

		System.out.println(" ---------------------------------------------------- \n\n");

	}


	
	public boolean validaMinHeap(){

		//System.out.println("\n\tValidando FILA PRIORIDADE");

		for(int i = 1; i <= qtdElementos; i++){

			if(filhoEsquerda(i) <= qtdElementos && custo[heap[i]] > custo[heap[filhoEsquerda(i)]]){
				System.out.println("\t\tAtual[" + i + "] = " + heap[i]);
				System.out.println("\t\tEsquerda[" + filhoEsquerda(i) + "] = " + custo[heap[filhoEsquerda(i)]]);
				return false;
			}

			if(filhoDireita(i) <= qtdElementos && custo[heap[i]] > custo[heap[filhoDireita(i)]]){
				System.out.println("\t\tAtual[" + i + "] = " + custo[heap[i]]);
				System.out.println("\t\tDireita[" + filhoDireita(i) + "] = " + custo[heap[filhoDireita(i)]]);	
				return false;
			}
		}

		return true;

	}



	///////////////////////////
	//      GETs e SETs     //
	//////////////////////////

	public boolean estaVazia(){
		return qtdElementos == 0;
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