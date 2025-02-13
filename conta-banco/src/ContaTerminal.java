import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ContaTerminal {
    public static void main(String[] args) {

        double saldo = 237.48;

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {

            // Exibir as mensagens para o usuário
            System.out.println("Olá, seja bem-vindo(a) ao Banco DaniDigital, insira seu nome para prosseguir!");
            String nome = scanner.nextLine();

            System.out.println("Por favor, digite o número da Agência:");
            String agencia = scanner.nextLine();
            int conta = 0;
            boolean validConta = false;

            // Solicitar número da conta até o usuário fornecer um valor válido
            while (!validConta) {
                try {
                    System.out.println("Por favor, digite o número da sua Conta:");
                    conta = scanner.nextInt();
                    validConta = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ocorreu um erro, digite um número válido para conta.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();

            // Exibir mensagem de conta criada
            System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco!\n" +
                    "Sua agência é: " + agencia + ", número da Conta Corrente: " + conta);

                    
            // O usuário deve digitar "saldo" para consultar o saldo da conta
            String comando;
            do {
                System.out.println("Se você deseja consultar o saldo, digite 'saldo'.");
                comando = scanner.nextLine();

                // Verificar se o comando digitado é "saldo"
                if (comando.equalsIgnoreCase("saldo")) {
                    System.out.printf("O seu saldo é de R$: %.2f e já está disponível para saque!%n", saldo);
                } else {
                    System.out.println("OPS, ocorreu um erro! Digite 'SALDO' para consultar o valor disponível.");
                }

            } while (!comando.equalsIgnoreCase("saldo"));

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do programa: " + e.getMessage());
        }
    }
}
