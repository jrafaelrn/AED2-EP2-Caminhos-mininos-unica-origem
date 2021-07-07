

public class Vertice { 

    private Lista<Arco> listaArcos;
    private boolean foiVisitado;
    private int custoVertice, grauIndividualVertice, grauTotal;
	private String verticeNome;


	public Vertice(String nome){
		
		this.verticeNome = nome;
		this.listaArcos = new Lista<Arco>();
        this.foiVisitado = false;
        this.custoVertice = 0;
		
	}


/*
	//Liga um vértice ao outro, criando um caminho
	public void ligarCaminho(Vertice caminho){
		if(!ehCaminho(caminho)){
			vertices.inserir(caminho);
			grauTotal++;
		}
	}

	//Verifica se o vertice já está no caminho
	public boolean ehCaminho(Vertice ligacao){
		
		for(int i = 0; i < this.vertices.getQuantidadeItensLista(); i++){

			Vertice caminho = this.vertices.getPelaPosicao(i);

			if(caminho == ligacao){
				return true;
			}
		}
		
		return false;

	}

	
	public void adicionaArco(Arco a){

        if(!arcoExisteDigrafo(a))
            listaArcos.inserir(a);

    }
*/


	///////////////////////////////
    //     IMPRESSÃO / DEBUG     //
    //////////////////////////////


	public void imprimirVertice(){

        System.out.println("\nVertice = " + verticeNome);
        System.out.println("Visitado? = " + foiVisitado);
        System.out.println("Custo Atual Vertice = " + custoVertice);
        
        for (int i = 0; i < listaArcos.getQuantidadeItensLista(); i++)
            listaArcos.getPelaPosicao(i).imprimirArco();

    }



    ///////////////////////////
    //      GETs e SETs     //
    //////////////////////////

	public int getGrauTotal(){
		return grauTotal;
	}

	
	public Lista<Arco> getListaArcos(){
        return listaArcos;
    }


    public void adicionaArco(Arco a){        
        listaArcos.inserir(a);
    }


    public boolean jaFoiVisitado(){
		return foiVisitado;
	}


	public void marcarVisita(){
		foiVisitado = true;
	}


    public void incrementaCusto(int custoAdicional){
        custoVertice += custoAdicional;
    }


    public int getCustoVertice(){
        return custoVertice;
    }

	public String getNome(){
		return verticeNome;
	}

	public int getNumeroArcos(){
		return listaArcos.getQuantidadeItensLista();
	}

}