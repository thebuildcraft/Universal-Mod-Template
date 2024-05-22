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

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
#if MC_VER >= MC_1_19_4
import net.minecraft.world.flag.FeatureFlagSet;
#endif
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Leander Knüttel
 * @version 22.05.2024
 */
public class ClientCommandSourceStack implements SharedSuggestionProvider {
    public void SendFeedback(Component text){
        Utils.sendToClientChat(text);
    }
    public void SendFeedback(String text){
        Utils.sendToClientChat(text);
    }

    public void SendError(Component text){
        Utils.sendToClientChat(text.copy().withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
    }
    public void SendError(String text){
        Utils.sendToClientChat(Text.literal(text).withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
    }

    public LocalPlayer getLocalPlayer(){
        return Minecraft.getInstance().player;
    }

    @Override
    public Collection<String> getOnlinePlayerNames() {
        throw new NotImplementedException("todo");
    }

    @Override
    public Collection<String> getSelectedEntities() {
        return SharedSuggestionProvider.super.getSelectedEntities();
    }

    @Override
    public Collection<String> getAllTeams() {
        throw new NotImplementedException("todo");
    }

    @Override
    public Stream<ResourceLocation> getRecipeNames() {
        throw new NotImplementedException("todo");
    }

    @Override
    public Collection<TextCoordinates> getRelevantCoordinates() {
        return SharedSuggestionProvider.super.getRelevantCoordinates();
    }

    @Override
    public Collection<TextCoordinates> getAbsoluteCoordinates() {
        return SharedSuggestionProvider.super.getAbsoluteCoordinates();
    }

    @Override
    public Set<ResourceKey<Level>> levels() {
        throw new NotImplementedException("todo");
    }

    @Override
    public RegistryAccess registryAccess() {
        throw new NotImplementedException("todo");
    }

    @Override
    public boolean hasPermission(int i) {
        throw new NotImplementedException("todo");
    }

    #if MC_VER < MC_1_18_2
    @Override
    public CompletableFuture<Suggestions> customSuggestion(CommandContext<SharedSuggestionProvider> commandContext, SuggestionsBuilder suggestionsBuilder) {
        throw new NotImplementedException("todo");
    }
    #else
    @Override
    public CompletableFuture<Suggestions> customSuggestion(CommandContext<?> commandContext) {
        throw new NotImplementedException("todo");
    }

    @Override
    public CompletableFuture<Suggestions> suggestRegistryElements(ResourceKey<? extends Registry<?>> resourceKey, ElementSuggestionType elementSuggestionType, SuggestionsBuilder suggestionsBuilder, CommandContext<?> commandContext) {
        throw new NotImplementedException("todo");
    }

    @Override
    public void suggestRegistryElements(Registry<?> $$0, ElementSuggestionType $$1, SuggestionsBuilder $$2) {
        SharedSuggestionProvider.super.suggestRegistryElements($$0, $$1, $$2);
    }
    #endif
    #if MC_VER < MC_1_19_4
    @Override
    public Collection<ResourceLocation> getAvailableSoundEvents() {
        throw new NotImplementedException("todo");
    }
    #else
    @Override
    public Stream<ResourceLocation> getAvailableSounds() {
        throw new NotImplementedException("todo");
    }

    @Override
    public FeatureFlagSet enabledFeatures() {
        throw new NotImplementedException("todo");
    }

    @Override
    public Collection<String> getCustomTabSugggestions() {
        return SharedSuggestionProvider.super.getCustomTabSugggestions();
    }
    #endif
}