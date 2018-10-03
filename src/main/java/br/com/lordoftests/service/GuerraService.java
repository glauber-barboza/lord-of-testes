package br.com.lordoftests.service;

import br.com.lordoftests.repository.Relatorio;
import br.com.lordoftests.model.Ork;
import br.com.lordoftests.model.interfaces.ISoldado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuerraService {

    @Autowired
    private Relatorio relatorio;

    public Boolean matarOrk(Ork ork, ISoldado soldado) {
        log(soldado,ork);

        while (soldado.getVida() > 0 && ork.getVida() > 0) {
            soldado.atacar(ork);
            log(soldado,ork);
        }
        if (ork.getVida() > soldado.getVida()) return false;

        return true;
    }

    public void emboscarOrks(List<Ork> orks, List<ISoldado> soldados) {
        List<ISoldado> cemiterioSoldados = new ArrayList<>();
        List<Ork> cemiterioOrks = new ArrayList<>();

        if (soldados.size() != 3) throw new RuntimeException("3 Soldados na emboscada, não tente roubar!!!");

        if (orks.size() != 3) throw new RuntimeException("Você só pode usar 3 Orks na emboscada!!!");

        while (true) {
            soldados.forEach(soldado -> {
                orks.forEach(ork -> {
                    if (soldado.getVida() > 0 && ork.getVida() > 0){
                        soldado.atacar(ork);
                        log(soldado,ork);
                    }else{
                        if(soldado.getVida() <= 0) {
                            Optional<ISoldado> soldCemit = cemiterioSoldados.stream()
                                    .filter(o -> o.getNome() == soldado.getNome())
                                    .findFirst();
                            if (!soldCemit.isPresent()) cemiterioSoldados.add(soldado);

                        }else if(ork.getVida() <= 0){
                            Optional<Ork> orkCemit = cemiterioOrks.stream()
                                    .filter(o -> o.getNome() == ork.getNome())
                                    .findFirst();
                            if (!orkCemit.isPresent()) cemiterioOrks.add(ork);
                        }
                    }
                });
            });
            if(cemiterioSoldados.size() ==3 || cemiterioOrks.size() ==3) break;
        }

        List<ISoldado> mortos = new ArrayList<>();
        mortos.addAll(cemiterioSoldados);
        mortos.addAll(cemiterioOrks);
        relatorio.salvarRelatorioBatalha(mortos);
    }

    private void log(ISoldado soldado,Ork ork){
        String log = String.format("vida do %s : %s vida do Ork %s : %s",
                soldado.getNome(),
                soldado.getVida(),
                ork.getNome(),
                ork.getVida());

        System.out.println(log);
    }
}
