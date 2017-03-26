package com.benjsicam.restfulblog.rabbitmq;

import com.benjsicam.restfulblog.domain.Category;
import com.benjsicam.restfulblog.domain.PostCategory;
import com.benjsicam.restfulblog.domain.RabbitMQMessage;
import com.benjsicam.restfulblog.service.CategoryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class Receiver {

    @Autowired
    CategoryService categoryService;

    public void receiveMessage(byte[] bytes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RabbitMQMessage message = mapper.readValue(new String(bytes), RabbitMQMessage.class);
        List<Category> categories = Arrays.asList(mapper.readValue(message.getBody(), Category[].class));
        if ("post".equals(message.getMicroserviceName())){
            switch (message.getOperation()){

                case "create":
                        for(Category category :categories){
                        setCategoryPostCategory(category);
                        categoryService.create(category);
                    }
                    break;

                case "update":
                    for(Category category :categories){
                        setCategoryPostCategory(category);
                        categoryService.update(category);
                    }
                    break;
            }
        }
    }

    private void setCategoryPostCategory(Category category) {
        for(PostCategory postCategory : category.getPostCategories()){
            postCategory.setCategory(category);
        }
    }
}
