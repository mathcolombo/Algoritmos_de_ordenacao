namespace DesafioOrdenacao.Algoritmos;

public class Selection : AlgoritmoOrdenacao
{
    public override int[] Sort(int[] vetor)
    {
        for (int i = 0; i < vetor.Length; i++) {
            int menor = i;

            for (int j = i; j < vetor.Length; j++) {
                if (vetor[menor] > vetor[j]) menor = j;
            }

            (vetor[i], vetor[menor]) = (vetor[menor], vetor[i]);
        }
        
        return vetor;
    }
}
