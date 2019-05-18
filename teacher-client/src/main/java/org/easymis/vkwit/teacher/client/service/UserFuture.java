package org.easymis.vkwit.teacher.client.service;


import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFuture {
    @Autowired
    private UserRestService userRestService;
    public CompletableFuture<String> findById(String id) {
        return CompletableFuture.supplyAsync(() -> {
            return userRestService.findById(id);
        });
    }
}

