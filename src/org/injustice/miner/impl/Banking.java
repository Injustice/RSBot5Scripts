/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.injustice.miner.impl;

import org.injustice.framework.api.IMethodContext;
import org.injustice.framework.script.node.StateNode;
import org.injustice.miner.data.Bank;
import org.injustice.miner.data.MinerMaster;
import org.injustice.miner.data.Rock;

/**
 *
 * @author Injustice
 */
public class Banking extends StateNode {
    private final Rock rock;
    private final Bank bank;
    private final int[] pickaxes = {1265, 1267, 1269, 1271, 1273, 1275, 15259};

    public Banking(IMethodContext ctx, Rock rock, MinerMaster factory) {
        super(ctx);
        this.rock = rock;
        this.bank = factory.getBank();
    }

    @Override
    public void execute() {
        if (ctx.bank.open()) {
            if (ctx.backpack.select().id(pickaxes).isEmpty()) {
                ctx.bank.depositInventory();
                ctx.bank.close();
            } else {
                ctx.bank.deposit(rock.getInvId(), org.powerbot.script.methods.Bank.Amount.ALL);
            }
        }
    }

    @Override
    public boolean activate() {
        return bank.getArea().contains(ctx.players.local());
    }

    @Override
    public String state() {
        return "Banking";
    }

}
