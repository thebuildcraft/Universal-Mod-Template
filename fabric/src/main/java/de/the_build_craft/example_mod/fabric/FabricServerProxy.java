/*
 *    This file is part of the Universal Mod Template
 *    licensed under the GNU GPL v3 License.
 *    (some parts of this file are originally from the Distant Horizons mod by James Seibel)
 *
 *    Copyright (C) 2024  Leander Knüttel
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.the_build_craft.example_mod.fabric;

import de.the_build_craft.example_mod.common.AbstractModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.apache.logging.log4j.Logger;

/**
 * This handles all events sent to the server
 *
 * @author Ran
 * @author Tomlee
 * @author Leander Knüttel
 * @version 17.05.2024
 */
public class FabricServerProxy implements AbstractModInitializer.IEventProxy
{
	private static final Logger LOGGER = AbstractModInitializer.LOGGER;
	
	private final boolean isDedicated;
	
	public FabricServerProxy(boolean isDedicated)
	{
		this.isDedicated = isDedicated;
	}
	
	private boolean isValidTime()//TODO is this needed???
	{
		if (isDedicated)
		{
			return true;
		}
		
		//FIXME: This may cause init issue...
		return !(Minecraft.getInstance().screen instanceof TitleScreen);
	}
	
	/** Registers Fabric Events */
	public void registerEvents()
	{
		LOGGER.info("Registering Fabric Server Events");
	}
}
