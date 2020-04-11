package com.goingao.gzh.web.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FIXME
 *
 * @author goingao
 * @date 2020-04-11
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @GetMapping("/list")
    public String list() {
        return "goods list";
    }
}
