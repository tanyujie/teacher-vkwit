package org.easymis.vkwit.teacher.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient("teacherapi")
public interface  UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    String findById(@RequestParam("id") String id);
}
