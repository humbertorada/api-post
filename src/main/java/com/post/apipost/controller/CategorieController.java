package com.post.apipost.controller;

import com.post.apipost.dto.request.CategorieDtoRequest;
import com.post.apipost.dto.request.CategorieUpdateDTO;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.service.impl.CategorieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieImpl categorie;

    @PostMapping
    @Transactional
    public ResponseEntity<CategorieDtoResponse> create(@RequestBody @Valid CategorieDtoRequest categorieDtoRequest){
        return ResponseEntity.ok(
                this.categorie.create(categorieDtoRequest)
        );
    }

    @GetMapping
    public ResponseEntity<List<CategorieDtoResponse>> findAll(){
        return ResponseEntity.ok(
          this.categorie.findAll()
        );
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CategorieDtoResponse> update(@RequestBody @Valid CategorieUpdateDTO categorieUpdateDTO) throws BadRequestException {
        return ResponseEntity.ok(
          this.categorie.update(categorieUpdateDTO)
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) throws BadRequestException {
        this.categorie.delete(id);
        return ResponseEntity.noContent().build();
    }
}
