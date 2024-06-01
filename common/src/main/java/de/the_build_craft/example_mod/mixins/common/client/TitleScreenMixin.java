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

package de.the_build_craft.example_mod.mixins.common.client;

#if MC_VER > MC_1_19_2
import net.minecraft.client.gui.components.LogoRenderer;
#endif
import net.minecraft.client.gui.screens.TitleScreen;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Leander Knüttel
 * @version 27.05.2024
 */
#if MC_VER > MC_1_19_2
@Mixin(LogoRenderer.class)
public class TitleScreenMixin {
    @Mutable
    @Shadow @Final private boolean showEasterEgg;

    @Inject(method = "<init>(Z)V", at = @At("RETURN"))
    private void setEasterEgg(CallbackInfo ci) {
        this.showEasterEgg = true; // Minceraft!
    }
}
#else
@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Mutable
    @Shadow @Final private boolean minceraftEasterEgg;

    @Inject(method = "<init>(Z)V", at = @At("RETURN"))
    private void setEasterEgg(CallbackInfo ci) {
        this.minceraftEasterEgg = true; // Minceraft!
    }
}
#endif
