package br.com.lordoftests.model.interfaces;

import br.com.lordoftests.model.Item;

public interface ISoldado {

    void adicionarItem(Item item);

    //Retornar a vida
    Integer receberAttack(Integer damage);

}
