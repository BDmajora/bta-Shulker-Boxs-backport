package bdmajora.shulkerboxbackport.gui.guiscreen;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import org.lwjgl.opengl.GL11;
import bdmajora.shulkerboxbackport.ShulkerBoxBackport;
import bdmajora.shulkerboxbackport.gui.container.ContainerShulkerBox;

public class GuiShulkerBox extends GuiContainer {
    private int GUIx;
    private int GUIy;
    private int rows;
    private int slotsNum;
    private final ContainerShulkerBox backpack;
    public GuiShulkerBox(EntityPlayer player, ItemStack stack) {
        super(new ContainerShulkerBox(player.inventory, stack));
        backpack = (ContainerShulkerBox)inventorySlots;
    }

    @Override
    public void init() {
        GUIx = (this.width - this.xSize) / 2;
        GUIy = (this.height - this.ySize) / 2;
        slotsNum = backpack.backpackInventory.getSizeInventory();
        rows = (int) Math.ceil(slotsNum/9d);
        super.init();
    }
    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString(backpack.backpackInventory.getInvName(), 8, 6, ShulkerBoxBackport.GUI_LABEL_COLOR);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, ShulkerBoxBackport.GUI_LABEL_COLOR);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        GL11.glColor3d(1d,1d, 1d);
        mc.renderEngine.bindTexture(mc.renderEngine.getTexture("/assets/shulkerboxbackport/gui/shulker_box.png"));
        drawTexturedModalRect(GUIx, GUIy, 0, 0, this.xSize, this.ySize);

        for (int i = 0; i < rows; i++) {
            if (i == rows - 1) {
                drawTexturedModalRect(GUIx + 7,GUIy + 17 + 18 * i, 0, 166, 18 * (slotsNum - (9 * i)), 18);
            } else {
                drawTexturedModalRect(GUIx + 7, GUIy + 17 + 18 * i, 0, 166, 162, 18);
            }
        }
    }
}
