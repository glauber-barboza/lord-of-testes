package br.com.lordoftests.service;

import br.com.lordoftests.model.Ork;
import br.com.lordoftests.model.interfaces.ISoldado;
import org.springframework.stereotype.Service;

@Service
public class GuerraService {

    public Boolean matarOrk(Ork ork, ISoldado soldado){
        System.out.println("vida do Soldado escolhido: "+soldado.getVida()+ " vida do Ork: "+ ork.getVida());

        while (soldado.getVida() > 0 && ork.getVida() > 0) {
            soldado.atacar(ork);
            System.out.println("vida do Soldado escolhido: "+soldado.getVida()+ " vida do Ork: "+ ork.getVida());

        }
        if(ork.getVida() > 0) return false;

        return true;
    }
}
