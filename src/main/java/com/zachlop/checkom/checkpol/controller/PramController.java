package com.zachlop.checkom.checkpol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PramController {

    @GetMapping("/check")
    public String checkStatus(){
        return "Application is up";
    }
}
