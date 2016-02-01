/*
 * Copyright (C) 2008-2016 by Holger Arndt
 *
 * This file is part of the Java Data Mining Package (JDMP).
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * JDMP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * JDMP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with JDMP; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.jdmp.gui.dataset.actions;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JComponent;

import org.jdmp.core.algorithm.clustering.Clusterer;
import org.jdmp.core.algorithm.clustering.KMeans;
import org.jdmp.core.dataset.ListDataSet;
import org.ujmp.core.interfaces.GUIObject;
import org.ujmp.gui.actions.AbstractObjectAction;
import org.ujmp.gui.util.GUIUtil;

public class ClusterKMeansAction extends AbstractObjectAction {
	private static final long serialVersionUID = -197407937839467203L;

	public ClusterKMeansAction(JComponent c, GUIObject i) {
		super(c, i);
		putValue(Action.NAME, "KMeans");
		putValue(Action.SHORT_DESCRIPTION, "Cluster a DataSet using the k-means Algorithm");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_K);
	}

	public Object call() {
		try {
			Clusterer c = new KMeans(GUIUtil.getInt("number of cluster centers", 1, 100));
			c.trainAll((ListDataSet) getCoreObject());
			c.predictAll((ListDataSet) getCoreObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
