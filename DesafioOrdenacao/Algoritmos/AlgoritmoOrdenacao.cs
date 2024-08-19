using System.Diagnostics;
using DesafioOrdenacao.Handlers;

namespace DesafioOrdenacao.Algoritmos;

public abstract class AlgoritmoOrdenacao
{
    //! Cronometra o tempo do ciclo de captura dos dados, ordenação e escrita dos dados
    public long Cronometrar(int quantidadeDeNumeros, string caminhoDeEntrada, string caminhoDeSaida)
    {
        Stopwatch cronometro = new();

        cronometro.Start();
        EscreverArquivoPosOrdenacao(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaida);
        cronometro.Stop();

        return cronometro.ElapsedMilliseconds; 
    }

    //! Transforma o arquivo em um array e o array ordenado em um arquivo
    private void EscreverArquivoPosOrdenacao(int quantidadeDeNumeros, string caminhoDeEntrada, string caminhoDeSaida)
    {
        int[] vetor = FileHandler.ArquivoToArray(caminhoDeEntrada, quantidadeDeNumeros);
        FileHandler.ArrayToArquivo(caminhoDeSaida, Sort(vetor));
    } 

    //! Algoritmo de ordenação
    public virtual int[] Sort(int[] vetor)
    {
        return vetor;
    }
}
