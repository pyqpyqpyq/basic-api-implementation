package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.RsEvent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(path="/rs", produces = "application/json; charset=utf-8")
@RestController
public class RsController {
//  private List<String> rsList = Arrays.asList("第一条事件", "第二条事件", "第三条事件");
  private final List<RsEvent> rsList;

  public RsController(){
    rsList=new ArrayList<RsEvent>(){{
      add(new RsEvent("第一条事件","无分类"));
      add(new RsEvent("第二条事件","无分类"));
      add(new RsEvent("第三条事件","无分类"));
    }};
  }

  @PutMapping("/event/{index}")
  public RsEvent updateRsEvent(@RequestBody RsEvent rsEvent, @PathVariable int index){
    index--;
    validateIndex(index);
    rsList.set(index,rsEvent);
    return rsEvent;
  }

  @DeleteMapping("/event/{index}")
  public RsEvent deleteRsEvent(@PathVariable int index){
    index--;
    validateIndex(index);
    return rsList.remove(index);
  }

  private void validateIndex(int index){
    if (index<0||index>=rsList.size()){
      throw new RuntimeException("index out of range");
    }
  }
}
