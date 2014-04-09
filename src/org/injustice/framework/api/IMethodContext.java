/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.injustice.framework.api;

import org.injustice.framework.api.methods.*;
import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.MethodContext;

/**
 *
 * @author Suhaib
 */
public class IMethodContext extends MethodContext {
    public final Backpack backpack;
    public final Bank bank;
    public final Lodestones lodestones;
    public final Movement movement;
    public final Camera camera;
    public final Combat combat;
    public final Conditions conditions;
    public final Misc misc;
    public final Skills skills;
    public final Utils utils;
    public final Log log;
    public final Sleep sleep;
    
    public IMethodContext(MethodContext ctx) {
        super(ctx);
        this.movement = new Movement(this);
        this.bank = new Bank(this);
        this.lodestones = new Lodestones(this);
        this.backpack = new Backpack(this);
        this.camera = new Camera(this);
        this.combat = new Combat(this);
        this.conditions = new Conditions(this);
        this.misc = new Misc(this);
        this.skills = new Skills(this);
        this.utils = new Utils(this);
        this.log = new Log(this);
        this.sleep = new Sleep(this);
    }

}
