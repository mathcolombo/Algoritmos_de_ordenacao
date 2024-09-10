package Algoritmos;

public class Bubble extends AlgoritmoOrdenacao {

    @Override
    public int[] sort(int[] vetor) {
        for (int c = 0; c < vetor.length; c++) {
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    // Troca os elementos
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                }
            }
        }
        return vetor;
    }
}
