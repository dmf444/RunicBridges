package dmf444.RunicBridges.Core.init;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.RunicBridges.Core.items.Rune;
import dmf444.RunicBridges.Core.items.RuneEssence;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmf444 on 10/4/2015.
 */
public class ItemLoader  {
    private static boolean IRegister=false;

    public static Item rune;
    public static Item runeEssence;

    public static Map<String, Item> RunicItems = new HashMap<>();

    public static void initiateItems() {
        rune = new Rune();
        runeEssence = new RuneEssence();




        registerItems();
    }


    private static void registerItems() {
        if(!IRegister){
            for (Field item : ItemLoader.class.getFields()){
                if (item.getType() == Item.class){
                    if (Modifier.isStatic(item.getModifiers())){
                        Object toRegister;
                        try {
                            toRegister = item.get(null);
                        } catch (IllegalArgumentException | IllegalAccessException e) {
                            e.printStackTrace();
                            continue;
                        }
                        if (toRegister instanceof Item){
                            if (toRegister != null){
                                GameRegistry.registerItem((Item) toRegister, item.getName());
                            }
                        }
                    }

                }
            }

            for (String meat : RunicItems.keySet()) {
                GameRegistry.registerItem(RunicItems.get(meat), meat);
            }





        }
        IRegister=true;
    }
}