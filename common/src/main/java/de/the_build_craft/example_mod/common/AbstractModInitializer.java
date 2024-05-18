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

package de.the_build_craft.example_mod.common;

import com.mojang.brigadier.CommandDispatcher;
#if MC_VER > MC_1_18_2
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.synchronization.SuggestionProviders;
#else
import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.network.chat.TextComponent;
#endif
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;

import net.minecraft.network.chat.Component;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.function.Supplier;

/**
 * Base for all mod loader initializers 
 * and handles most setup.
 *
 * @author James Seibel
 * @author Leander Knüttel
 * @version 17.05.2024
 */
public abstract class AbstractModInitializer
{
	public static final String MOD_ID = "example_mod";
	public static final String MOD_NAME = "Example Mod";
	public static final String VERSION = "1.0.0";
	public static final Logger LOGGER = LogManager.getLogger("RemotePlayerWaypointsForXaero");

	private CommandDispatcher<CommandSourceStack> commandDispatcher;

	
	//==================//
	// abstract methods //
	//==================//
	
	protected abstract void createInitialBindings();
	protected abstract IEventProxy createClientProxy();
	protected abstract IEventProxy createServerProxy(boolean isDedicated);
	protected abstract void initializeModCompat();
	
	//protected abstract void subscribeClientStartedEvent(Runnable eventHandler);
	//protected abstract void subscribeServerStartingEvent(Consumer<MinecraftServer> eventHandler);
	//protected abstract void runDelayedSetup();

	public LoaderType loaderType;
	public enum LoaderType{
		Fabric,
		Quilt,
		Forge,
		NeoForge;
		LoaderType(){
		}
	}
	
	//===================//
	// initialize events //
	//===================//
	
	public void onInitializeClient()
	{
		LOGGER.info("Initializing " + MOD_NAME);
		
		this.startup();//<-- common mod init in here
		this.printModInfo();

		this.createClientProxy().registerEvents();
		this.createServerProxy(false).registerEvents();

		this.initializeModCompat();
		this.initConfig();

		//Client Init here

		LOGGER.info(MOD_NAME + " Initialized");

		//this.subscribeClientStartedEvent(this::postInit);
	}
	
	public void onInitializeServer()
	{
		LOGGER.info("Initializing " + MOD_NAME);
		
		this.startup();//<-- common mod init in here
		this.printModInfo();

		this.createServerProxy(true).registerEvents();

		this.initConfig();

		//Server Init here

		LOGGER.info(MOD_NAME + " Initialized");

		/*this.subscribeServerStartingEvent(server ->
		{
			this.postInit();
			
			LOGGER.info("Dedicated server initialized at " + server.getServerDirectory());
		});*/
	}
	
	
	
	//===========================//
	// inner initializer methods //
	//===========================//

	/**
	 * common mod init for client and server
	 */
	private void startup()
	{
		this.createInitialBindings();
		//do common mod init here
	}
	
	private void printModInfo()
	{
		LOGGER.info(MOD_NAME + ", Version: " + VERSION);
	}
	
	private void initConfig()
	{

	}
	
	/*private void postInit()
	{
		LOGGER.info("Post-Initializing Mod");
		this.runDelayedSetup();
		LOGGER.info("Mod Post-Initialized");
	}*/

	#if MC_VER > MC_1_18_2
	public void registerServerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext _context, Commands.CommandSelection environment) {
		//TODO test example command
		//Example Command
		LiteralArgumentBuilder<CommandSourceStack> setAfkTimeCommand = literal("server_set_afk_time")
				.then(argument("player", StringArgumentType.word())
						.then(argument("time", IntegerArgumentType.integer(0))
								.executes(context -> {
									String playerName = StringArgumentType.getString(context, "player");
									int time = IntegerArgumentType.getInteger(context, "time");
									#if MC_VER < MC_1_20_1
									context.getSource().sendSuccess(Component.literal("Set AFK time for " + playerName + " to " + time), true);
									#else
									Supplier<Component> supplier = () -> Component.literal("Set AFK time for " + playerName + " to " + time);
									//or use a normal method
									//Example:
									//supplier = this::test;
									context.getSource().sendSuccess(supplier, true);
									#endif
									return 1;
								})));
		//don't forget to register it...
		dispatcher.register(setAfkTimeCommand);

		//register commands here
	}
	//Example
	/*public Component test(){
		return Component.literal("test");
	}*/
	//SuggestionProviders ???
	public void registerClientCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext _context){
		//TODO test example client command
		//Example Command
		LiteralArgumentBuilder<CommandSourceStack> setAfkTimeCommand = literal("client_set_afk_time")
				.then(argument("player", StringArgumentType.word())
						.then(argument("time", IntegerArgumentType.integer(0))
								.executes(context -> {
									String playerName = StringArgumentType.getString(context, "player");
									int time = IntegerArgumentType.getInteger(context, "time");
									#if MC_VER < MC_1_20_1
									context.getSource().sendSuccess(Component.literal("Set AFK time for " + playerName + " to " + time), true);
									#else
									Supplier<Component> supplier = () -> Component.literal("Set AFK time for " + playerName + " to " + time);
									//or use a normal method
									//Example:
									//supplier = this::test;
									context.getSource().sendSuccess(supplier, true);
									#endif
									return 1;
								})));
		//don't forget to register it...
		dispatcher.register(setAfkTimeCommand);

		//register commands here
	}
	#else
	public void registerServerCommands(CommandDispatcher<CommandSourceStack> dispatcher, boolean dedicated) {
		//TODO test example command
		//Example Command
		LiteralArgumentBuilder<CommandSourceStack> setAfkTimeCommand = literal("server_set_afk_time")
				.then(argument("player", StringArgumentType.word())
						.then(argument("time", IntegerArgumentType.integer(0))
								.executes(context -> {
									String playerName = StringArgumentType.getString(context, "player");
									int time = IntegerArgumentType.getInteger(context, "time");
									context.getSource().sendSuccess(new TextComponent("Set AFK time for " + playerName + " to " + time), true);
									return 1;
								})));
		//don't forget to register it...
		dispatcher.register(setAfkTimeCommand);

		//register commands here
	}

	public void registerClientCommands(CommandDispatcher<CommandSourceStack> dispatcher){
		//TODO test example client command
		//Example Command
		LiteralArgumentBuilder<CommandSourceStack> setAfkTimeCommand = literal("client_set_afk_time")
				.then(argument("player", StringArgumentType.word())
						.then(argument("time", IntegerArgumentType.integer(0))
								.executes(context -> {
									String playerName = StringArgumentType.getString(context, "player");
									int time = IntegerArgumentType.getInteger(context, "time");
									context.getSource().sendSuccess(new TextComponent("Set AFK time for " + playerName + " to " + time), true);
									return 1;
								})));
		//don't forget to register it...
		dispatcher.register(setAfkTimeCommand);

		//register commands here
	}
	#endif

	private static LiteralArgumentBuilder<CommandSourceStack> literal(String string) {
		return LiteralArgumentBuilder.literal(string);
	}
	public static <T> RequiredArgumentBuilder<CommandSourceStack, T> argument(String name, ArgumentType<T> type) {
		return RequiredArgumentBuilder.argument(name, type);
	}
	
	//================//
	// helper classes //
	//================//
	
	public interface IEventProxy
	{
		void registerEvents();
	}
}
