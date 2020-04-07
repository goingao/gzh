package com.goingao.gzh.web.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FIXME
 *
 * @author goingao
 * @date 2020-04-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public String queryUser() {
        log.info("查询 user list");
        return "ok";
    }
}
