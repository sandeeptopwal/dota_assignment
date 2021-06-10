package com.eshopbox.dota.builder;

import com.eshopbox.dota.feignClient.response.HerosInfo;
import com.eshopbox.dota.feignClient.response.PlayedHeros;
import com.eshopbox.dota.api.model.HeroModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HeroDetailBuilder {

    public final List<HeroModel> buildHeroDetailsModel(List<PlayedHeros> playedHeroes, List<HerosInfo> heroesInfoList){
        List<HeroModel> heroModelList = new ArrayList<>();

        Set<Long> playedHeroIdsSet = playedHeroes.stream().map(PlayedHeros::getHero_id).collect(Collectors.toSet());

        heroesInfoList.stream().filter(heroInfo -> playedHeroIdsSet.contains(heroInfo.getId())).forEach(heroesInfo -> {
            HeroModel heroModel = new HeroModel();
            heroModel.setName(heroesInfo.getName());
            heroModel.setHero_id(heroesInfo.getId());
            heroModel.setLocalized_name(heroesInfo.getLocalized_name());
            heroModelList.add(heroModel);
        });

        return heroModelList;
    }
}
