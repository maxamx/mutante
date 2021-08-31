package maxamx.magneto.mutante;

import maxamx.magneto.mutante.repository.MutanteRepository;
import maxamx.magneto.mutante.service.MutanteService;
import maxamx.magneto.mutante.service.impl.MutantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class MutanteTest {

    private MutanteService mutantService;
    @Mock
    private MutanteRepository mutanteRepository;

    @BeforeEach
    void loadContext(){
        mutantService = new MutantServiceImpl(mutanteRepository);
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
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","TGAAGG","TATATA","TCACTG"};
        Assertions.assertTrue(mutantService.isMutant(dna));
    }

    @Test
    void inexistenteSequenciaNaVertical(){
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAATG","TATATA","TCACTG"};
        Assertions.assertTrue(mutantService.isMutant(dna));
    }
}
