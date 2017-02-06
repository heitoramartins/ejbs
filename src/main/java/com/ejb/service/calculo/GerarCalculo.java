package com.ejb.service.calculo;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import com.ejb.annotation.FORD;
import com.ejb.annotation.GM;
import com.ejb.annotation.OUTRAS;
import com.ejb.model.Carro;

@Dependent
public class GerarCalculo extends Template{

	@Inject @Any
	private Instance<Calculo> calculoLazy;

	@Override
	boolean isGM(Carro carro) {
		return carro.isGM();
	}

	@Override
	boolean isFord(Carro carro) {
	 	return carro.isFord();
	}

	@Override
	Carro ford(Carro carro) {
		  Instance<Calculo> calculo = calculoLazy.select(new AnnotationLiteral<FORD>(){}); 
		  carro = calculo.get().calcularTotais(carro);
		  return carro;
	}

	@Override
	Carro gm(Carro carro) {
		  Instance<Calculo> calculo = calculoLazy.select(new AnnotationLiteral<GM>(){}); 
	      carro = calculo.get().calcularTotais(carro);
	      return carro;
	}

	@Override
	Carro outras(Carro carro) {
		  Instance<Calculo> calculo = calculoLazy.select(new AnnotationLiteral<OUTRAS>(){}); 
	      carro = calculo.get().calcularTotais(carro);
	      return carro;
	}

	
	

		
}
