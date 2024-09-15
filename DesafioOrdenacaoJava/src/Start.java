import java.io.File;
import java.util.Scanner;

import Algoritmos.*;
import Utils.Handlers.FileHandler;

public class Start {

    public static void startAplicacao() {

        //! Instancia o Scanner
        Scanner scanner = new Scanner(System.in);

        //! Instancia os algoritmos de ordenação
        Bubble bubble = new Bubble();
        Heap heap = new Heap();
        Insertion insertion = new Insertion();
        Merge merge = new Merge();
        Quick quick = new Quick();
        Selection selection = new Selection();

        //! Quantidade de execuções
        int quantidadeDeExecucoes = 6;
        
        for(int execucao = 1 ; execucao <= quantidadeDeExecucoes ; execucao++) {
            
            int quantidadeDeNumeros = 100000;
            int incrementoQuantidadeDeNumeros = 60000;
            int paradaQuantidadeDeNumeros = 700000;

            String tipoCriacao = "";

            //! Cria o subtítulo da execução
            if(execucao == 1)
                tipoCriacao = ": Crescente com repetição";
            if(execucao == 2)
                tipoCriacao = ": Decrescente com repetição";
            if(execucao == 3)
                tipoCriacao = ": Aleatório com repetição";
            if(execucao == 4)
                tipoCriacao = ": Crescente sem repetição";
            if(execucao == 5)
                tipoCriacao = ": Decrescente sem repetição";
            if(execucao == 6)
                tipoCriacao = ": Aleatório sem repetição";

            //! Título da execução
            System.out.println();
            System.out.println();
            System.out.println("##################################################################################");
            System.out.println();
            System.out.println("                           EXECUÇÃO " + execucao + tipoCriacao);
            System.out.println();
            System.out.println("##################################################################################");
            System.out.println();
            System.out.println();

            //! Faz todas as baterias enquanto não atingir sua quantidade de números limite
            for(int bateria = 1 ; quantidadeDeNumeros <= paradaQuantidadeDeNumeros ; bateria++) {
    
                String pathExecucao = getPath(execucao);               
                String path = adicionaBateriaPath(pathExecucao, bateria);
                
                //! Cria o diretório da bateria caso não exista
                File diretorioBateria = new File(path);
                if (!diretorioBateria.exists())
                    diretorioBateria.mkdirs();

                //! Variáveis de path referente aos requisitos
                String caminhoDeEntrada = path + "numerosParaOrdenar.csv";   
                String caminhoDeSaidaBubble = path + "bubbleSort.csv";
                String caminhoDeSaidaHeap = path + "heapSort.csv";
                String caminhoDeSaidaInsertion = path + "insertionSort.csv";
                String caminhoDeSaidaMerge = path + "mergeSort.csv";
                String caminhoDeSaidaQuick = path + "quickSort.csv";
                String caminhoDeSaidaSelection = path + "selectionSort.csv";

                //! Cria os arquivos com os números a serem ordenados
                if(execucao == 1) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoCrescenteComRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }
                
                if(execucao == 2) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoDecrescenteComRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }
                
                if(execucao == 3) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoAleatorioComRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }
                
                if(execucao == 4) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoCrescenteSemRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }
                
                if(execucao == 5) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoDecrescenteSemRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }
                
                if(execucao == 6) {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    FileHandler.gerarArquivoAleatorioSemRepeticao(caminhoDeEntrada, quantidadeDeNumeros);
                }

                //! Título da bateria
                System.out.println("##################################################################################");
                System.out.println();
                System.out.println("                               Bateria " + bateria + ": " + quantidadeDeNumeros);
                System.out.println();
                System.out.println("##################################################################################");

                //! Roda os scripts de cronometrar
                for(int c = 0 ; c < 6 ; c++) {
                    
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    
                    //! Cronometra e exibe o tempo de execução do Bubble Sort
                    if(c == 0) {
                        long tempoExecucaoBubble = bubble.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaBubble);
                        System.out.println("Tempo de execução Bubble -> " + tempoExecucaoBubble + " Milissegundos");
                    }
                    
                    //! Cronometra e exibe o tempo de execução do Heap Sort
                    if(c == 1) {
                        long tempoExecucaoHeap = heap.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaHeap);
                        System.out.println("Tempo de execução Heap -> " + tempoExecucaoHeap + " Milissegundos");
                    }
                    
                    //! Cronometra e exibe o tempo de execução do Insertion Sort
                    if(c == 2) {
                        long tempoExecucaoInsertion = insertion.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaInsertion);
                        System.out.println("Tempo de execução Insertion -> " + tempoExecucaoInsertion + " Milissegundos");
                    }
                    
                    //! Cronometra e exibe o tempo de execução do Merge Sort
                    if(c == 3) {
                        long tempoExecucaoMerge = merge.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaMerge);
                        System.out.println("Tempo de execução Merge -> " + tempoExecucaoMerge + " Milissegundos");
                    }
                    
                    //! Cronometra e exibe o tempo de execução do Quick Sort
                    if(c == 4) {
                        long tempoExecucaoQuick = quick.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaQuick);
                        System.out.println("Tempo de execução Quick -> " + tempoExecucaoQuick + " Milissegundos");
                    }
                    
                    //! Cronometra e exibe o tempo de execução Selection Sort
                    if(c == 5) {
                        long tempoExecucaoSelection = selection.cronometrar(quantidadeDeNumeros, caminhoDeEntrada, caminhoDeSaidaSelection);
                        System.out.println("Tempo de execução Selection -> " + tempoExecucaoSelection + " Milissegundos");
                    }
                }
                
                //! Incremento do intervalo pedido
                quantidadeDeNumeros += incrementoQuantidadeDeNumeros;

                //! Exibe o fim da bateria e espera o gatilho do teclado
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println();
                System.out.println("Bateria " + bateria + " concluída, aperte ENTER para continuar");
                scanner.nextLine();
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
            
            //! Exibe o final do programa
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println();
            System.out.println("                             Baterias finalizadas!!");
            System.out.println();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            
            //! Exibe o fim da bateria e espera o gatilho do teclado
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println();
            System.out.println("EXECUÇÃO " + execucao + " concluída, aperte ENTER para continuar");
            scanner.nextLine();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }

        //! Exibe o final do programa
        System.out.println();
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println();
        System.out.println("                             EXECUÇÕES finalizadas!!");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println();
        System.out.println();

        //! Fecha o Scanner
        scanner.close();
    }


    //! Retorna o caminho para salvar os arquivos de determinada execucao
    public static String getPath(int execucao) {

        if(execucao == 1)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-CrescenteComRepeticao/";
        if(execucao == 2)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-DecrescenteComRepeticao/";
        if(execucao == 3)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-AleatorioComRepeticao/";
        if(execucao == 4)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-CrescenteSemRepeticao/";
        if(execucao == 5)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-DecrescenteSemRepeticao/";
        if(execucao == 6)
            return "DesafioOrdenacaoJava/src/Utils/Files/" + execucao + "-AleatorioSemRepeticao/";
        
        return "DesafioOrdenacaoJava/src/Utils/Files/ERROR"; 
    }

    //! Retorna o caminho para salvar os arquivos de determinada bateria
    public static String adicionaBateriaPath(String pathExecucao, int bateria) {
        return pathExecucao + bateria + "-Bateria/";
    }
}
