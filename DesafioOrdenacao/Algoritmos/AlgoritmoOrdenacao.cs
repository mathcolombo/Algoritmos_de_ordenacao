using System.Diagnostics;
using DesafioOrdenacao.Handlers;

namespace DesafioOrdenacao.Algoritmos;

public class AlgoritmoOrdenacao
{
    //! Cronometra o tempo do ciclo de captura dos dados, ordenação e escrita dos dados
    public long Cronometrar(int quantidadeDeNumeros, string caminhoDeEntrada, string caminhoDeSaida)
    {
        int[] vetor = FileHandler.ArquivoToArray(caminhoDeEntrada, quantidadeDeNumeros);
        Stopwatch cronometro = new();

        cronometro.Start();
        int[] vetorOrdenado = Sort(vetor);
        cronometro.Stop();

        FileHandler.ArrayToArquivo(caminhoDeSaida, vetorOrdenado);
        return cronometro.ElapsedMilliseconds; 
    }    

    //! Algoritmo de ordenação
    public virtual int[] Sort(int[] vetor)
    {
        return vetor;
    }
}
