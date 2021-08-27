package maxamx.magneto.mutante.service;

import java.util.Optional;

public interface MutantService {
   boolean isMutant(String[] dna);

   boolean horizontal(String[] dna);

   boolean vertical(String[] dna);
}
