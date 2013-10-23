package spacecraft.mods.galacticraft.venus.client;

import spacecraft.mods.galacticraft.venus.CommonProxyVenus;
import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import spacecraft.mods.galacticraft.venus.client.fx.GCVenusEntityDropParticleFX;
import spacecraft.mods.galacticraft.venus.client.model.GCVenusModelSpaceshipTier3;
import spacecraft.mods.galacticraft.venus.client.render.entities.GCVenusRenderAlienVillager;
import spacecraft.mods.galacticraft.venus.client.render.entities.GCVenusRenderEvolvedBlaze;
import spacecraft.mods.galacticraft.venus.client.render.entities.GCVenusRenderFlameling;
import spacecraft.mods.galacticraft.venus.client.render.item.GCVenusItemRendererSpaceshipT3;
import spacecraft.mods.galacticraft.venus.client.sounds.GCVenusSounds;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityAlienVillager;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityEvolvedBlaze;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityFlameling;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityRocketT3;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.client.GCCoreCloudRenderer;
import micdoodle8.mods.galacticraft.core.client.render.entities.GCCoreRenderAlienVillager;
import micdoodle8.mods.galacticraft.core.client.render.entities.GCCoreRenderSpaceship;
import micdoodle8.mods.galacticraft.core.client.render.entities.GCCoreRenderZombie;
import micdoodle8.mods.galacticraft.core.client.render.item.GCCoreItemRendererKey;
import micdoodle8.mods.galacticraft.core.client.sounds.GCCoreSoundUpdaterSpaceship;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ClientProxyVenus extends CommonProxyVenus
{
    private static int eggRenderID;
    private static int treasureRenderID;
    
    public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();
    
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new GCVenusSounds());
    }
    
    @Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
        NetworkRegistry.instance().registerChannel(new ClientPacketHandler(), GCVenus.CHANNEL, Side.CLIENT);
        ClientProxyVenus.eggRenderID = RenderingRegistry.getNextAvailableRenderId();

        //Blue Cape
        String capeBlueString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeBlue.png";
        //Green Cape
        String capeGreenString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeGreen.png";
        //Orange Cape
        String capeOrangeString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeOrange.png";
        //Red Cape
        String capeRedString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeRed.png";
        //Violet Cape
        String capeVioletString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeViolet.png";
        //Yellow Cape
        String capeYellowString = "https://raw.github.com/Super4Ever4MC/Galacticraft-Venus-Add-on/master/capes/capeYellow.png";

        ClientProxyCore.capeMap.put("mattparks", capeBlueString);     
        ClientProxyCore.capeMap.put("flashy3", capeOrangeString); 
        ClientProxyCore.capeMap.put("ghostheart305", capeRedString); 
        ClientProxyCore.capeMap.put("langjam350roxsox", capeBlueString); 
        ClientProxyCore.capeMap.put("_Ja1m3", capeRedString); 
        ClientProxyCore.capeMap.put("dinammar", capeVioletString); 
        ClientProxyCore.capeMap.put("goldenkat99", capeOrangeString); 
    }

    @Override
    public void registerRenderInformation()
    {
        IModelCustom cargoRocketModel = AdvancedModelLoader.loadModel("/assets/galacticraftvenus/models/cargoRocket.obj");
        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityRocketT3.class, new GCCoreRenderSpaceship(new GCVenusModelSpaceshipTier3(), GCVenus.TEXTURE_DOMAIN, "rocketT3"));
        RenderingRegistry.addNewArmourRendererPrefix("gem");
        MinecraftForgeClient.registerItemRenderer(GCVenusItems.spaceship.itemID, new GCVenusItemRendererSpaceshipT3(cargoRocketModel));
    
        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityAlienVillager.class, new GCVenusRenderAlienVillager());
        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityFlameling.class, new GCVenusRenderFlameling());
        //        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityEvolvedBlaze.class, new GCVenusRenderEvolvedBlaze());
    }


    @Override
    public int getEggRenderID()
    {
        return ClientProxyVenus.eggRenderID;
    }

    @Override
    public int getTreasureRenderID()
    {
        return ClientProxyVenus.treasureRenderID;
    }


    @Override
    public void spawnParticle(String var1, double var2, double var4, double var6)
    {
        final Minecraft var14 = FMLClientHandler.instance().getClient();

        if (var14 != null && var14.renderViewEntity != null && var14.effectRenderer != null)
        {
            final double var15 = var14.renderViewEntity.posX - var2;
            final double var17 = var14.renderViewEntity.posY - var4;
            final double var19 = var14.renderViewEntity.posZ - var6;
            Object var21 = null;
            final double var22 = 64.0D;

            if (var15 * var15 + var17 * var17 + var19 * var19 < var22 * var22)
            {
                if (var1.equals("sludgeDrip"))
                {
                }
            }
        }
    }

    public class ClientPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
        {
            final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
            final int packetType = PacketUtil.readPacketID(data);
            EntityPlayer player = (EntityPlayer) p;

            if (packetType == 0)
            {
                final Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class };
                final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

                int entityID = 0;
                Entity entity = null;
                
                switch ((Integer) packetReadout[1])
                {
                case 0:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                case 1:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                }
            }
        }
    }

    {
    }

    public static boolean handleLavaMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }

    public static boolean handleWaterMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.water);
    }

    {
    }

    public static class TickHandlerClient implements ITickHandler
    {
        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
            final Minecraft minecraft = FMLClientHandler.instance().getClient();

            final WorldClient world = minecraft.theWorld;

            if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
                if (world != null)
                {
                    if (world.provider instanceof GCVenusWorldProvider)
                    {
                        if (world.provider.getSkyRenderer() == null)
                        {
                            world.provider.setSkyRenderer(new GCVenusSkyProvider());
                        }

                        if (world.provider.getCloudRenderer() == null)
                        {
                            world.provider.setCloudRenderer(new GCCoreCloudRenderer());
                        }
                    }

                    for (int i = 0; i < world.loadedEntityList.size(); i++)
                    {
                        final Entity e = (Entity) world.loadedEntityList.get(i);

                        if (e != null)
                        {
                            if (e instanceof GCVenusEntityRocketT3)
                            {
                                final GCVenusEntityRocketT3 eship = (GCVenusEntityRocketT3) e;

                                if (eship.rocketSoundUpdater == null)
                                {
                                    eship.rocketSoundUpdater = new GCCoreSoundUpdaterSpaceship(FMLClientHandler.instance().getClient().sndManager, eship, FMLClientHandler.instance().getClient().thePlayer);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
        }

        @Override
        public String getLabel()
        {
            return "Galacticraft Venus 2 Client";
        }

        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.CLIENT);
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        return null;
    }
}
