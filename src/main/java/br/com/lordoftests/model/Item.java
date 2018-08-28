package br.com.lordoftests.model;

public class Item {

    private String nome;

    private Integer preco;

    private Integer damage;

    private Integer defesa;

    private Integer vida;

    public Item(String nome, Integer preco, Integer damage, Integer defesa, Integer vida) {
        this.nome = nome;
        this.preco = preco;
        this.damage = damage;
        this.defesa = defesa;
        this.vida = vida;
    }
}
