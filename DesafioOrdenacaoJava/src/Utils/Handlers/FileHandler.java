package Utils.Handlers;

import java.io.*;
import java.util.Random;

public class FileHandler {

    //! Cria um novo arquivo com a quantidade de números informada
    public static void gerarArquivoComNumerosAleatorios(String caminhoNovoArquivo, int quantidadeDeNumeros) {
        
        try (FileOutputStream fluxoDoArquivo = new FileOutputStream(caminhoNovoArquivo);
             BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(fluxoDoArquivo))) {
            
            Random rand = new Random();

            for (int c = 0; c < quantidadeDeNumeros; c++) {
                escritor.write(Integer.toString(rand.nextInt(quantidadeDeNumeros)));
                escritor.newLine();
            }

            System.out.println("Arquivo gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um arquivo com os dados de um array
    public static void arrayToArquivo(String caminhoNovoArquivo, int[] vetor) {

        try (FileOutputStream fluxoDoArquivo = new FileOutputStream(caminhoNovoArquivo);
             BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(fluxoDoArquivo))) {
            
            for (int valor : vetor) {
                escritor.write(Integer.toString(valor));
                escritor.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um array com os dados de um arquivo
    public static int[] arquivoToArray(String caminhoArquivo, int tamanhoVetor) {

        int[] vetor = new int[tamanhoVetor];

        try (FileInputStream fluxoDoArquivo = new FileInputStream(caminhoArquivo);
             BufferedReader leitor = new BufferedReader(new InputStreamReader(fluxoDoArquivo))) {
            
            String linha;
            int c = 0;

            while ((linha = leitor.readLine()) != null && c < tamanhoVetor) {
                vetor[c] = Integer.parseInt(linha);
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return vetor;
    }
}
