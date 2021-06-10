package com.eshopbox.dota.feignClient.response;

import lombok.Data;

@Data
public class PlayedHeros {

    private long hero_id;
    private long last_played;
    private int games;
    private int win;
    private int with_games;
    private int with_win;
    private int against_games;
    private int against_win;
}
