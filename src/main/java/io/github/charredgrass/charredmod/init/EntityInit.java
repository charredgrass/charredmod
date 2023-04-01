package io.github.charredgrass.charredmod.init;

import io.github.charredgrass.charredmod.CharredMod;
import io.github.charredgrass.charredmod.entities.ExplodingArrowEntity;
import io.github.charredgrass.charredmod.entities.SplittingArrowEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CharredMod.MODID);

    public static final RegistryObject<EntityType<ExplodingArrowEntity>> EXPLODING_ARROW =
            ENTITIES.register("exploding_arrow",
                    () -> EntityType.Builder.of((EntityType.EntityFactory<ExplodingArrowEntity>) ExplodingArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F).build("exploding_arrow"));

    public static final RegistryObject<EntityType<SplittingArrowEntity>> SPLITTING_ARROW =
            ENTITIES.register("splitting_arrow",
                    () -> EntityType.Builder.of((EntityType.EntityFactory<SplittingArrowEntity>) SplittingArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F).build("splitting_arrow"));
}
