package com.mongo.springmogodb.service;
import com.mongo.springmogodb.entity.Author;
import com.mongo.springmogodb.repository.AuthorRepo;
import com.mongo.springmogodb.repository.CustomAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private CustomAuthorRepo customAuthorRepo;
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author findById(String id) {
        return authorRepo.findById(id).get();
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author findByEmail(@PathVariable String email) {
        return authorRepo.findByEmail(email);
    }

    public Author insert(Author entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException("ID should be null when inserting a new entity.");
        }
        return authorRepo.save(entity);
    }

    public List<Author> insertAll(List<Author> entities) {
        return authorRepo.saveAll(entities);
    }

    public Author update(Author entity) {
        Author author = findById(entity.getId());
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        author.setPhone(entity.getPhone());
        return authorRepo.save(entity);
    }
    public void  updateByEmail(String email,String name,String phone){
        customAuthorRepo.updateByEmail(email,name,phone);
    }


    public void deleteById(String id) {
        authorRepo.deleteById(id);
    }
}
