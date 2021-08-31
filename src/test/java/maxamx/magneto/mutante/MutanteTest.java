package maxamx.magneto.mutante;

import maxamx.magneto.mutante.repository.MutanteRepository;
import maxamx.magneto.mutante.service.MutanteService;
import maxamx.magneto.mutante.service.impl.MutantServiceImpl;
import maxamx.magneto.mutante.util.MatrizUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MutanteTest {

    private MutanteService mutantService;
    @Mock
    private MutanteRepository mutanteRepository;

    @BeforeEach
    void loadContext(){
        mutantService = new MutantServiceImpl(mutanteRepository);
    }

    private final List<String> sequencia = Collections.unmodifiableList(Arrays.asList("AAAA","TTTT","GGGG","CCCC"));

    @Test
    void existeSequenciaNaHorizontal(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),1);
    }

    @Test
    void inexistenteSequenciaNaHorizontal(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","TATATA","TCACTG"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),0);
    }


    @Test
    void existeSequenciaNaVertical(){
        String [] dna = {"ATGCGA","TAGTGC","TTATGT","TGAAGG","TATATA","TCACTG"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),1);
    }

    @Test
    void inexistenteSequenciaNaVertical(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAATG","TATATA","TCACTG"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),0);
    }


    @Test
    void existeSequenciaNaDiagonalPrincipal(){
        String [] dna = {"ATACGA","CAGTGC","TTATGT","AGAAAG","TATATG","TCACCA"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),1);
    }

    @Test
    void inexistenteSequenciaNaDiagonalPrincipal(){
        String [] dna = {"ATACGT","CTGATC","ATCTTG","ATATAG","CATATG","ACACCT"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),0);
    }


    @Test
    void existeSequenciaNaDiagonalSecundaria(){
        String [] dna = {"ATACGA","CAGTGC","TTATGT","AGAAAG","TATATG","TCACCA"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),1);
    }


    @Test
    void inexistenteSequenciaNaDiagonalSecundaria(){
        String [] dna = {"ATACGA","CAGTGC","TTATGT","AGAAAG","TATATG","TCACCA"};
        Assertions.assertEquals(MatrizUtil.localizaSequenciaNaHorizontal(dna,sequencia),0);
    }
}
