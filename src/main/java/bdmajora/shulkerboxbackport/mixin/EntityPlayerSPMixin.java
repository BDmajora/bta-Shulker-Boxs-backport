package bdmajora.shulkerboxbackport.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import bdmajora.shulkerboxbackport.IPlayerDisplay;
import bdmajora.shulkerboxbackport.gui.guiscreen.GuiShulkerBox;

@Mixin(value = EntityPlayerSP.class, remap = false)
public class EntityPlayerSPMixin implements IPlayerDisplay {
    @Unique
    private final Minecraft mc = Minecraft.getMinecraft(this);
    @Unique
    private final EntityPlayerSP thisAs = (EntityPlayerSP)(Object)this;

    @Override
    public void displayGUIBackpack(ItemStack stack) {
        mc.displayGuiScreen(new GuiShulkerBox(thisAs, stack));
    }
}

