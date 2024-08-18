namespace DesafioOrdenacao.Algoritmos;

public class Quick : AlgoritmoOrdenacao
{
    private static int Particiona(int[] vetor, int esq, int dir)
    {
        int pivo = vetor[esq];
        int i = esq;

        for (int j = 1; j < vetor.Length; j++) {

            if (vetor[j] <= pivo) {
                i++;
                (vetor[i], vetor[j]) = (vetor[j], vetor[i]);
            }
        }
        (vetor[i], vetor[esq]) = (vetor[esq], vetor[i]);

        return i;
    }

    private static void Quicksort(int[] vetor, int esq, int dir) {
        
        if (esq < dir) {
            int indicePivo = Particiona(vetor, esq, dir);
            Quicksort(vetor, esq, indicePivo);
            Quicksort(vetor, indicePivo + 1, dir);
        }
    }

    public override int[] Sort(int[] vetor) {
        Quicksort(vetor, 0, vetor.Length);
        return vetor;
    }
}
