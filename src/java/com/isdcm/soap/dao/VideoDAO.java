package com.isdcm.soap.dao;

import com.isdcm.soap.dto.VideoDTO;
import com.isdcm.soap.jdbc.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    
    public List<VideoDTO> searchByTitle(String title){
        List<VideoDTO> list = new ArrayList<>();
        try{
            DataSource ds = DataSource.getInstance();
            String sql = "SELECT * FROM MYDB.VIDEO WHERE UPPER(TITULO) LIKE UPPER(?)";
            PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");

            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                VideoDTO video = new VideoDTO();
                video.setTitulo(result.getString("titulo"));
                video.setAutor(result.getString("autor"));
                video.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());
                video.setDuracion(result.getTime("duracion").toLocalTime());
                video.setReproducciones(result.getInt("reproducciones"));
                video.setDescripcion(result.getString("descripcion"));
                video.setFormato(result.getString("formato"));
                list.add(video);
            }
            
            ds.getConnection().close();
        }
        catch(SQLException e){ System.out.println(e);}
        return list;
    }
    
    public List<VideoDTO> searchByAuthor(String author){
        List<VideoDTO> list = new ArrayList<>();
        try{
            DataSource ds = DataSource.getInstance();
            String sql = "SELECT * FROM MYDB.VIDEO WHERE UPPER(AUTOR) LIKE UPPER(?)";
            PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);
            pstmt.setString(1, "%" + author + "%");

            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                VideoDTO video = new VideoDTO();
                video.setTitulo(result.getString("titulo"));
                video.setAutor(result.getString("autor"));
                video.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());
                video.setDuracion(result.getTime("duracion").toLocalTime());
                video.setReproducciones(result.getInt("reproducciones"));
                video.setDescripcion(result.getString("descripcion"));
                video.setFormato(result.getString("formato"));
                list.add(video);
            }
            
            ds.getConnection().close();
        }
        catch(SQLException e){ System.out.println(e);}
        return list;
    }
    
    public List<VideoDTO> searchByCreationDate(int day, int month, int year){
        List<VideoDTO> list = new ArrayList<>();
        try{
            DataSource ds = DataSource.getInstance();            
            String sql = "SELECT * FROM MYDB.VIDEO WHERE 1 = 1 ";
            ArrayList parameters = new ArrayList();

            if(day != 0) {
                sql += " AND DAY(FECHA_CREACION)=?";
                parameters.add(day);
            }

            if(month != 0){
                sql += " AND MONTH(FECHA_CREACION)=?";
                parameters.add(month);
            }
            
            if(year != 0){
                sql += " AND YEAR(FECHA_CREACION)=?";
                parameters.add(year);
            }
            
            sql += " ORDER BY FECHA_CREACION DESC";
            
            PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);
            
            //add parameters to statement
            int index = 1;
            for (Object param : parameters) {
                pstmt.setObject(index, param);
                index++;
            }

            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                VideoDTO video = new VideoDTO();
                video.setTitulo(result.getString("titulo"));
                video.setAutor(result.getString("autor"));
                video.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());
                video.setDuracion(result.getTime("duracion").toLocalTime());
                video.setReproducciones(result.getInt("reproducciones"));
                video.setDescripcion(result.getString("descripcion"));
                video.setFormato(result.getString("formato"));
                list.add(video);
            }
            
            ds.getConnection().close();
        }
        catch(SQLException e){ System.out.println(e);}
        return list;
    }
}
