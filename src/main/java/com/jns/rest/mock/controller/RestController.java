package com.jns.rest.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestController {
  
  @RequestMapping("/**")
  @ResponseBody
  public String one(
          @RequestBody(required=false) String body ) {
    if (body != null && !body.isEmpty()) {
        log.debug("------------------------------");
        log.debug("BODY:");
        log.debug(body);
    }
    return new String("Responser");
  }

}