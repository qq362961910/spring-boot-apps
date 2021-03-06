package com.jy.study.spring.websocket.study.controller;

import com.jy.study.spring.websocket.study.service.AsyncTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    private AsyncTaskService asyncTaskService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("async_task")
    public String asyncTask() {
        asyncTaskService.sleep10Second();
        return "success";
    }

    @RequestMapping("exception")
    public String exception() {
        throw new RuntimeException();
    }

    public TestController(AsyncTaskService asyncTaskService) {
        this.asyncTaskService = asyncTaskService;
    }
}
