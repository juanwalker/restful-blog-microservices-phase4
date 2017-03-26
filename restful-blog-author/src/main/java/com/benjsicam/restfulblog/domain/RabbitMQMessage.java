package com.benjsicam.restfulblog.domain;

/**
 * Created by The Colombia on 16/02/2017.
 */
public class RabbitMQMessage {

    private String microserviceName;
    private String operation;
    private String body;

    public RabbitMQMessage(){

    }

    public RabbitMQMessage(String microserviceName, String operation, String body){
        this.microserviceName = microserviceName;
        this.operation = operation;
        this.body = body;
    }

    public String getMicroserviceName() {
        return microserviceName;
    }

    public void setMicroserviceName(String microserviceName) {
        this.microserviceName = microserviceName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
