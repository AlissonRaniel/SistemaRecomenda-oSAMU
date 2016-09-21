package br.com.cesed.facisa.si.tcc.irepository;

import br.com.cesed.facisa.si.tcc.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository <Chamado, String>{
	public Chamado findByDate(String data);
}
