package org.injustice.ironminer;

import org.injustice.framework.Timer;
import org.injustice.framework.api.IMethodContext;
import org.injustice.framework.script.ActiveScript;
import org.powerbot.script.Manifest;
import org.powerbot.script.wrappers.Action;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;

/**
 * Created by Azmat on 27/01/14.
 */
@Manifest(
        name = "IronMiner",
        description = "Mines iron anywhere",
        authors = "bartsome",
        version = 0.01
)
public class IronMiner extends ActiveScript {
    private IMethodContext ctx;
    private Tile startTile;
    private int radius;
    private final int id = 440;
    private final int[] ids = {
            2092, 2093, 5773,
            5773, 5774, 5775,
            6943, 6944,
            9717, 9717,
            9718, 9718, 9719, 11954,
            11954, 11955, 11956,
            14099, 14107, 14856, 14857, 14858, 14913, 14914,
            21281, 21281,
            21282, 21282, 21283, 31071, 31072, 31073,
            37307, 37307, 37308, 37309, 72081,
            72081, 72082, 72083};
    private final int[] gems ={1621, 1617, 1619, 1623, 1625, 1627, 1629, 1631, 21345};
    private final Timer failsafeTimer;

    public IronMiner() {
        this.ctx = new IMethodContext(super.ctx);
        failsafeTimer = new Timer(15000);
    }

    @Override
    public void start() {
        startTile = ctx.players.local().getLocation();
        radius = 7;
    }


    @Override
    public int poll() {
        if (ctx.backpack.count() != 28 && !ctx.backpack.containsAnyOf(gems)) {
            for (GameObject g : ctx.objects.select().id(ids)
                    .within(startTile, radius).nearest().first()) {
                if (g.isValid()) {
                    System.out.println("Valid");
                    if (g.isOnScreen()) {
                        System.out.println("Clicking rock");
                        if (g.interact("Mine")) {
                            System.out.println("Sleeping");
                            for (int i = 0; i < 10 && ctx.players.local().getAnimation() == -1; i++) {
                                ctx.sleep.sleep(600, 650);
                            }
                            if (true) {
                                for (GameObject secondRock : ctx.objects.limit(1, 1)) {
                                    ctx.mouse.move(secondRock);
                                    System.out.println("Hovering next rock");
                                }
                            }
                            ctx.sleep.sleep(600);
                            for (int i = 0; i < 10 && ctx.players.local().getAnimation() != -1; i++) {
                                ctx.sleep.sleep(600, 650);
                            }
                        }
                    } else {
                        System.out.println("Turning to rock");
                        ctx.camera.turnTo(g);
                    }
                }
            }
        } else {
            for (Action a : ctx.combatBar.getActions()) {
                if (a.getType() == Action.Type.ITEM && a.getId() == id) {
                    failsafeTimer.reset();
                    while (a.getId() == id) {
                        System.out.println("Dropping " + a.getComponent().getItemName());
                        ctx.keyboard.send(a.getBind());
                        failsafeCheck();
                        ctx.sleep.sleep(150, 300);
                    }
                }
            }
        }
        return 500;
    }

    private void failsafeCheck() {
        if (!failsafeTimer.isRunning()) {
            System.out.println("Failsafe drop");
            for (Item i : ctx.backpack.select().id(id)) {
                i.interact("Drop");
                ctx.sleep.sleep(500, 600);
            }
        }
    }



}
