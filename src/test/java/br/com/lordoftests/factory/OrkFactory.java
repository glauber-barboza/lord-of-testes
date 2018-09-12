package br.com.lordoftests.factory;

import br.com.lordoftests.model.Item;
import br.com.lordoftests.model.Ork;

public class OrkFactory {

    private Ork ork;

    public static class Builder{
        private Ork orkBuilder;

        public Builder(){
            orkBuilder = new Ork(1000, 1000, 50, 100);
        }

        public Builder withEscudo(){
            orkBuilder.adicionarItem(ItemFactory.escudo());
            return this;
        }

        public Builder withMachado(){
            orkBuilder.adicionarItem(ItemFactory.machado());
            return this;
        }

        public Builder withFullSet(){
            orkBuilder.adicionarItem(ItemFactory.capacete());
            orkBuilder.adicionarItem(ItemFactory.peito());
            orkBuilder.adicionarItem(ItemFactory.calca());
            orkBuilder.adicionarItem(ItemFactory.botas());
            return this;
        }

        public Ork build(){return orkBuilder; }
    }
}
