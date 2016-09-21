package br.com.cesed.facisa.si.tcc.controller;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesed.facisa.si.tcc.constants.Constants;
import br.com.cesed.facisa.si.tcc.domain.*;
import br.com.cesed.facisa.si.tcc.iservice.ChamadoService;
import br.com.cesed.facisa.si.tcc.iservice.SocorristaService;
import br.com.cesed.facisa.si.tcc.isimilarity.SimilarityWebService;



@RestController
public class ChamadoController {
	
	private final ChamadoService iChamadoService;
	
	private final SocorristaService iSocorristaService;
	
	private final SimilarityWebService iSimilarity;
	
	@Autowired
	public ChamadoController(final ChamadoService ichamadoService, final SocorristaService isocorristaService, final SimilarityWebService iSimilarity) {
		this.iChamadoService = ichamadoService;
		this.iSocorristaService = isocorristaService;
		this.iSimilarity = iSimilarity;
	}
	
	@RequestMapping(value="/chamados", method = RequestMethod.GET)
	public ResponseEntity< List<Chamado> > listarTodos() {		
		return new ResponseEntity< List<Chamado> >
		(iChamadoService.listarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/chamado/{id}", method = RequestMethod.GET)
	public ResponseEntity <Chamado> getPeloID(@PathVariable String id) {
		
		Chamado chamado = iChamadoService.getPeloID(id);
		
		if (chamado == null){
			return new ResponseEntity<Chamado>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/chamado", method = RequestMethod.POST)
	public ResponseEntity<String> salvar (@RequestBody List<Chamado> chamados) {
		
		try {
			
			for (Chamado chamado : chamados) {
				iChamadoService.salvar(chamado);
			}
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/chamado/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Chamado> deletar (@PathVariable String id) {
	
		Chamado chamado = iChamadoService.getPeloID(id);
		
		try {
			
			if(chamado == null) {
				return new ResponseEntity<Chamado>(HttpStatus.NOT_FOUND);
			}
			
			iChamadoService.deletar (chamado);
			return new ResponseEntity<Chamado>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Chamado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/chamado", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar (@RequestBody Chamado chamado) {
		
		try {
			iChamadoService.salvar(chamado);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/recomendacao/{id}", method = RequestMethod.GET)
	public ResponseEntity <String> getRecomendacao(@PathVariable String id) {
		
		Chamado chamado = iChamadoService.getPeloID(id);
		
		List<Socorrista> socorristas = iSocorristaService.listarTodos();
		
		String retornoJson = null;
		
		if (chamado != null){
			try {
				for (Socorrista socorrista : socorristas) {
					String text1 = URLEncoder.encode(Constants.TEXT1_WEBSERVICE.concat(chamado.getQueixa()), "UTF-8");
					String text2 = URLEncoder.encode(Constants.TEXT1_WEBSERVICE.concat(socorrista.getCapacitacao()), "UTF-8");
					retornoJson = iSimilarity.responseWebService(Constants.URL_WEBSERVICE.concat(Constants.ECOMERCIAL).concat(text1).concat(Constants.ECOMERCIAL).concat(text2));					
				}
				
				System.out.println("RETORNO: " + retornoJson);
			
				return new ResponseEntity<String>(retornoJson, HttpStatus.OK);
			}catch (Exception e) {
				System.out.println("erro: " + e.getMessage());
			}
		}
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
	}
}
