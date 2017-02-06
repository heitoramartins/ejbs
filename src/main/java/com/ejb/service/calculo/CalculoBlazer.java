package com.ejb.service.calculo;

import java.math.BigDecimal;

import javax.enterprise.context.Dependent;

import com.ejb.annotation.GM;
import com.ejb.model.Carro;


@Dependent
@GM
public class CalculoBlazer implements Calculo{

	@Override
	public Carro calcularTotais(Carro carro) {
		if(carro.isGM() && carro.getMarca()
				.equalsIgnoreCase("BLAZER"))
			if(verificaPlaca(carro)){
				carro.setValor(new BigDecimal(1));
			}else{
				carro.setValor(new BigDecimal(20));
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
