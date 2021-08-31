package maxamx.magneto.mutante.service;

import maxamx.magneto.mutante.vo.ResultadoEstatisticaVO;
import org.springframework.stereotype.Service;

@Service
public interface MutanteService {
   boolean isMutant(String[] dna);
    void salvar(String[] dna, boolean ehUmMutante);
    ResultadoEstatisticaVO estatistica();
}
