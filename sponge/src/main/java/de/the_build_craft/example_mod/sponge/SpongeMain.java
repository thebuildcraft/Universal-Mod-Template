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

package de.the_build_craft.example_mod.sponge;

import de.the_build_craft.example_mod.common.AbstractModInitializer;
import de.the_build_craft.example_mod.common.LoaderType;
import org.spongepowered.api.Server;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

/**
 * @author Leander Knüttel
 * @version 02.06.2024
 */
@Plugin(AbstractModInitializer.MOD_ID)
public class SpongeMain extends AbstractModInitializer {
    public static SpongeMain INSTANCE;

    @Listener
    public void onServerStart(final StartedEngineEvent<Server> event) {
        onInitializeServer();
    }

    @Override
    public void onInitializeServer() {
        loaderType = LoaderType.Sponge;
        super.onInitializeServer();
        INSTANCE = this;

        //Sponge Server init here
    }

    @Override
    protected void createInitialBindings() {

    }

    @Override
    protected IEventProxy createServerProxy(boolean isDedicated) {
        return new SpongeServerProxy();
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
