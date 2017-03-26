package com.benjsicam.restfulblog.service;

import com.benjsicam.restfulblog.RestfulBlogCredentialsApplication;
import com.benjsicam.restfulblog.dao.CredentialsRepository;
import com.benjsicam.restfulblog.domain.Credentials;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {

    private static final Log logger = LogFactory.getLog(CredentialsService.class);


    @Autowired
    CredentialsRepository credentialsRepository;

    @HystrixCommand(fallbackMethod = "getDefaultCredentials")
    public Credentials getCredentialsByUserName(String userName){
        Credentials credentials = this.credentialsRepository.findByUsername(userName);
        credentials.getRoles().add("ROLE_USER");
        logger.info("you called getCredentialsByUserName");
        return credentials;
    }

    public Credentials getDefaultCredentials(String userName){
        return new Credentials();
    }



    public void saveAndFlush(Credentials credentials){
        this.credentialsRepository.saveAndFlush(credentials);
        logger.info("you called saveAndFlush");
    }

    public void delete(Long id){
        this.credentialsRepository.delete(id);
        logger.info("you called delete");
    }

}
