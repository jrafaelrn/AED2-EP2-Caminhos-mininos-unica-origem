import java.io.*;
import java.util.*;

public class Simulacao{

	private int numVertices, custoMaximo, tamanho;
	private double probabilidade;
	private MedidorTempo medidor;
	private Digrafo digrafo;
	Random random = new Random();
	int[] custoDijkstra, custoBellmanFord, custoDagMin;


	public Simulacao(int tamanho, double probabilidade, int custoMaximo) throws IOException {

		this.tamanho = tamanho;
		this.probabilidade = probabilidade;
		this.custoMaximo = custoMaximo;
		this.medidor = new MedidorTempo();
		simulaTudo();

	}



	private void simulaTudo() throws IOException {

		numVertices = Simulacao.getNumeroVertices_Digrafo(tamanho, probabilidade);
		int vInicial = 0; 

		digrafo = new Digrafo(numVertices);
		gerarDigrafo();
		System.out.println("\n\nARBITRARIOS");
		simulaDijkstra(vInicial, "DIGRAFO");		
		simulaBellmanFord(vInicial, "DIGRAFO");		

		
		if(validaCustosDigrafos())
			System.out.println("ARBITRARIOS - Custos iguais");
		else
			System.out.println("ARBITRARIOS - Custos diferentes");



		numVertices = getNumeroVertices_Dag(tamanho, probabilidade)*2;
		digrafo = new Digrafo(numVertices);
		gerarDag();
		System.out.println("\n\nDAGs");
		simulaDijkstra(vInicial, "DAG");
		simulaBellmanFord(vInicial, "DAG");
		simulaDagMin(vInicial, "DAG");

		if(validaCustosDags())
			System.out.println("DAGs - Custos iguais");
		else
			System.out.println("DAGs - Custos diferentes");


	}




	private void gerarDigrafo(){
		
		// Loop para gerar a conexao entre os Vertices baseado na probabilidade passada
		for(int i = 0; i < numVertices; i++){

			for(int j = 0; j < numVertices; j++){

				if(verticeConecta() && i != j){

					int custo = sorteiaCusto();
					digrafo.setNovoArco(i, j, custo);

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
					digrafo.setNovoArco(i, j, custo);

				}
			
			}

		}

	}





	private void simulaDijkstra(int vInicial, String tipo){

		medidor.comecaCpuTime();
		medidor.comeca();
		System.out.println("\nComecando Dijkstra");

		Dijkstra dij = new Dijkstra(digrafo, vInicial);
		custoDijkstra = dij.getCustos();

		long tempoClock = medidor.terminaCpuTime();
		long tempoDireto = medidor.termina();
		System.out.println("DIJKSTRA - TEMPO CLOCK: " + tempoClock + " (ms)");
		System.out.println("DIJKSTRA - TEMPO DIRETO: " + tempoDireto + " (ms)\n");
		
		String log = "ALGORITMO:DIJKSTRA;TIPO:" + tipo + ";TAMANHO:" + tamanho + ";DENSIDADE:" + probabilidade + ";TEMPO-CLOCK:" + tempoClock;
		gravarArquivoLog(log);

	}


	private void simulaBellmanFord(int vInicial, String tipo){

		medidor.comecaCpuTime();
		medidor.comeca();
		System.out.println("\nComecando Bellman Ford");

		BellmanFord bf = new BellmanFord(digrafo, vInicial);
		custoBellmanFord = bf.getCustos();

		long tempoClock = medidor.terminaCpuTime();
		long tempoDireto = medidor.termina();
		System.out.println("BELLMAN-FORD - TEMPO CLOCK: " + tempoClock + " (ms)");
		System.out.println("BELLMAN-FORD - TEMPO DIRETO: " + tempoDireto + " (ms)\n");

		String log = "ALGORITMO:BELLMAN-FORD;TIPO:" + tipo + ";TAMANHO:" + tamanho + ";DENSIDADE:" + probabilidade + ";TEMPO:" + tempoClock;
		gravarArquivoLog(log);

	}


	private void simulaDagMin(int vInicial, String tipo){

		medidor.comecaCpuTime();
		medidor.comeca();
		System.out.println("\nComecando DagMIN");

		DagMin dg = new DagMin(digrafo, vInicial);
		custoDagMin = dg.getCustos();
		
		long tempoClock = medidor.terminaCpuTime();
		long tempoDireto = medidor.termina();
		System.out.println("DAGMIN - TEMPO CLOCK: " + tempoClock + " (ms)");
		System.out.println("DAGMIN - TEMPO DIRETO: " + tempoDireto + " (ms)\n");

		String log = "ALGORITMO:DAG-MIN;TIPO:" + tipo + ";TAMANHO:" + tamanho + ";DENSIDADE:" + probabilidade + ";TEMPO:" + tempoClock;
		gravarArquivoLog(log);

	}




