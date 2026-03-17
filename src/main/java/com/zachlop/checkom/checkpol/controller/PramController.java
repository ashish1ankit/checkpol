package com.zachlop.checkom.checkpol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PramController {
private static final Logger logger = LoggerFactory.getLogger(PramController.class);
    @GetMapping("/check")
    public String checkStatus(){
        logger.info("🟢 SUCCESS: Someone just visited the /hello endpoint!");
        return "Application is up";
    }
}
