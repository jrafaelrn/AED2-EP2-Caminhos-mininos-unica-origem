public class Digrafo {
    
  	private Lista<Vertice> listaVertices;
	private Lista<Arco> listaArcos;
	private String nome;
	private int numVertices, numArcos;
    
	
	//Esta sendo considerado uma lista de adjacencia 

	public Digrafo(String nome, int tamanho){
		
		this.nome = nome;
		this.numVertices = 0;		//Tamanho de um grafo
		this.numArcos = 0;
    	this.listaVertices = new Lista<>();
		this.listaArcos = new Lista<>();
		
    }
	

	///////////////////////////////
    //     IMPRESSÃO / DEBUG     //
    //////////////////////////////

    public void imprimirDigrafo(){

        System.out.println("\n\n===========================================");
        System.out.println("\t\t\t IMPRIMINDO Digrafo ");

        System.out.println("\n --------------- VERTICES -------------------");

		int totalArcos = 0;
        
      	for(int i = 0; i < listaVertices.getQuantidadeItensLista(); i++){    
			Vertice v = listaVertices.getPelaPosicao(i);
			v.imprimirVertice();
			totalArcos += v.getNumeroArcos();
		}

		System.out.println("\n --------------------------------------------");

        System.out.println("\nTotal Vertices: " + listaVertices.getQuantidadeItensLista());
		System.out.println("Total Arcos: " + totalArcos);

        System.out.println("\n===========================================");
		
    }

	
    ///////////////////////////
    //      GETs e SETs     //
    //////////////////////////
/*
    private boolean arcoExisteDigrafo(Arco Arco){

        Vertice v = Arco.getVerticeOrigem();

        for(int i = 0; i < listaArcos.getQuantidadeItensLista(); i++)
            if (listaArcos.getPelaPosicao(i).getVerticeOrigem() == v || 
                listaArcos.getPelaPosicao(i).getVerticeDestino() == v)
                return true;

        return false;
    }
*/
  
	public void adicionaVertice(Vertice v){
  		listaVertices.inserir(v);
		numVertices++;

		int qtdArcos = v.getNumeroArcos();
		for(int i = 0; i < qtdArcos; i++){
			Arco a = v.getListaArcos().getPelaPosicao(i);
			listaArcos.inserir(a);
			numArcos++;
		}
  	}

	public Lista<Vertice> getVertices() { 
		return this.listaVertices;
	}

	public Lista<Arco> getArcos() { 
		return this.listaArcos;
	}

	public String toString(){
		return this.nome;
	}

	public int getNumVertices(){
		return this.numVertices;
	}

		public int getNumArcos(){
		return this.numArcos;
	}


}
