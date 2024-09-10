package Algoritmos;

public class Selection extends AlgoritmoOrdenacao {

    @Override
    public int[] sort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            int menor = i;

            for (int j = i; j < vetor.length; j++) {
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                }
            }

            // Troca os elementos
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }

        return vetor;
    }
}
