namespace DesafioOrdenacao.Algoritmos;

public class Bubble : AlgoritmoOrdenacao
{

    public override int[] Sort(int[] vetor)
    {
        for(int c = 0 ; c < vetor.Length ; c++)
        {
            for(int i = 0 ; i < vetor.Length - 1 ; i++)
            {
                if(vetor[i] > vetor[i+1])
                {
                    (vetor[i], vetor[i+1]) = (vetor[i+1], vetor[i]);
                }
            }
        }

        return vetor;
    }
}
