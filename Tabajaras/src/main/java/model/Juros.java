package model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Juros {
    
    
    
    public double calculaJurosAtraso(double valor,LocalDate dataVencimento,
            int tipPagamento){
        
        double juros = 0;
        
        if(dataVencimento.isBefore(LocalDate.now())){
            
            int dias = (int) DAYS.between(LocalDate.now(), dataVencimento);

            

                juros = valor * 2 + dias * 0.033;

                juros = juros / 100.0;

            
            
        }else{
            
        }
        
        
        
        return juros;
    }
    
    public double calculaJurosPorParcelamento(double valor,LocalDate dataCompra,
            LocalDate dataVencimento, int tipoPagamento){
        
        double juros = 0;
        
        switch (tipoPagamento){
                
                case 1:
                    break;
                case 2:
                    juros = valor * 2.03;
                    break;
                case 3:
                    juros = valor * 4.06;
                    break;
                case 4:
                    juros = valor * 6.09;
                    break;
                case 5:
                    juros = valor * 7.64;
                    break;
                case 6:
                    juros = valor * 8.92;
                    break;
                case 7:
                    juros = valor * 10.06;
                    break;
                case 8:
                    juros = valor * 10.62;
                    break;    
                case 9:
                    juros = valor * 11.23;
                    break;
                case 10:
                    juros = valor * 12.41;
                    break;
                case 11:
                    juros = valor * 13.60;
                    break;
                case 12:
                    juros = valor * 14.80;
                    break;    
                    
        }
        
        juros = juros / 100.0;
        
        return juros;
    }
    
    public double calculaJurosPorParcelamento(double valor,LocalDate dataVencimento, int tipoPagamento){
        
        double juros = 0;
        
        switch (tipoPagamento){
                
                case 1:
                    break;
                case 2:
                    juros = valor * 2.03;
                    break;
                case 3:
                    juros = valor * 4.06;
                    break;
                case 4:
                    juros = valor * 6.09;
                    break;
                case 5:
                    juros = valor * 7.64;
                    break;
                case 6:
                    juros = valor * 8.92;
                    break;
                case 7:
                    juros = valor * 10.06;
                    break;
                case 8:
                    juros = valor * 10.62;
                    break;    
                case 9:
                    juros = valor * 11.23;
                    break;
                case 10:
                    juros = valor * 12.41;
                    break;
                case 11:
                    juros = valor * 13.60;
                    break;
                case 12:
                    juros = valor * 14.80;
                    break;    
                    
        }
        
        juros = juros / 100.0;
        
        juros = juros + this.calculaJurosAtraso(valor, dataVencimento, 1);
        
        return juros;
    }
    
}
