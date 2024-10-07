package io.github.maloryware.backstreet_gardener.networking;

import io.github.maloryware.backstreet_gardener.networking.payloads.S2CSoundPayload;
import io.github.maloryware.backstreet_gardener.sound.moving.BubblingSoundInstance;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;

import static io.github.maloryware.backstreet_gardener.sound.BSGSoundsClient.BUBBLING;

@SuppressWarnings("DataFlowIssue")
public class ClientPacketHandler {


	private static SoundInstance soundToPlay;
	public static void initialize(){

		ClientPlayNetworking.registerGlobalReceiver(S2CSoundPayload.ID, ((payload, context) -> {
			context.client().execute(() -> {
				if(payload.sound() == BUBBLING.getId()){
					soundToPlay = new BubblingSoundInstance((PlayerEntity) context.client().world.getEntityById(payload.sourceId()));
				}
				context.client().getSoundManager().play(soundToPlay);
				}
			);
		}));

	}
}
