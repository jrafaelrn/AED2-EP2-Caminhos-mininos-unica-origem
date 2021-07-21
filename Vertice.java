
public class Vertice { 

  public int custoVertice;
  private Lista<Arco> listaArcos;
  private int grauIndividualVertice, grauTotal;
	private String verticeNome;
	private Vertice pai;


	public Vertice(String nome){

		this.verticeNome = nome;
		this.listaArcos = new Lista<Arco>();
    this.custoVertice = Integer.MAX_VALUE;		
		this.pai = null;
		
	}


	///////////////////////////////
    //     IMPRESSÃO / DEBUG     //
    //////////////////////////////

	public void imprimirVertice(){

        System.out.println("\n" + this);
        System.out.println("Visitado? = " + jaFoiVisitado());
        System.out.println("Custo Atual Vertice = " + custoVertice);
        
        for (int i = 0; i < listaArcos.getQuantidadeItensLista(); i++)
            System.out.println(listaArcos.getPelaPosicao(i));

    }




    ///////////////////////////
    //      GETs e SETs     //
    //////////////////////////

	public String toString(){
		return "Vertice: " + verticeNome;
	}

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
		return custoVertice != Integer.MAX_VALUE;		
	}


	public void setCusto(int custo){
		custoVertice = custo;
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


	public void setPai(Vertice pai){
		this.pai = pai;
	}

	public Vertice getPai(){
		return this.pai;
	}

}