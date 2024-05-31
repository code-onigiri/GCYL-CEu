package com.fulltrix.tjfcore;

import com.fulltrix.tjfcore.item.TJFCoreItems;
import com.fulltrix.tjfcore.recipes.RecipeHandler;
import com.fulltrix.tjfcore.recipes.TJFRecipeMaps;
import com.fulltrix.tjfcore.recipes.categories.handlers.ElectricImplosionHandler;
import com.fulltrix.tjfcore.recipes.categories.handlers.FuelHandler;
import com.fulltrix.tjfcore.recipes.categories.handlers.VoidMinerHandler;
import com.fulltrix.tjfcore.recipes.recipeproperties.AdvFusionCoilProperty;
import gregicality.multiblocks.common.GCYMConfigHolder;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.event.HighTierEvent;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.api.unification.material.event.MaterialEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.io.IOException;
import java.util.function.Function;

import static com.fulltrix.tjfcore.item.TJFMetaBlocks.*;

@Mod.EventBusSubscriber(modid = TJFCore.MODID)
public class CommonProxy {
    public void preInit() {
        TJFCoreItems.init();
    }

    private static void registerRecipesAfterCT() {
        ElectricImplosionHandler.buildElectricImplosionRecipes();
    }

    public void onLoad() throws IOException {
        registerRecipesAfterCT();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void forceHighTierConfig(HighTierEvent event) {
        //Force enable high tier content, regardless of config option
        event.enableHighTier();

        //Force enable tiered casings from GCYM
        GCYMConfigHolder.globalMultiblocks.enableTieredCasings = true;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerMaterials(MaterialEvent event) {
        //TJFMaterials.registerNuclearMaterials();
        TJFMaterials.register();
        TJFMaterials.register2();
        TJFMaterials.registerSuperconductors();
        TJFMaterials.materialChanges();
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(TJFCore.MODID)) {
            ConfigManager.sync(TJFCore.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(HEATING_COIL);
        registry.register(MULTIBLOCK_CASING2);
        registry.register(TRANSPARENT_CASING);
        registry.register(FUSION_CASING);
        registry.register(VACUUM_CASING);
        registry.register(DIVERTOR_CASING);
        registry.register(CRYOSTAT_CASING);
        registry.register(EXPLOSIVE);
        registry.register(SIMPLE_BLOCK);
        registry.register(METAL_CASING_1);
        registry.register(METAL_CASING_2);
        registry.register(REACTOR_CASING);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(HEATING_COIL, VariantItemBlock::new));
        registry.register(createItemBlock(MULTIBLOCK_CASING2, VariantItemBlock::new));
        registry.register(createItemBlock(TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(FUSION_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(VACUUM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(DIVERTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(CRYOSTAT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EXPLOSIVE, VariantItemBlock::new));
        registry.register(createItemBlock(SIMPLE_BLOCK, VariantItemBlock::new));
        registry.register(createItemBlock(METAL_CASING_1, VariantItemBlock::new));
        registry.register(createItemBlock(METAL_CASING_2, VariantItemBlock::new));
        registry.register(createItemBlock(REACTOR_CASING, VariantItemBlock::new));
    }


    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        AdvFusionCoilProperty.registerAdvFusionTier(1, "1");
        AdvFusionCoilProperty.registerAdvFusionTier(2, "2");
        AdvFusionCoilProperty.registerAdvFusionTier(3, "3");
        AdvFusionCoilProperty.registerAdvFusionTier(4, "4");
        AdvFusionCoilProperty.registerAdvFusionTier(5, "5");
        FusionEUToStartProperty.registerFusionTier(9, "(Adv MK1)");
        FusionEUToStartProperty.registerFusionTier(10, "(Adv MK2)");
        FusionEUToStartProperty.registerFusionTier(11, "(Adv MK3)");

        TJFRecipeMaps.modifyMaps();

        RecipeHandler.initRecipes();
        RecipeHandler.initChains();

        FuelHandler.init();

        //RecipeHandler.registerLargeMachineRecipes();
    }

    @SubscribeEvent
    public static void registerOrePrefix(RegistryEvent.Register<IRecipe> event) {
        //NuclearHandler.register();
        VoidMinerHandler.register();
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        ResourceLocation registryName = block.getRegistryName();
        if (registryName == null) {
            throw new IllegalArgumentException("Block " + block.getTranslationKey() + " has no registry name.");
        }
        itemBlock.setRegistryName(registryName);
        return itemBlock;
    }

    //public void onLoad() throws IOException {

   //}
}
