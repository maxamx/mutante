package maxamx.magneto.mutante.controller;

import lombok.AllArgsConstructor;
import maxamx.magneto.mutante.service.MutanteService;
import maxamx.magneto.mutante.vo.EstatisticaVO;
import maxamx.magneto.mutante.vo.MutanteVO;
import maxamx.magneto.mutante.vo.ResultadoEstatisticaVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MutanteController {

    private MutanteService mutanteService;

    @PostMapping("/mutante")
    public ResponseEntity<Boolean> mutant(@RequestBody MutanteVO dna){
        boolean ehUmMutante = mutanteService.isMutant(dna.getDna());
        mutanteService.salvar(dna.getDna(),ehUmMutante);
        if(ehUmMutante)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }
    @GetMapping("/estatisticas")
    public ResponseEntity<ResultadoEstatisticaVO> estatisticas(){
        return ResponseEntity.ok(mutanteService.estatistica());
    }
}
