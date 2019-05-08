/**
 * 
 */
package com.blueharvest.repository.ws.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blueharvest.repository.db.dao.UserTransationRepository;
import com.blueharvest.repository.db.entity.Transation;

/**
 * @author Parantap Mathur
 *
 */
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadTransationDataBase {

  @Bean
  CommandLineRunner initTransDatabase(UserTransationRepository repository) {
    return args -> {
      System.out.println("Preloading " + repository.save(new Transation("1234acb12p1", "Parantap", 30, "API testing", "Harvest-Accnt-1", null)));
      
      
    };
  }
}
