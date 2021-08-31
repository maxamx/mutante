package maxamx.magneto.mutante.service.impl;

import lombok.AllArgsConstructor;
import maxamx.magneto.mutante.entity.Mutante;
import maxamx.magneto.mutante.repository.MutanteRepository;
import maxamx.magneto.mutante.service.MutanteService;
import maxamx.magneto.mutante.vo.EstatisticaVO;
import maxamx.magneto.mutante.vo.ResultadoEstatisticaVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor()
public class MutantServiceImpl implements MutanteService {

    private final List<String> sequencia = Collections.unmodifiableList(Arrays.asList("AAAA","TTTT","GGGG","CCCC"));

    private MutanteRepository mutanteRepository;

    @Override
    public boolean isMutant(final String[] dna) {
        long quantidade = localizaSequenciaNaHorizontal(dna)+localizaSequenciaNaVertical(dna);
        return quantidade >1;
    }


    public void salvar(final String[] dna, boolean ehUmMutante){
        Mutante mutante = new Mutante(null,dna.toString(),ehUmMutante);
        mutanteRepository.save(mutante);
    }

    public ResultadoEstatisticaVO estatistica(){
        List<EstatisticaVO> resultado = mutanteRepository.obterEstatistica();
        long qtdMutante= resultado.stream().filter(e-> e.isMutante()).mapToLong(e->e.getQuantidade()).findFirst().orElse(0);
        long qtdHumano= resultado.stream().filter(e-> !e.isMutante()).mapToLong(EstatisticaVO::getQuantidade).findFirst().orElse(0);
        return new ResultadoEstatisticaVO(qtdMutante,qtdHumano,calcularRazao(qtdMutante,qtdHumano));
    }

    private String calcularRazao(long quantidadeMutante, long quantidadeHumano) {
        if(quantidadeHumano!=0l) {
            BigDecimal result=  BigDecimal.valueOf(quantidadeMutante).divide(BigDecimal.valueOf(quantidadeHumano));
            return String.format("%.01f", result);
        } else return "Não há como calcular a rãzão";
    }

    private long localizaSequenciaNaHorizontal(final String[] dna) {
        return Arrays.stream(dna)
                .filter(this::localizaSequenciaMutante)
                .count();
    }

    private boolean localizaSequenciaMutante(String sequenciaColetada) {
        return sequencia.stream().anyMatch(sequenciaColetada::contains);
    }

    private long localizaSequenciaNaVertical(final String[] dna) {
        return Arrays.stream(dna)
                .filter(this::localizaSequenciaMutante)
                .count();
    }


}
