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

        //! Quantidade inicial de números a serem ordenados
        int quantidadeDeNumeros = 100000;

        //! Faz todas as baterias enquanto não atingir sua quantidade de números limite
        for(int bateria = 1 ; quantidadeDeNumeros <= 700000 ; bateria++) {

            //! Título da bateria
            System.out.println("##################################################################################");
            System.out.println();
            System.out.println("                                 Bateria " + bateria);
            System.out.println();
            System.out.println("##################################################################################");

            //! Incremento do intervalo pedido
            quantidadeDeNumeros += 60000;
            
            //! Variáveis de path referente aos requisitos
            String path = getPath(bateria);

            String caminhoDeEntrada = path + "numerosAleatorios.csv";
            String caminhoDeSaidaBubble = path + "bubbleSort.csv";
            String caminhoDeSaidaHeap = path + "heapSort.csv";
            String caminhoDeSaidaInsertion = path + "insertionSort.csv";
            String caminhoDeSaidaMerge = path + "mergeSort.csv";
            String caminhoDeSaidaQuick = path + "quickSort.csv";
            String caminhoDeSaidaSelection = path + "selectionSort.csv";
            
            //! Verifica se o diretório ja existe, caso não exista o cria
            File diretorio = new File(path);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            //! Gera o arquivo com números aleatórios
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            FileHandler.gerarArquivoComNumerosAleatorios(caminhoDeEntrada, quantidadeDeNumeros);

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
        System.out.println("                           Baterias finalizadas!!");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        //! Fecha o Scanner
        scanner.close();
    }

    //! Retorna o caminho para salvar os arquivos de determinada bateria
    public static String getPath(int bateria) {
        return "DesafioOrdenacaoJava/src/Utils/Files/" + bateria + "-Bateria/";
    }
}
