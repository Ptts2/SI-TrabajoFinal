package dao;

import java.util.List;
import java.util.Scanner;
import modelo.Empresas;
import modelo.HibernateUtil;
import modelo.Nomina;
import modelo.Trabajadorbbdd;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberto
 */
public class daoBase {
    
    
    public void dao(){
        
        
        /* PRIMERA PRACTICA 
           //Pido la entrada del NIF
           System.out.println("Introduce el NIF del trabajador: ");
           Scanner sc = new Scanner(System.in);
           String nifTrabajador = sc.nextLine();
           
           
           //Inicio la sesion
           SessionFactory sf = HibernateUtil.getSessionFactory();
           Session sesion = sf.openSession();
           
           //Creo la consulta
           String consultaNif = "SELECT n FROM Trabajadorbbdd n WHERE n.nifnie=:param1";
           Query query = sesion.createQuery(consultaNif);
           query.setParameter("param1", nifTrabajador);
           
           List<Trabajadorbbdd> trabajadores = query.list();
           
           if(trabajadores.isEmpty()){
               System.out.println("ERROR: El trabajador no existe");
               HibernateUtil.shutdown();
               return;
           }
           
           Trabajadorbbdd trabajadorBuscado = trabajadores.get(0);
           
           //Imprimo los datos del punto 1
           System.out.println("Nombre: "+trabajadorBuscado.getNombre()+
                              "\nApellidos: "+trabajadorBuscado.getApellido1()+" "+trabajadorBuscado.getApellido2()+
                              "\nNIF: "+trabajadorBuscado.getNifnie()+
                              "\nCategoria: "+trabajadorBuscado.getCategorias().getNombreCategoria()+
                              "\nEmpresa: "+trabajadorBuscado.getEmpresas().getNombre()
           );
           
           System.out.println("-------------------------SALARIOS-------------------------");
           for(Object n : trabajadorBuscado.getNominas()){
               
              Nomina nom = (Nomina) n;
              System.out.println("Fecha: "+nom.getMes()+"/"+nom.getAnio()+"\nSalario Bruto: "+nom.getBrutoNomina());
              System.out.println("----------------------------------------------------------");
           }
           
           //Consulta para recuperar las empresas
           String consultaEmpresas = "FROM Empresas n";
           Query query2 = sesion.createQuery(consultaEmpresas);
           
           List<Empresas> empresas = query2.list();

           for(Empresas e : empresas){
               
               if(e.getNombre().equals(trabajadorBuscado.getEmpresas().getNombre()))
                   continue;
               
               e.setNombre(e.getNombre()+"2021");
               Transaction tx = sesion.beginTransaction();
               sesion.saveOrUpdate(e);
               tx.commit();
               System.out.println("El nombre de la empresa ha sido actualizado a  "+e.getNombre());
           }
           System.out.println("Nombre de empresas actualizado!");
           
           
           String consultaNominasAEliminar = "SELECT n FROM Nomina n WHERE n.trabajadorbbdd.empresas.idEmpresa!=:param1";
           String consultaTrabajadoresAEliminar = "SELECT n FROM Trabajadorbbdd n WHERE n.empresas.idEmpresa!=:param1";
           
           Query query3 = sesion.createQuery(consultaNominasAEliminar);
           query3.setParameter("param1", trabajadorBuscado.getEmpresas().getIdEmpresa());
           
           Query query4 = sesion.createQuery(consultaTrabajadoresAEliminar);
           query4.setParameter("param1", trabajadorBuscado.getEmpresas().getIdEmpresa());
           
           List<Nomina> nominasAElim = query3.list();
           List<Trabajadorbbdd> trabajadoresAElim = query4.list();
           
                          
           Transaction tx = sesion.beginTransaction();
           for(Nomina nom : nominasAElim){
               sesion.delete(nom);
           }
           tx.commit();
           
           Transaction tx2 = sesion.beginTransaction();
           for(Trabajadorbbdd t : trabajadoresAElim){
               sesion.delete(t);
           }
           tx2.commit();
           
           System.out.println("Nominas y trabajadores no pertenecientes a la emperesa "+trabajadorBuscado.getEmpresas().getNombre()+" fueron eliminados correctamente!");
           HibernateUtil.shutdown();
           */
    }

}
