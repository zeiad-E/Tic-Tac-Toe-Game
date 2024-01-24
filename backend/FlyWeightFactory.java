package backend;

import java.util.HashMap;

public class FlyWeightFactory {
    private static HashMap<GamePostion, backGround> x = new HashMap<GamePostion, backGround>();
    static backGround bGround = null;

    public static backGround getbackGround(GamePostion g) {
        if (x.containsKey(g))
            bGround = x.get(g);
        else {
            bGround = new backGround();
        }
        return bGround;
    }
}
