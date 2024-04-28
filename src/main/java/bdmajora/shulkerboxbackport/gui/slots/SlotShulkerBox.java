package bdmajora.shulkerboxbackport.gui.slots;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;
import bdmajora.shulkerboxbackport.item.ItemShulkerBox;
import bdmajora.shulkerboxbackport.item.ItemShulkerBoxInventory;

public class SlotShulkerBox extends Slot {
    public SlotShulkerBox(ItemShulkerBoxInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }
    @Override
    public boolean canPutStackInSlot(ItemStack itemstack) {
        return itemstack.getItem() != null && !(itemstack.getItem() instanceof ItemShulkerBox);
    }
}
