namespace DesafioOrdenacao.Algoritmos;

public class Insertion : AlgoritmoOrdenacao
{
    public override int[] Sort(int[] vetor)
    {
        for (int i = vetor.Length - 2; i >= 0; i--) {
            int x = vetor[i];
            int j = i + 1;

            while (j < vetor.Length && vetor[j] < x) {
                vetor[j - 1] = vetor[j];
                j++;
            }
            vetor[j - 1] = x;
        }

        return vetor;
    }
}
