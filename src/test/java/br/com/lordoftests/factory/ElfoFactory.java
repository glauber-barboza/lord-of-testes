package br.com.lordoftests.factory;

import br.com.lordoftests.model.Elfo;

public class ElfoFactory {

    public static class Builder{
        private Elfo elfoBuilder;

        public Builder(){
            elfoBuilder = new Elfo(1000, 700, 120, 0);
        }

        public Builder withArcoFlecha(){
            elfoBuilder.adicionarItem(ItemFactory.arcoFlecha());
            return this;
        }

        public Builder withItemPeito(){
            elfoBuilder.adicionarItem(ItemFactory.peito());
            return this;
        }

        public Builder withItemCalca(){
            elfoBuilder.adicionarItem(ItemFactory.calca());
            return this;
        }

        public Builder withItemBotas(){
            elfoBuilder.adicionarItem(ItemFactory.botas());
            return this;
        }

        public Builder registrarNome(String nome){
            elfoBuilder.setNome(nome);
            return this;
        }


        public Builder addPotions(Integer quantidade){
            for (int i = 0; i < quantidade; i++) {
                elfoBuilder.adicionarItem(ItemFactory.potion());
            }
            return this;
        }

        public Elfo build(){
            String elfo = String.format("Elfo %s: Vida: %s Dano: %s Defesa: %s Pilas: %s",
                    elfoBuilder.getNome(),
                    elfoBuilder.getVida(),
                    elfoBuilder.getDano(),
                    elfoBuilder.getDefesa(),
                    elfoBuilder.getPila());

            System.out.println(elfo);
            return elfoBuilder; }
    }
}
