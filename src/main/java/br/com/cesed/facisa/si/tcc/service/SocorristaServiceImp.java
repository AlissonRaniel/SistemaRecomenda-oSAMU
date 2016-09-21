package br.com.cesed.facisa.si.tcc.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.cesed.facisa.si.tcc.domain.*;
import br.com.cesed.facisa.si.tcc.irepository.SocorristaRepository;

import br.com.cesed.facisa.si.tcc.iservice.SocorristaService;

@Service
@Validated
public class SocorristaServiceImp implements SocorristaService{

	private final SocorristaRepository socorristaRepository;
	
    @Autowired
    public SocorristaServiceImp(final SocorristaRepository socorristaRepository) {
    	this.socorristaRepository = socorristaRepository;
    }
    
	public Socorrista getPeloID(String id) {
		return socorristaRepository.findOne(id);
	}
	
	public List<Socorrista> listarTodos() {
		return socorristaRepository.findAll();
	}
    
    @Transactional
    public void salvar(@NotNull @Valid Socorrista socorrista) {
		
    	Socorrista existente = socorristaRepository.findOne(socorrista.getId());
    	
        if (existente == null) {
            socorristaRepository.save(socorrista);
        } 
	}
    
    @Transactional
    public void atualizar(@NotNull @Valid Socorrista socorrista) {
		
    	Socorrista existente = socorristaRepository.findOne(socorrista.getId());
    	
        if (existente != null) {
            socorristaRepository.save(socorrista);
        } 
	}
    
    @Transactional
    public void deletar (@NotNull @Valid Socorrista socorrista) {
		
    	Socorrista existente = socorristaRepository.findOne(socorrista.getId());
    	
        if (existente != null) {
        	socorristaRepository.delete(socorrista);
        } 
	}
    
    public SocorristaRepository getContatoRepsitory(){
    	return socorristaRepository;
    }
}
