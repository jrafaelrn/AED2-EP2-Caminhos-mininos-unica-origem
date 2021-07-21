public class Arco {
    
    private Vertice origem, destino;
    private int custo, tamanho;

    //Construtor
    public Arco(Vertice origem, Vertice destino, int custo){
    	this.origem = origem;
    	this.destino = destino;
    	this.custo = custo;
		  origem.adicionaArco(this);
		  this.tamanho += 2;//É adicionado 1 vértice e 1 aresta
    }


	///////////////////////////////
    //     IMPRESSÃO / DEBUG     //
    //////////////////////////////

    public String toString(){
    	String texto  = "DE: " + origem +  " -> PARA: " + destino + "\t CUSTO: " + custo;
		return texto;
    }


    ///////////////////////////
    //      GETs e SETs     //
    //////////////////////////


    public Vertice[] getVertices(){
        Vertice[] vertices = new Vertice[2];
        vertices[0] = origem;
        vertices[1] = destino;
        return vertices;
    }

    public Vertice getVerticeOrigem(){
        return origem;
    }

    public Vertice getVerticeDestino(){
        return destino;
    }

    public int getCusto(){
        return custo;
    }

	public int getQtd(){
		return tamanho;
	}


}
