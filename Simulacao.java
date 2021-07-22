import java.io.*;

public class Simulacao{

	private int numVertices, custoMaximo;
	private double probabilidade;
	private MedidorTempo medidor;
	private Digrafo digrafo;


	public Simulacao(int numVertices, double probabilidade, int custoMaximo) throws IOException {

		this.numVertices = numVertices;
		this.probabilidade = probabilidade;
		this.custoMaximo = custoMaximo;
		this.medidor = new MedidorTempo();
		this.digrafo = new Digrafo(numVertices);

	}



	public void simulaTudo() throws IOException {

		System.out.print("Num Vertices:\t" + numVertices);
		System.out.println("\t\tDensidade:\t" + (int) (probabilidade * 100) + " %");

		gerarDigrafo();
		simulaDijkstra();
		simulaBellmanFord();

		digrafo = new Digrafo(numVertices);

		gerarDag();
		simulaDijkstra();
		simulaBellmanFord();
		simulaDagMin();

	}




	private void gerarDigrafo(){
		
		// Loop para gerar a conexao entre os Vertices baseado na probabilidade passada
		for(int i = 0; i < numVertices; i++){

			for(int j = 0; j < numVertices; j++){

				if(verticeConecta() && i != j){

					int custo = sorteiaCusto();
					digrafo.setNovoArco(vOrigem, vDestino, custo);

				}
			
			}

		}

	}



	private void gerarDag(){
		
		// Loop para gerar a conexao entre os Vertices baseado na probabilidade passada
		for(int i = 0; i < numVertices; i++){

			for(int j = i+1; j < numVertices; j++){

				if(verticeConecta()){
					
					int custo = sorteiaCusto();
					digrafo.setNovoArco(vOrigem, vDestino, custo);

				}
			
			}

		}

	}





	private void simulaDijkstra(){

		int vInicial = 0; 	// Num aleatório ??

		Dijkstra dij = new Dijkstra(digrafo, vInicial);

	}



	private void simulaBellmanFord(){

		int vInicial = 5; // Num aleatório ??

		BellmanFord bf = new BellmanFord(digrafo, vInicial);

	}




	private void simulaDagMin(){


	}




	//////////////////////////////////////////
	//					MÉTODOS AUXILIARES					//
	//////////////////////////////////////////

	
	// 	Método que devolve um booleano para indicar 
	//	se o Vertice deve se conectado, baseado na Probabilidade
	private boolean verticeConecta(){
		double r = Math.random();
		return r <= probabilidade;
	}


	// 	Método que devolve um valor aleatorio, de valor <= custoMaximo
	private int sorteiaCusto(){
		return (int) Math.floor(Math.random() * (custoMaximo + 1));
	}


	static int getNumeroVertices(int tamanhoEntrada, double probabilidade){

		double num = (probabilidade - 1) + Math.sqrt((Math.pow((1 - probabilidade),2) + 4 * probabilidade * tamanhoEntrada)) / (2 * probabilidade);
		return (int) Math.round(num);

	}
	

	//////////////////////////////////
	//					GRAVAÇÃO		  			//
	//////////////////////////////////

	public void gravarLog_bellmanFord(String log) throws IOException {
		gravarArquivoLog("log_bellmanFord.txt", log);
	}

	public void gravarLog_bellmanFordDag(String log) throws IOException {
		gravarArquivoLog("log_bellmanFordDag.txt", log);
	}

	public void gravarLog_dijkstra(String log) throws IOException {
		gravarArquivoLog("log_dijkstra.txt", log);
	}


	private void gravarArquivoLog(String arquivoLog, String log)throws IOException{

		if(!new File(arquivoLog).exists()){
			RandomAccessFile arq = new RandomAccessFile(arquivoLog, "rw");
		}

		Writer csv = new BufferedWriter(new FileWriter(arquivoLog, true));
		csv.append(log + ",ORDEM:" + "\n");
		csv.close();

	}

}