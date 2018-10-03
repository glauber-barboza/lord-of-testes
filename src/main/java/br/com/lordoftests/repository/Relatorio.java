package br.com.lordoftests.repository;

import br.com.lordoftests.model.interfaces.ISoldado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Relatorio {

    public void salvarRelatorioBatalha(List<ISoldado> soldados){
        List<ISoldado> relatorio = soldados;
        //Salvou
    }
}
