package tosutosu.betterwithbackpacks;

import net.minecraft.core.item.Item;
import tosutosu.betterwithbackpacks.item.ItemBackpack;
import turniplabs.halplibe.helper.ItemHelper;

import static tosutosu.betterwithbackpacks.BetterWithBackpacks.itemID;

public class ModItems {
    public static final Item Shulker_Box = ItemHelper.createItem(BetterWithBackpacks.MOD_ID, new ItemBackpack("Shulker",itemID++,27), "Shulker", "Shulker.png").setMaxStackSize(1);
    public static void init(){}
}
