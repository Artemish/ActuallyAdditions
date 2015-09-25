/*
 * This file ("InitBooklet.java") is part of the Actually Additions Mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://github.com/Ellpeck/ActuallyAdditions/blob/master/README.md
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * � 2015 Ellpeck
 */

package ellpeck.actuallyadditions.booklet;

import ellpeck.actuallyadditions.blocks.InitBlocks;
import ellpeck.actuallyadditions.blocks.metalists.TheColoredLampColors;
import ellpeck.actuallyadditions.blocks.metalists.TheMiscBlocks;
import ellpeck.actuallyadditions.booklet.page.BookletPage;
import ellpeck.actuallyadditions.booklet.page.PageCrafting;
import ellpeck.actuallyadditions.booklet.page.PageFurnace;
import ellpeck.actuallyadditions.booklet.page.PageTextOnly;
import ellpeck.actuallyadditions.config.values.ConfigIntValues;
import ellpeck.actuallyadditions.crafting.BlockCrafting;
import ellpeck.actuallyadditions.crafting.FoodCrafting;
import ellpeck.actuallyadditions.crafting.ItemCrafting;
import ellpeck.actuallyadditions.crafting.ToolCrafting;
import ellpeck.actuallyadditions.items.InitItems;
import ellpeck.actuallyadditions.items.metalists.TheFoods;
import ellpeck.actuallyadditions.items.metalists.TheMiscItems;
import ellpeck.actuallyadditions.items.metalists.TheSpecialDrops;
import ellpeck.actuallyadditions.util.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;

public class InitBooklet{

    public static ArrayList<BookletIndexEntry> entries = new ArrayList<BookletIndexEntry>();
    public static ArrayList<BookletPage> pagesWithItemStackData = new ArrayList<BookletPage>();

    public static BookletChapter chapterIntro;

    public static BookletIndexEntry entryFunctionalNonRF = new BookletIndexEntry("functionalNoRF");
    public static BookletIndexEntry entryFunctionalRF = new BookletIndexEntry("functionalRF");
    public static BookletIndexEntry entryGeneratingRF = new BookletIndexEntry("generatingRF");
    public static BookletIndexEntry entryItemsNonRF = new BookletIndexEntry("itemsNoRF");
    public static BookletIndexEntry entryItemsRF = new BookletIndexEntry("itemsRF");
    public static BookletIndexEntry entryMisc = new BookletIndexEntry("misc");
    public static BookletIndexEntry allAndSearch = new BookletEntryAllSearch("allAndSearch");

