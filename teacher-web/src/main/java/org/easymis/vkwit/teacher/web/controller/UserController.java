package org.easymis.vkwit.teacher.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.vkwit.teacher.client.service.UserFuture;
import org.easymis.vkwit.teacher.client.service.UserRestService;
import org.easymis.vkwit.teacher.object.UserQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Created by lenovo-t on 2019-05-16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRestService userService;
    @Autowired
    private UserFuture userFuture;
    @RequestMapping("/index")
    public String index(HttpSession httpSession) {
        httpSession.getAttribute("userLogin");
        return "index";
    }
    @RequestMapping(value="/{id}")
    public CompletableFuture<String> show(ModelMap model, @PathVariable String id) {
		return userFuture.findById(id).thenApply(json -> {
			UserQo user = new Gson().fromJson(json, UserQo.class);
			model.addAttribute("user", user);
			return "user/show";
		});
    }
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/login.do",method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        return null;
    }
    @RequestMapping(value="/logout.do",method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request,HttpSession session) {
        return null;
    }
    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
/*    @RequestMapping(value="/register.do",method = RequestMethod.POST)
    public ResponseEntity register(@RequestParam String username, @RequestParam String password) {
        EasyMisMember member = new EasyMisMember();
        return null;
    }*/

    /**
     * 找回密码
     * @param request
     * @param userName
     * @return
     */
    @RequestMapping(value = "/forgetPassword.do")
    @ResponseBody
    public Map forgetPass(HttpServletRequest request, String userName){
        Map map = new HashMap<String ,String >();
        return map;
    }
}
