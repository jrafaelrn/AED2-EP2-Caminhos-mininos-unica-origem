class Main{ 

	
	/* Fazer ler um arquivo txt com vertices e arestas */

	public static void main(String[] args){

		Digrafo d1 = new Digrafo("Digrafo 1",8);
		Vertice v1 = new Vertice("a");
		Vertice v2 = new Vertice("b");
		Vertice v3 = new Vertice("c");
		Arco a1 = new Arco(v1,v2,"Aresta 1",3); 
		Arco a2 = new Arco(v2,v3,"Aresta 2",2); 
		Arco a3 = new Arco(v1,v3,"Aresta 3",6); 

		v1.adicionaArco(a1);
		v2.adicionaArco(a2);
		v2.adicionaArco(a3);

		d1.adicionaVertice(v1);
		d1.adicionaVertice(v2);
		d1.adicionaVertice(v3);

		d1.imprimirDigrafo();


	}


	static int getNumeroVertices(int tamanhoEntrada, double probabilidade){

		double num = (probabilidade - 1) + Math.sqrt((Math.pow((1 - probabilidade),2) + 4 * probabilidade * tamanhoEntrada)) / (2 * probabilidade);
		return (int) Math.round(num);

	}





	/*
	
		// 	TESTE DE COERENCIA DE TAMANHO

		for (double i = 1; i < 10; i++){
			
			double prob = i/10;
			int num = getNumeroVertices(1000, prob);
			System.out.println("Tamanho: " + 1000 + "\tProbabilidade: " + prob + "\tNum Vertices: " + num);
			
		}


		

		// TESTE DO SORTEIO CUSTO MAXIMO

		for(int i = 0; i < 100000; i++){
			
			int sorteio = sorteiaCusto(500);

			System.out.println(sorteio);

			if (sorteio > 500 || sorteio < 0){
				System.out.println("ERRO!!!!!");
				break;
			}

			System.out.println("OK!");
		}


	static int sorteiaCusto(int custoMaximo){
		return (int) Math.floor(Math.random() * (custoMaximo + 1));
	}
	




/*

    public static void main(String[] args){
        
        // Loop para simular diferentes tamanhos entradas
        for (int tam = 1000; tam < 5000; tam+=1000){
         
            // Loop para simular diferentes probabilidades/densidades
            for (double prob = 1; prob < 10; prob++){

				double probabilidade = prob/10;
				int numVertices = getNumeroVertices(tam, probabilidade);
                
                try{
                    Simulacao simula = new Simulacao(numVertices, probabilidade, 100); 		//Variar custo maximo?
					simula.simulaTudo();
                }
                catch (Exception e){
                    System.out.println(" !!! Erro na simulacao !!!");
                    e.printStackTrace();
                }
            }

        }

    }

*/

}