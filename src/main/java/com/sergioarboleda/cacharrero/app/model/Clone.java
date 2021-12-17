package com.sergioarboleda.cacharrero.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @author Carotobarj
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clone")
public class Clone {

    @Id
    private Integer id;
    private String brand;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private boolean availability;
    private double price;
    private int quantity;
    private String photography;
}


