package br.com.lordoftests.factory;

import br.com.lordoftests.model.Humano;

public class HumanoFactory {

    public static class Builder{
        private Humano humanoBuilder;

        public Builder(){
            humanoBuilder = new Humano(1000, 1000, 200, 30);
        }

        public Builder withEspada(){
            humanoBuilder.adicionarItem(ItemFactory.espada());
            return this;
        }

        public Builder withEscudo(){
            humanoBuilder.adicionarItem(ItemFactory.escudo());
            return this;
        }

        public Builder withSetSemCalsa(){
            humanoBuilder.adicionarItem(ItemFactory.capacete());
            humanoBuilder.adicionarItem(ItemFactory.peito());
            humanoBuilder.adicionarItem(ItemFactory.botas());
            return this;
        }

        public Builder registrarNome(String nome){
            humanoBuilder.setNome(nome);
            return this;
        }

        public Builder addPotions(Integer quantidade){
            for (int i = 0; i < quantidade; i++) {
                humanoBuilder.adicionarItem(ItemFactory.potion());
            }
            return this;
        }

        public Humano build(){
            String humano = String.format("Humano %s: Vida: %s Dano: %s Defesa: %s Pilas: %s",
                    humanoBuilder.getNome(),
                    humanoBuilder.getVida(),
                    humanoBuilder.getDano(),
                    humanoBuilder.getDefesa(),
                    humanoBuilder.getPila());

            System.out.println(humano);
            return humanoBuilder;
        }
    }
}
