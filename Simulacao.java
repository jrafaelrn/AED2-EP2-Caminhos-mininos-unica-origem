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
		this.digrafo = new Digrafo("Digrafo", numVertices);

	}





	public void simulaTudo() throws IOException {

		// Loop para gerar a conexao entre os Vertices baseado na probabilidade passada
		for(int i = 0; i < numVertices; i++){

			for(int j = 0; j < numVertices; j++){

				if(verticeConecta() && i != j){

					Vertice vOrigem = new Vertice(new Integer(i).toString());
					Vertice vDestino = new Vertice(new Integer(j).toString());
					
					int custo = sorteiaCusto();
					Arco arco = new Arco(vOrigem, vDestino,new Integer(j).toString(), custo);

					

				}
			
			}

		}


	}


	
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

	///////////////////////////////
	//			GRAVAÇÃO
	//////////////////////////////


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