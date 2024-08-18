namespace DesafioOrdenacao.Handlers;

public class FileHandler
{
    //! Cria um novo arquivo com a quantidade de números passados
    public static void GerarArquivoComNumerosAleatorios(string caminhoNovoArquivo, int quantidadeDeNumeros)
    {
        using(var fluxoDoArquivo = new FileStream(caminhoNovoArquivo, FileMode.Create))
        using(var escritor = new StreamWriter(fluxoDoArquivo))
        {
            Random rand = new();
            
            for(int c = 0 ; c < quantidadeDeNumeros ; c++)
            {
                escritor.WriteLine(rand.Next(quantidadeDeNumeros));
            }
            Console.WriteLine($"Arquivo gerado");
        }
    }

    //! Cria um arquivo com os dados do vetor
    public static void ArrayToArquivo(string caminhoNovoArquivo, int[] vetor)
    {
        using(var fluxoDoArquivo = new FileStream(caminhoNovoArquivo, FileMode.Create))
        using(var escritor = new StreamWriter(fluxoDoArquivo))
        {
            for(int c = 0 ; c < vetor.Length ; c++)
            {
                escritor.WriteLine(vetor[c]);
            }
            Console.WriteLine($"Array convertido em arquivo!");
        }
    }

    //! Cria um array com os dados do arquivo
    public static int[] ArquivoToArray(string caminhoArquivo, int tamanhoVetor)
    {
        int[] vetor = new int[tamanhoVetor];

        using (var fluxoDoArquivo = new FileStream(caminhoArquivo, FileMode.Open))
        {
            var leitor = new StreamReader(fluxoDoArquivo);
            int c = 0;

            while (!leitor.EndOfStream)
            {
                vetor[c] = int.Parse(leitor.ReadLine()!);
                c++;
            }
            Console.WriteLine($"Arquivo convertido em array!");
        }

        return vetor;
    }
}
