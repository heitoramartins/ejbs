package com.ejb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.exception.CarroNaoEncontradoException;
import com.ejb.model.Carro;
import com.ejb.model.vo.CarroVO;
import com.ejb.repasotory.CarroRepository;
import com.ejb.service.calculo.GerarCalculo;

@Stateless
public class CarroService extends CarroRepository<Carro, Long>{
		
	@Inject 
	private GerarCalculo calculo;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public CarroService() {
		super(Carro.class);
	}

	@PersistenceContext
	private EntityManager em;

	public CarroVO calcularTotais(String marca, String modelo, String placa){
		 Carro carro = findMarcaAndModeloAndPlaca(marca, modelo, placa);
		 if(carro != null){
		 calculo.calcularTotais(carro);
		 CarroVO vo = EntityToVO(carro);
		 return vo;
		 }else{
			 throw new CarroNaoEncontradoException("carro nao existente!");
		 }
	}
	
	private CarroVO EntityToVO(Carro carro){
		CarroVO vo = new CarroVO();
		vo.setId(carro.getId());
		vo.setMarca(carro.getMarca());
		vo.setModelo(carro.getModelo().getDescricao());
		vo.setPlaca(carro.getPlaca());
		vo.setValor(carro.getValor());
		return vo;
	}
	
}
