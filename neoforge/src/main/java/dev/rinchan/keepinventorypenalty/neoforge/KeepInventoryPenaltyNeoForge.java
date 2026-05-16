package dev.rinchan.keepinventorypenalty.neoforge;

import dev.rinchan.keepinventorypenalty.KeepInventoryPenalty;
import dev.rinchan.keepinventorypenalty.KeepInventoryPenaltyConfig;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

@Mod(KeepInventoryPenalty.MOD_ID)
public class KeepInventoryPenaltyNeoForge {
    public KeepInventoryPenaltyNeoForge(IEventBus modBus) {
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, KeepInventoryPenaltyConfig.SPEC);
        NeoForge.EVENT_BUS.addListener(this::onServerStarted);
        NeoForge.EVENT_BUS.addListener(this::onLivingDeath);
        NeoForge.EVENT_BUS.addListener(this::onPlayerRespawn);
        NeoForge.EVENT_BUS.addListener(this::onPlayerLogout);
    }

    private void onServerStarted(ServerStartedEvent event) {
        KeepInventoryPenalty.enforceKeepInventory(event.getServer());
    }

    private void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            KeepInventoryPenalty.applyDeathPenalty(player);
        }
    }

    private void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            KeepInventoryPenalty.finishRespawn(player);
        }
    }

    private void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        KeepInventoryPenalty.clearPlayer(event.getEntity().getUUID());
    }
}
