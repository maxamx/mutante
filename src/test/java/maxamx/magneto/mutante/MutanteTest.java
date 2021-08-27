package maxamx.magneto.mutante;

import maxamx.magneto.mutante.service.MutantService;
import maxamx.magneto.mutante.service.impl.MutantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MutanteTest {

    private MutantService mutantService;

    @BeforeEach
    void carrega(){
        mutantService = new MutantServiceImpl();
    }

    @Test
    void existeSequenciaNaHorizontal(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assertions.assertTrue(mutantService.isMutant(dna));
    }

    @Test
    void inexistenteSequenciaNaHorizontal(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","TATATA","TCACTG"};
        Assertions.assertFalse(mutantService.isMutant(dna));
    }


    @Test
    void existeSequenciaNaVertical(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assertions.assertTrue(mutantService.isMutant(dna));
    }

    @Test
    void inexistenteSequenciaNaVertical(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"};
        Assertions.assertTrue(mutantService.isMutant(dna));
    }
}