    static{
        chapterIntro = new BookletChapter("intro", entryMisc, new ItemStack(InitItems.itemLexicon), new PageTextOnly(1), new PageTextOnly(2), new PageCrafting(3, ItemCrafting.recipeBook));

        //Miscellaneous
        new BookletChapter("craftingIngs", entryMisc, new ItemStack(InitItems.itemMisc, 1, TheMiscItems.COIL.ordinal()), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeCoil).setNoText(), new PageCrafting(3, ItemCrafting.recipeCoilAdvanced).setNoText(), new PageCrafting(4, BlockCrafting.recipeCase).setNoText(), new PageCrafting(5, BlockCrafting.recipeStoneCase).setNoText(), new PageCrafting(6, BlockCrafting.recipeEnderPearlBlock).setNoText(), new PageCrafting(7, BlockCrafting.recipeEnderCase).setNoText(), new PageCrafting(8, ItemCrafting.recipeRing).setNoText(), new PageCrafting(9, ItemCrafting.recipeKnifeHandle).setNoText(), new PageCrafting(10, ItemCrafting.recipeKnifeBlade).setNoText(), new PageCrafting(11, ItemCrafting.recipeKnife).setNoText(), new PageCrafting(12, ItemCrafting.recipeDough).setNoText(), new PageCrafting(13, ItemCrafting.recipeRiceDough).setNoText());
        new BookletChapter("quartz", entryMisc, new ItemStack(InitItems.itemMisc, 1, TheMiscItems.QUARTZ.ordinal()), new PageTextOnly(1).setStack(new ItemStack(InitBlocks.blockMisc, 1, TheMiscBlocks.ORE_QUARTZ.ordinal())).addTextReplacement("<lowest>", ConfigIntValues.BLACK_QUARTZ_MIN_HEIGHT.getValue()).addTextReplacement("<highest>", ConfigIntValues.BLACK_QUARTZ_MAX_HEIGHT.getValue()), new PageTextOnly(2).setStack(new ItemStack(InitItems.itemMisc, 1, TheMiscItems.QUARTZ.ordinal())), new PageCrafting(3, BlockCrafting.recipeQuartzBlock).setNoText(), new PageCrafting(4, BlockCrafting.recipeQuartzPillar).setNoText(), new PageCrafting(5, BlockCrafting.recipeQuartzChiseled).setNoText());
        new BookletChapter("cloud", entryMisc, new ItemStack(InitBlocks.blockSmileyCloud), new PageTextOnly(1), new PageCrafting(2, BlockCrafting.recipeSmileyCloud).setNoText());
        new BookletChapter("coalStuff", entryMisc, new ItemStack(InitItems.itemMisc, 1, TheMiscItems.TINY_COAL.ordinal()), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeTinyCoal).setNoText(), new PageCrafting(3, ItemCrafting.recipeTinyChar).setNoText(), new PageCrafting(4, BlockCrafting.recipeBlockChar).setNoText());
        ArrayList<BookletPage> lampPages = new ArrayList<BookletPage>();
        lampPages.add(new PageTextOnly(lampPages.size()+1));
        lampPages.add(new PageCrafting(lampPages.size()+1, BlockCrafting.recipePowerer).setNoText());
        for(IRecipe recipe : BlockCrafting.recipesLamps){
            lampPages.add(new PageCrafting(lampPages.size()+1, recipe).setNoText());
        }
        new BookletChapter("lamps", entryMisc, new ItemStack(InitBlocks.blockColoredLampOn, 1, TheColoredLampColors.GREEN.ordinal()), lampPages.toArray(new BookletPage[lampPages.size()]));

        new BookletChapter("treasureChest", entryMisc, new ItemStack(InitBlocks.blockTreasureChest), new PageTextOnly(1).setStack(new ItemStack(InitBlocks.blockTreasureChest)));

        //No RF Using Blocks
        new BookletChapter("breaker", entryFunctionalNonRF, new ItemStack(InitBlocks.blockBreaker), new PageCrafting(1, BlockCrafting.recipeBreaker), new PageCrafting(2, BlockCrafting.recipePlacer), new PageCrafting(3, BlockCrafting.recipeLiquidPlacer), new PageCrafting(4, BlockCrafting.recipeLiquidCollector));
        new BookletChapter("phantomfaces", entryFunctionalNonRF, new ItemStack(InitBlocks.blockPhantomLiquiface), new PageTextOnly(1).addTextReplacement("<range>", ConfigIntValues.PHANTOMFACE_RANGE.getValue()), new PageCrafting(2, BlockCrafting.recipePhantomface), new PageCrafting(3, BlockCrafting.recipeLiquiface), new PageCrafting(4, BlockCrafting.recipeEnergyface), new PageCrafting(5, ItemCrafting.recipePhantomConnector).setNoText(), new PageCrafting(6, BlockCrafting.recipePhantomBooster));
        new BookletChapter("phantomBreaker", entryFunctionalNonRF, new ItemStack(InitBlocks.blockPhantomBreaker), new PageTextOnly(1).addTextReplacement("<range>", ConfigIntValues.PHANTOM_PLACER_RANGE.getValue()), new PageCrafting(2, BlockCrafting.recipePhantomPlacer).setNoText(), new PageCrafting(3, BlockCrafting.recipePhantomBreaker).setNoText());
        new BookletChapter("esd", entryFunctionalNonRF, new ItemStack(InitBlocks.blockInputterAdvanced), new PageTextOnly(1), new PageCrafting(2, BlockCrafting.recipeESD).setNoText(), new PageCrafting(3, BlockCrafting.recipeAdvancedESD).setNoText());
        new BookletChapter("xpSolidifier", entryFunctionalNonRF, new ItemStack(InitBlocks.blockXPSolidifier), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemSpecialDrop, 1, TheSpecialDrops.SOLIDIFIED_EXPERIENCE.ordinal())), new PageCrafting(2, BlockCrafting.recipeSolidifier).setNoText());
        new BookletChapter("greenhouseGlass", entryFunctionalNonRF, new ItemStack(InitBlocks.blockGreenhouseGlass), new PageTextOnly(1), new PageCrafting(2, BlockCrafting.recipeGlass).setNoText());
        new BookletChapter("fishingNet", entryFunctionalNonRF, new ItemStack(InitBlocks.blockFishingNet), new PageTextOnly(1), new PageCrafting(2, BlockCrafting.recipeFisher).setNoText());
        new BookletChapter("feeder", entryFunctionalNonRF, new ItemStack(InitBlocks.blockFeeder), new PageTextOnly(1), new PageCrafting(2, BlockCrafting.recipeFeeder).setNoText());
        new BookletChapter("compost", entryFunctionalNonRF, new ItemStack(InitBlocks.blockCompost), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemFertilizer)).addTextReplacement("<num>", ConfigIntValues.COMPOST_AMOUNT.getValue()), new PageCrafting(2, BlockCrafting.recipeCompost).setNoText(), new PageCrafting(3, ItemCrafting.recipeMashedFood));
        new BookletChapter("crate", entryFunctionalNonRF, new ItemStack(InitBlocks.blockGiantChest), new PageCrafting(1, BlockCrafting.recipeCrate));

        //RF Using Blocks
        new BookletChapterCoffee("coffeeMachine", entryFunctionalRF, new ItemStack(InitBlocks.blockCoffeeMachine), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemCoffeeBean)).addTextReplacement("<rf>", ConfigIntValues.COFFEE_MACHINE_ENERGY_USED.getValue()).addTextReplacement("<coffee>", ConfigIntValues.COFFEE_CACHE_USED_PER_ITEM.getValue()).addTextReplacement("<water>", ConfigIntValues.COFFEE_MACHINE_WATER_USED.getValue()), new PageTextOnly(2).setStack(new ItemStack(InitItems.itemCoffee)), new PageCrafting(3, BlockCrafting.recipeCoffeeMachine).setNoText(), new PageCrafting(4, ItemCrafting.recipeCup).setNoText());
        new BookletChapter("crusher", entryFunctionalRF, new ItemStack(InitBlocks.blockGrinderDouble), new PageTextOnly(1).addTextReplacement("<rf1>", ConfigIntValues.GRINDER_ENERGY_USED.getValue()).addTextReplacement("<rf2>", ConfigIntValues.GRINDER_DOUBLE_ENERGY_USED.getValue()), new PageCrafting(2, BlockCrafting.recipeCrusher).setNoText(), new PageCrafting(3, BlockCrafting.recipeDoubleCrusher).setNoText());
        new BookletChapter("furnaceDouble", entryFunctionalRF, new ItemStack(InitBlocks.blockFurnaceDouble), new PageCrafting(1, BlockCrafting.recipeFurnace).addTextReplacement("<rf>", ConfigIntValues.FURNACE_ENERGY_USED.getValue()));
        new BookletChapter("miner", entryFunctionalRF, new ItemStack(InitBlocks.blockOreMagnet), new PageTextOnly(1).addTextReplacement("<rf>", ConfigIntValues.ORE_MAGNET_ENERGY_USE.getValue()).addTextReplacement("<oil>", ConfigIntValues.ORE_MAGNET_OIL_USE.getValue()).addTextReplacement("<range>", ConfigIntValues.ORE_MAGNET_RANGE.getValue()), new PageCrafting(2, BlockCrafting.recipeMiner).setNoText(), new PageCrafting(3, BlockCrafting.recipeCasing).setNoText());
        new BookletChapter("lavaFactory", entryFunctionalRF, new ItemStack(InitBlocks.blockLavaFactoryController), new PageTextOnly(1).addTextReplacement("<rf>", ConfigIntValues.LAVA_FACTORY_ENERGY_USED.getValue()), new PageCrafting(2, BlockCrafting.recipeLavaFactory).setNoText());
        new BookletChapter("energizer", entryFunctionalRF, new ItemStack(InitBlocks.blockEnergizer), new PageCrafting(1, BlockCrafting.recipeEnergizer), new PageCrafting(2, BlockCrafting.recipeEnervator));
        new BookletChapter("repairer", entryFunctionalRF, new ItemStack(InitBlocks.blockItemRepairer), new PageCrafting(1, BlockCrafting.recipeRepairer).addTextReplacement("<rf>", ConfigIntValues.REPAIRER_ENERGY_USED.getValue()));

        //RF Generating Blocks
        new BookletChapter("coalGen", entryGeneratingRF, new ItemStack(InitBlocks.blockCoalGenerator), new PageCrafting(1, BlockCrafting.recipeCoalGen).addTextReplacement("<rf>", ConfigIntValues.COAL_GEN_ENERGY_PRODUCED.getValue()));
        new BookletChapter("solarPanel", entryGeneratingRF, new ItemStack(InitBlocks.blockFurnaceSolar), new PageTextOnly(1).addTextReplacement("<rf>", ConfigIntValues.FURNACE_SOLAR_ENERGY_PRODUCED.getValue()), new PageCrafting(2, BlockCrafting.recipeSolar).setNoText());
        new BookletChapter("heatCollector", entryGeneratingRF, new ItemStack(InitBlocks.blockHeatCollector), new PageTextOnly(1).addTextReplacement("<rf>", ConfigIntValues.HEAT_COLLECTOR_ENERGY_PRODUCED.getValue()).addTextReplacement("<min>", ConfigIntValues.HEAT_COLLECTOR_BLOCKS.getValue()), new PageCrafting(2, BlockCrafting.recipeHeatCollector).setNoText());
        new BookletChapter("canola", entryGeneratingRF, new ItemStack(InitBlocks.blockFermentingBarrel), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemMisc, 1, TheMiscItems.CANOLA.ordinal())).addTextReplacement("<pressRF>", ConfigIntValues.PRESS_ENERGY_USED.getValue()).addTextReplacement("<canola>", ConfigIntValues.PRESS_MB_PRODUCED.getValue()).addTextReplacement("<rf>", ConfigIntValues.OIL_GEN_ENERGY_PRODUCED.getValue()), new PageCrafting(2, BlockCrafting.recipeCanolaPress).setNoText(), new PageCrafting(3, BlockCrafting.recipeFermentingBarrel).setNoText(), new PageCrafting(4, BlockCrafting.recipeOilGen).setNoText());

        //No RF Using Items
        new BookletChapter("wings", entryItemsNonRF, new ItemStack(InitItems.itemWingsOfTheBats), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemMisc, 1, TheMiscItems.BAT_WING.ordinal())), new PageCrafting(2, ItemCrafting.recipeWings).setNoText());
        new BookletChapter("foods", entryItemsNonRF, new ItemStack(InitItems.itemFoods, 1, TheFoods.HAMBURGER.ordinal()), new PageCrafting(1, FoodCrafting.recipePizza).setNoText(), new PageFurnace(2, new ItemStack(InitItems.itemFoods, 1, TheFoods.RICE_BREAD.ordinal())).setNoText(), new PageCrafting(3, FoodCrafting.recipeHamburger).setNoText(), new PageCrafting(4, FoodCrafting.recipeBigCookie).setNoText(), new PageCrafting(5, FoodCrafting.recipeSubSandwich).setNoText(), new PageCrafting(6, FoodCrafting.recipeFrenchFry).setNoText(), new PageCrafting(7, FoodCrafting.recipeFrenchFries).setNoText(), new PageCrafting(8, FoodCrafting.recipeFishNChips).setNoText(), new PageCrafting(9, FoodCrafting.recipeCheese).setNoText(), new PageCrafting(10, FoodCrafting.recipePumpkinStew).setNoText(), new PageCrafting(11, FoodCrafting.recipeCarrotJuice).setNoText(), new PageCrafting(12, FoodCrafting.recipeSpaghetti).setNoText(), new PageCrafting(13, FoodCrafting.recipeNoodle).setNoText(), new PageCrafting(14, FoodCrafting.recipeChocolate).setNoText(), new PageCrafting(15, FoodCrafting.recipeChocolateCake).setNoText(), new PageCrafting(16, FoodCrafting.recipeToast).setNoText(), new PageFurnace(17, new ItemStack(InitItems.itemFoods, 1, TheFoods.BAGUETTE.ordinal())).setNoText());
        new BookletChapter("leafBlower", entryItemsNonRF, new ItemStack(InitItems.itemLeafBlowerAdvanced), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeLeafBlower).setNoText(), new PageCrafting(3, ItemCrafting.recipeLeafBlowerAdvanced).setNoText());
        ArrayList<BookletPage> aiotPages = new ArrayList<BookletPage>();
        aiotPages.add(new PageTextOnly(aiotPages.size()+1));
        for(IRecipe recipe : ToolCrafting.recipesPaxels){
            aiotPages.add(new PageCrafting(aiotPages.size()+1, recipe).setNoText());
        }
        new BookletChapter("aiots", entryItemsNonRF, new ItemStack(InitItems.emeraldPaxel), aiotPages.toArray(new BookletPage[aiotPages.size()]));

        new BookletChapter("jams", entryItemsNonRF, new ItemStack(InitItems.itemJams), new PageTextOnly(1).setStack(new ItemStack(InitItems.itemJams, 1, Util.WILDCARD)));

        ArrayList<BookletPage> potionRingPages = new ArrayList<BookletPage>();
        potionRingPages.add(new PageTextOnly(potionRingPages.size()+1));
        for(IRecipe recipe : ItemCrafting.recipesPotionRings){
            potionRingPages.add(new PageCrafting(potionRingPages.size()+1, recipe).setNoText());
        }
        new BookletChapter("potionRings", entryItemsNonRF, new ItemStack(InitItems.itemPotionRing), potionRingPages.toArray(new BookletPage[potionRingPages.size()]));

        //RF Using Items
        new BookletChapter("drill", entryItemsRF, new ItemStack(InitItems.itemDrill), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeDrill).setNoText(), new PageCrafting(3, ItemCrafting.recipeDrillSpeedI).setNoText(), new PageCrafting(4, ItemCrafting.recipeDrillSpeedII).setNoText(), new PageCrafting(5, ItemCrafting.recipeDrillSpeedIII).setNoText(), new PageCrafting(6, ItemCrafting.recipeDrillFortuneI).setNoText(), new PageCrafting(7, ItemCrafting.recipeDrillFortuneII).setNoText(), new PageCrafting(8, ItemCrafting.recipeDrillSilk).setNoText(), new PageCrafting(9, ItemCrafting.recipeDrillThree).setNoText(), new PageCrafting(10, ItemCrafting.recipeDrillFive).setNoText(), new PageCrafting(11, ItemCrafting.recipeDrillPlacing).setNoText());
        new BookletChapter("staff", entryItemsRF, new ItemStack(InitItems.itemTeleStaff), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeStaff).setNoText());
        new BookletChapter("magnetRing", entryItemsRF, new ItemStack(InitItems.itemMagnetRing), new PageCrafting(1, ItemCrafting.recipeMagnetRing));
        new BookletChapter("growthRing", entryItemsRF, new ItemStack(InitItems.itemGrowthRing), new PageCrafting(1, ItemCrafting.recipeGrowthRing));
        new BookletChapter("waterRemovalRing", entryItemsRF, new ItemStack(InitItems.itemWaterRemovalRing), new PageCrafting(1, ItemCrafting.recipeWaterRing));
        new BookletChapter("batteries", entryItemsRF, new ItemStack(InitItems.itemBatteryTriple), new PageTextOnly(1), new PageCrafting(2, ItemCrafting.recipeBattery).setNoText(), new PageCrafting(3, ItemCrafting.recipeBatteryDouble).setNoText(), new PageCrafting(4, ItemCrafting.recipeBatteryTriple).setNoText(), new PageCrafting(5, ItemCrafting.recipeBatteryQuadruple).setNoText(), new PageCrafting(6, ItemCrafting.recipeBatteryQuintuple).setNoText());
    }
}