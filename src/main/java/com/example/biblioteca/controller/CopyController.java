package com.example.biblioteca.controller;

import com.example.biblioteca.models.CopyModel;
import com.example.biblioteca.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/copies")
public class CopyController {
    @Autowired
    CopyService copyService;

    @PostMapping(value = "/save")
    public CopyModel saveCopy(@RequestBody CopyModel copy) {
        CopyModel result = new CopyModel();

        result = copyService.saveCopy(copy);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public CopyModel getCopyById(@PathVariable(value = "id") Integer id) {
        CopyModel result = new CopyModel();

        result = copyService.getCopyById(id);

        return result;
    }

    @GetMapping
    public List<CopyModel> getAllCopies(){
        return copyService.getAllCopies();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteCopyById(@PathVariable(value = "id") Integer id){
        copyService.deleteCopyById(id);
        return ResponseEntity.noContent().build();
    }
}
