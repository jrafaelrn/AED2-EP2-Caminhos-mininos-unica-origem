class Main{ 

	public static void main(String[] args){

		//testeBellmanFord_Professor();

		

		System.out.println("*********  INICIANDO SIMULACAO  ************");
		int tam = 10000;
			
		// Loop para simular diferentes tamanhos entradas
		while (tam <= 500000){

			System.out.print("\n---- Tamanho Esperado:\t" + tam + " - Densidade: ");
			
			// Loop para simular diferentes probabilidades/densidades
			for (double prob = 1; prob < 10; prob++){

				double probabilidade = prob/10;
				System.out.print((int) (probabilidade * 100) + " %, ");
							
				try{
						Simulacao simula = new Simulacao(tam, probabilidade, 100); 		//Variar custo maximo?
				}
				catch (Exception e){
						System.out.println(" !!! Erro na simulacao !!!");
						e.printStackTrace();
						return;
				}
						
			}

			System.out.println();
			if (tam <= 40000)
				tam += 10000;
			else
				if (tam <= 90000)
					tam += 50000;
				else	
					tam += 100000;

		}

		System.out.println("\n\n**********  SIMULACAO FINALIZADA  ********");		

	}



	public static void testeBellmanFord_Professor(){
   
		Digrafo d1 = new Digrafo(5);
    
		d1.setNovoArco(0,3,6); 
		d1.setNovoArco(0,1,3); 
		d1.setNovoArco(1,4,-2); 
		d1.setNovoArco(1,2,0); 
		d1.setNovoArco(3,4,-7); 
		d1.setNovoArco(3,1,-1); 
		d1.setNovoArco(4,2,3); 		

		d1.imprimirDigrafo();

		MedidorTempo medidor = new MedidorTempo();

		medidor.comeca();
		medidor.comecaCpuTime();
		System.out.println("\nComecando -- ");

		//Encontra caminho minino com BELLMAN-FORD
		BellmanFord bf = new BellmanFord(d1, 0, 100);

		
		long tempoClock = medidor.terminaCpuTime();
		long tempoDireto = medidor.termina();
		
		System.out.println("\nTEMPO CLOCK: " + tempoClock + " (ms)");
		System.out.println("\nTEMPO DIRETO: " + tempoDireto + " (ms)\n");



	}



}