package dev.rinchan.keepinventorypenalty.compat;

import dev.rinchan.keepinventorypenalty.KeepInventoryPenalty;
import java.util.Set;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

public final class CuriosCompat {
    private CuriosCompat() {
    }

    public static void damageEquipped(ServerPlayer player, Set<ItemStack> seen) {
        CuriosApi.getCuriosInventory(player).ifPresent(handler -> handler.getCurios().values().forEach(stacksHandler -> {
            IDynamicStackHandler stacks = stacksHandler.getStacks();
            for (int slot = 0; slot < stacks.getSlots(); slot++) {
                KeepInventoryPenalty.damage(stacks.getStackInSlot(slot), seen);
            }
        }));
    }
}
