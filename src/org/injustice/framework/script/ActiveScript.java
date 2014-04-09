/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.injustice.framework.script;

import org.injustice.framework.script.job.Container;
import org.injustice.framework.script.job.Job;
import org.injustice.framework.script.job.TaskContainer;
import org.powerbot.script.PollingScript;

/**
 *
 * @author Injustice
 */
public abstract class ActiveScript extends PollingScript {
	private final Container container = new TaskContainer();
 
	protected ActiveScript() {
		getExecQueue(State.SUSPEND).add(new Runnable() {
			@Override
			public void run() {
				setPaused(true);
			}
		});
		getExecQueue(State.RESUME).add(new Runnable() {
			@Override
			public void run() {
				setPaused(false);
			}
		});
		getExecQueue(State.STOP).add(new Runnable() {
			@Override
			public void run() {
				shutdown();
			}
		});
	}
 
	protected final boolean isActive() {
		return !container.isTerminated();
	}
 
	protected final boolean isPaused() {
		return container.isPaused();
	}
 
	protected final void setPaused(boolean paramBoolean) {
		container.setPaused(paramBoolean);
	}
 
	/**
	 * Graceful shutdown
	 */
	protected final void shutdown() {
		if (!isShutdown()) {
			container.shutdown();
		}
	}
 
	protected final boolean isShutdown() {
		return container.isShutdown();
	}
 
	/**
	 * Force stop
	 */
	protected void forceStop() {
		container.interrupt();
	}
 
	protected final Container getContainer() {
		return container;
	}
 
	protected final void submit(Job job) {
		container.submit(job);
	}
}