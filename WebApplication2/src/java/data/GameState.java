package data;

import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {

    private ArrayList<Player> players;
    private ArrayList<Projectile> projectiles;

    public GameState() {
        this.players = new ArrayList<>();
        players.add(new Player(0, Direction.DOWN, new Location(0,0)));
        players.add(new Player(1, Direction.RIGHT, new Location(0,190)));
        players.add(new Player(2, Direction.LEFT, new Location(190,0)));
        players.add(new Player(3, Direction.UP, new Location(190,190)));
        this.projectiles = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public void setPlayer(int id, Direction x, Location y){
        players.add(new Player(id,x,y));
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

}
