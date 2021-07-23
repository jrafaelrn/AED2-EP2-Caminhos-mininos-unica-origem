public class Link{

	public int posVerticeDestino, custo;
	public Link proximo;

	public Link(int posVerticeDestino, int custo, Link proximo){
		this.posVerticeDestino = posVerticeDestino;
		this.custo = custo;
		this.proximo = proximo;
	}

	public String toString(){
		String retorno = "Arco ---> Para: " + posVerticeDestino + " - Custo: " + custo;
		return retorno;
	}


}