package com.dio.eletronicosapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.dio.eletronicosapi.constants.EletronicosConstant.ENDPOINT_DYNAMO;
import static com.dio.eletronicosapi.constants.EletronicosConstant.REGION_DYNAMO;

public class EletronicosData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Eletronicos_Api_Table");

        Item eletronicos = new Item()
                .withPrimaryKey("id", "2")
                .withString("brand", "Asus")
                .withString("model", "Zenfone 6")
                .withNumber("Gb", 128);

        Item eletronicos2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("Brand", "Samsung")
                .withString("Model", "Note10")
                .withNumber("Gb", 64);

        Item eletronicos3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("Brand", "Xiaome")
                .withString("Model", "Redmi")
                .withNumber("Gb", 128);

        PutItemOutcome outcome1 = table.putItem(eletronicos);
        PutItemOutcome outcome2 = table.putItem(eletronicos2);
        PutItemOutcome outcome3 = table.putItem(eletronicos3);
    }
}
