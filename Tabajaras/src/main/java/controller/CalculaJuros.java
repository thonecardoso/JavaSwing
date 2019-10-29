/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author thone
 */
public class CalculaJuros {
    
    
	
	public double calculoJurosParcelamento(double valor, int quantParcela, Integer tipoPagamento ) {
		double result=valor;
		
		
		for(int i=0;i<quantParcela;i++) {
			result+=result*0.1;
		}
		
		if(tipoPagamento==2) {
			result+=result*0.013;
		}
		else if(tipoPagamento==3) {
			result+=result*0.018;
		}
		return result-valor;
		
	}
	
	public double calculaJurosPorAtraso(double valor, LocalDate dataVencimento, LocalDate dataPagamento) {
		double result=valor;
		long difDias = ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
		
		if(difDias>0&&difDias<=15) {
			result=result*1.03;		
		}
		else if(difDias>=16&&difDias<=30) {
			result=result*1.09;
		}
		else if(difDias>30)
			result=result + (result*0.033)*difDias;
		
		return result-valor;
	}

    
}
