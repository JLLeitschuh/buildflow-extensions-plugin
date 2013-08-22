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

import com.cloudbees.plugins.flow.FlowRun;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Comparator that will sort the FlowRuns based on BuildNumber
 */
public final class FlowRunComparator implements Comparator<FlowRun>, Serializable {

	public static final FlowRunComparator INSTANCE = new FlowRunComparator();

	private static final long serialVersionUID = 17L;

	private FlowRunComparator() {
		// hinder instantiation.
	}

	public int compare(FlowRun f1, FlowRun f2) {
		return f1.getNumber() - f2.getNumber();
	}

	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

}
