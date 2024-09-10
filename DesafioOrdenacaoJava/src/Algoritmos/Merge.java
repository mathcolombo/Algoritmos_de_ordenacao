package Algoritmos;

public class Merge extends AlgoritmoOrdenacao {

    @Override
    public int[] sort(int[] vetor) {
        if (vetor.length < 2) {
            return vetor;
        }

        int meio = vetor.length / 2;
        int[] esquerdo = new int[meio];
        int[] direito = new int[vetor.length - meio];

        System.arraycopy(vetor, 0, esquerdo, 0, meio);
        System.arraycopy(vetor, meio, direito, 0, vetor.length - meio);

        sort(esquerdo);
        sort(direito);

        return merge(vetor, esquerdo, direito);
    }

    private int[] merge(int[] vetor, int[] esquerdo, int[] direito) {
        int i = 0, j = 0, k = 0;

        while (i < esquerdo.length && j < direito.length) {
            if (esquerdo[i] <= direito[j]) {
                vetor[k++] = esquerdo[i++];
            } else {
                vetor[k++] = direito[j++];
            }
        }

        while (i < esquerdo.length) {
            vetor[k++] = esquerdo[i++];
        }

        while (j < direito.length) {
            vetor[k++] = direito[j++];
        }

        return vetor;
    }
}
