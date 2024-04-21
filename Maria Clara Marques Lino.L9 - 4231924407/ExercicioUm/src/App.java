import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util
import java.util.InputMismatchException;  // Importa a classe InputMismatchException do pacote java.util
import java.util.List;  // Importa a interface List do pacote java.util
import java.util.Scanner;  // Importa a classe Scanner do pacote java.util

public class App {  // Declaração da classe App

    public static void main(String[] args) throws Exception {  // Declaração do método main que pode lançar uma exceção
        Scanner sc = new Scanner(System.in);  // Cria um objeto Scanner para ler a entrada do usuário
        List<Pais> paises = new ArrayList<>();  // Cria uma lista vazia para armazenar objetos da classe Fifa
        int option = 0;  // Declara e inicializa a variável option com o valor 0

        do {  // Início do loop do-while
            try {  // Início do bloco try para tratar exceções
                System.out.println("Digite a opção desejada:");  // Exibe uma mensagem para o usuário
                System.out.println("[1] Ordenar por Ordem Alfabética");  // Exibe as opções disponíveis
                System.out.println("[2] Ordenar por audiência TV");
                System.out.println("[3] Encerrar");
                option = sc.nextInt();  // Lê a opção escolhida pelo usuário e armazena na variável option
                
                switch (option) {  // Início da estrutura switch para executar código com base no valor da variável option
                    case 1:  // Se a opção for 1
                        Pais.sortCountryes(paises);  // Chama o método estático sortCountryes da classe Fifa
                        break;  // Sai do switch
                    case 2:  // Se a opção for 2
                        Pais.sortAudience(paises);  // Chama o método estático sortAudience da classe Fifa
                        break;  // Sai do switch
                    case 3:  // Se a opção for 3
                        System.out.println("Programa Encerrado.");  // Exibe uma mensagem
                        System.exit(0);  // Encerra o programa
                        break;  // Sai do switch
                    default:  // Para qualquer outra opção
                        System.out.println("Opção invalida. Informe uma opção valida:");  // Exibe uma mensagem de erro
                }  // Fim da estrutura switch

            } catch (InputMismatchException e) {  // Captura a exceção InputMismatchException
                System.out.println("Opção inválida. Insira um número inteiro");  // Exibe uma mensagem de erro
                sc.nextLine();  // Limpa o buffer do Scanner
            }  // Fim do bloco try-catch

        } while (option != 1 && option != 2 && option != 3);  // Continua o loop do-while enquanto a option não for 1, 2 ou 3

        sc.close();  // Fecha o objeto Scanner
    }  // Fim do método main

}  // Fim da classe App
