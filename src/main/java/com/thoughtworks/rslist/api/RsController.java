package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.hs;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RsController {


    private List<hs> hsList = init2List();

    private List<hs> init2List() {
        List<hs> temp2List = new ArrayList<>();
        temp2List.add(new hs("第一条事件","无分类"));
        temp2List.add(new hs("第二条事件","无分类"));
        temp2List.add(new hs("第三条事件","无分类"));
        return temp2List;
    }
//======================================================
//        private List<String> tempList = new ArrayList<>();
//    private List<String> rsList = initList();
//
//    private List<String> initList() {
//        List<String> tempList = new ArrayList<>();
//        tempList.add("第一条事件");
//        tempList.add("第二条事件");
//        tempList.add("第三条事件");
//        return tempList;
//    }
//
//    @GetMapping("/hs/{index}")
//    public String get_a_hs(@PathVariable String index) {
//        return rsList.get(Integer.parseInt(index) - 1);
//    }
//
//    @GetMapping("/hs/rg")
//    public String get_a_list_of_hs(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {
//        if (start == null || end == null) {
//            return rsList.toString();
//        }
//        return rsList.subList(start - 1, end).toString();
//    }
//
//    @GetMapping("/hs/list")
//    public String get_all_hs() {
//        return rsList.toString();
//    }
//
//    @PostMapping("/hs/event")
//    public void add_a_hs(@RequestBody String temp) {
//        rsList.add(temp);
//    }
//    =======================================================================



//    private List<hs> initList() {
//        List<String> tempList = new ArrayList<>();
//        tempList.add("第一条事件");
//        tempList.add("第二条事件");
//        tempList.add("第三条事件");
//        return tempList;
//    }

    @GetMapping("/hs/{index}")
    public hs get_a_hs(@PathVariable String index) {
        return hsList.get(Integer.parseInt(index) - 1);
    }

    @GetMapping("/hs/rg")
    public String get_a_list_of_hs(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {
        if (start == null || end == null) {
            return hsList.toString();
        }
        return hsList.subList(start - 1, end).toString();
    }

    @GetMapping("/hs/list")
    public List<hs> get_all_hs() {
        return hsList;
    }

    @PostMapping("/hs/event")
    public void add_a_hs( @RequestBody hs temp) {
        hsList.add(temp);
    }











}

