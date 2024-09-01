package com.mongo.springmogodb.repository;

import com.mongo.springmogodb.entity.Author;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CustomAutherORepompl implements CustomAuthorRepo{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateByEmail(String email, String name,String phone) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("name", name);
        update.set("phone", phone);

        UpdateResult res= mongoTemplate.updateFirst(query,update, Author.class);
        if (res==null) System.out.println("No Docs Updated");
        else System.out.println(res.getMatchedCount()+" Docs Updated");
    }
}
