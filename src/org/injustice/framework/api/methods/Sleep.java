/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.injustice.framework.api.methods;

import org.injustice.framework.api.Condition;
import org.injustice.framework.api.IMethodContext;
import org.injustice.framework.api.IMethodProvider;

/**
 *
 * @author Injustice
 */
public class Sleep extends IMethodProvider {

    public Sleep(final IMethodContext c) {
        super(c);
    }
    public void waitFor(final boolean condition, final long timeout) {
        Condition c = new Condition() {
            @Override
            public boolean activate() {
                return condition;
            }
        };
        while (!c.activate()) {
            sleep((int) timeout);
        }
    }

}
