package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.Exception.CommonError;
import com.thoughtworks.rslist.Exception.MyException;
import com.thoughtworks.rslist.dto.Hs;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RsController {


    private List<Hs> hsList = init2List();

    private List<Hs> init2List() {
        List<Hs> temp2List = new ArrayList<>();
        temp2List.add(new Hs("第一条事件", "无分类"));
        temp2List.add(new Hs("第二条事件", "无分类"));
        temp2List.add(new Hs("第三条事件", "无分类"));
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

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        ALL Above based on the hot search is Class of String instead of Hs and has been
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @GetMapping("/hs/{index}")
    public ResponseEntity<Hs> get_a_hs(@PathVariable Integer index) throws MyException {
        if (index >= 3 || index >= 1) {
            return ResponseEntity.ok(hsList.get(index - 1));
        }
        throw new MyException();


    }

    @GetMapping("/hs/rg")
    public ResponseEntity<List<Hs>> get_a_list_of_hs(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {
        if (start == null || end == null) {
            return ResponseEntity.ok(hsList);
        }
        if (start > 0 && start <= hsList.size() && end <= hsList.size() && end <= hsList.size()) {
            throw new IndexOutOfBoundsException();
        }
        return ResponseEntity.ok(hsList.subList(start - 1, end));
    }


    @GetMapping("/hs/list")
    public List<Hs> get_all_hs() {
        return hsList;
    }

    @PostMapping("/hs/event")
    public void add_a_hs(@Validated @RequestBody Hs temp) {
        hsList.add(temp);
    }


    @PutMapping("/hs/modify")
    public void modify_a_hs(@RequestParam Integer id, @RequestBody Hs hs) {
        if (id != null) {
            Hs tem = hsList.get(id - 1);
            if (hs.getKey() != null) {
                tem.setKey(hs.getKey());
            }
            if (hs.getHs_name() != null) {
                tem.setHs_name(hs.getHs_name());
            }
        }
    }

    @DeleteMapping("/hs/delete/{index}")
    public void delete_a_hs(@PathVariable Integer index) {
        if (index != null) {
            hsList.remove(index - 1);
        }
    }


    @ExceptionHandler({IndexOutOfBoundsException.class, MyException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<CommonError> handleIndexOutOfBoundsException(Exception ex) {
        if (ex instanceof IndexOutOfBoundsException) {
            CommonError commonError = new CommonError();
            commonError.setError("invalid request param");
            return ResponseEntity.status(400).body(commonError);
        }
//        if (ex instanceof MyException){
//            CommonError commonError = new CommonError();
//            commonError.setError("invalid index");
//            return ResponseEntity.status(400).body(commonError);
//        }
        if (ex instanceof MethodArgumentNotValidException){
            CommonError commonError = new CommonError();
            commonError.setError("invalid param");
            return ResponseEntity.status(400).body(commonError);
        }
        CommonError commonError = new CommonError();
        commonError.setError("invalid index");
        return ResponseEntity.status(400).body(commonError);
    }

}

