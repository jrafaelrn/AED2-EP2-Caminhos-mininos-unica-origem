public class Arco {
    
    private Vertice origem, destino;
    private int custo, tamanho;
	String nomeArco;


    //Construtor
    public Arco(Vertice origem, Vertice destino, String nomeArco, int custo){
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
		this.nomeArco = nomeArco;
		//this.criarCaminho(origem,destino);
		this.tamanho += 2;		//É adicionado 1 vértice e 1 aresta
    }

/*
	//Criar um caminho adicionando um vértice a até b
	public void criarCaminho(Vertice a, Vertice b){
		a.ligarCaminho(b);
		b.ligarCaminho(a);
	}
*/



	///////////////////////////////
    //     IMPRESSÃO / DEBUG     //
    //////////////////////////////

    public void imprimirArco(){
        System.out.print("DE: " + origem.getNome());
        System.out.print(" -> PARA: " + destino.getNome());
		System.out.println("\t CUSTO: " + custo);
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
