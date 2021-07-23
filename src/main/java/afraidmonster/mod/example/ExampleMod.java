package afraidmonster.mod.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ExampleMod implements ModInitializer {
	
	private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CUSTOM_SURFACE_BUILDER_0 = SurfaceBuilder.DEFAULT
	.withConfig(new TernarySurfaceConfig(
		Blocks.ANCIENT_DEBRIS.getDefaultState(),
		Blocks.ANDESITE.getDefaultState(),
		Blocks.NETHERRACK.getDefaultState()));

		private static final Biome CUSTOMLAND = createCustomLand();

		private static Biome createCustomLand() {

			SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
			DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);
			DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

			GenerationSettings.Builder generatorSettings = new GenerationSettings.Builder();
			generatorSettings.surfaceBuilder(CUSTOM_SURFACE_BUILDER_0);
			DefaultBiomeFeatures.addDungeons(generatorSettings);
			DefaultBiomeFeatures.addMineables(generatorSettings);
			DefaultBiomeFeatures.addLandCarvers(generatorSettings);
			DefaultBiomeFeatures.addDefaultUndergroundStructures(generatorSettings);

			return (new Biome.Builder())
			.precipitation(Biome.Precipitation.RAIN)
			.category(Biome.Category.NONE)
			.depth(0.125F)
			.scale(0.05F)
			.temperature(0.8F)
			.downfall(0.4F)
			.effects((new BiomeEffects.Builder())
				.waterColor(0xb434eb)
				.waterFogColor(0x050533)
				.fogColor(0xffc0c0)
				.skyColor(0xb434eb)
				.build())
			.spawnSettings(spawnSettings.build())
			.generationSettings(generatorSettings.build())
			.build();
		}

		public static final RegistryKey<Biome> CUSTOMLAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("testbiome", "customland"));










	@Override
	@Deprecated
	public void onInitialize() {

		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("testbiome","ancient_debris"), CUSTOM_SURFACE_BUILDER_0);
		Registry.register(BuiltinRegistries.BIOME, CUSTOMLAND_KEY.getValue(), CUSTOMLAND);

		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.TEMPERATE, 2D);
		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.COOL, 2D);

		
		
		

		
	}
	
}
