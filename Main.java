class Main {

	public static void main(String[] args) {

		System.out.println("*********  INICIANDO SIMULACAO  ************");
		int tam = 10000;

		// Loop para simular diferentes tamanhos entradas
		while (tam <= 500000) {

			System.out.print("\n---- Tamanho Esperado:\t" + tam + " - Densidade: ");

			// Loop para simular diferentes probabilidades/densidades
			for (double prob = 1; prob < 10; prob++) {

				double probabilidade = prob / 10;
				System.out.print((int) (probabilidade * 100) + " %, ");

				try {
					Simulacao simula = new Simulacao(tam, probabilidade, 100); // Variar custo maximo?
				} catch (Exception e) {
					System.out.println(" !!! Erro na simulacao !!!");
					e.printStackTrace();
					return;
				}

			}

			System.out.println();
			if (tam <= 40000)
				tam += 10000;
			else if (tam <= 90000)
				tam += 50000;
			else
				tam += 100000;

		}

		System.out.println("\n\n**********  SIMULACAO FINALIZADA  ********");

	}

}