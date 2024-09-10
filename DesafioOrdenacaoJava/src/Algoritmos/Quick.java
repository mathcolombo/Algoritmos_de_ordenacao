package Algoritmos;

public class Quick extends AlgoritmoOrdenacao {

    private static int particiona(int[] vetor, int esq, int dir) {
        int pivo = vetor[esq];
        int i = esq;

        for (int j = esq + 1; j < dir; j++) {
            if (vetor[j] <= pivo) {
                i++;
                // Troca os elementos
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        // Troca o pivô para sua posição correta
        int temp = vetor[i];
        vetor[i] = vetor[esq];
        vetor[esq] = temp;

        return i;
    }

    private static void quicksort(int[] vetor, int esq, int dir) {
        if (esq < dir - 1) { // Precisa ser "dir - 1" para evitar estouro de pilha
            int indicePivo = particiona(vetor, esq, dir);
            quicksort(vetor, esq, indicePivo);
            quicksort(vetor, indicePivo + 1, dir);
        }
    }

    @Override
    public int[] sort(int[] vetor) {
        quicksort(vetor, 0, vetor.length);
        return vetor;
    }
}
