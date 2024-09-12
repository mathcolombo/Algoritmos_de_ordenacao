package Algoritmos;

import Utils.Handlers.FileHandler;

public class AlgoritmoOrdenacao {

    //! Cronometra o tempo do ciclo de captura dos dados, ordenação e escrita dos dados
    public long cronometrar(int quantidadeDeNumeros, String caminhoDeEntrada, String caminhoDeSaida) {
        int[] vetor = FileHandler.arquivoToArray(caminhoDeEntrada, quantidadeDeNumeros);

        long inicio = System.currentTimeMillis(); //! Inicia o cronômetro
        int[] vetorOrdenado = sort(vetor); //! Ordena o vetor
        long tempoExecucao = System.currentTimeMillis() - inicio; //! Para o cronômetro

        FileHandler.arrayToArquivo(caminhoDeSaida, vetorOrdenado);
        return tempoExecucao;
    }

    //! Algoritmo de ordenação (deve ser sobrescrito para implementar a ordenação)
    public int[] sort(int[] vetor) {
        return vetor;
    }
}
