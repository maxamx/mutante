package maxamx.magneto.mutante.controller;

import lombok.AllArgsConstructor;
import maxamx.magneto.mutante.service.MutantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MutanteController {

    private MutantService mutantService;

    @PostMapping("/mutante")
    public ResponseEntity<Boolean> mutant(@RequestBody String[] dna){
        boolean result = mutantService.isMutant(dna);
        if (result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
