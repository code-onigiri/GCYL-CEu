package com.fulltrix.tjfcore.machines;

import com.fulltrix.tjfcore.TJFConfig;
import com.fulltrix.tjfcore.TJFUtility;
import com.fulltrix.tjfcore.client.ClientHandler;
import com.fulltrix.tjfcore.machines.multi.MetaTileEntityBioReactor;
import com.fulltrix.tjfcore.machines.multi.MetaTileEntityCosmicRayDetector;
import com.fulltrix.tjfcore.machines.multi.MetaTileEntityElectricImplosion;
import com.fulltrix.tjfcore.machines.multi.MetaTileEntityStellarForge;
import com.fulltrix.tjfcore.machines.multi.advance.*;
import com.fulltrix.tjfcore.machines.multi.miner.MetaTileEntityVoidMiner;
import com.fulltrix.tjfcore.machines.multi.simple.MetaTileEntityPlasmaCondenser;
import com.fulltrix.tjfcore.recipes.TJFRecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import net.minecraft.util.ResourceLocation;

import static com.fulltrix.tjfcore.TJFUtility.tjfId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class TJFTileEntities {
    public static MetaTileEntityBioReactor BIO_REACTOR;
    public static MetaTileEntityAdvFusionReactor[] ADVANCED_FUSION_REACTOR = new MetaTileEntityAdvFusionReactor[5];
    public static SimpleMachineMetaTileEntity[] DEHYDRATOR = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];
    public static MetaTileEntityVoidMiner[] VOID_MINER = new MetaTileEntityVoidMiner[3];
    public static MetaTileEntityStellarForge STELLAR_FORGE;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntityVolcanus VOLCANUS;
    public static MetaTileEntityHyperReactor[] HYPER_REACTOR = new MetaTileEntityHyperReactor[3];
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;
    public static MetaTileEntityAdvMixer ADVANCED_MIXER;
    public static MetaTileEntityAdvCentrifuge ADVANCED_CENTRIFUGE;
    public static MetaTileEntityElectricImplosion ELECTRIC_IMPLOSION;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[8];
    public static SimpleGeneratorMetaTileEntity[] ROCKET_GENERATOR = new SimpleGeneratorMetaTileEntity[8];

    ///////////////////////////////////////////
    public static final MetaTileEntityEnergyHatch[] ENERGY_INPUT_HATCH_4A = new MetaTileEntityEnergyHatch[4]; // UEV, UIV, UXV, OPV
    public static final MetaTileEntityEnergyHatch[] ENERGY_INPUT_HATCH_16A = new MetaTileEntityEnergyHatch[4];
    public static final MetaTileEntityEnergyHatch[] ENERGY_OUTPUT_HATCH_4A = new MetaTileEntityEnergyHatch[4];
    public static final MetaTileEntityEnergyHatch[] ENERGY_OUTPUT_HATCH_16A = new MetaTileEntityEnergyHatch[4];

    public static int id = 32000;

    public static void init() {

        BIO_REACTOR = registerMetaTileEntity(id, new MetaTileEntityBioReactor(new ResourceLocation("tjfcore", "bio_reactor")));

        ADVANCED_FUSION_REACTOR[0] = registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uhv"), GTValues.UHV));
        ADVANCED_FUSION_REACTOR[1] = registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uev"), GTValues.UEV));
        ADVANCED_FUSION_REACTOR[2] = registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uiv"), GTValues.UIV));
        ADVANCED_FUSION_REACTOR[3] = registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uxv"), GTValues.UXV));
        ADVANCED_FUSION_REACTOR[4] = registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.opv"), GTValues.OpV));

        VOID_MINER[0] = registerMetaTileEntity(++id, new MetaTileEntityVoidMiner(tjfId("void_miner"), GTValues.UV, TJFConfig.multis.voidMiner.maxTemp));
        VOID_MINER[1] = registerMetaTileEntity(++id, new MetaTileEntityVoidMiner(tjfId("void_miner.uhv"), GTValues.UHV, TJFConfig.multis.voidMiner.maxTempUHV));
        VOID_MINER[2] = registerMetaTileEntity(++id, new MetaTileEntityVoidMiner(tjfId("void_miner.uev"), GTValues.UEV, TJFConfig.multis.voidMiner.maxTempUEV));

        STELLAR_FORGE = registerMetaTileEntity(++id, new MetaTileEntityStellarForge(tjfId("stellar_forge")));

        COSMIC_RAY_DETECTOR = registerMetaTileEntity(++id, new MetaTileEntityCosmicRayDetector(tjfId("cosmic_ray_detector")));

        VOLCANUS = registerMetaTileEntity(++id, new MetaTileEntityVolcanus(tjfId("volcanus")));

        HYPER_REACTOR[0] = registerMetaTileEntity(++id, new MetaTileEntityHyperReactor(tjfId("hyper_reactor.i"), GTUtility.getTierByVoltage(TJFConfig.multis.hyperReactors.euGeneration[0])));
        HYPER_REACTOR[1] = registerMetaTileEntity(++id, new MetaTileEntityHyperReactor(tjfId("hyper_reactor.ii"), GTUtility.getTierByVoltage(TJFConfig.multis.hyperReactors.euGeneration[1])));
        HYPER_REACTOR[2] = registerMetaTileEntity(++id, new MetaTileEntityHyperReactor(tjfId("hyper_reactor.iii"), GTUtility.getTierByVoltage(TJFConfig.multis.hyperReactors.euGeneration[2])));

        PLASMA_CONDENSER = registerMetaTileEntity(++id, new MetaTileEntityPlasmaCondenser(tjfId("plasma_condenser"), false));

        ADVANCED_MIXER = registerMetaTileEntity(++id, new MetaTileEntityAdvMixer(tjfId("large_mixer")));

        ADVANCED_CENTRIFUGE = registerMetaTileEntity(++id, new MetaTileEntityAdvCentrifuge(tjfId("large_centrifuge")));

        ELECTRIC_IMPLOSION = registerMetaTileEntity(++id, new MetaTileEntityElectricImplosion(tjfId("electric_implosion")));

        LARGE_NAQUADAH_REACTOR = registerMetaTileEntity(++id, new MetaTileEntityLargeNaquadahReactor(tjfId("large_naquadah_reactor")));


        //TODO: configurable efficiency for naq reactors, efficiency implementation in general

        /*
        if (TJFConfig.Misc.naqEfficieny) {
            NAQUADAH_REACTOR[4] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("naquadah_reactor.mk2"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 6, 100));
            NAQUADAH_REACTOR[5] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("naquadah_reactor.mk3"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 7, 80));
            NAQUADAH_REACTOR[6] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("naquadah_reactor.mk4"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 8, 50));
        } else {

         */
            NAQUADAH_REACTOR[4] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("naquadah_reactor.mk2"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 6,GTUtility.genericGeneratorTankSizeFunction));
            NAQUADAH_REACTOR[5] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("naquadah_reactor.mk3"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 7, GTUtility.genericGeneratorTankSizeFunction));
            NAQUADAH_REACTOR[6] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("naquadah_reactor.mk4"), TJFRecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 8, GTUtility.genericGeneratorTankSizeFunction));
        /*}

        if (TJFConfig.Misc.rocketEfficiency) {
            ROCKET_GENERATOR[3] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("rocket_generator.mk1"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 4, TJFConfig.Misc.EVRocketEfficiency));
            ROCKET_GENERATOR[4] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("rocket_generator.mk2"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 5,  TJFConfig.Misc.IVRocketEfficiency));
            ROCKET_GENERATOR[5] = registerMetaTileEntity(++id, new SimpleGeneratorWithLossMetaTileEntity(tjfId("rocket_generator.mk3"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 6,  TJFConfig.Misc.LuVRocketEfficiency));
        } else {

         */
            ROCKET_GENERATOR[3] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("rocket_generator.mk1"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 4, GTUtility.genericGeneratorTankSizeFunction));
            ROCKET_GENERATOR[4] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("rocket_generator.mk2"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
            ROCKET_GENERATOR[5] = registerMetaTileEntity(++id, new SimpleGeneratorMetaTileEntity(tjfId("rocket_generator.mk3"), TJFRecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        //}

        //TODO: figure this out
        /*
        for(int i = 10; i<13 ; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            ENERGY_INPUT_HATCH_4A[i-10] = registerMetaTileEntity(++id,
                    new MetaTileEntityEnergyHatch(tjfId("energy_hatch.input_4a"+voltageName),i,4,false));
            ENERGY_OUTPUT_HATCH_4A[i-10] = registerMetaTileEntity(++id,
                    new MetaTileEntityEnergyHatch(tjfId("energy_hatch.input_4a"+voltageName),i,4,true));
            ENERGY_INPUT_HATCH_16A[i-10] = registerMetaTileEntity(++id,
                    new MetaTileEntityEnergyHatch(tjfId("energy_hatch.input_16a"+voltageName),i,16,false));
            ENERGY_OUTPUT_HATCH_16A[i-10] = registerMetaTileEntity(++id,
                    new MetaTileEntityEnergyHatch(tjfId("energy_hatch.input_16a"+voltageName),i,16,true));
        }

         */

        MetaTileEntities.registerSimpleMetaTileEntity(DEHYDRATOR, ++id, "dehydrator", TJFRecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES, Textures.SIFTER_OVERLAY, true, TJFUtility::tjfId, GTUtility.hvCappedTankSizeFunction);
    }
}