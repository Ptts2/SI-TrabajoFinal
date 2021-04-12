package proyectosi2_ar;

import dao.daoBase;
import java.util.List;
import java.util.Scanner;
import modelo.Empresas;
import modelo.HibernateUtil;
import modelo.Nomina;
import modelo.Trabajadorbbdd;
import modelo.Validador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Roberto
 */
public class ProyectoSI2_AR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        //new daoBase().dao();
        
        System.out.println(new Validador().generarIBAN("20960043043554600000", "ES"));
        System.out.println(new Validador().validarIBAN("ES9211112223504444444444"));
        System.out.println(new Validador().generarDigitoDNI("X9924125"));
        System.out.println(new Validador().validarDigitoDNI("X9924125Q"));
        System.out.println(new Validador().generarDigitosControl("20960043043554600000"));
        System.out.println(new Validador().validarDigitosControl("20960043043554600000"));
    }
    
}
