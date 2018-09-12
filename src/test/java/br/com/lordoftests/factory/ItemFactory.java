package br.com.lordoftests.factory;

import br.com.lordoftests.model.Item;

public class ItemFactory {
    private Item item;

    public static Item escudo(){
        return new Item("Escudo",250,0,35,0);
    }

    public static Item espada(){
        return new Item("Espada",300,120,0,0);
    }

    public static Item machado(){
        return new Item("Machado",250,170,0,0);
    }

    public static Item arcoFlecha(){
        return new Item("arcoFlecha",350,220,0,0);
    }

    public static Item capacete(){
        return new Item("Capacete",100,0,10,0);
    }

    public static Item peito(){
        return new Item("peito",200,0,30,0);
    }

    public static Item calca(){
        return new Item("calca",150,0,15,0);
    }

    public static Item botas(){
        return new Item("botas",100,0,10,0);
    }
}
