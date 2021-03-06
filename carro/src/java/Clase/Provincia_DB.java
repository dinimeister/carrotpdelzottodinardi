/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;
import java.sql.*;
import java.util.*;
import Conexion.Conexion;
/**
 *
 * @author Daniel
 */
public class Provincia_DB {
    public static List<Provincia> ListarProvinciaPorCodigo(String CodigoDepart){
        List<Provincia> lista = new ArrayList<Provincia>();
        
        Provincia prov = new Provincia();
        
        Connection cn;
        Conexion con = new Conexion();
        cn=con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_PROVINCIA_POR_CODIGO (?)");
            cs.setString(1, CodigoDepart);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                prov.setCodigoProv(rs.getInt("IdProvincia"));
                prov.setNombreProv(rs.getString("provincia")); 
                lista.add(prov);
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        return lista;
    }
}
