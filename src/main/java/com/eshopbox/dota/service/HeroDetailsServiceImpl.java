package com.eshopbox.dota.service;

import com.eshopbox.dota.builder.HeroDetailBuilder;
import com.eshopbox.dota.exceptions.AppException;
import com.eshopbox.dota.feignClient.DotaApiFeign;
import com.eshopbox.dota.feignClient.response.HerosInfo;
import com.eshopbox.dota.feignClient.response.PlayedHeros;
import com.eshopbox.dota.api.model.HeroModel;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HeroDetailsServiceImpl implements HeroDetailsService{

    private final DotaApiFeign dotaApiFeign;
    private final HeroDetailBuilder heroDetailBuilder;

    public HeroDetailsServiceImpl(DotaApiFeign dotaApiFeign, HeroDetailBuilder heroDetailBuilder) {
        this.dotaApiFeign = dotaApiFeign;
        this.heroDetailBuilder = heroDetailBuilder;
    }


    @Override
    public List<HeroModel> getHerosDetailOfPlayer(long accountId) {
        int isRadiant = 1;
        String sortBy = "games";
        try {
            List<PlayedHeros> playedHerosList = dotaApiFeign.getHerosofAPlayer(accountId, isRadiant, sortBy);
            List<HerosInfo> herosInfos = dotaApiFeign.getHerosList();

            List<PlayedHeros> filteredHeroList = playedHerosList.stream().limit(3).collect(Collectors.toList());
            return heroDetailBuilder.buildHeroDetailsModel(filteredHeroList,herosInfos);
        }catch (FeignException e){
            log.error(e.getMessage());
            throw new AppException("Something went wrong. Please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
