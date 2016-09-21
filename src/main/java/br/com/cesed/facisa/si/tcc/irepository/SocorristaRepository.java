package br.com.cesed.facisa.si.tcc.irepository;

import br.com.cesed.facisa.si.tcc.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocorristaRepository extends JpaRepository <Socorrista, String>{
	public Socorrista findByNome(String nome);
}
