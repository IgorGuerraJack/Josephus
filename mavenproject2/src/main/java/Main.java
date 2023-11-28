import java.util.*;

public class Main {
    static class Pessoa {
        int numero;
        String nome;
        String cpf;
        String telefone;
        String endereco;

        public Pessoa(int numero, String nome, String cpf, String telefone, String endereco) {
            this.numero = numero;
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return "Número: " + numero + ", Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone + ", Endereço: " + endereco;
        }
    }

    static int problemaJosephus(List<Pessoa> pessoas, int k) {
        int n = pessoas.size();
        int indice = 0;

        Random aleatorio = new Random();

        while (n > 1) {

            indice = (indice + aleatorio.nextInt(k - 1) + 1) % n;

            pessoas.remove(indice);
            n -= 1;
        }

        return pessoas.get(0).numero;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> listaPessoas = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            listaPessoas.add(new Pessoa(i, "Nome" + i, gerarCPF(), gerarTelefone(), gerarEndereco()));
        }

        System.out.println("Informe o valor de k: ");
        int k = sc.nextInt();

        int numeroSobrevivente = problemaJosephus(new ArrayList<>(listaPessoas), k);
        System.out.println("O número da pessoa sobrevivente é: " + numeroSobrevivente);

        Pessoa sobrevivente = listaPessoas.stream().filter(p -> p.numero == numeroSobrevivente).findFirst().orElse(null);
        if (sobrevivente != null) {
            System.out.println("Informações da pessoa sobrevivente:");
            System.out.println(sobrevivente);
        }
    }

   private static String gerarCPF() {
    Random aleatorio = new Random();
    int num1 = aleatorio.nextInt(10);
    int num2 = aleatorio.nextInt(10);
    int num3 = aleatorio.nextInt(10);
    int num4 = aleatorio.nextInt(10);
    int num5 = aleatorio.nextInt(10);
    int num6 = aleatorio.nextInt(10);
    int num7 = aleatorio.nextInt(10);
    int num8 = aleatorio.nextInt(10);
    int num9 = aleatorio.nextInt(10);

    return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", num1, num2, num3, num4, num5, num6, num7, num8, num9, aleatorio.nextInt(10), aleatorio.nextInt(10));
}

private static String gerarTelefone() {
    Random aleatorio = new Random();
    int num1 = aleatorio.nextInt(10);
    int num2 = aleatorio.nextInt(10);
    int num3 = aleatorio.nextInt(10);
    int num4 = aleatorio.nextInt(10);
    int num5 = aleatorio.nextInt(10);
    int num6 = aleatorio.nextInt(10);
    int num7 = aleatorio.nextInt(10);
    int num8 = aleatorio.nextInt(10);

    return String.format("(%d%d) 9%d%d%d%d-%d%d%d%d", num1, num2, num3, num4, num5, num6, num7, num8, aleatorio.nextInt(10), aleatorio.nextInt(10));
}

private static String gerarEndereco() {
    Random aleatorio = new Random();
    int num1 = aleatorio.nextInt(10);
    int num2 = aleatorio.nextInt(10);
    int num3 = aleatorio.nextInt(10);
    int num4 = aleatorio.nextInt(10);
    int num5 = aleatorio.nextInt(10);
    int num6 = aleatorio.nextInt(10);
    int num7 = aleatorio.nextInt(10);
    int num8 = aleatorio.nextInt(10);
    int num9 = aleatorio.nextInt(10);

    return String.format("Rua %d%d%d%d%d Nº %d%d%d", num1, num2, num3, num4, num5, num6, num7, num8, num9);
}
}