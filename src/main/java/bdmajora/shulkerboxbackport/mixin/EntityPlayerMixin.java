package bdmajora.shulkerboxbackport.mixin;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import bdmajora.shulkerboxbackport.IPlayerDisplay;

@Mixin(value = EntityPlayer.class, remap = false)
public class EntityPlayerMixin implements IPlayerDisplay {
    @Override
    public void displayGUIBackpack(ItemStack stack) {

    }
}
