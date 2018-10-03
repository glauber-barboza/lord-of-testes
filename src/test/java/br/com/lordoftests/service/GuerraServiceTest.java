package br.com.lordoftests.service;

import br.com.lordoftests.repository.Relatorio;
import br.com.lordoftests.factory.AnaoFactory;
import br.com.lordoftests.factory.ElfoFactory;
import br.com.lordoftests.factory.HumanoFactory;
import br.com.lordoftests.factory.OrkFactory;
import br.com.lordoftests.model.Anao;
import br.com.lordoftests.model.Elfo;
import br.com.lordoftests.model.Humano;
import br.com.lordoftests.model.Ork;
import br.com.lordoftests.model.interfaces.ISoldado;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@RunWith(SpringRunner.class)
@Import(GuerraService.class)
public class GuerraServiceTest {

    @Autowired
    private GuerraService guerraService;

    @MockBean
    private Relatorio relatorio;

    @MockBean
    private MyClass myClass;

    @Test
    public void elfoAtacaOrk() {
        Ork ork = new OrkFactory.Builder()
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Elfo elfo = new ElfoFactory.Builder()
                .withItemPeito()
                .withItemCalca()
                .withItemBotas()
                .withArcoFlecha()
                .addPotions(4)
                .build();

        Boolean dead = guerraService.matarOrk(ork, elfo);

        Assert.assertTrue(dead);
    }

    @Test
    public void humanoAtacaOrk() {
        Ork ork = new OrkFactory.Builder()
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Humano humano = new HumanoFactory.Builder()
                .withSetSemCalsa()
                .withEscudo()
                .withEspada()
                .addPotions(1)
                .build();

        Boolean dead = guerraService.matarOrk(ork, humano);

        Assert.assertTrue(dead);
    }

    @Test
    public void anaoAtacaOrk() {
        Ork ork = new OrkFactory.Builder()
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Anao anao = new AnaoFactory.Builder()
                .withSetSemCalsa()
                .withMachado()
                .addPotions(6)
                .build();

        Boolean dead = guerraService.matarOrk(ork, anao);

        Assert.assertTrue(dead);
    }

    @Test
    public void armarEmboscada() {

        MyClass teste = new MyClass();
        String meuDadoMokado = "Meu dado Moocado";

        doReturn(meuDadoMokado).when(myClass).fazerAlgo(any());
        doThrow(new RuntimeException()).when(myClass).salvarBD(any());

        teste.salvarBD("algo");

        doThrow(new RuntimeException()).when(myClass).fazerAlgo(any());


        guerraService.emboscarOrks(montarEsquadraoSoldados(),montarEsquadraoOrk());
    }


    @Test(expected = RuntimeException.class)
    public void validarExeption() throws Exception {
        Elfo elfo = new ElfoFactory.Builder()
                .withItemPeito()
                .registrarNome("Glauber")
                .withItemCalca()
                .withItemBotas()
                .withArcoFlecha()
                .addPotions(10)
                .build();
    }


    private List<Ork> montarEsquadraoSoldados(){

        Ork ork1 = new OrkFactory.Builder()
                .registrarNome("ork1")
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Ork ork2 = new OrkFactory.Builder()
                .registrarNome("ork2")
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Ork ork3 = new OrkFactory.Builder()
                .registrarNome("ork3")
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        Ork ork4 = new OrkFactory.Builder()
                .registrarNome("ork4")
                .withEscudo()
                .withFullSet()
                .withMachado()
                .build();

        return new ArrayList<>(Arrays.asList(ork1,ork2,ork3));
    }

    private List<ISoldado> montarEsquadraoOrk(){

        Elfo elfo = new ElfoFactory.Builder()
                .registrarNome("Elfo")
                .withItemPeito()
                .withItemCalca()
                .withItemBotas()
                .withArcoFlecha()
                .addPotions(4)
                .build();

        Humano humano = new HumanoFactory.Builder()
                .withSetSemCalsa()
                .registrarNome("Humano")
                .withEscudo()
                .withEspada()
                .addPotions(1)
                .build();

        Humano humano1 = new HumanoFactory.Builder()
                .withSetSemCalsa()
                .registrarNome("Humano1")
                .withEscudo()
                .withEspada()
                .addPotions(1)
                .build();

        Humano humano2 = new HumanoFactory.Builder()
                .withSetSemCalsa()
                .registrarNome("Humano2")
                .withEscudo()
                .withEspada()
                .addPotions(1)
                .build();

        Anao anao = new AnaoFactory.Builder()
                .registrarNome("Anao")
                .withSetSemCalsa()
                .withMachado()
                .addPotions(6)
                .build();
        return new ArrayList<>(Arrays.asList(humano,humano1,anao));
    }
}
