package com.thoughtworks.rslist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RsController {
    private List<String> rsList = Arrays.asList("第一条事件", "第二条事件", "第三条事件");

    @GetMapping("/hs/{index}")
    public String get_a_hs(@PathVariable String index) {
        return rsList.get(Integer.parseInt(index) - 1);
    }

    @GetMapping("/hs/rg")
    public String get_a_hs(@RequestParam(required = false) Integer start,@RequestParam(required = false) Integer end) {
      if (start==null || end==null){
        return rsList.toString();
      }
        return rsList.subList(start-1, end).toString();
    }

}

