package Utils.Handlers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FileHandler {

    //! Repetição a cada repeticao números
    private final static int repeticao = 500;

    //? COM REPETIÇÃO

    //! Cria um novo arquivo com números crescentes com repetição
    public static void gerarArquivoCrescenteComRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {

            for (int i = 0; i < quantidadeDeNumeros; i++) {
                writer.write(Integer.toString(i / repeticao));
                writer.newLine();
            }

            System.out.println("Arquivo crescente com repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um novo arquivo com números decrescentes com repetição
    public static void gerarArquivoDecrescenteComRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {

            for (int i = quantidadeDeNumeros; i > 0; i--) {
                writer.write(Integer.toString(i / repeticao));
                writer.newLine();
            }

            System.out.println("Arquivo decrescente com repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um novo arquivo com números aleatórios com repetição
    public static void gerarArquivoAleatorioComRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {
        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {
            
            Random rand = new Random();

            for (int c = 0; c < quantidadeDeNumeros; c++) {
                escritor.write(Integer.toString(rand.nextInt(quantidadeDeNumeros / repeticao)));
                escritor.newLine();
            }

            System.out.println("Arquivo aleatório com repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //? SEM REPETIÇÃO

    //! Cria um novo arquivo com números crescentes sem repetição
    public static void gerarArquivoCrescenteSemRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {

            for (int i = 0; i < quantidadeDeNumeros; i++) {
                escritor.write(Integer.toString(i));
                escritor.newLine();
            }

            System.out.println("Arquivo crescente sem repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um novo arquivo com números decrescentes sem repetição
    public static void gerarArquivoDecrescenteSemRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {

            for (int i = quantidadeDeNumeros; i > 0; i--) {
                escritor.write(Integer.toString(i));
                escritor.newLine();
            }

            System.out.println("Arquivo decrescente sem repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Cria um novo arquivo com números aleatórios sem repetição
    public static void gerarArquivoAleatorioSemRepeticao(String caminhoNovoArquivo, int quantidadeDeNumeros) {

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros); // Embaralha os números para serem aleatórios

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoNovoArquivo))) {

            for (int numero : numeros) {
                escritor.write(Integer.toString(numero));
                escritor.newLine();
            }

            System.out.println("Arquivo aleatório sem repetição gerado!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //? CONVERTE DADOS

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
