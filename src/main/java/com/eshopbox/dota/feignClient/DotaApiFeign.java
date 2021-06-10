package com.eshopbox.dota.feignClient;

import com.eshopbox.dota.feignClient.response.HerosInfo;
import com.eshopbox.dota.feignClient.response.PlayedHeros;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value="dotaserver",url = "${open-dota-api.url}")
public interface DotaApiFeign {


    @GetMapping("players/{account_id}/heroes")
    List<PlayedHeros> getHerosofAPlayer(@PathVariable("account_id")long accountId, @RequestParam("is_radiant")int isRadiant, @RequestParam("sort")String sortBy);

    @GetMapping("heroes")
    List<HerosInfo> getHerosList();

}
