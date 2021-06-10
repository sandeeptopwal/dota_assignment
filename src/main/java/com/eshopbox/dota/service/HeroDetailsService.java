package com.eshopbox.dota.service;

import com.eshopbox.dota.api.model.HeroModel;

import java.util.List;

public interface HeroDetailsService {

    List<HeroModel> getHerosDetailOfPlayer(long accountId);

}
