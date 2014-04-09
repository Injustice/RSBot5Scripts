/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.injustice.framework.script.job.state;

import org.injustice.framework.api.IMethodContext;
import org.injustice.framework.script.node.StateNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author Injustice
 */
public abstract class Branch extends StateNode {

    private final Queue<Node> nodes = new ConcurrentLinkedQueue();
    private final AtomicReference<Node> currentNode = new AtomicReference();

    public Branch(IMethodContext ctx, Node[] nodes) {
        super(ctx);
        this.nodes.addAll(Arrays.asList(nodes));
    }

    public abstract boolean branch();

    @Override
    public final boolean activate() {
        if (branch()) {
            for (Node node : nodes) {
                if (node != null && node.activate()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void execute() {
        Node current = currentNode.get();
        if (current != null && current.isAlive()) {
            return;
        }

        for (Node next : nodes) {
            if (next != null && next.activate()) {
                currentNode.set(next);
                getContainer().submit(next);
                next.join();
            }
        }
    }
}