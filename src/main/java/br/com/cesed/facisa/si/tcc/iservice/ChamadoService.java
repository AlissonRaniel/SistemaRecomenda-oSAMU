package br.com.cesed.facisa.si.tcc.iservice;

import java.util.List;

import br.com.cesed.facisa.si.tcc.domain.Chamado;

public interface ChamadoService {
	
	public void salvar(Chamado chamado);
	public Chamado getPeloID(String id);
	public void deletar (Chamado chamado);
	public void atualizar (Chamado chamado);
	public List<Chamado> listarTodos();

}
