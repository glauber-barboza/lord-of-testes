package br.com.lordoftests.model;

import br.com.lordoftests.model.interfaces.ISoldado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Personagem implements ISoldado {

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
        itens.add(item);
    }

    @Override
    public void atacar(ISoldado soldado) {
        soldado.receberAtack(this.getDano());
        this.receberAtack(soldado.getDano());
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

    public Integer getVida(){
        return vida;
    }

    private void tomarPotion(){
        Integer potion = 0;
        //TODO validar se exste potion
        Optional<Item> item = this.itens.stream()
                .filter(t -> t.getNome().equals("Potion"))
                .findFirst();

        if(item.isPresent()){
            potion = item.get().getVida();
        }

        this.vida += potion ;
    }
}
