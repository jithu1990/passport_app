/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passport.application.DAO;

import com.passport.application.Applybean;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 *
 * @author muhammed.noushad
 */
public class AllDAO {
    private Object abean;

public boolean Register(String U, String P) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
    SecureRandom scr=SecureRandom.getInstance("SHA1PRNG");
    int rnd=scr.nextInt(100000);
    int ret= this.getStatement().executeUpdate("Insert into login values ("+rnd+",'"+U+"','"+P+"','Apply')");
    System.out.println(ret);
    
    if(ret!=0){return true;}
    else{return false;}
    }
    
public boolean LoginDAO(String U, String P) throws SQLException, ClassNotFoundException
{
ResultSet rt = this.getStatement().executeQuery("select * from login where UN='"+U+"' and PD='"+P+"'");
return rt.next();
}

public Statement getStatement() throws SQLException, ClassNotFoundException
    {
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Passport","pass","pass");
       Statement stmt=con.createStatement();
       return stmt; 
    }

    public int getUID(String UN) throws SQLException, ClassNotFoundException {
        
        ResultSet rs=this.getStatement().executeQuery("select * from login where UN='"+UN+"'");
        if(rs.next()){return rs.getInt(1);}
        else{return 0;}
    }

    public boolean ApplyDAO(Applybean abean, int UID) throws SQLException, ClassNotFoundException {
        int ret= this.getStatement().executeUpdate("Insert into application values ("+UID+",'"+abean.getGname()+"','"+abean.getSname()+"','"+abean.getFname()+"','"+abean.getMname()+"','"+abean.getPbirth()+"','"+abean.getAddress()+"',"+abean.getPin()+",'"+abean.getEmail()+"',"+abean.getPhone()+",'Applied')");
        if(ret!=0){return true;}
         else{return false;}
    
    }

    public boolean checkStatus(int UID) throws SQLException, ClassNotFoundException {
        String Status="";
        ResultSet rs=this.getStatement().executeQuery("select status from application where UID="+UID);
        while(rs.next()){ Status=rs.getString("status");}
        if (Status.equalsIgnoreCase("Applied")||Status.equalsIgnoreCase("Approved")){return false;}
        else{return true;}
    }

    public String checkRole(String User) throws SQLException, ClassNotFoundException {
        ResultSet rs=this.getStatement().executeQuery("select * from login where UN='"+User+"'");
        if(rs.next()){
        return rs.getString("role");
        }
        else{return "fail";
    }
    }

    public boolean ApproveReject(String UID, String Action) throws SQLException, ClassNotFoundException {
        int ret=0;
        if (Action.equalsIgnoreCase("Approved")){
        ret= this.getStatement().executeUpdate("update application set status='Approved' where UID="+Integer.parseInt(UID)+" and status='Applied'");
        }
        if (Action.equalsIgnoreCase("Rejected")){
        ret= this.getStatement().executeUpdate("update application set status='Rejected' where UID="+Integer.parseInt(UID));
        }
       
        if(ret!=0){return true;}
        else{return false;}
        
    }
    
    public String getToken()
    {
     
    String token=UUID.randomUUID().toString();
    
    return token;
    }
    
    public boolean validateToken(String RToken,String Stoken)
    {
    if(Stoken.equalsIgnoreCase(RToken)){return true;}
    else{return false;}
    }
}
