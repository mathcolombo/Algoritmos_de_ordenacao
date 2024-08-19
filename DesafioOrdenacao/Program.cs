using DesafioOrdenacao.Handlers;
using DesafioOrdenacao.Algoritmos;
public class Program
{

    public static void Main(string[] args)
    {
        int quantidadeDeNumeros = 500000;
        Bubble bubble = new();
        FileHandler.GerarArquivoComNumerosAleatorios("Files/teste.csv", quantidadeDeNumeros);
        Console.WriteLine($"Tempo de execução -> {bubble.Cronometrar(quantidadeDeNumeros, "Files/teste.csv", "Files/bubbleSort.csv")} Milisegundos");
    }
}