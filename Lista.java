// Implementa uma lista baseada num vetor, com uso de tipos genericos

public class Lista <Tipo> {

    private Tipo[] dados;
    private int qtdAtual;

    @SuppressWarnings("unchecked")
    public Lista(){

        dados = (Tipo []) new Object[1000];     //Valor a definir
        qtdAtual = 0;

    }


    public void inserir(Tipo objeto){

        // Valida o tamanho utilizado para determinar
        // se é necessário aumentar a alocação de memória

        if (qtdAtual > dados.length * 0.5){    //Valor a definir
            aumentarTamanhoMemoria();
        }

        dados[qtdAtual] = objeto;
        qtdAtual++;       

		System.out.println(objeto + "  - Quantidade atualizada: " + qtdAtual);

    }



    public Tipo retirarPrimeiroLista(){

        Tipo t = dados[0];

        for (int i = 0; i < dados.length; i++){
            dados[i] = dados[i+1];
        }

        qtdAtual--;

        return t;
    }



    public Tipo retirarUltimoLista(){

        Tipo t = dados[qtdAtual];
        qtdAtual--;
        
        return t;

    }


    public Tipo getPelaPosicao(int posicao){
        
        if (posicao < qtdAtual)
            return dados[posicao];
        else{
            System.out.println("Poiscao invalida: " + posicao + "\tQtd Atual: " + qtdAtual);
            return null;
        }

    }


    public int getQuantidadeItensLista(){
        return qtdAtual;
    }


    @SuppressWarnings("unchecked")
    private void aumentarTamanhoMemoria(){

        int tamanhoAtual = dados.length;
        int novoTamanho = tamanhoAtual + 1000;      //Valor a definir

        Tipo[] novosDados = (Tipo[]) new Object[novoTamanho];

        //Copia os valores
        for(int i = 0; i < qtdAtual; i++)
            novosDados[i] = dados[i];

        //Atualiza o endereco principal
        dados = novosDados;        

    }
    
}
