/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.injustice.framework.api.methods;

import org.injustice.framework.Timer;
import org.injustice.framework.api.IMethodContext;

/**
 *  
 * @author Suhaib
 */
public class Skills extends org.powerbot.script.methods.Skills {

    private Timer t;
    private final int[] startExp = new int[25], startLvl = new int[25];
    public final String[] SKILL_NAMES = { "attack", "defence", "strength", "constitution", "range", "prayer",
            "magic", "cooking", "woodcutting", "fletching", "fishing", "firemaking", "crafting", "smithing",
            "mining", "herblore", "agility", "thieving", "slayer", "farming", "runecrafting", "hunter",
            "construction", "summoning", "dungeoneering" };

    public Skills(IMethodContext c) {
        super(c);
        t = new Timer(0);
        for (int i = 0; i < SKILL_NAMES.length; i++) {
            startExp[i] = getExperience(i);
            startLvl[i] = getRealLevel(i);
        }
    }

    public int getLevelsGained(final int idx) {
        return getRealLevel(idx) - startLvl[idx];
    }

    public int getPercentToNextLevel(final int index) {
        final int lvl = ctx.skills.getRealLevel(index);
        return getPercentToLevel(index, lvl + 1);
    }

    
    public int getPercentToLevel(final int index, final int endLvl) {
        final int lvl = ctx.skills.getRealLevel(index);
        if (lvl == 99) {
            return 0;
        }
        final int xpNeeded = org.powerbot.script.methods.Skills.XP_TABLE[endLvl] - org.powerbot.script.methods.Skills.XP_TABLE[lvl];
        if (xpNeeded == 0) {
            return 0;
        }
        final int xpDone = ctx.skills.getExperience(index)
                - org.powerbot.script.methods.Skills.XP_TABLE[lvl];
        return 100 * xpDone / xpNeeded;
    }

    public String getTimeToNextLevel(final int skill) {
        return Timer.format(getTimeToLevel(skill));
    }

    public int getExpTNL(final int skill) {
        return getExperienceAt(getLevel(skill) + 1) - getExperience(skill);
    }

    public int getExpGain(final int idx) {
        return getExperience(idx) - startExp[idx];
    }

    public double percentToLevel(final int idx) {
        return percentToLevel(idx, getLevel(idx) + 1);
    }

    public double percentToLevel(final int idx, final int lvl) {
        int curLvl = getLevel(idx);
        if (lvl < 1 || lvl > (idx == 24 ? 120 : 99)) {
            return 0;
        }
        if (curLvl == (idx == 24 ? 120 : 99) || curLvl == lvl) {
            return 100;
        }
        return ((100 * (getExperience(idx) - XP_TABLE[curLvl])) / (XP_TABLE[lvl] - XP_TABLE[curLvl]));
    }

    private double hourly(int total, long time) {
        return (total * 3600000D / time);
    }

    public double getHourlyExp(final int idx) {
        return hourly(getExpGain(idx), t.getElapsed());
    }

    public long getTimeToLevel(final int idx) {
        double hourlyExp = getHourlyExp(idx);
        if (hourlyExp == 0) {
            return 0;
        }
        return 1000 * (long) ((getExpTNL(getLevel(idx) + 1) * 3600) / hourlyExp);
    }

    public long getTimeToLevel(final int idx, final int level) {
        double hourlyExp = getHourlyExp(idx);
        if (hourlyExp == 0) {
            return 0;
        }
        return 1000 * (long) ((getExpTNL(idx) * 3600) / hourlyExp);
    }

}
