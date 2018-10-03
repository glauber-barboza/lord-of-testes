package br.com.lordoftests.model.interfaces;

import br.com.lordoftests.model.Item;

public interface ISoldado {

    void adicionarItem(Item item);

    void atacar(ISoldado soldado);

    void receberAtack(Integer dano);

    Integer getDano();

    Integer getVida();

    Integer getDefesa();

    Integer getPila();

    String getNome();

}
