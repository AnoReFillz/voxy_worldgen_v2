package com.ethan.voxyworldgenv2.mixin;

import com.ethan.voxyworldgenv2.client.DebugRenderer;
import net.minecraft.client.gui.components.debug.DebugScreenEntries;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(DebugScreenEntries.class)
public class DebugScreenEntriesMixin {

    @Inject(method = "allEntries", at = @At("RETURN"))
    private static void addVoxyEntry(CallbackInfoReturnable<Map<Identifier, DebugScreenEntry>> cir) {
        cir.getReturnValue().put(DebugRenderer.ID, DebugRenderer.INSTANCE);
    }
}
