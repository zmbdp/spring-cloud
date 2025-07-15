package com.zmbdp.input.controller;

import com.zmbdp.input.service.InputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    private InputService inputService;

    @RequestMapping("/setValue")
    public String setValue(@RequestParam("value") String value) {
        return inputService.setValue(value);
    }
}
