import java.util.Scanner;

public class ContaTerminal {

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    String cliente;
    int agencia = 1;
    int conta = 10;
    double saldo;

    System.out.println("Iniciando crianção de conta...");
    Thread.sleep(2000);

    System.out.println("Qual é o seu nome?");
    cliente = scan.next();
    System.out.println("Qual é o saldo que você deseja inserir na conta?");
    while (true) {
      try {
        saldo = Double.parseDouble(scan.next());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Use um valor numérico.");
      }
    }

    System.out.println(cliente + ", o número da sua conta é " + saldo + ".");
    System.out.println("E sua agência é " + agencia + ".");

    System.out.printf(
        "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %.2f já está disponível para saque.",
        cliente, agencia, conta, saldo);
  }
}
