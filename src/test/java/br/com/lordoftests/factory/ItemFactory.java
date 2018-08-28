package br.com.lordoftests.factory;

import br.com.lordoftests.model.Item;

public class ItemFactory {
    private Item item;

    public static class Builder{
        private Item itemBuilder;

        public Builder(){
        }

        public Builder escudo(){
            itemBuilder = new Item("Escudo",100,0,50,0);
            return this;
        }

        public Item build(){return itemBuilder; }
    }
}
