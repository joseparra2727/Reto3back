package com.sergioarboleda.cacharrero.app.model;


import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Map;

/**
 * @author Carotobarj
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")


public class Order {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;

    private Map<String, Clone> products;
    private Map<String, Integer> quantities;

}


