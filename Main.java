class Main{ 


	public static void main(String[] args){

		//testeEP();
		//testeBellmanFord_Professor();
		//testeDjikstra_Professor();
		//testeYoutube();

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
						int numVertices = Simulacao.getNumeroVertices(tam, probabilidade);
                
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



	

   

   
 
	public static void testeDjikstra_Professor(){
   
		//SIMULANDO GRAFO DA AULA GRAVADA ==> https://youtu.be/jTH4eHf-lik?t=1467
		//TESTE DO ALGORITMO DE DIJKSTRA >> OK
		
		Digrafo d1 = new Digrafo(6);

		d1.setNovoArco(0, 3, 2);
		d1.setNovoArco(0, 4, 4);
		d1.setNovoArco(0, 2, 7);
		d1.setNovoArco(1, 2, 0);
		d1.setNovoArco(2, 4, 1);
		d1.setNovoArco(3, 5, 3);
		d1.setNovoArco(3, 4, 1);
		d1.setNovoArco(4, 5, 1);
		d1.setNovoArco(4, 1, 4);
		d1.setNovoArco(5, 1, 2);

		d1.imprimirDigrafo();

		//	Encontra caminho minino com DIJKSTRA
		Dijkstra dij = new Dijkstra(d1, 0);

	}





 /*
 
	public static void testeBellmanFord_Professor(){
   
		//SIMULANDO GRAFO DA AULA GRAVADA ==> https://youtu.be/lId3K8TI8aY?t=1192
		//TESTE DO ALGORITMO DE BELLMAN_FORD
		
		Digrafo d1 = new Digrafo("Digrafo 1",8);
   
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




*/



}