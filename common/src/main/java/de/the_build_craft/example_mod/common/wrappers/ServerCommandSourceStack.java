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

package de.the_build_craft.example_mod.common.wrappers;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * @author Leander Knüttel
 * @version 22.05.2024
 */
public class ServerCommandSourceStack extends CommandSourceStack {
    public ServerCommandSourceStack(CommandSource $$0, Vec3 $$1, Vec2 $$2, ServerLevel $$3, int $$4, String $$5, Component $$6, MinecraftServer $$7, @Nullable Entity $$8) {
        super($$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7, $$8);
    }

    public void SendFeedback(Component text, boolean allowLogging){
        #if MC_VER < MC_1_20_1
		sendSuccess(text, allowLogging);
		#else
        Supplier<Component> supplier = () -> text;
        sendSuccess(supplier, allowLogging);
		#endif
    }

    public void SendFeedback(String text, boolean allowLogging){
        #if MC_VER < MC_1_20_1
		sendSuccess(Text.literal(text), allowLogging);
		#else
        Supplier<Component> supplier = () -> Text.literal(text);
        sendSuccess(supplier, allowLogging);
		#endif
    }

    public void SendError(Component text, boolean allowLogging){
        #if MC_VER < MC_1_20_1
		sendSuccess(text.copy().withStyle(Style.EMPTY.withColor(ChatFormatting.RED)), allowLogging);
		#else
        Supplier<Component> supplier = () -> text.copy().withStyle(Style.EMPTY.withColor(ChatFormatting.RED));
        sendSuccess(supplier, allowLogging);
		#endif
    }

    public void SendError(String text, boolean allowLogging){
        #if MC_VER < MC_1_20_1
		sendSuccess(Text.literal(text).withStyle(Style.EMPTY.withColor(ChatFormatting.RED)), allowLogging);
		#else
        Supplier<Component> supplier = () -> Text.literal(text).withStyle(Style.EMPTY.withColor(ChatFormatting.RED));
        sendSuccess(supplier, allowLogging);
		#endif
    }
}
