/**
 * 
 */
package com.blueharvest.repository.ws.util;

/**
 * @author Parantap Mathur
 *
 */
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blueharvest.repository.db.dao.UserAccountRepository;
import com.blueharvest.repository.db.entity.Customer_Account;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(UserAccountRepository repository) {
    return args -> {
     // System.out.println("Preloading " + repository.save(new Account("fromApp1", "app api", 23, null, "AppApi11")));
      //System.out.println("Preloading " + repository.save(new Account("fromApp2", "app api", 33, null, "AppApi22")));
    };
  }
}
