package br.com.cesed.facisa.si.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesed.facisa.si.tcc.domain.*;
import br.com.cesed.facisa.si.tcc.iservice.SocorristaService;



@RestController
public class SocorristaController {
	
	private final SocorristaService iSocorristaService;
	
	@Autowired
	public SocorristaController(final SocorristaService isocorristaService) {
		this.iSocorristaService = isocorristaService;
	}
	
	@RequestMapping(value="/socorristas", method = RequestMethod.GET)
	public ResponseEntity< List<Socorrista> > listarTodos() {		
		return new ResponseEntity< List<Socorrista> >
		(iSocorristaService.listarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/socorrista/{id}", method = RequestMethod.GET)
	public ResponseEntity <Socorrista> getPeloID(@PathVariable String id) {
		
		Socorrista socorrista = iSocorristaService.getPeloID(id);
		
		if (socorrista == null){
			return new ResponseEntity<Socorrista>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Socorrista>(socorrista, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/socorrista", method = RequestMethod.POST)
	public ResponseEntity<String> salvar (@RequestBody List<Socorrista> socorristas) {
		
		try {
			
			for (Socorrista socorrista : socorristas) {
				iSocorristaService.salvar(socorrista);
			}	
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/socorrista/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Socorrista> deletar (@PathVariable String id) {
	
		Socorrista socorrista = iSocorristaService.getPeloID(id);
		
		try {
			if(socorrista == null) {
				return new ResponseEntity<Socorrista>(HttpStatus.NOT_FOUND);
			}
			
			iSocorristaService.deletar (socorrista);
			return new ResponseEntity<Socorrista>(HttpStatus.OK);
		}			
		
		catch (Exception e) {
			return new ResponseEntity<Socorrista>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/socorrista", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar (@RequestBody Socorrista socorrista) {
		
		try {
			iSocorristaService.salvar(socorrista);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
