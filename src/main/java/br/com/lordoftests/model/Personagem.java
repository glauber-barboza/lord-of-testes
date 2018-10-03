package br.com.lordoftests.model;

import br.com.lordoftests.model.interfaces.ISoldado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Personagem implements ISoldado {

    private String nome;
    private Integer dinheiro;
    private Integer vida;
    private Integer damage;
    private Integer defesa;
    private List<Item> itens = new ArrayList<>();

    public Personagem(Integer dinheiro, Integer vida, Integer damage, Integer defesa) {
        this.dinheiro = dinheiro;
        this.vida = vida;
        this.damage = damage;
        this.defesa = defesa;
    }

    @Override
    public void adicionarItem(Item item) {
        dinheiro = dinheiro - item.getPreco();
        if(dinheiro < 0) throw new RuntimeException(nome + "não tem pila para comprar o item!!! item:"+ item.getNome());
        itens.add(item);
    }

    @Override
    public void atacar(ISoldado soldado) {
        soldado.receberAtack(this.getDano());
        if(this.getVida() > 0) this.receberAtack(soldado.getDano());
    }

    @Override
    public void receberAtack(Integer dano) {
        Integer defesaComItens = this.defesa;
        for (Item i:itens) defesaComItens += i.getDefesa();

         if(this.vida < 300) tomarPotion();

        if(defesaComItens < dano) this.vida -=  dano - defesaComItens;
    }

    @Override
    public Integer getDano() {
        Integer danoComItens = this.damage;
        for (Item i:itens) danoComItens += i.getDamage();

        return danoComItens;
    }

    @Override
    public Integer getDefesa() {
        Integer defesaComItens = this.defesa;
        for (Item i:itens) defesaComItens += i.getDefesa();

        return defesaComItens;
    }

    private void tomarPotion(){
        Integer potion = 0;
        Optional<Item> item = this.itens.stream()
                .filter(t -> t.getNome().equals("potion"))
                .findFirst();

        if(item.isPresent()){
            potion = item.get().getVida();
            itens.remove(item.get());
            Integer vida = this.vida + potion;
            System.out.println(nome +" Tomou Potion, Vida: "+ vida);
        }

        this.vida += potion ;
    }

    public Integer getVida(){
        return vida;
    }

    public Integer getPila(){
        return dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
