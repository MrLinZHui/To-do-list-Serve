package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.domain.Dolist;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "*")
@Controller
@RequestMapping(path = "/dolists")
public class DoListController {
    private List<Dolist> dolists = new ArrayList<>();

    @PostMapping
    public ResponseEntity addList(@RequestBody Dolist dolist){
        System.out.println("listValue:"+dolist.getListValue()+",isEditing:"+dolist.isSelecting());
        dolists.add(dolist);
        return ResponseEntity.ok(getJsonArray());
    }
    @GetMapping
    public  ResponseEntity getList(){
        return ResponseEntity.ok(getJsonArray());
    }

    private JSONArray getJsonArray() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonpObject = new JSONObject();
        System.out.println("dolists.size:"+dolists.size());
        if(dolists.size()>0) {
            dolists.forEach(dolist -> {
                jsonpObject.put("itemName", dolist.getListValue());
                jsonpObject.put("isSelected", dolist.isSelecting());
                jsonArray.add(jsonpObject);
            });
        }
        return jsonArray;
    }

    @PutMapping(path = "/{index}")
    public ResponseEntity updateList(@PathVariable int index){
        System.out.println(index);
        Dolist  dolist =  dolists.get(index);
        dolists.get(index).setSelecting(!dolist.isSelecting());
        return ResponseEntity.ok(getJsonArray());
    }
    @DeleteMapping(path = "/{index}")
    public ResponseEntity deleteFromList(@PathVariable int index){
        dolists.remove(index);
        return ResponseEntity.ok(getJsonArray());
    }
}
