using DesafioOrdenacao.Handlers;
using DesafioOrdenacao.Algoritmos;
public class Program
{

    public static void Main(string[] args)
    {
        Bubble bubble = new();
        FileHandler.GerarArquivoComNumerosAleatorios("Files/teste.csv", 100000);
        Console.WriteLine($"Tempo de execução -> {bubble.Cronometrar(100000, "Files/teste.csv", "Files/bubbleSort.csv")} Milisegundos");
    }

    private static void Menu()
    {
        
    }
}