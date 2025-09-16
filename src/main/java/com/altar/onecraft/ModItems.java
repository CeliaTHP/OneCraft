package com.altar.onecraft;

import com.altar.onecraft.fruits.*;
import com.altar.onecraft.fruits.GomuGomuFruit;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{

    //Create Item registerer
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "onecraft");

    //Register custom items
    public static final RegistryObject<Item> GOMU_GOMU = ITEMS.register("gomu_gomu", GomuGomuFruit::new);

    public static final RegistryObject<Item> BOMU_BOMU = ITEMS.register("bomu_bomu", BomuBomuFruit::new);
    public static final RegistryObject<Item> GORO_GORO = ITEMS.register("goro_goro", GoroGoroFruit::new);
    public static final RegistryObject<Item> GURA_GURA = ITEMS.register("gura_gura", GuraGuraFruit::new);
    public static final RegistryObject<Item> HIE_HIE = ITEMS.register("hie_hie", HieHieFruit::new);
    public static final RegistryObject<Item> HITO_HITO = ITEMS.register("hito_hito", HitoHitoFruit::new);
    public static final RegistryObject<Item> HORO_HORO = ITEMS.register("horo_horo", HoroHoroFruit::new);
    public static final RegistryObject<Item> ITO_ITO = ITEMS.register("ito_ito", ItoItoFruit::new);
    public static final RegistryObject<Item> JIKI_JIKI = ITEMS.register("jiki_jiki", JikiJikiFruit::new);
    public static final RegistryObject<Item> KAGE_KAGE = ITEMS.register("kage_kage", KageKageFruit::new);
    public static final RegistryObject<Item> KILO_KILO = ITEMS.register("kilo_kilo", KiloKiloFruit::new);
    public static final RegistryObject<Item> MAGU_MAGU = ITEMS.register("magu_magu", MaguMaguFruit::new);
    public static final RegistryObject<Item> MERA_MERA = ITEMS.register("mera_mera", MeraMeraFruit::new);
    public static final RegistryObject<Item> MOKU_MOKU = ITEMS.register("moku_moku", MokuMokuFruit::new);
    public static final RegistryObject<Item> NEKO_NEKO = ITEMS.register("neko_neko", NekoNekoFruit::new);
    public static final RegistryObject<Item> NIKYU_NIKYU = ITEMS.register("nikyu_nikyu", NikyuNikyuFruit::new);
    public static final RegistryObject<Item> OPE_OPE = ITEMS.register("ope_ope", OpeOpeFruit::new);
    public static final RegistryObject<Item> PIKA_PIKA = ITEMS.register("pika_pika", PikaPikaFruit::new);
    public static final RegistryObject<Item> RYU_RYU = ITEMS.register("ryu_ryu", RyuRyuFruit::new);
    public static final RegistryObject<Item> SUKE_SUKE = ITEMS.register("suke_suke", SukeSukeFruit::new);
    public static final RegistryObject<Item> TORI_TORI = ITEMS.register("tori_tori", ToriToriFruit::new);
    public static final RegistryObject<Item> YAMI_YAMI = ITEMS.register("yami_yami", YamiYamiFruit::new);
    public static final RegistryObject<Item> ZUSHI_ZUSHI = ITEMS.register("zushi_zushi", ZushiZushiFruit::new);


}
