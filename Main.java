class Main{ 


	public static void main(String[] args){

		//testeEP();
		//testeBellmanFord_Professor();
		//testeDjikstra_Professor();
		testeYoutube();

	}








	
    public static void testeEP(){

		System.out.println("\n\n********************************************");
		System.out.println("*********  INICIANDO SIMULACAO  ************");
		System.out.println("********************************************\n");
        
        // Loop para simular diferentes tamanhos entradas
        for (int tam = 1000; tam <= 10000; tam+=1000){

			System.out.println("\n---- Tamanho:\t" + tam);
         
            // Loop para simular diferentes probabilidades/densidades
            for (double prob = 1; prob < 10; prob++){

				double probabilidade = prob/10;
				int numVertices = getNumeroVertices(tam, probabilidade);
                
                try{
                    Simulacao simula = new Simulacao(numVertices, probabilidade, 1000); 		//Variar custo maximo?
					simula.simulaTudo();
                }
                catch (Exception e){
                    System.out.println(" !!! Erro na simulacao !!!");
                    e.printStackTrace();
                }

            }

        }


		System.out.println("\n\n********************************************");
		System.out.println("**********  FINALIZANDO SIMULACAO   ********");
		System.out.println("********************************************");

    }



	
	static int getNumeroVertices(int tamanhoEntrada, double probabilidade){

		double num = (probabilidade - 1) + Math.sqrt((Math.pow((1 - probabilidade),2) + 4 * probabilidade * tamanhoEntrada)) / (2 * probabilidade);
		return (int) Math.round(num);

	}

   

   
 
	public static void testeDjikstra_Professor(){
   
		//SIMULANDO GRAFO DA AULA GRAVADA ==> https://youtu.be/jTH4eHf-lik?t=1467
		//TESTE DO ALGORITMO DE DIJKSTRA
		
		Digrafo d1 = new Digrafo("Digrafo 1",8);
   
		Vertice v0 = new Vertice("0");
		Vertice v1 = new Vertice("1");
		Vertice v2 = new Vertice("2");
		Vertice v3 = new Vertice("3");
		Vertice v4 = new Vertice("4");
		Vertice v5 = new Vertice("5");

    	d1.adicionaVertice(v0);
		d1.adicionaVertice(v1);
		d1.adicionaVertice(v2);
		d1.adicionaVertice(v3);
		d1.adicionaVertice(v4);
		d1.adicionaVertice(v5);
    
		Arco a1 = new Arco(v0,v2,7); 
		Arco a2 = new Arco(v0,v4,4); 
		Arco a3 = new Arco(v0,v3,2); 
		Arco a4 = new Arco(v1,v2,0); 
		Arco a5 = new Arco(v2,v4,1); 
		Arco a6 = new Arco(v3,v4,1); 
		Arco a7 = new Arco(v3,v5,3); 
		Arco a8 = new Arco(v4,v1,4); 
		Arco a9 = new Arco(v4,v5,1); 
		Arco a10 = new Arco(v5,v1,2);


		d1.imprimirDigrafo();


		//	Encontra caminho minino com DIJKSTRA
		Dijkstra dij = new Dijkstra(d1, v0);


		d1.imprimirDigrafo();



	}





 
 
	public static void testeBellmanFord_Professor(){
   
		//SIMULANDO GRAFO DA AULA GRAVADA ==> https://youtu.be/lId3K8TI8aY?t=1192
		//TESTE DO ALGORITMO DE BELLMAN_FORD
		
		Digrafo d1 = new Digrafo("Digrafo 1",8);
   
		Vertice v0 = new Vertice("0");
		Vertice v1 = new Vertice("1");
		Vertice v2 = new Vertice("2");
		Vertice v3 = new Vertice("3");
		Vertice v4 = new Vertice("4");

    	d1.adicionaVertice(v0);
		d1.adicionaVertice(v1);
		d1.adicionaVertice(v2);
		d1.adicionaVertice(v3);
		d1.adicionaVertice(v4);
    
		Arco a1 = new Arco(v0,v1,3); 
		Arco a2 = new Arco(v0,v3,6); 
		Arco a3 = new Arco(v3,v1,-1); 
		Arco a4 = new Arco(v3,v4,-7); 
		Arco a5 = new Arco(v1,v4,-2); 
		Arco a6 = new Arco(v1,v2,0); 
		Arco a7 = new Arco(v4,v2,3); 
		

		d1.imprimirDigrafo();


		//Encontra caminho minino com BELLMAN-FORD
		BellmanFord bf = new BellmanFord(d1, v0);


		d1.imprimirDigrafo();



	}



	// 
	public static void testeYoutube(){
   
		//SIMULANDO YOUTUBE => https://www.youtube.com/watch?v=dx0vUNkARSw
		//TESTE DO ALGORITMO DE BELLMAN_FORD
		
		Digrafo d1 = new Digrafo("Digrafo 1",8);
   
		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");

    	d1.adicionaVertice(a);
		d1.adicionaVertice(b);
		d1.adicionaVertice(c);
		d1.adicionaVertice(d);
		d1.adicionaVertice(e);
    
		Arco a1 = new Arco(a,b,4); 
		Arco a2 = new Arco(a,d,2); 
		Arco a3 = new Arco(b,d,3); 
		Arco a4 = new Arco(b,c,2); 
		Arco a5 = new Arco(b,e,3); 
		Arco a6 = new Arco(d,b,3); 
		Arco a7 = new Arco(d,c,4); 
		Arco a8 = new Arco(d,e,5); 
		Arco a9 = new Arco(e,c,-5); 
		
		

		d1.imprimirDigrafo();


		//Encontra caminho minino com BELLMAN-FORD
		BellmanFord bf = new BellmanFord(d1, a);


		d1.imprimirDigrafo();



	}








}