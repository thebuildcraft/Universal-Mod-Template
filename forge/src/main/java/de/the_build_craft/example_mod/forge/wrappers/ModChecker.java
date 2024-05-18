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

package de.the_build_craft.example_mod.forge.wrappers;

import de.the_build_craft.example_mod.common.IModChecker;
import net.minecraftforge.fml.ModList;

import java.io.File;

/**
 * can check if a mod is installed
 *
 * @author James Seibel
 * @author Leander Knüttel
 * @version 17.05.2024
 */
public class ModChecker implements IModChecker
{
	public static ModChecker INSTANCE;
	public ModChecker(){
		INSTANCE = this;
	}
	
	@Override
	public boolean isModLoaded(String modid)
	{
		return ModList.get().isLoaded(modid);
	}
	
	@Override
	public File modLocation(String modid)
	{
		return ModList.get().getModFileById(modid).getFile().getFilePath().toFile();
	}
	
}
