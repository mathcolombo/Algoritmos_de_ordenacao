using DesafioOrdenacao.Handlers;
using DesafioOrdenacao.Algoritmos;
public class Program
{

    public static void Main(string[] args)
    {
        int quantidadeDeNumeros = 50000;
        string caminhoDeEntrada = "Files/teste.csv";
        
        Bubble bubble = new();
        
        FileHandler.GerarArquivoComNumerosAleatorios("Files/teste.csv", quantidadeDeNumeros);
        Console.WriteLine($"Tempo de execução -> {bubble.Cronometrar(quantidadeDeNumeros, caminhoDeEntrada, "Files/bubbleSort.csv")} Milisegundos");
    }
}