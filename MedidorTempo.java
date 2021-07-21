public class MedidorTempo {

	private long inicio, inicioClock;
	
	
	// Métodos baseados no Tempo
	public void comeca() {
		//Marca o inicio do tempo.
		inicio = System.currentTimeMillis();
	}
	

	public long termina() {
		//Pega o instante que terminou menos oque comecou e divide por 1000(milisegundo)
		return (System.currentTimeMillis() - inicio) / 1000;
	}


	
	// Métodos baseados no Clock

	public void comecaClock(){
		inicioClock = System.currentTimeMillis();
	}


	public long terminaClock(){
		return 0;

	}
}