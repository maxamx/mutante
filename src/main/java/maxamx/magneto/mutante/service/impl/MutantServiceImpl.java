package maxamx.magneto.mutante.service.impl;

import maxamx.magneto.mutante.service.MutantService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MutantServiceImpl implements MutantService {

    private final List<String> sequencia = Collections.unmodifiableList(Arrays.asList("AAAA","TTTT","GGGG","CCCC"));


    @Override
    public boolean isMutant(final String[] dna) {
        long quantidade = localizaSequenciaNaHorizontal(dna)+localizaSequenciaNaVertical(dna);
        return quantidade >1;
    }

    private long localizaSequenciaNaHorizontal(final String[] dna) {
        return Arrays.stream(dna)
                .filter(this::localizaSequenciaMutante)
                .count();
    }

    private boolean localizaSequenciaMutante(String sequenciaColetada) {
        return sequencia.stream().filter(sequenciaColetada::contains).count()>0;
    }

    private long localizaSequenciaNaVertical(final String[] dna) {
        return Arrays.stream(dna)
                .filter(this::localizaSequenciaMutante)
                .count();
    }


}
