package com.zmbdp.output.controller;

import com.zmbdp.output.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    private OutputService outputService;

    @RequestMapping("/getValue/{value}")
    public String getValue(@PathVariable("value") String value) {
        log.info("接收到 value: {}", value);
        return outputService.getValue(value);
    }
}
