package com.fulltrix.tjfcore.machines;

import com.fulltrix.tjfcore.machines.multi.MetaTileEntityBioReactor;
import com.fulltrix.tjfcore.machines.multi.advance.MetaTileEntityAdvFusionReactor;
import gregtech.api.GTValues;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;

import static com.fulltrix.tjfcore.TJFUtility.tjfId;

public class TJFTileEntities {
    public static MetaTileEntityBioReactor BIO_REACTOR;

    public static MetaTileEntityAdvFusionReactor[] ADVANCED_FUSION_REACTOR = new MetaTileEntityAdvFusionReactor[5];

    public static int id = 32000;

    public static void init() {

        BIO_REACTOR = MetaTileEntities.registerMetaTileEntity(id, new MetaTileEntityBioReactor(new ResourceLocation("tjfcore", "bio_reactor")));

        ADVANCED_FUSION_REACTOR[0] = MetaTileEntities.registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uhv"), GTValues.UHV));
        ADVANCED_FUSION_REACTOR[1] = MetaTileEntities.registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uev"), GTValues.UEV));
        ADVANCED_FUSION_REACTOR[2] = MetaTileEntities.registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uiv"), GTValues.UIV));
        ADVANCED_FUSION_REACTOR[3] = MetaTileEntities.registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.uxv"), GTValues.UXV));
        ADVANCED_FUSION_REACTOR[4] = MetaTileEntities.registerMetaTileEntity(++id, new MetaTileEntityAdvFusionReactor(tjfId("adv_fusion_reactor.opv"), GTValues.OpV));

    }
}