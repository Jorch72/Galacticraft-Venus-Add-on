package micdoodle8.mods.galacticraft.core.network;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityControllable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.relauncher.Side;

public class GCCorePacketControllableEntity implements IGalacticraftAdvancedPacket
{
    public static final int packetID = 12;

    public static Packet buildKeyPacket(int key)
    {
        final Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = GalacticraftCore.CHANNEL;

        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final DataOutputStream data = new DataOutputStream(bytes);

        try
        {
            data.writeInt(GCCorePacketControllableEntity.packetID);
            data.writeInt(key);

            packet.data = bytes.toByteArray();
            packet.length = packet.data.length;

            data.close();
            bytes.close();
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        return packet;
    }

    @Override
    public byte getPacketID()
    {
        return GCCorePacketControllableEntity.packetID;
    }

    @Override
    public void handlePacket(DataInputStream stream, Object[] extraData, Side side)
    {
        try
        {
            final EntityPlayer player = (EntityPlayer) extraData[0];

            final int key = stream.readInt();
            if (player.ridingEntity != null && player.ridingEntity instanceof GCCoreEntityControllable)
            {
                ((GCCoreEntityControllable) player.ridingEntity).pressKey(key);
            }

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}
