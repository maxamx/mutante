package maxamx.magneto.mutante.repository;

import maxamx.magneto.mutante.entity.Mutante;
import maxamx.magneto.mutante.vo.EstatisticaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutanteRepository extends JpaRepository<Mutante,Long> {

    @Query(value = "select new maxamx.magneto.mutante.vo.EstatisticaVO(m.mutante, COUNT(m)) from Mutante m group by m.mutante")
    public List<EstatisticaVO> obterEstatistica();

}
