import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        HashMap<String, Cliente> clientes = new HashMap<>();
        ArrayList<ItemCarrinho> carrinho = new ArrayList<>();

        produtos.add(new Produto("Perfume Brisa Serena 50ml", "Perfumes", 189.90));
        produtos.add(new Produto("Perfume Noite Intensa 100ml", "Perfumes", 219.90));
        produtos.add(new Produto("Sabonete Jasmim Sublime", "Sabonetes", 29.90));
        produtos.add(new Produto("Sabonete Alpine Pure", "Sabonetes", 6.50));
        produtos.add(new Produto("Shampoo Frescor Revitalizante", "Shampoos", 34.90));
        produtos.add(new Produto("Shampoo Natural Shine", "Shampoos", 9.90));
        produtos.add(new Produto("Difusor Amanhecer Leve", "Difusores Aromáticos", 79.90));
        produtos.add(new Produto("Difusor Tranquilidade da Floresta", "Difusores Aromáticos", 99.90));

        System.out.println("\n()()()--- BEM-VINDO A LOJA VIVELIS ---()()()\n");

        System.out.print("Digite seu CPF, por favor: ");
        String cpf = entrada.nextLine();

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
            System.out.println("4 - Remover do Carrinho");
            System.out.println("5 - Ver Carrinho");
            System.out.println("6 - Comprar");
            System.out.println("7 - Suporte");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                System.out.println("\n*** PRODUTOS ***");
                System.out.println("(Num - Descrição - Categoria - Valor)");
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println(i + 1 + " - " + produtos.get(i).nome + " | " + produtos.get(i).categoria + " | R$ " + produtos.get(i).preco);
                }

            } else if (opcao == 2) {
                System.out.println("\n*** CATEGORIAS ***");
                System.out.println("1 - Perfumes");
                System.out.println("2 - Sabonetes");
                System.out.println("3 - Shampoos");
                System.out.println("4 - Difusores Aromáticos");
                System.out.print("Escolha uma opção: ");

                int cat = entrada.nextInt();
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

                System.out.println("\n*** PRODUTOS - " + categoria + " - ***");
                for (int i = 0; i < produtos.size(); i++) {
                    if (produtos.get(i).categoria.equals(categoria)) {
                        System.out.println(i + " - " + produtos.get(i).nome + " | R$ " + produtos.get(i).preco);
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Número do produto: ");
                int num = entrada.nextInt();
                num = num - 1;

                if (num >= 0 && num < produtos.size()) {
                    System.out.print("Quantidade: ");
                    int quantidade = entrada.nextInt();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida!");
                        continue;
                    }


                    boolean encontrou = false;
                    for (int i = 0; i < carrinho.size(); i++) {
                        if (carrinho.get(i).produto.nome.equals(produtos.get(num).nome)) {
                            carrinho.get(i).quantidade = carrinho.get(i).quantidade + quantidade;
                            System.out.println("Quantidade atualizada no carrinho!");
                            encontrou = true;
                            break;
                        }
                    }


                    if (!encontrou) {
                        carrinho.add(new ItemCarrinho(produtos.get(num), quantidade));
                        System.out.println("Produto adicionado ao carrinho!");
                    }
                } else {
                    System.out.println("Produto inválido!");
                }
            } else if (opcao == 4) {

                if (carrinho.size() == 0) {
                    System.out.println("Carrinho vazio!");
                } else {
                    System.out.println("\n*** REMOVER DO CARRINHO ***");
                    System.out.println("(Num - Produto - Qtd Atual)");
                    for (int i = 0; i < carrinho.size(); i++) {
                        ItemCarrinho item = carrinho.get(i);
                        System.out.println(i + " - " + item.produto.nome + " | Qtd: " + item.quantidade);
                    }


                    System.out.print("Número do item para remover: ");
                    int numItem = entrada.nextInt();

                    if (numItem >= 0 && numItem < carrinho.size()) {
                        ItemCarrinho item = carrinho.get(numItem);
                        System.out.println("Quantidade atual: " + item.quantidade);
                        System.out.print("Quantidade a remover (0 = remover tudo): ");
                        int qtdRemover = entrada.nextInt();

                        if (qtdRemover <= 0 || qtdRemover >= item.quantidade) {

                            carrinho.remove(numItem);
                            System.out.println("Item removido do carrinho!");
                        } else {

                            item.quantidade = item.quantidade - qtdRemover;
                            System.out.println("Quantidade reduzida! Nova quantidade: " + item.quantidade);
                        }
                    } else {
                        System.out.println("Item inválido!");
                    }
                }

            } else if (opcao == 5) {

                System.out.println("\n*** CARRINHO ***");
                if (carrinho.size() == 0) {
                    System.out.println("Carrinho vazio, adicione alguns produtos para continuar!");
                } else {
                    double total = 0;
                    System.out.println("(Num - Produto - Quantidade - Preço Unit - Subtotal)");
                    for (int i = 0; i < carrinho.size(); i++) {
                        ItemCarrinho item = carrinho.get(i);
                        double subtotal = item.produto.preco * item.quantidade;
                        System.out.println(i + 1+ " - " + item.produto.nome + " | Qtd: " + item.quantidade +
                                " | R$ " + item.produto.preco + " | Subtotal: R$ " + subtotal);
                        total = total + subtotal;
                    }
                    System.out.println("TOTAL DO CARRINHO: R$ " + total);

                    if (total > 199.90) {
                        System.out.println("FRETE GRÁTIS!");
                    } else {
                        double falta = 199.90 - total;
                        System.out.printf("Falta R$ %.2f para o frete grátis, ", falta);
                    }
                }

            } else if (opcao == 6) {
                if (carrinho.size() == 0) {
                    System.out.println("Seu carrinho está vazio!");
                } else {
                    double total = 0;
                    for (int i = 0; i < carrinho.size(); i++) {
                        ItemCarrinho item = carrinho.get(i);
                        total = total + (item.produto.preco * item.quantidade);
                    }

                    System.out.println("\n=== FINALIZAR COMPRA ===");
                    System.out.println("Subtotal: R$ " + total);

                    if (total < 29.90) {
                        System.out.println("Frete: R$ 9.90");
                        total = total + 9.90;
                    } else {
                        System.out.println("Frete: GRÁTIS");
                    }

                    System.out.println("Pagamento:");
                    System.out.println("1 - Débito");
                    System.out.println("2 - Crédito");
                    System.out.println("3 - PIX (10% desconto)");
                    System.out.print("Escolha  o método de pagamento: ");

                    int pag = entrada.nextInt();

                    if (pag == 1) {
                        System.out.println("Débito selecionado");
                    } else if (pag == 2) {
                        System.out.println("Crédito selecionado");
                    } else if (pag == 3) {
                        total = total * 0.9;
                        System.out.println("PIX selecionado - 10% desconto!");
                    } else {
                        System.out.println("Pagamento inválido!");
                        continue;
                    }

                    System.out.println("TOTAL FINAL: R$ " + total);
                    System.out.println("Compra realizada!");

                    cliente.compras = cliente.compras + 1;

                    if (cliente.compras % 10 == 0) {
                        System.out.println("PARABÉNS! Você ganhou um brinde!");
                    }

                    carrinho.clear();
                }

            } else if (opcao == 7) {
                System.out.println("\n*** SUPORTE  ***");
                System.out.println("Atendimento: 8h às 18h de segunda a sexta-feira");
                System.out.println("Email: suportevivelis@vivelis.com");
                System.out.println("Nosso WhatsApp: (48) 99655-3129");
            } else if (opcao == 8) {
                System.out.println("Obrigado por visitar a Vivelis. Volte sempre!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        entrada.close();
    }
}