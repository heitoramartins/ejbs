package com.ejb.service.calculo;

import java.math.BigDecimal;

import javax.enterprise.context.Dependent;

import com.ejb.annotation.FORD;
import com.ejb.annotation.OUTRAS;
import com.ejb.model.Carro;


@Dependent
@OUTRAS
public class CalculoOutras implements Calculo{

	@Override
	public Carro calcularTotais(Carro carro){ 
		if(carro.isOutras()){
			if(verificaPlaca(carro)){
				carro.setValor(new BigDecimal(1));
			}else{
				carro.setValor(new BigDecimal(5));
			}
		}
		return carro;
	 }
	
	private boolean verificaPlaca(Carro carro){
		String letra;
		String aux = "";
		for (int i = 0; i < carro.getPlaca().length(); i++) {
			char c = carro.getPlaca().charAt(i);
			 letra = Character.toString(c);
			 if(letra.contains("B")){
			   	 aux += letra;
			 }
		 }
        
		String compare ="B99";
		StringBuffer retorno = new StringBuffer();
		retorno.append(carro.getPlaca().substring(5));
		String resultado = aux + retorno;
		if(resultado.equals(compare))
			return true;
		return false;
	}
			
}