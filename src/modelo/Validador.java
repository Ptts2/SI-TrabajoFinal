package modelo;

import java.math.BigInteger;

/**
 *
 * @author Roberto
 */
public class Validador {
    
    
    public String generarIBAN(String cuenta, String pais){
        
        if(cuenta.length()!= 20 || pais.length()!=2) return null;
        
        
        final String tablaLetras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        final String[] tablaTransformacion = {"10", "11", "12", "13", "14", 
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"}; 
        
        //Pais numeros -> 14 28 -> 142800
        
        String numPais = tablaTransformacion[tablaLetras.indexOf(pais.charAt(0))]+tablaTransformacion[tablaLetras.indexOf(pais.charAt(1))];
        numPais+="00";
        
        //control = 98 - resto cuenta%97
        
        BigInteger cuentaNumPais = new BigInteger(cuenta+numPais);
        BigInteger control98= cuentaNumPais.mod(new BigInteger("97"));
        
        int control = 98 - control98.intValue();
        String controlS;
        
        if(control < 10){
            controlS=String.valueOf(control)+"0";
        }else{
            controlS=String.valueOf(control);
        }
        
        return pais+controlS+cuenta;
    }
    
    public boolean validarIBAN(String IBAN){
        
        if(IBAN == null || IBAN.length() == 0) return false;
        
        final String tablaLetras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        final String[] tablaTransformacion = {"10", "11", "12", "13", "14", 
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"}; 
        
        String control = IBAN.substring(2,4);
        String pais = IBAN.substring(0,2);
        String cuenta = IBAN.substring(4);
        String numPais = tablaTransformacion[tablaLetras.indexOf(pais.charAt(0))]+tablaTransformacion[tablaLetras.indexOf(pais.charAt(1))];

        BigInteger resto= new BigInteger(cuenta+numPais+control).mod(new BigInteger("97"));
        
        return resto.intValue()==1;

    }
    
    public String generarDigitoDNI(String NumDNI){
        
        if(NumDNI == null || NumDNI.length() == 0) return null;
        
        final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        String DNI = NumDNI;
        
        String letraNie = String.valueOf(NumDNI.charAt(0));
        
        
        if(letraNie.equals("X")){
            DNI = "0"+NumDNI.substring(1);
        }else if(letraNie.equals("Y")){
            DNI = "1"+NumDNI.substring(1);
        }else if(letraNie.equals("Z")){
            DNI = "2"+NumDNI.substring(1);
        }
        
        BigInteger DNIn = new BigInteger(DNI);
        int resto = (DNIn.mod(new BigInteger("23"))).intValue();
        char digito = letras.charAt(resto);
        
        return String.valueOf(digito);
    }
    
    
    public boolean validarDigitoDNI(String DNI){
        
        if(DNI == null || DNI.length() == 0) return false;
        
        String letra = String.valueOf(DNI.charAt(8));
        return letra.equals(generarDigitoDNI(DNI.substring(0,8)));
    }
    
    
    public String generarDigitosControl(String cuenta){
        
        if(cuenta == null || cuenta.length() == 0) return null;
        
        String partePrimerDigito="00"+cuenta.substring(0,8);
        String parteSegundoDigito=cuenta.substring(10);
        
        //multiplicar 2^n mod 11 por el num
        int primerDigControl = 0;
        int segundoDigControl = 0;
        
        for(int i = 0; i<10; i++){
            
            primerDigControl += (Math.pow(2, i)%11)*Integer.parseInt(String.valueOf(partePrimerDigito.charAt(i)));
            segundoDigControl += (Math.pow(2, i)%11)*Integer.parseInt(String.valueOf(parteSegundoDigito.charAt(i)));
        }
        
        primerDigControl %= 11;
        segundoDigControl %= 11;
        
        primerDigControl = 11 - primerDigControl;
        segundoDigControl = 11 - segundoDigControl;
        
        if(primerDigControl == 10){
            primerDigControl = 1;
        }else if(primerDigControl == 11){
            primerDigControl = 0;
        }
        
        if(segundoDigControl == 10){
            segundoDigControl = 1;
        }else if(segundoDigControl == 11){
            segundoDigControl = 0;
        }
        
        return String.valueOf(primerDigControl)+String.valueOf(segundoDigControl);
    }
    
    public boolean validarDigitosControl(String cuenta){
        
        if(cuenta == null || cuenta.length() == 0) return false;
        
        String digitosControl = cuenta.substring(8,10);
        return generarDigitosControl(cuenta).equals(digitosControl);
    }
    
}
