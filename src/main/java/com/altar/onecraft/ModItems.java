package com.altar.onecraft;

import com.altar.GomuGomuItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{

    //Create Item registerer
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "onecraft");

    //Register custom items
    public static final RegistryObject<Item> GOMU_GOMU = ITEMS.register("gomu_gomu", GomuGomuItem::new);



}
