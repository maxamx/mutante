package maxamx.magneto.mutante.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
public class EstatisticaVO implements Serializable {
    private boolean mutante;
    private Long quantidade;
}
