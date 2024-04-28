package bdmajora.shulkerboxbackport.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import bdmajora.shulkerboxbackport.ShulkerBoxBackport;
import bdmajora.shulkerboxbackport.IPlayerDisplay;

public class ItemShulkerBox extends Item{
    public final int backpackSize;
    public ItemShulkerBox(String name, int id) {
        this(name, id, 9);
    }
    public ItemShulkerBox(String name, int id, int backpackSize) {
        super(name, id);
        this.maxStackSize = 1;
        this.backpackSize = backpackSize;
    }
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (!world.isClientSide && ShulkerBoxBackport.ENABLE_BACKPACKS){
            ((IPlayerDisplay) entityplayer).displayGUIBackpack(itemstack);
        }
        return itemstack;
    }
}
