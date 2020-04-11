package com.goingao.gzh.web.goods.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @GetMapping("/list")
    public String list() {
        logger.trace("trace 这是商品列表");
        logger.debug("debug 这是商品列表");
        logger.info("info 这是商品列表");
        logger.warn("warn 这是商品列表");
        logger.error("error 这是商品列表");
        return "goods list";
    }
}
