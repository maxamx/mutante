package maxamx.magneto.mutante.service.impl;

import maxamx.magneto.mutante.service.MutantService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MutantServiceImpl implements MutantService {

    private final List<String> sequencia = Collections.unmodifiableList(Arrays.asList("AAAA","TTTT","GGGG","CCCC"));


    @Override
    public boolean isMutant(final String[] dna) {
//        long quantidadeHorizontal = horizontal(dna);
//        long quantidadeVertical = vertical(dna);

    return false;
    }

    public boolean horizontal(final String[] dna) {
        return Arrays.stream(dna)
                .filter(horizontal -> sequencia.stream().filter(horizontal::contains).count()>0)
                .count()>0;
    }

    public boolean vertical(final String[] dna) {
        return Arrays.stream(dna)
                .filter(vertical -> sequencia.stream().filter(vertical::contains).count()>0)
                .count()>0;
    }


}
