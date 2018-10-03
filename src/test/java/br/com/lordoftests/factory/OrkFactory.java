package br.com.lordoftests.factory;

import br.com.lordoftests.model.Ork;

public class OrkFactory {

    public static class Builder{
        private Ork orkBuilder;

        public Builder(){
            orkBuilder = new Ork(1050, 1000, 52, 100);
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

        public Builder registrarNome(String nome){
            orkBuilder.setNome(nome);
            return this;
        }

        public Ork build(){
            String ork = String.format("Ork %s: Vida: %s Dano: %s Defesa: %s Pilas: %s",
                    orkBuilder.getNome(),
                    orkBuilder.getVida(),
                    orkBuilder.getDano(),
                    orkBuilder.getDefesa(),
                    orkBuilder.getPila());
            System.out.println(ork);
            return orkBuilder;
        }
    }
}
