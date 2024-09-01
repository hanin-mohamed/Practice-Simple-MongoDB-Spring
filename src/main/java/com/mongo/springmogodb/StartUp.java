package com.mongo.springmogodb;

import com.mongo.springmogodb.entity.Author;
import com.mongo.springmogodb.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartUp implements CommandLineRunner {
    @Autowired
    private AuthorRepo autherRepo;

    @Override
    public void run(String... args) throws Exception {

      if (autherRepo.findAll().isEmpty()) {
          Author author = new Author();
          author.setName("Haneen");
          author.setEmail("haneen@gmail.com");
          author.setPhone("01559844210");
          Author author2 = new Author();
          author2.setName("Mohamed");
          author2.setEmail("Mohamed@gmail.com");
          author2.setPhone("01060244681");
          Author author3 = new Author();
          author3.setName("Ahmed");
          author3.setEmail("Ahmed@gmail.com");
          author3.setPhone("01229798943");
          autherRepo.insert(Arrays.asList(author, author2, author3));

      }
    }
}
