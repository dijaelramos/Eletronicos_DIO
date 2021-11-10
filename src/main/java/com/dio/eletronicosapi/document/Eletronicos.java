package com.dio.eletronicosapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName ="Eletronicos_Api_Table")
public class Eletronicos {

    @Id
    @DynamoDBHashKey (attributeName = "id")
    private String id;

    @DynamoDBAttribute (attributeName = "brand")
    private String brand;

    @DynamoDBAttribute (attributeName = "model")
    private String model;

    @DynamoDBAttribute (attributeName = "Gb")
    private int Gb;

    public Eletronicos(String id, String brand, String model, int gb) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.Gb = gb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGb() {
        return Gb;
    }

    public void setGb(int gb) {
        Gb = gb;
    }
}
