package com.busyqa.course.pojo;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

public class Game {
    int gameI;

    @Column(name="arguments")
    @ElementCollection(targetClass=GameCard.class)
    private List<GameCard> cardsOfGame;
}
