package afraidmonster.mod.example;


import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import afraidmonster.mod.example.Armour.TitaniumArmorMaterial;
import afraidmonster.mod.example.Generation.ModOreBlock;
import afraidmonster.mod.example.Tools.CustomAxe;
import afraidmonster.mod.example.Tools.CustomHoe;
import afraidmonster.mod.example.Tools.CustomPickaxe;
import afraidmonster.mod.example.Tools.TitaniumToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.item.ItemStack;



public class mod implements ModInitializer {

	public static final ItemGroup TITANIUM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("mod", "titanium_group"))
            .icon(() -> new ItemStack(mod.TITANIUM_INGOT)) // This uses the model of the new material you created as an icon, but you can reference to whatever you like
            .build();
	
	
	public static final Item TITANIUM_INGOT = new Item(new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final Block ENDER_TITANIUM_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0F, 4.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	
	public static final Item RAW_TITANIUM = new Item(new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.RARE));
	private static ConfiguredFeature<?, ?> TITANIUM_ORE_END = Feature.ORE
    .configure(new OreFeatureConfig(
      new BlockMatchRuleTest(Blocks.END_STONE), ENDER_TITANIUM_ORE.getDefaultState(),
      6))
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(
	  100)))))
    .spreadHorizontally()
    .repeat(5);
	public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings.copy(Blocks.NETHERITE_BLOCK));
	
	public static final Item TITANIUM_SCRAP = new Item(new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.RARE));
	public static final ToolItem TITANIUM_PICKAXE = new CustomPickaxe(TitaniumToolMaterial.INSTANCE, 5, -2.7F, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final ToolItem TITANIUM_SWORD = new SwordItem(TitaniumToolMaterial.INSTANCE, 13, -2.0F, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final ToolItem TITANIUM_SHOVEL = new ShovelItem(TitaniumToolMaterial.INSTANCE, 7, -2.6F, new  Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final ToolItem TITANIUM_AXE = new CustomAxe(TitaniumToolMaterial.INSTANCE, 17, -2.5F, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC)); 
	public static final ToolItem TITANIUM_HOE = new CustomHoe(TitaniumToolMaterial.INSTANCE, 4, -2.7F, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC)); 
	public static final ArmorMaterial TITANIUM = new TitaniumArmorMaterial();
	public static final Item TITANIUM_HELMET = new ArmorItem(TITANIUM, EquipmentSlot.HEAD, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final Item TITANIUM_CHESTPLATE = new ArmorItem(TITANIUM, EquipmentSlot.CHEST, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final Item TITANIUM_LEGGINGS = new ArmorItem(TITANIUM, EquipmentSlot.LEGS, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final Item TITANIUM_BOOTS = new ArmorItem(TITANIUM, EquipmentSlot.FEET, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC));
	public static final Block NETHER_TITANIUM_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0F, 4.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	
	
	 
	
	
	
	
	
	private static ConfiguredFeature<?, ?> TITANIUM_ORE_NETHER = Feature.ORE
    .configure(new OreFeatureConfig(
		OreFeatureConfig.Rules.BASE_STONE_NETHER, NETHER_TITANIUM_ORE.getDefaultState(),
      4))
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(
	  50)))))
    .spreadHorizontally()
    .repeat(3);

	//private static ConfiguredFeature<?, ?> TITANIUM_ORE_NETHER = Feature.ORE
    //.configure(new OreFeatureConfig(
    // OreFeatureConfig.Rules.BASE_STONE_NETHER, NETHER_TITANIUM_ORE.getDefaultState(),
     // 4))
    //.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 50)))
    //.spreadHorizontally()
  //  .repeat(3);
	
	public static final String MOD_ID = "mod";

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
	@SuppressWarnings("deprecation")
	public void onInitialize() {

	OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.TEMPERATE, 2D);
	OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.COOL, 2D);



		
	
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_ingot"), TITANIUM_INGOT);
	Registry.register(Registry.BLOCK, new Identifier("mod", "ender_titanium_ore"), ENDER_TITANIUM_ORE);
	Registry.register(Registry.ITEM, new Identifier("mod", "ender_titanium_ore"), new BlockItem(ENDER_TITANIUM_ORE, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.UNCOMMON)));
	Registry.register(Registry.ITEM, new Identifier("mod", "raw_titanium"), RAW_TITANIUM);
	RegistryKey<ConfiguredFeature<?, ?>> titaniumOreEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
        new Identifier("mod","ender_titanium_ore"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, titaniumOreEnd.getValue(), TITANIUM_ORE_END);
    BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, titaniumOreEnd);
	Registry.register(Registry.BLOCK, new Identifier("mod", "titanium_block"), TITANIUM_BLOCK);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_block"), new BlockItem(TITANIUM_BLOCK, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.EPIC)));
	
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_scrap"), TITANIUM_SCRAP);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_pickaxe"), TITANIUM_PICKAXE);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_sword"), TITANIUM_SWORD);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_shovel"), TITANIUM_SHOVEL);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_axe"), TITANIUM_AXE);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_hoe"), TITANIUM_HOE);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_helmet"), TITANIUM_HELMET);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_chestplate"), TITANIUM_CHESTPLATE);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_leggings"), TITANIUM_LEGGINGS);
	Registry.register(Registry.ITEM, new Identifier("mod", "titanium_boots"), TITANIUM_BOOTS);
	RegistryKey<ConfiguredFeature<?, ?>> titaniumOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
       new Identifier("mod","nether_titanium_ore"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, titaniumOreNether.getValue(), TITANIUM_ORE_NETHER);
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, titaniumOreNether);
	Registry.register(Registry.BLOCK, new Identifier("mod", "nether_titanium_ore"), NETHER_TITANIUM_ORE);
	Registry.register(Registry.ITEM, new Identifier("mod", "nether_titanium_ore"), new BlockItem(NETHER_TITANIUM_ORE, new Item.Settings().group(mod.TITANIUM_GROUP).rarity(Rarity.UNCOMMON)));

	Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("testbiome","ancient_debris"), CUSTOM_SURFACE_BUILDER_0);
	Registry.register(BuiltinRegistries.BIOME, CUSTOMLAND_KEY.getValue(), CUSTOMLAND);

	OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.TEMPERATE, 2D);
	OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.COOL, 2D);
	
	

	}






	



	









}
