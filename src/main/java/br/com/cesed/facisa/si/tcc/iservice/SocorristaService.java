package br.com.cesed.facisa.si.tcc.iservice;

import java.util.List;
import br.com.cesed.facisa.si.tcc.domain.Socorrista;

public interface SocorristaService {
	
	public void salvar(Socorrista socorrista);
	public Socorrista getPeloID(String id);
	public void deletar (Socorrista socorrista);
	public void atualizar (Socorrista socorrista);
	public List<Socorrista> listarTodos();

}
