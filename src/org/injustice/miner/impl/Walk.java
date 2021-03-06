/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.injustice.miner.impl;

import org.injustice.framework.Timer;
import org.injustice.framework.api.IMethodContext;
import org.injustice.framework.script.node.StateNode;
import org.injustice.miner.data.Location;
import org.injustice.miner.data.MinerMaster;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 *
 * @author Injustice
 */
public class Walk extends StateNode {

    private static String state;
    private final Tile[] path;
    private final Timer nextStep = new Timer(1000);

    public Walk(IMethodContext ctx, final Tile[] path) {
        super(ctx);
        this.path = path;
    }

    @Override
    public void execute() {
        new TilePath(ctx, path).traverse();
        nextStep.reset();
    }

    public Walk createBankPathInstance(MinerMaster factory, IMethodContext ctx) {
        state = "Walking bank";
        return new Walk(ctx, factory.getPath().getPath());
    }

    public Walk createSitePathInstance(MinerMaster factory, IMethodContext ctx) {
        Tile[] path = factory.getPath().getPath();
        path[path.length + 1] = Location.startTile;
        state = "Walking back";
        return new Walk(ctx, path);
    }

    @Override
    public boolean activate() {
        return !nextStep.isRunning();
    }

    @Override
    public String state() {
        return state;
    }
}
