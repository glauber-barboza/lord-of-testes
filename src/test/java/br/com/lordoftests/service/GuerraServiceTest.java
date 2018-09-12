package br.com.lordoftests.service;

import br.com.lordoftests.factory.OrkFactory;
import br.com.lordoftests.model.Elfo;
import br.com.lordoftests.model.Ork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(GuerraService.class)
public class GuerraServiceTest {

    @Autowired
    private GuerraService guerraService;

    @Test
    public void atacarOrk() {
        Ork ork = new OrkFactory.Builder()
                .withEscudo()
                .build();
        Elfo elfo = new Elfo(1000, 500, 500, 0);

        guerraService.matarOrk(ork, elfo);
    }
}
