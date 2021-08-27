package maxamx.magneto.mutante;

import maxamx.magneto.mutante.service.MutantService;

import maxamx.magneto.mutante.service.impl.MutantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MutantTest {






    @Test
    void existeSequenciaNaHorizontal(){
        MutantService mutantService = new MutantServiceImpl();
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assertions.assertTrue(mutantService.horizontal(dna));
    }



    @Test
    void existeSequenciaNaVertical(){
        MutantService mutantService = new MutantServiceImpl();
        String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assertions.assertTrue(mutantService.vertical(dna));
    }
}
