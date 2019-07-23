package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.domain.Dolist;
import com.thoughtworks.parking_lot.service.DolistService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(value = "*")
@Controller
@RequestMapping(path = "/dolists")
public class DoListController {
    private List<Dolist> dolists = new ArrayList<>();
    @Autowired
    DolistService dolistService;
    @PostMapping
    public ResponseEntity addList(@RequestBody Dolist dolist){
        dolists.add(dolist);
        return ResponseEntity.ok(dolistService.addList(dolist));
    }
    @GetMapping
    public  ResponseEntity getList(){
        return ResponseEntity.ok(dolistService.getList());
    }


    @PutMapping(path = "/{index}")
    public ResponseEntity updateList(@PathVariable int index){
        return ResponseEntity.ok(dolistService.updateList(index));
    }
    @DeleteMapping(path = "/{index}")
    public ResponseEntity deleteFromList(@PathVariable int index){
        //dolists.remove(index);
        return ResponseEntity.ok(dolistService.deleteFromList(index));
    }
}
