package br.com.cesed.facisa.si.tcc.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.cesed.facisa.si.tcc.domain.*;
import br.com.cesed.facisa.si.tcc.irepository.ChamadoRepository;
import br.com.cesed.facisa.si.tcc.iservice.ChamadoService;

@Service
@Validated
public class ChamadoServiceImp implements ChamadoService{

	private final ChamadoRepository chamadoRepository;
	
    @Autowired
    public ChamadoServiceImp(final ChamadoRepository chamadoRepository) {
    	this.chamadoRepository = chamadoRepository;
    }
    
	public Chamado getPeloID(String id) {
		return chamadoRepository.findOne(id);
	}
	
	public List<Chamado> listarTodos() {
		return chamadoRepository.findAll();
	}
    
    @Transactional
    public void salvar(@NotNull @Valid Chamado chamado) {
		
    	Chamado existente = chamadoRepository.findOne(chamado.getId());
    	
        if (existente == null) {
            chamadoRepository.save(chamado);
        } 
	}
    
    @Transactional
    public void atualizar(@NotNull @Valid Chamado chamado) {
		
    	Chamado existente = chamadoRepository.findOne(chamado.getId());
    	
        if (existente != null) {
            chamadoRepository.save(chamado);
        } 
	}
    
    @Transactional
    public void deletar (@NotNull @Valid Chamado chamado) {
		
    	Chamado existente = chamadoRepository.findOne(chamado.getId());
    	
        if (existente != null) {
        	chamadoRepository.delete(chamado);
        } 
	}
    
    public ChamadoRepository getContatoRepsitory(){
    	return chamadoRepository;
    }
}
