package quests.encounters;

import enemies.IEnemy;

import java.util.List;

public class Encounter implements IEncounter {

    private boolean encounter;
    private List<IEnemy> enemies;

    public Encounter(boolean encounter, List<IEnemy> enemies) {
        this.encounter = encounter;
        this.enemies = enemies;
    }

    @Override
    public boolean encounter() {
        return encounter;
    }

    @Override
    public List<IEnemy> enemies() {
        return enemies;
    }

}
