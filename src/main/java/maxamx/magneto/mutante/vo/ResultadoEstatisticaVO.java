package maxamx.magneto.mutante.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ResultadoEstatisticaVO implements Serializable {

    private Long count_mutant_dna;
    private Long count_human_dna;

    @JsonProperty("razão")
    private String razao;

}
