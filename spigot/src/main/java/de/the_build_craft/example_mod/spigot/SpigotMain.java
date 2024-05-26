/*
 *    This file is part of the Universal Mod Template
 *    licensed under the GNU GPL v3 License.

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

package de.the_build_craft.example_mod.spigot;

import de.the_build_craft.example_mod.common.AbstractModInitializer;
import de.the_build_craft.example_mod.common.LoaderType;

/**
 * @author Leander Knüttel
 * @version 26.05.2024
 */
public class SpigotMain extends AbstractModInitializer {
    public static SpigotMain INSTANCE;

    @Override
    public void onInitializeServer() {
        loaderType = LoaderType.Spigot;
        super.onInitializeServer();
        INSTANCE = this;

        //Spigot Server init here
    }

    @Override
    protected void createInitialBindings() {

    }

    @Override
    protected IEventProxy createServerProxy(boolean isDedicated) {
        return null;
    }

    @Override
    protected void initializeModCompat() {

    }

    /**
     * ignore this!
     */
    @Override
    protected IEventProxy createClientProxy() {
        return null;
    }
}
