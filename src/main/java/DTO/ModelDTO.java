package DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ModelDTO {

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date creationDate = new Date();
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date modificationDate = new Date();

}
