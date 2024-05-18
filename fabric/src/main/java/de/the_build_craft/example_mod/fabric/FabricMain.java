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

import com.mojang.brigadier.CommandDispatcher;
import de.the_build_craft.example_mod.common.AbstractModInitializer;
import de.the_build_craft.example_mod.fabric.wrappers.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
#if MC_VER > MC_1_18_2
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
#else
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
#endif

/**
 * main entry point on Fabric
 *
 * @author James Seibel
 * @author Leander Knüttel
 * @version 17.05.2024
 */
public class FabricMain extends AbstractModInitializer implements ClientModInitializer, DedicatedServerModInitializer
{
	//TODO why is this here ??????
	//private static final ResourceLocation INITIAL_PHASE = ResourceLocation.tryParse("example_mod:dedicated_server_initial");
	
	@Override
	public void onInitializeClient(){
		loaderType = LoaderType.Fabric;
		super.onInitializeClient();
		#if MC_VER > MC_1_18_2
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> registerClientCommands((CommandDispatcher) dispatcher, context));
		#else
		//TODO test for MC <= 1.18.2
		registerClientCommands((CommandDispatcher) ClientCommandManager.DISPATCHER);
		#endif

		//Fabric Client init here
	}

	@Override
	public void onInitializeServer(){
		loaderType = LoaderType.Fabric;
		super.onInitializeServer();
		CommandRegistrationCallback.EVENT.register(this::registerServerCommands);

		//Fabric Server init here
	}


	@Override
	protected void createInitialBindings() {
		new ModChecker();

		//Fabric static Instances here
	}
	
	@Override
	protected IEventProxy createClientProxy() { return new FabricClientProxy(); }
	
	@Override
	protected IEventProxy createServerProxy(boolean isDedicated) { return new FabricServerProxy(isDedicated); }
	
	@Override
	protected void initializeModCompat()
	{
		//mod compatibility setup here
	}
	// TODO can this be removed?
	/*@Override
	protected void subscribeClientStartedEvent(Runnable eventHandler) {
		ClientLifecycleEvents.CLIENT_STARTED.register((mc) -> eventHandler.run());
	}*/
	
	/*@Override
	protected void subscribeServerStartingEvent(Consumer<MinecraftServer> eventHandler)
	{
		ServerLifecycleEvents.SERVER_STARTING.addPhaseOrdering(INITIAL_PHASE, Event.DEFAULT_PHASE);
		ServerLifecycleEvents.SERVER_STARTING.register(INITIAL_PHASE, eventHandler::accept);
	}*/
	
	/*@Override
	protected void runDelayedSetup()
	{
		//setup after init here
	}*/
	
}
