/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdcm.soap.services;

import com.isdcm.soap.dao.VideoDAO;
import com.isdcm.soap.dto.VideoDTO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fiblabs
 */
@WebService(serviceName = "SearchVideoWS")
public class SearchVideoWS {
    
    private final VideoDAO videoDAO;

    public SearchVideoWS() {
        this.videoDAO = new VideoDAO();
    }


    /**
     * Web service operation
     * @param title
     * @return List
     */
    @WebMethod(operationName = "searchByTitle")
    public List<VideoDTO> searchByTitle(@WebParam(name = "title") String title) {
        return videoDAO.searchByTitle(title);
    }

    /**
     * Web service operation
     * @param author
     * @return 
     */
    @WebMethod(operationName = "searchByAuthor")
    public List<VideoDTO> searchByAuthor(@WebParam(name = "author") String author) {
        return videoDAO.searchByAuthor(author);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByCreationDate")
    public List<VideoDTO> searchByCreationDate(@WebParam(name = "day") int day, @WebParam(name = "month") int month, @WebParam(name = "year") int year) {
        return videoDAO.searchByCreationDate(day, month, year);
    }
}
