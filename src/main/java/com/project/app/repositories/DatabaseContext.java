package com.project.app.repositories;
import com.mongodb.ConnectionString;
import com.mongodb.MongoCredential;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    /*@Bean
    MongoClient mongoClient(){
        return MongoClients.create();
    }*/

    @Bean
    MongoDatabase database(){
        //Configuracion de codec para parsear POJO
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);

        //Cliente de base de datos
        MongoClient mongoClient =  MongoClients.create(new ConnectionString("mongodb://superAdmin:a1b2c3d4@3.16.50.104:27017/admin?authSource=admin&readPreference=primary&ssl=false"));
        MongoDatabase database = mongoClient.getDatabase("DB-Volunteeringo").withCodecRegistry(pojoCodecRegistry);
        return database;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoClient mongoClient =  MongoClients.create(new ConnectionString("mongodb://superAdmin:a1b2c3d4@3.16.50.104:27017/admin?authSource=admin&readPreference=primary&ssl=false"));
        return new MongoTemplate(mongoClient, "DB-Volunteeringo");
    }

    // Configuracion sql2o
    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPass;

    @Bean
    public Sql2o sql2o(){
        return new Sql2o(dbUrl, dbUser, dbPass);
    }

}
