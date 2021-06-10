package com.eshopbox.dota.api.controller;

import com.eshopbox.dota.api.model.HeroModel;
import com.eshopbox.dota.service.HeroDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player/{accountId}")
public class DotaController {

    private final HeroDetailsService heroDetailsService;

    public DotaController(HeroDetailsService heroDetailsService) {
        this.heroDetailsService = heroDetailsService;
    }

    @GetMapping("heros")
    public ResponseEntity<List<HeroModel>> getHerosList(@PathVariable("accountId")long accountId){

        return new ResponseEntity(heroDetailsService.getHerosDetailOfPlayer(accountId), HttpStatus.OK);
    }

}
