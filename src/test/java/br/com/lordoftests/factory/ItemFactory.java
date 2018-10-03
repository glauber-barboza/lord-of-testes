package br.com.lordoftests.factory;

import br.com.lordoftests.model.Item;

public class ItemFactory {

    public static Item escudo(){
        return new Item("Escudo",250,0,50,0);
    }

    public static Item espada(){
        return new Item("Espada",300,120,0,0);
    }

    public static Item machado(){
        return new Item("Machado",250,175,0,0);
    }

    public static Item arcoFlecha(){
        return new Item("arcoFlecha",350,250,0,0);
    }

    public static Item capacete(){
        return new Item("capacete",100,0,20,0);
    }

    public static Item peito(){
        return new Item("peito",200,0,50,0);
    }

    public static Item calca(){
        return new Item("calca",150,0,30,0);
    }

    public static Item botas(){
        return new Item("botas",100,0,20,0);
    }

    public static Item potion(){
        return new Item("potion",50,0,0,150);
    }
}
