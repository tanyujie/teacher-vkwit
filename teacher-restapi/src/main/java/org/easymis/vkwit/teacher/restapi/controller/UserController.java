package org.easymis.vkwit.teacher.restapi.controller;

import java.util.concurrent.CompletableFuture;

import org.easymis.vkwit.teacher.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public CompletableFuture<String> findById(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> userService.findOne(id))
                .thenApply(user ->{
                    return new Gson().toJson(user);
                });
    }
}
