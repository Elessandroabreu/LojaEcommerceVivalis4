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
