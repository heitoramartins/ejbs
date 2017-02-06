package com.ejb.service.calculo;

import com.ejb.model.Carro;

public abstract class Template implements Calculo{

	@Override
	public Carro calcularTotais(Carro carro){
	    if(isGM(carro)){
	    	return gm(carro);
	    }else if(isFord(carro)){
	    	return ford(carro);
	    }else
	    	return outras(carro);
	}
        
    	
	abstract boolean isGM(Carro carro);
	abstract boolean isFord(Carro carro);
    abstract Carro ford(Carro carro);
	abstract Carro gm(Carro carro);
	abstract Carro outras(Carro carro);
	
}
