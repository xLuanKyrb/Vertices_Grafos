import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valor;

      do {
          System.out.println("Atividade de Grafos");

        System.out.println("""
                1 - Atividade de Rede Completa
                2 - Teste sobre o Grafo
                0 - Sair
                """);
        valor = scanner.nextInt();

        switch (valor){
            case 1 :
                RedeInternet.main(args);
                break;

            case 2 :
                RedeSocialGrafo.main(args);
                break;

            case 0:
                System.out.println("Encerrando o Sistema");
                break;

            default:
                System.out.println("Opção Invalida");
        }
    } while (valor != 0);

      scanner.close();
}
}