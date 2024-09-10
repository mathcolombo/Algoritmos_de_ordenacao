package Algoritmos;

public class Insertion extends AlgoritmoOrdenacao {

    @Override
    public int[] sort(int[] vetor) {
        for (int i = vetor.length - 2; i >= 0; i--) {
            int x = vetor[i];
            int j = i + 1;

            while (j < vetor.length && vetor[j] < x) {
                vetor[j - 1] = vetor[j];
                j++;
            }
            vetor[j - 1] = x;
        }

        return vetor;
    }
}
