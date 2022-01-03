package janclient.packets.server;

import java.io.IOException;

import janclient.packets.ECPacket;
import net.minecraft.network.PacketBuffer;

public abstract class SPacket extends ECPacket {

	@Override
	public void writePacketData(PacketBuffer buf) throws IOException {
		// TODO Auto-generated method
		//Sent From Server. nothing to write
		
	}
	
}
