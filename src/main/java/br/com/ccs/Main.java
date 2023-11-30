package br.com.ccs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final List<Produto> produtos = new ArrayList<>();

    static void setup() {
        produtos.add(buildProduto("monitor lcd"));
        produtos.add(buildProduto("papel"));
        produtos.add(buildProduto("toalha"));
        produtos.add(buildProduto("monitor crt"));
        produtos.add(buildProduto("guardanapo"));
        produtos.add(buildProduto("tesoura"));
    }

    private static Produto buildProduto(String descricao) {

        return Produto
                .builder()
                .codigo((int) (Math.random() * 100))
                .descricao(descricao).build();
    }

    public static void main(String[] args) {
        setup();

        produtos.forEach(p -> System.out.print(p.getDescricao().concat(", ")));

        System.out.println("\n\n#### Em ordem natural crescente: ####");

        var crescente = produtos
                .stream()
                .sorted(Comparator.comparing(Produto::getDescricao))
                .toList();

        crescente.forEach(p -> System.out.print(p.getDescricao().concat(", ")));

        System.out.println("\n\n#### Em ordem natural decrescente: ####");

        var decrescente = produtos
                .stream()
                .sorted((o1, o2) -> o2.getDescricao().compareTo(o1.getDescricao()))
                .toList();

        decrescente.forEach(p -> System.out.print(p.getDescricao().concat(", ")));

        System.out.println("\n\n#### Em ordem natural decrescente: ####");

        var codigoDecrescente = produtos
                .stream()
                .sorted((o1, o2) -> o2.getCodigo().compareTo(o1.getCodigo()))
                .toList();

        codigoDecrescente.forEach(p -> System.out.print(p.getCodigo() + "".concat(", ")));

        System.out.println("\n\n#### Em ordem natural crescente: ####");

        var codigoCrescente = produtos
                .stream()
                .sorted(Comparator.comparing(Produto::getCodigo))
                .toList();

        codigoCrescente.forEach(p -> System.out.print(p.getCodigo() + "".concat(", ")));
    }
}