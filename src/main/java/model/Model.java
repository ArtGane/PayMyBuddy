package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Model {

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date creationDate = new Date();

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date modificationDate = new Date();

}
