import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        HashMap<String, Cliente> clientes = new HashMap<>();
        ArrayList<ItemCarrinho> carrinho = new ArrayList<>();

        produtos.add(new Produto("Shampoo Hidratante", "Shampoos", 15.90));
        produtos.add(new Produto("Shampoo Anti-Caspa", "Shampoos", 18.50));
        produtos.add(new Produto("Sabonete Líquido Lavanda", "Sabonetes", 12.30));
        produtos.add(new Produto("Difusor Aromático Citrus", "Difusores Aromáticos", 8.90));
        produtos.add(new Produto("Sabonete Esfoliante", "Sabonetes", 25.00));
        produtos.add(new Produto("Perfume Floral 100ml", "Perfumes", 35.90));
        produtos.add(new Produto("Shampoo Nutritivo", "Shampoos", 22.70));
        produtos.add(new Produto("Perfume Masculino 50ml", "Perfumes", 89.90));
        produtos.add(new Produto("Sabonete Natural Mel", "Sabonetes", 14.50));
        produtos.add(new Produto("Difusor Aromático Relaxante", "Difusores Aromáticos", 28.90));

        System.out.println("\n()()()--- BEM-VINDO A LOJA VIVELIS ---()()()\n");

        System.out.print("Digite seu CPF, por favor: ");
        String cpf = sc.nextLine();

        Cliente cliente = clientes.get(cpf);
        if (cliente == null) {
            cliente = new Cliente(cpf);
            clientes.put(cpf, cliente);
        }

        int opcao = 1;
        while (opcao != 0) {
            System.out.println("\n    *** MENU ***");
            System.out.println("1 - Ver Produtos");
            System.out.println("2 - Filtrar Categoria");
            System.out.println("3 - Adicionar no Carrinho");
            System.out.println("4 - Ver Carrinho");
            System.out.println("5 - Remover do Carrinho");
            System.out.println("6 - Comprar");
            System.out.println("7 - Suporte");
            System.out.println("8 - Sair");
            System.out.print("Opção escolhida: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.println("\n*** PRODUTOS ***");
                System.out.println("(Num - Descrição - Categoria - Valor)");
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println(i + " - " + produtos.get(i).nome + " | " + produtos.get(i).categoria + " | R$ " + produtos.get(i).preco);
                }
            } else if (opcao == 2) {
                System.out.println("\n*** CATEGORIAS ***");
                System.out.println("1 - Perfumes");
                System.out.println("2 - Sabonetes");
                System.out.println("3 - Shampoos");
                System.out.println("4 - Difusores Aromáticos");
                System.out.print("Escolha uma opção: ");

                int cat = sc.nextInt();
                String categoria = "";

                if (cat == 1) {
                    categoria = "Perfumes";
                } else if (cat == 2) {
                    categoria = "Sabonetes";
                } else if (cat == 3) {
                    categoria = "Shampoos";
                } else if (cat == 4) {
                    categoria = "Difusores Aromáticos";
                } else {
                    System.out.println("Categoria inválida!");
                    continue;
                }