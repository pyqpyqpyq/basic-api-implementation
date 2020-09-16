package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.Hs;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RsController {


    private List<Hs> hsList = init2List();

    private List<Hs> init2List() {
        List<Hs> temp2List = new ArrayList<>();
        temp2List.add(new Hs("第一条事件","无分类"));
        temp2List.add(new Hs("第二条事件","无分类"));
        temp2List.add(new Hs("第三条事件","无分类"));
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
    public Hs get_a_hs(@PathVariable String index) {
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
    public List<Hs> get_all_hs() {
        return hsList;
    }

    @PostMapping("/hs/event")
    public void add_a_hs( @RequestBody Hs temp) {
        hsList.add(temp);
    }


    @PutMapping("/hs/modify")
    public void modify_a_hs(@RequestParam Integer id, @RequestBody Hs hs) {
        if (id!=null){
        Hs tem=hsList.get(id-1);
        if (hs.getKey()!=null){tem.setKey(hs.getKey());}
        if (hs.getHs_name()!=null){tem.setHs_name(hs.getHs_name());}}
    }

    @DeleteMapping("/hs/delete/{index}")
    public void delete_a_hs(@PathVariable Integer index) {
        if (index!=null){
            hsList.remove(index-1);}
    }








}