	//////////////////////////////////////////
	//					MÉTODOS AUXILIARES					//
	//////////////////////////////////////////

	
	// 	Método que devolve um booleano para indicar 
	//	se o Vertice deve se conectado, baseado na Probabilidade
	private boolean verticeConecta(){
		double rand = random.nextDouble();
		return rand <= probabilidade;
	}


	// 	Método que devolve um valor aleatorio, de valor <= custoMaximo
	private int sorteiaCusto(){
		return (int) Math.abs((random.nextDouble() * (custoMaximo - 1)) + 1);
	}


	static int getNumeroVertices_Digrafo(int tamanhoEntrada, double probabilidade){

		double num = (probabilidade - 1) + Math.sqrt((Math.pow((1 - probabilidade),2) + 4 * probabilidade * tamanhoEntrada)) / (2 * probabilidade);
		return (int) Math.round(num);

	}
	
	
	static int getNumeroVertices_Dag(int tamanhoEntrada, double probabilidade){

		double num = ((probabilidade/2) - 1) + Math.sqrt((Math.pow((1 - (probabilidade/2)),2) + 4 * (probabilidade/2) * tamanhoEntrada)) / (2 * (probabilidade/2));
		return (int) Math.round(num);

	}


	//////////////////////////////////
	//					GRAVAÇÃO		  			//
	//////////////////////////////////

	private void gravarArquivoLog(String log){

		String arquivoLog = "log.txt";

		try{
			
			RandomAccessFile arq = new RandomAccessFile(arquivoLog, "rw");

			Writer csv = new BufferedWriter(new FileWriter(arquivoLog, true));
			csv.append(log + "\n");
			csv.close();

		}
		catch (Exception e){
			System.out.println("!!! ERRO NA GRAVACAO DO LOG !!!");
			e.printStackTrace();
		}

	}



	//////////////////////////////////
	//					VALIDACAO		  			//
	//////////////////////////////////

	private boolean validaCustosDigrafos(){

		for (int i = 0; i < numVertices; i++){
			if(custoDijkstra[i] != custoBellmanFord[i]){
				System.out.println("Custo Dijkstra[" + i + "] = " + custoDijkstra[i]);
				System.out.println("Custo BellmanF[" + i + "] = " + custoBellmanFord[i]);
				return false;
			}
		}

		return true;

	}


	private boolean validaCustosDags(){

		boolean dij_bmf, dij_dag, bmf_dag;
		dij_bmf = dij_dag = bmf_dag = true;

		// Valida se os custos do Dijkstra == BellmanFord
		for (int i = 0; i < numVertices; i++){
			if(custoDijkstra[i] != custoBellmanFord[i]){
				System.out.println("Custo Dijkstra[" + i + "] = " + custoDijkstra[i]);
				System.out.println("Custo BellmanF[" + i + "] = " + custoBellmanFord[i]);
				dij_bmf = false;
				break;
			}
		}


		// Valida se os custos do Dijkstra == DAG
		for (int i = 0; i < numVertices; i++){
			if(custoDijkstra[i] != custoDagMin[i]){
				System.out.println("Custo Dijkstra[" + i + "] = " + custoDijkstra[i]);
				System.out.println("Custo Dag-Min[" + i + "] = " + custoDagMin[i]);
				dij_dag = false;
				break;
			}
		}

		// Valida se os custos do BellmanFord == DAG
		for (int i = 0; i < numVertices; i++){
			if(custoBellmanFord[i] != custoDagMin[i]){
				System.out.println("Custo BellmanF[" + i + "] = " + custoBellmanFord[i]);
				System.out.println("Custo Dag-Min[" + i + "] = " + custoDagMin[i]);
				bmf_dag = false;
				break;
			}
		}

		
		if (!dij_bmf) System.out.println("\n!!Problema com Dijkstra e BellmanFord");
		else System.out.println("\n!!Dijkstra e BellmanFord = OK");

		if (!dij_dag) System.out.println("\n!!Problema com Dijkstra e DAG");
		else System.out.println("\n!!Dijkstra e DAG = OK");

		if (!bmf_dag) System.out.println("\n!!Problema com BellmanFord e DAG");
		else System.out.println("\n!!BellmanFord e DAG = OK");


		if(!dij_bmf || !dij_dag || !bmf_dag) return false;

		return true;

	}


}