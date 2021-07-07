public class Digrafo {
    
    private Lista<Vertice> listaVertices, visitados;
	private String nome;
	private int numVertices, numArcos;
    
	
	//	Esta sendo considerado uma lista de adjacencia 
	//	Criar métodos para simular tbm com matriz de adjacencia quando prob >= 0.8? Parte2?
    
	public Digrafo(String nome, int tamanho){
		
		this.nome = nome;
		this.numVertices = tamanho;		//Tamanho de um grafo
		this.numArcos = 0;
        this.listaVertices = new Lista<Vertice>();
		
    }


   

    


	public void buscaEmProfundidade(Vertice a) {

	}

	public void buscaEmLargura(Vertice a){

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
    }

	public Lista<Vertice> getVertices() { 
		return this.listaVertices;
	}

	public String toString(){
		return this.nome;
	}


}
