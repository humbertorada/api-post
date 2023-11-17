package com.post.apipost.util;

import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.models.Categorie;

public class ReturnResponses {

    public static CategorieDtoResponse responseCategorie(Categorie categorie){
        return new CategorieDtoResponse(
                categorie.getId(),
                categorie.getCreationDate(),
                categorie.getUpdateDate(),
                categorie.getName(),
                categorie.getDescription()
        );
    }
}
