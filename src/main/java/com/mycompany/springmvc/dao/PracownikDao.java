/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvc.dao;

import com.mycompany.springmvc.beans.Pracownik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PracownikDao {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(Pracownik p){
        String sql = "insert into pracownik (nazwisko,pensja,firma) "
                + "values ('" + p.getNazwisko() + "'," + p.getPensja() + ",'" + p.getFirma() + "')";
        return template.update(sql);
    }
    
    public int delete(int id){
        String sql = "Delete from pracownik where id="+ id + "";
        return template.update(sql);
    }
    
    public int update(Pracownik p){
        String sql = "update  pracownik set nazwisko = '" + p.getNazwisko() + "', pensja='" +  p.getPensja() + "', firma = '" + p.getFirma() +"' where id =" +p.getId() + ";";
        return template.update(sql);
    }
    
    public Pracownik getPracownikById(int id){
        String sql="select * from pracownik where id=?" ; 
        return template.queryForObject(sql, new Object[]{id},
            new BeanPropertyRowMapper<>(Pracownik.class));
    }
 
    public List <Pracownik> getAll(){
        return template.query("select * from pracownik", 
                new RowMapper <Pracownik> (){
                
                    @Override
                    public Pracownik mapRow(ResultSet rs, int row)
                    throws SQLException{
                        Pracownik e = new Pracownik();
                        e.setId(rs.getInt(1));
                        e.setNazwisko(rs.getString(2));
                        e.setPensja(rs.getFloat(3));
                        e.setFirma(rs.getString(4));
                        return e;
                    }
                });
    }
}
