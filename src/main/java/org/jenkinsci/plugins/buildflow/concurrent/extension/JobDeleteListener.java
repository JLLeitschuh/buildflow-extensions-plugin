/*
 * The MIT License
 *
 * Copyright (c) 2013, Cisco Systems, Inc., a California corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.buildflow.concurrent.extension;

import com.cloudbees.plugins.flow.BuildFlow;
import hudson.Extension;
import hudson.model.Item;
import hudson.model.listeners.ItemListener;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The job delete listener listens for deletion of jobs and removes any state associated with them from the
 * stored shared state.
 */
@Extension
public class JobDeleteListener extends ItemListener {

	private final Logger log = Logger.getLogger(ItemListener.class.getName());

	/**
	 * When an item is about to be deleted this will remove any shared state that this job has associated with it.
	 */
	@Override
	public void onDeleted(Item item) {
		if (item instanceof BuildFlow) {
			log.log(Level.INFO, "Removing shared state for {}.", item.getFullName());
			ConcurrentBuildFlowExtensionPlugin.INSTANCE.removeSharedState((BuildFlow) item);
		}
	}

}