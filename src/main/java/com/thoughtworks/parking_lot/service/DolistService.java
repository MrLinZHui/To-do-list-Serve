package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.domain.Dolist;
import com.thoughtworks.parking_lot.repository.DolistRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DolistService {
    @Autowired
    DolistRepository dolistRepository;
    public Object addList(Dolist dolist){
        //dolists.add(dolist);
        JSONObject jsonObject = new JSONObject();
        List<Dolist> dolists = dolistRepository.findAll();
        List<Dolist> dolists1  =dolists.stream().filter(dolist1 -> dolist1.getListValue().equals(dolist.getListValue())).collect(Collectors.toList());
        if(dolists1.size()>0){
            jsonObject.put("Error","the value is exit");
            return jsonObject;
        }
        dolistRepository.save(dolist);
        dolists = dolistRepository.findAll();
        return getJsonArray(dolists);
    }
    public  JSONArray getList(){
        List<Dolist> dolists = dolistRepository.findAll();
        return getJsonArray(dolists);
    }

    private JSONArray getJsonArray(List<Dolist> dolists) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonpObject = new JSONObject();
        System.out.println("dolists.size:"+dolists.size());
        if(dolists.size()>0) {
            dolists.forEach(dolist -> {
                jsonpObject.put("itemName", dolist.getListValue());
                jsonpObject.put("isSelected", dolist.isSelecting());
                jsonpObject.put("id", dolist.getId());
                jsonpObject.put("Error","");
                jsonArray.add(jsonpObject);
            });
        }
        return jsonArray;
    }

    public JSONArray updateList(@PathVariable int index){
        Dolist dolist = dolistRepository.findById((long)index).get();
        dolist.setSelecting(!dolist.isSelecting());
        dolistRepository.save(dolist);
        return getJsonArray(dolistRepository.findAll());
    }
    public JSONArray deleteFromList(@PathVariable int index){
        List<Dolist> dolists = dolistRepository.findAll();
        dolistRepository.deleteById((long)index);
        dolists = dolistRepository.findAll();
        return getJsonArray(dolists);
    }
}
