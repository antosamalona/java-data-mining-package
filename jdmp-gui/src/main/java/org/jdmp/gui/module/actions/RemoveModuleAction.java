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

package org.jdmp.gui.module.actions;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import org.jdmp.core.module.HasModuleMap;
import org.jdmp.core.module.Module;

public class RemoveModuleAction extends ModuleListAction {
	private static final long serialVersionUID = 2706158091911195359L;

	private Module module = null;

	public RemoveModuleAction(JComponent c, HasModuleMap i, Module m) {
		this(c, i);
		this.module = m;
	}

	public RemoveModuleAction(JComponent c, HasModuleMap i) {
		super(c, i);
		putValue(Action.NAME, "Remove Module...");
		putValue(Action.SHORT_DESCRIPTION, "Remove a Module");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));
	}

	public Object call() {
		if (module != null) {
			getIModules().getModuleMap().remove(module);
			return module;
		}
		return null;
	}

}
