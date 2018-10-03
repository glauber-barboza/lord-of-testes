package br.com.lordoftests.factory;

import br.com.lordoftests.model.Anao;

public class AnaoFactory {
    public static class Builder{
        private Anao anaoBuilder;

        public Builder(){
            anaoBuilder = new Anao(950, 2000, 135, 25);
        }

        public Builder withMachado(){
            anaoBuilder.adicionarItem(ItemFactory.machado());
            return this;
        }

        public Builder withSetSemCalsa(){
            anaoBuilder.adicionarItem(ItemFactory.capacete());
            anaoBuilder.adicionarItem(ItemFactory.peito());
            //anaoBuilder.adicionarItem(ItemFactory.calca());
            anaoBuilder.adicionarItem(ItemFactory.botas());
            return this;
        }

        public Builder addPotions(Integer quantidade){
            for (int i = 0; i < quantidade; i++) {
                anaoBuilder.adicionarItem(ItemFactory.potion());
            }
            return this;
        }

        public Builder registrarNome(String nome){
            anaoBuilder.setNome(nome);
            return this;
        }

        public Anao build(){
            String humano = String.format("Anao %s: Vida: %s Dano: %s Defesa: %s Pilas: %s",
                    anaoBuilder.getNome(),
                    anaoBuilder.getVida(),
                    anaoBuilder.getDano(),
                    anaoBuilder.getDefesa(),
                    anaoBuilder.getPila());

            System.out.println(humano);
            return anaoBuilder;
        }
    }
}
