package com.g35.data;

public class FollowEnemyModel extends EnemyModel {
    HeroModel hero;

    public FollowEnemyModel(Position position, HeroModel hero) {
        super(position);
        this.hero = hero;
    }

    public Position getHeroPosition() {
        return hero.getPosition();
    }
}
