public class Digrafo {
    
	private Link[] listaAdj;
	private int numVertices, numArcos;
    
	
	//Esta sendo considerado uma lista de adjacencia 

	public Digrafo(int tamanho){
		
		this.numVertices = tamanho;		//Tamanho de um grafo
		this.numArcos = 0;
		this.listaAdj = new Link[tamanho];

		for(int v = 0; v < tamanho; v++){
			listaAdj[v] = null;
		}

  }
	

	///////////////////////////////
  //     IMPRESSÃO / DEBUG     //
  //////////////////////////////

  public void imprimirDigrafo(){

		System.out.println("\n\n===========================================");
		System.out.println("\t\t\t IMPRIMINDO Digrafo ");
		System.out.println("\n --------------- VERTICES -------------------");

		int numArcos = 0;
        
    for(int i = 0; i < numVertices; i++){    

			System.out.println("Vertice[" + i + "]");
			
			Link arco = listaAdj[i];
			while(arco != null){
				System.out.println("\t\t\tVertice Destino: " + arco.posVerticeDestino + "\tCusto: " + arco.custo);
				arco = arco.proximo;
				numArcos++;
			}

			System.out.println();

		}

		System.out.println("\n --------------------------------------------");

    System.out.println("\nTotal Vertices: " + numVertices);
		System.out.println("Total Arcos: " + numArcos);

    System.out.println("\n===========================================");
		
  }

	
	///////////////////////////
	//      GETs e SETs     //
	//////////////////////////

	public int getNumVertices(){
		return numVertices;
	}


	public int getNumArcos(){
		return numArcos;
	}


	public Link getArco(int posicaoVertice){
		return listaAdj[posicaoVertice];
	}


	public void setNovoArco(int posOrigem, int posDestino, int custo){
		
		if (posOrigem == posDestino) return;

		Link antigaCabeca = listaAdj[posOrigem];
		Link arco = new Link(posDestino, custo, antigaCabeca);

		listaAdj[posOrigem] = arco;
		numArcos++;

	}


}
