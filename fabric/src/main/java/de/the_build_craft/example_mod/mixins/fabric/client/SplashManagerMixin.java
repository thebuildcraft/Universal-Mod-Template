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

package de.the_build_craft.example_mod.mixins.fabric.client;

#if MC_VER > MC_1_19_4
import net.minecraft.client.gui.components.SplashRenderer;
#endif
import net.minecraft.client.resources.SplashManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Leander Knüttel
 * @version 17.05.2024
 */
@Mixin(SplashManager.class)
public class SplashManagerMixin {
    @Inject(method = "getSplash", at = @At("HEAD"), cancellable = true)
    #if MC_VER > MC_1_19_4
    private void setSplash(CallbackInfoReturnable<SplashRenderer> cir) {
        cir.setReturnValue(new SplashRenderer("§c§lExampleMod Fabric!"));
    }
    #else
    private void setSplash(CallbackInfoReturnable<String> cir) {
    cir.setReturnValue("§c§lExampleMod Fabric!");
    }
    #endif
}