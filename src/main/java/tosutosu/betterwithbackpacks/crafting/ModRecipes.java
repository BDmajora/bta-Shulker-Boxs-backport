package tosutosu.betterwithbackpacks.crafting;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.Registry;
import net.minecraft.core.data.registry.recipe.RecipeEntryBase;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Item;
import tosutosu.betterwithbackpacks.BetterWithBackpacks;
import tosutosu.betterwithbackpacks.ModItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ModRecipes implements RecipeEntrypoint {
    public static final RecipeNamespace BACKPACKS = new RecipeNamespace();
    public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));
    public static final Registry<Class<? extends RecipeEntryBase<?, ?, ?>>> RECIPE_TYPES = new Registry<>();
    @Override
    public void onRecipesReady() {
        Registries.RECIPE_TYPES.register("backpacks:backpack", RecipeEntryBackpack.class);

        BACKPACKS.register("workbench", WORKBENCH);

        Registries.RECIPES.register("backpacks", BACKPACKS);

        if (!BetterWithBackpacks.ENABLE_BACKPACKS){return;}
        RecipeBuilderShaped templateBackpack = new RecipeBuilderShaped(BetterWithBackpacks.MOD_ID, "AAA", "ABA", "AAA");
        }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(BetterWithBackpacks.MOD_ID);
        RecipeBuilder.getRecipeNamespace(BetterWithBackpacks.MOD_ID);
    }
}
