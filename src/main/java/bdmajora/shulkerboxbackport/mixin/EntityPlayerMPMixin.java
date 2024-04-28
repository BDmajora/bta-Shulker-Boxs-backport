package bdmajora.shulkerboxbackport.mixin;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import net.minecraft.server.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import bdmajora.shulkerboxbackport.ShulkerBoxBackport;
import bdmajora.shulkerboxbackport.IPlayerDisplay;
import bdmajora.shulkerboxbackport.gui.container.ContainerShulkerBox;

@Mixin(value = EntityPlayerMP.class, remap = false)
public class EntityPlayerMPMixin implements IPlayerDisplay {
    @Unique
    private final EntityPlayerMP thisAs = (EntityPlayerMP)(Object)this;
    @Shadow
    private void getNextWindowId() {}
    @Shadow
    private int currentWindowId = 0;
    @Override
    public void displayGUIBackpack(ItemStack stack) {
        getNextWindowId();
        ContainerShulkerBox backpack = new ContainerShulkerBox(thisAs.inventory, stack);
        thisAs.playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, ShulkerBoxBackport.GUI_BACKPACK_ID, "Backpack", backpack.backpackInventory.getSizeInventory()));
        thisAs.craftingInventory = backpack;
        thisAs.craftingInventory.windowId = currentWindowId;
        thisAs.craftingInventory.onContainerInit(thisAs);
    }
}
