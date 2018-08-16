package br.com.lordoftests.model;

import br.com.lordoftests.model.interfaces.ISoldado;

import java.util.List;

public class Personagem implements ISoldado {

    public Personagem(Integer dinheiro, Integer vida, Integer damage, Integer defesa) {
        this.dinheiro += dinheiro;
        this.vida += vida;
        this.damage += damage;
        this.defesa += defesa;
    }

    private Integer dinheiro = 500;

    private Integer vida = 1000;

    private Integer damage = 50;

    private Integer defesa = 10;

    private List<Item> itens;

    @Override
    public void adicionarItem(Item item) {

    }

    @Override
    public Integer receberAttack(Integer damage) {
        return vida;
    }
}
