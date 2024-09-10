package Algoritmos;

public class Heap extends AlgoritmoOrdenacao {

    @Override
    public int[] sort(int[] vetor) {
        int n = vetor.length;

        // Constrói o heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vetor, n, i);
        }

        // Extrai um por um os elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            // Chama heapify na árvore reduzida
            heapify(vetor, i, 0);
        }

        return vetor;
    }

    // Para reorganizar o heap
    private void heapify(int[] vetor, int n, int i) {
        int maior = i; // Inicializa maior como raiz
        int esquerda = 2 * i + 1; // Filho esquerdo
        int direita = 2 * i + 2;  // Filho direito

        // Se o filho da esquerda for maior que a raiz
        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        // Se o filho da direita for maior que o maior até agora
        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        // Se o maior não for a raiz
        if (maior != i) {
            int temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            // Recursivamente organiza o sub-árvore afetado
            heapify(vetor, n, maior);
        }
    }
}
