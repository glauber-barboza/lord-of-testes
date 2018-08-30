package br.com.lordoftests.model;

public class Item {

    private String nome;
    private int preco;
    private int damage;
    private int defesa;
    private int vida;

    public Item(String nome, int preco, int damage, int defesa, int vida) {
        this.nome = nome;
        this.preco = preco;
        this.damage = damage;
        this.defesa = defesa;
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVida() {
        return vida;
    }
}
