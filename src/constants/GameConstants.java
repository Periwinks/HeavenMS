package constants;

import client.MapleDisease;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import client.MapleJob;
import constants.skills.Aran;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import server.maps.MapleMap;
import server.maps.FieldLimit;
import server.quest.MapleQuest;

/*
 * @author kevintjuh93
 * @author Ronan
 */
public class GameConstants {
    public static String[] WORLD_NAMES = {"Scania", "Bera", "Broa", "Windia", "Khaini", "Bellocan", "Mardia", "Kradia", "Yellonde", "Demethos", "Galicia", "El Nido", "Zenith", "Arcenia", "Kastia", "Judis", "Plana", "Kalluna", "Stius", "Croa", "Medere"};
    public static final int[]  OWL_DATA = new int[]{1082002, 2070005, 2070006, 1022047, 1102041, 2044705, 2340000, 2040017, 1092030, 2040804};
    public static final String[] stats = {"tuc", "reqLevel", "reqJob", "reqSTR", "reqDEX", "reqINT", "reqLUK", "reqPOP", "cash", "cursed", "success", "setItemID", "equipTradeBlock", "durability", "randOption", "randStat", "masterLevel", "reqSkillLevel", "elemDefault", "incRMAS", "incRMAF", "incRMAI", "incRMAL", "canLevel", "skill", "charmEXP"};
    public static final int[] CASH_DATA = new int[]{50200004, 50200069, 50200117, 50100008, 50000047};
    
    // Ronan's rates upgrade system
    private static final int[] DROP_RATE_GAIN = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private static final int[] MESO_RATE_GAIN = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105};
    private static final int[]  EXP_RATE_GAIN = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};    //fibonacci :3
    
    private static final int[] jobUpgradeBlob = {1, 20, 60, 110, 190};
    private static final int[] jobUpgradeSpUp = {0, 1, 2, 3, 6};
    private final static Map<Integer, String> jobNames = new HashMap<>();
    private final static NumberFormat nfFormatter = new DecimalFormat("#,###,###,###");
    private final static NumberFormat nfParser = NumberFormat.getInstance(ServerConstants.USE_UNITPRICE_WITH_COMMA ? Locale.FRANCE : Locale.UK);
    
    public static final MapleDisease[] CPQ_DISEASES = {MapleDisease.SLOW, MapleDisease.SEDUCE, MapleDisease.STUN, MapleDisease.POISON,
                                                       MapleDisease.SEAL, MapleDisease.DARKNESS, MapleDisease.WEAKEN, MapleDisease.CURSE};
    
    public static int getPlayerBonusDropRate(int slot) {
        return(DROP_RATE_GAIN[slot]);
    }
    
    public static int getPlayerBonusMesoRate(int slot) {
        return(MESO_RATE_GAIN[slot]);
    }
    
    public static int getPlayerBonusExpRate(int slot) {
        return(EXP_RATE_GAIN[slot]);
    }
    
    // used by the "goto" command for players
    public static final HashMap<String, Integer> GOTO_TOWNS = new HashMap<String, Integer>() {{
        put("southperry", 60000);
        put("amherst", 1000000);
        put("henesys", 100000000);
        put("ellinia", 101000000);
        put("perion", 102000000);
        put("kerning", 103000000);
        put("lith", 104000000);
        put("sleepywood", 105040300);
        put("florina", 110000000);
        put("nautilus", 120000000);
        put("ereve", 130000000);
        put("rien", 140000000);
        put("orbis", 200000000);
        put("happy", 209000000);
        put("elnath", 211000000);
        put("ludi", 220000000);
        put("aqua", 230000000);
        put("leafre", 240000000);
        put("mulung", 250000000);
        put("herb", 251000000);
        put("omega", 221000000);
        put("korean", 222000000);
        put("ellin", 300000000);
        put("nlc", 600000000);
        put("showa", 801000000);
        put("shrine", 800000000);
        put("ariant", 260000000);
        put("magatia", 261000000);
        put("singapore", 540000000);
        put("quay", 541000000);
        put("kampung", 551000000);
        put("amoria", 680000000);
        put("temple", 270000100);
        put("square", 103040000);
        put("neo", 240070000);
        put("mushking", 106020000);
    }};
    
    // used by the "goto" command for only-GMs
    public static final HashMap<String, Integer> GOTO_AREAS = new HashMap<String, Integer>() {{
        put("gmmap", 180000000);
        put("excavation", 990000000);
        put("mushmom", 100000005);
        put("griffey", 240020101);
        put("manon", 240020401);
        put("horseman", 682000001);
        put("balrog", 105090900);
        put("zakum", 211042300);
        put("papu", 220080001);
        put("guild", 200000301);
        put("skelegon", 240040511);
        put("hpq", 100000200);
        put("pianus", 230040420);
        put("horntail", 240050400);
        put("pinkbean", 270050000);
        put("keep", 610020006);
        put("dojo", 925020001);
        put("bosspq", 970030000);
        put("fm", 910000000);
    }};
    
    public static final List<String> GAME_SONGS = new ArrayList<String>(455) {{
        add("Jukebox/Congratulation");
        add("Bgm00/SleepyWood");
        add("Bgm00/FloralLife");
        add("Bgm00/GoPicnic");
        add("Bgm00/Nightmare");
        add("Bgm00/RestNPeace");
        add("Bgm01/AncientMove");
        add("Bgm01/MoonlightShadow");
        add("Bgm01/WhereTheBarlogFrom");
        add("Bgm01/CavaBien");
        add("Bgm01/HighlandStar");
        add("Bgm01/BadGuys");
        add("Bgm02/MissingYou");
        add("Bgm02/WhenTheMorningComes");
        add("Bgm02/EvilEyes");
        add("Bgm02/JungleBook");
        add("Bgm02/AboveTheTreetops");
        add("Bgm03/Subway");
        add("Bgm03/Elfwood");
        add("Bgm03/BlueSky");
        add("Bgm03/Beachway");
        add("Bgm03/SnowyVillage");
        add("Bgm04/PlayWithMe");
        add("Bgm04/WhiteChristmas");
        add("Bgm04/UponTheSky");
        add("Bgm04/ArabPirate");
        add("Bgm04/Shinin'Harbor");
        add("Bgm04/WarmRegard");
        add("Bgm05/WolfWood");
        add("Bgm05/DownToTheCave");
        add("Bgm05/AbandonedMine");
        add("Bgm05/MineQuest");
        add("Bgm05/HellGate");
        add("Bgm06/FinalFight");
        add("Bgm06/WelcomeToTheHell");
        add("Bgm06/ComeWithMe");
        add("Bgm06/FlyingInABlueDream");
        add("Bgm06/FantasticThinking");
        add("Bgm07/WaltzForWork");
        add("Bgm07/WhereverYouAre");
        add("Bgm07/FunnyTimeMaker");
        add("Bgm07/HighEnough");
        add("Bgm07/Fantasia");
        add("Bgm08/LetsMarch");
        add("Bgm08/ForTheGlory");
        add("Bgm08/FindingForest");
        add("Bgm08/LetsHuntAliens");
        add("Bgm08/PlotOfPixie");
        add("Bgm09/DarkShadow");
        add("Bgm09/TheyMenacingYou");
        add("Bgm09/FairyTale");
        add("Bgm09/FairyTalediffvers");
        add("Bgm09/TimeAttack");
        add("Bgm10/Timeless");
        add("Bgm10/TimelessB");
        add("Bgm10/BizarreTales");
        add("Bgm10/TheWayGrotesque");
        add("Bgm10/Eregos");
        add("Bgm11/BlueWorld");
        add("Bgm11/Aquarium");
        add("Bgm11/ShiningSea");
        add("Bgm11/DownTown");
        add("Bgm11/DarkMountain");
        add("Bgm12/AquaCave");
        add("Bgm12/DeepSee");
        add("Bgm12/WaterWay");
        add("Bgm12/AcientRemain");
        add("Bgm12/RuinCastle");
        add("Bgm12/Dispute");
        add("Bgm13/CokeTown");
        add("Bgm13/Leafre");
        add("Bgm13/Minar'sDream");
        add("Bgm13/AcientForest");
        add("Bgm13/TowerOfGoddess");
        add("Bgm14/DragonLoad");
        add("Bgm14/HonTale");
        add("Bgm14/CaveOfHontale");
        add("Bgm14/DragonNest");
        add("Bgm14/Ariant");
        add("Bgm14/HotDesert");
        add("Bgm15/MureungHill");
        add("Bgm15/MureungForest");
        add("Bgm15/WhiteHerb");
        add("Bgm15/Pirate");
        add("Bgm15/SunsetDesert");
        add("Bgm16/Duskofgod");
        add("Bgm16/FightingPinkBeen");
        add("Bgm16/Forgetfulness");
        add("Bgm16/Remembrance");
        add("Bgm16/Repentance");
        add("Bgm16/TimeTemple");
        add("Bgm17/MureungSchool1");
        add("Bgm17/MureungSchool2");
        add("Bgm17/MureungSchool3");
        add("Bgm17/MureungSchool4");
        add("Bgm18/BlackWing");
        add("Bgm18/DrillHall");
        add("Bgm18/QueensGarden");
        add("Bgm18/RaindropFlower");
        add("Bgm18/WolfAndSheep");
        add("Bgm19/BambooGym");
        add("Bgm19/CrystalCave");
        add("Bgm19/MushCatle");
        add("Bgm19/RienVillage");
        add("Bgm19/SnowDrop");
        add("Bgm20/GhostShip");
        add("Bgm20/NetsPiramid");
        add("Bgm20/UnderSubway");
        add("Bgm21/2021year");
        add("Bgm21/2099year");
        add("Bgm21/2215year");
        add("Bgm21/2230year");
        add("Bgm21/2503year");
        add("Bgm21/KerningSquare");
        add("Bgm21/KerningSquareField");
        add("Bgm21/KerningSquareSubway");
        add("Bgm21/TeraForest");
        add("Bgm22/DecisiveBattle");
        add("Bgm22/DespairOnDevl");
        add("Bgm22/EdelsteinCity");
        add("Bgm22/GelimerLab");
        add("Bgm22/LowGradeOre");
        add("Bgm22/NationalPark");
        add("Bgm22/PowerStation");
        add("Bgm22/UndergroundPlace");
        add("Bgm23/BlizzardCastle");
        add("Bgm23/CastleBoss");
        add("Bgm23/CastleInside");
        add("Bgm23/CastleOutside");
        add("Bgm23/CrimsonTower");
        add("Bgm23/LionHeart");
        add("Bgm23/MPBonusMap");
        add("Bgm24/battleBGMTypeA");
        add("Bgm24/battleBGMTypeB");
        add("Bgm24/battleBGMTypeC");
        add("Bgm24/battleBGMTypeD");
        add("Bgm24/battleEntrace");
        add("Bgm24/KreaseAgit");
        add("Bgm24/KreaseColosseum");
        add("Bgm24/KreaseField");
        add("Bgm24/monsterPark");
        add("Bgm25/AltarOfAkayrum");
        add("Bgm25/CrackOfDimension");
        add("Bgm25/CygnusGarden");
        add("Bgm25/destructionPerion");
        add("Bgm25/destructionPerionShelter");
        add("Bgm25/destructionTown");
        add("Bgm25/FlowerInBlue");
        add("Bgm25/knightsStronghold");
        add("Bgm25/profession");
        add("Bgm25/SoundOfElf");
        add("Bgm25/timeGate");
        add("Bgm25/WindAndFlower");
        add("Bgm26/BurningWoods");
        add("Bgm26/DarkMage");
        add("Bgm26/DarkWoods");
        add("Bgm26/FinalFight");
        add("Bgm26/Flood");
        add("Bgm26/PeacefulWoods");
        add("Bgm26/Serenity");
        add("Bgm26/SpeakInTheVoid");
        add("Bgm27/AngelsRoom");
        add("Bgm27/BaseOfBetrayers");
        add("Bgm27/BorderArea");
        add("Bgm27/GreatTemple");
        add("Bgm27/NovaSanctum");
        add("Bgm27/Pantheon");
        add("Bgm27/PantheonField");
        add("Bgm27/StepOfKaiser");
        add("Bgm27/TrappedKaiser");
        add("Bgm28/citadelofTyrant");
        add("Bgm28/funkyBlackmarket");
        add("Bgm28/helisiumField");
        add("Bgm28/helisiumMysticforest");
        add("Bgm28/helisiumWarcry");
        add("Bgm28/retake");
        add("Bgm28/thefinalWar");
        add("Bgm28/trinityForce");
        add("Bgm29/AbyssCave");
        add("Bgm29/banbantime");
        add("Bgm29/JoyfulTeaParty");
        add("Bgm29/QueenPalace");
        add("Bgm29/TimeChaos");
        add("Bgm29/YggdrasilPrayer");
        add("Bgm30/5thSpotLightFlyAway");
        add("Bgm30/fromUnderToUpper");
        add("Bgm30/inAllVerity");
        add("Bgm30/pulseResonance");
        add("Bgm30/thePhoto");
        add("Bgm30/underside");
        add("Bgm31/fadedCitadel");
        add("Bgm31/itsmonstersLife");
        add("Bgm31/itsmonstersLife2");
        add("Bgm31/journey");
        add("Bgm31/scholarsLibrary");
        add("Bgm31/specialtyStore");
        add("Bgm31/specialtyStoreRemix");
        add("Bgm32/TheColossalHeart");
        add("Bgm32/TheLivingMountain");
        add("Bgm32/TheRaiders");
        add("Bgm32/TheRush");
        add("Bgm33/AriantInMirror");
        add("Bgm33/BeBornZero");
        add("Bgm33/DisputeInMirror");
        add("Bgm33/EdelsteinCityInMirror");
        add("Bgm33/FantasticThinkingInMirror");
        add("Bgm33/FloralLifeInMirror");
        add("Bgm33/LeafreInMirror");
        add("Bgm33/MureungHillInMirror");
        add("Bgm33/NastyLiar");
        add("Bgm33/RedRoom");
        add("Bgm33/ShadowKnight");
        add("Bgm33/ShadowTemple");
        add("Bgm33/SmileZero");
        add("Bgm33/TimeTempleInMirror");
        add("Bgm34/AgainstTheDark");
        add("Bgm34/DimensionLibrary");
        add("Bgm34/GlacierAdventure");
        add("Bgm34/GoFight!ShowYourEnergy!");
        add("Bgm34/MapleLeaf");
        add("Bgm34/MoleKingRises");
        add("Bgm34/Sailing");
        add("Bgm34/TheAurora");
        add("Bgm34/TheFairyAcademy");
        add("Bgm34/TheFairyForest");
        add("Bgm34/TheStormyForest");
        add("Bgm34/WoundedLeaf");
        add("Bgm35/Hekaton");
        add("Bgm35/InRuinInVain");
        add("Bgm35/StopInEnds");
        add("Bgm35/StopInHundreds");
        add("Bgm35/TragicForest");
        add("Bgm35/TragicRestart");
        add("Bgm36/decision");
        add("Bgm36/Dominion");
        add("Bgm36/foxvillage");
        add("Bgm36/HappyTimeLong");
        add("Bgm36/HappyTimeShort");
        add("Bgm36/RoyalGuard");
        add("Bgm36/sadfoxvillage");
        add("Bgm37/AmusingStoryInTheFairyTale");
        add("Bgm37/HazardFromCave");
        add("Bgm37/JungleInTheSea");
        add("Bgm37/StrangeSortOfStory");
        add("Bgm37/TheBottomOfTheSea");
        add("Bgm37/VentureIntoTheUnknown");
        add("Bgm38/battlefield");
        add("Bgm38/FlowerVioleta");
        add("Bgm38/HollowAttack");
        add("Bgm38/LifeIsComedy");
        add("Bgm38/MushroomCastle");
        add("Bgm38/SchoolLife");
        add("Bgm38/UrbanStreet");
        add("Bgm38/VikingShip");
        add("Bgm38/VikingSkipper");
        add("Bgm38/WarMushCastle");
        add("Bgm39/InvitavionStarplanet");
        add("Bgm39/masterOfKeyBoard");
        add("Bgm39/StarPlanetGameField");
        add("Bgm39/StarPlanetMainEvent");
        add("Bgm39/StarPlanetWaitField");
        add("Bgm39/StarPlanetWorldEvent");
        add("Bgm39/TodaysFortune");
        add("Bgm39/VirtualArena");
        add("Bgm39/YUTYUTYUT");
        add("Bgm40/BattleOnTheDeck");
        add("Bgm40/BlackHeavenTheme");
        add("Bgm40/BlackHeavenTheme_parade");
        add("Bgm40/HeroComes");
        add("Bgm40/JunkYard");
        add("Bgm40/RabbitsDream");
        add("Bgm40/SecretMission");
        add("Bgm40/SecretMissionBase");
        add("Bgm40/TheDollMaster");
        add("Bgm41/BigMachine");
        add("Bgm41/BigMachine_mission");
        add("Bgm41/Gravity Core");
        add("Bgm41/Gravity Lord");
        add("Bgm41/Gravity Lord Rise");
        add("Bgm41/Haven Theme");
        add("Bgm41/HeavenAgain");
        add("Bgm41/HeavenAgain_reprise");
        add("Bgm41/PromiseOfHeaven");
        add("Bgm41/PromiseOfHeaven_vocaless");
        add("Bgm42/Catch Your Dreams! full");
        add("Bgm42/Catch Your Dreams! intro");
        add("Bgm42/Catch Your Dreams! play");
        add("Bgm42/Catch Your Dreams! vocaless");
        add("Bgm42/Demon's eye");
        add("Bgm42/Demon's eye2");
        add("Bgm42/TheBeast");
        add("Bgm42/TheBeast2");
        add("Bgm43/Dancing With Ghosts");
        add("Bgm43/Kinesis Theme I");
        add("Bgm43/Kinesis Theme II");
        add("Bgm43/Kinesis Theme Skill");
        add("Bgm43/monsterWorld");
        add("Bgm43/Skyscraper");
        add("Bgm43/This too shall pass away");
        add("Bgm43/TresureGameMulti");
        add("Bgm43/TresureGameSingle");
        add("Bgm43/Unexpected crisis");
        add("Bgm43/Unknown Part Of City");
        add("Bgm43/Welcome To The Creepy Ghost Park");
        add("Bgm44/Desperately");
        add("Bgm44/DragonTigerDungeon");
        add("Bgm44/DragonTigerField");
        add("Bgm44/Hieijan_KR");
        add("Bgm44/Hieijan_nohime_KR");
        add("Bgm44/InsideHonnouji_KR");
        add("Bgm44/Kecon_KR");
        add("Bgm44/Momijigaoka_KR");
        add("Bgm44/MomijiNoSakamichi_KR");
        add("Bgm44/SheSellsALuckyThing");
        add("Bgm44/TheKingOfDestruction");
        add("Bgm44/TheSilentWar");
        add("Bgm44/WildFury");
        add("Bgm45/Anthem For Heroes");
        add("Bgm45/Army Of Fears Theme");
        add("Bgm45/Climbing Up The WorldTree");
        add("Bgm45/Demian");
        add("Bgm45/Demian Spine");
        add("Bgm45/Demian True");
        add("Bgm45/Endless Journey");
        add("Bgm45/God Of Control - Lobby");
        add("Bgm45/God Of Control - Stage");
        add("Bgm45/Heroes Of Maple Theme");
        add("Bgm45/Heroes Of Maple Theme Piano");
        add("Bgm45/Jazz For Dr Lim");
        add("Bgm45/Pain And Sorrow");
        add("Bgm45/Pain To Hope");
        add("Bgm45/Showtime!");
        add("Bgm45/The Devil Is Coming");
        add("Bgm45/Through The Blizzard");
        add("Bgm45/Time Is Gold");
        add("Bgm45/Timeless Beholder");
        add("Bgm45/Travelers");
        add("Bgm46/BrokenDream");
        add("Bgm46/Cave Of Rest");
        add("Bgm46/ChewChew MainTheme");
        add("Bgm46/ChewChew WildWorld");
        add("Bgm46/ClockTowerofNightmare");
        add("Bgm46/LachelntheIllusionCity");
        add("Bgm46/Lake Of Oblivion");
        add("Bgm46/Volcanic Zone Of Extinction");
        add("Bgm46/WierldForestIntheGirlsdream");
        add("Bgm47/ArcanaBoss");
        add("Bgm47/Asylum");
        add("Bgm47/AsylumAmbience");
        add("Bgm47/AsylumAmbiencePiano");
        add("Bgm47/AsylumPiano");
        add("Bgm47/CrystalAcademia");
        add("Bgm47/DancesWithAliens");
        add("Bgm47/DeathOfAsylum");
        add("Bgm47/DeathOfAsylumChoir");
        add("Bgm47/DeathOfAsylumChoirExtended");
        add("Bgm47/GoGoRangers!");
        add("Bgm47/HuntingGround");
        add("Bgm47/IlliumRebirth");
        add("Bgm47/MrHazard");
        add("Bgm47/SavageTerminal");
        add("Bgm47/TheTuneOfAzureLight");
        add("Bgm47/TheTuneOfAzureLight2");
        add("Bgm47/VacuumCleaner");
        add("Bgm48/BlackDungeon");
        add("Bgm48/Doomsday_FULL");
        add("Bgm48/Doomsday_LOOP");
        add("Bgm48/EveningPrimrose");
        add("Bgm48/ForgottenNames");
        add("Bgm48/gloryWing");
        add("Bgm48/EveningPrimrose");
        add("Bgm48/ForgottenNames");
        add("Bgm48/gloryWing");
        add("Bgm48/Memory");
        add("Bgm48/MemoryOfKritias");
        add("Bgm48/noname");
        add("Bgm48/Nowhere");
        add("Bgm48/Outpost");
        add("Bgm48/OverTheClouds");
        add("Bgm48/OverTheClouds_RhythmicVer");
        add("Bgm48/SwampOfMemoryMoras");
        add("Bgm48/Title");
        add("Bgm48/VerdelDungeon");
        add("Bgm48/VerdelField");
        add("Bgm48/VerdelTown");
        add("Bgm48/WayBackHome");
        add("Bgm49/BloodCage");
        add("Bgm49/ConteminatedSea");
        add("Bgm49/DepthOfPain");
        add("Bgm49/Diffraction");
        add("Bgm49/EternalSwamp");
        add("Bgm49/FerociousBattlefield");
        add("Bgm49/FerociousBattlefield_loop");
        add("Bgm49/FerociousBattlefield_RiserEdit");
        add("Bgm49/FerociousBattlefield_ShortEdit");
        add("Bgm49/HeartofSuffering");
        add("Bgm49/MirrorCage");
        add("Bgm49/SecretLabyrinth");
        add("Bgm49/SoupOfLife");
        add("Bgm49/StrangeFog");
        add("Bgm49/TempleInTheMirror");
        add("Bgm49/WarCloud");
        add("Bgm49/WaveofEmptiness");
        add("Bgm50/BlackFury");
        add("Bgm50/LostSpace");
        add("Bgm50/NewBeginningNotTheEnd");
        add("Bgm50/SubterminalPoint");
        add("Bgm50/TearsOfTheWorld");
        add("Bgm50/TempleOfDarkness");
        add("Bgm50/TheWorld'sEnd");
        add("Bgm50/ThroneOfDarkness");
        add("Bgm50/WorldHorizon");
        add("Bgm51/battleHorizonTheme");
        add("Bgm51/LosGurugers");
        add("Bgm51/LuensHouse");
        add("Bgm51/MapleSquadS1");
        add("Bgm51/Pathfinder");
        add("Bgm51/SecretElodin");
        add("Bgm51/ThePartemRuins");
        add("Bgm51/TheVillageOfKarupa");
        add("BgmEvent/FunnyRabbit");
        add("BgmEvent/FunnyRabbitFaster");
        add("BgmEvent/wedding");
        add("BgmEvent/weddingDance");
        add("BgmEvent/wichTower");
        add("BgmGL/amoria");
        add("BgmGL/Amorianchallenge");
        add("BgmGL/chapel");
        add("BgmGL/cathedral");
        add("BgmGL/Courtyard");
        add("BgmGL/CrimsonwoodKeep");
        add("BgmGL/CrimsonwoodKeepInterior");
        add("BgmGL/GrandmastersGauntlet");
        add("BgmGL/HauntedHouse");
        add("BgmGL/NLChunt");
        add("BgmGL/NLCtown");
        add("BgmGL/NLCupbeat");
        add("BgmGL/PartyQuestGL");
        add("BgmGL/PhantomForest");
        add("BgmJp/Feeling");
        add("BgmJp/BizarreForest");
        add("BgmJp/Hana");
        add("BgmJp/Yume");
        add("BgmJp/Bathroom");
        add("BgmJp/BattleField");
        add("BgmJp/FirstStepMaster");
        add("BgmMY/Highland");
        add("BgmMY/KualaLumpur");
        add("BgmSG/BoatQuay_field");
        add("BgmSG/BoatQuay_town");
        add("BgmSG/CBD_field");
        add("BgmSG/CBD_town");
        add("BgmSG/Ghostship");
        add("BgmUI/ShopBgm");
        add("BgmUI/Title");
    }};
    
    // MapleStory default keyset
    private static final int[] DEFAULT_KEY = {18, 65, 2, 23, 3, 4, 5, 6, 16, 17, 19, 25, 26, 27, 31, 34, 35, 37, 38, 40, 43, 44, 45, 46, 50, 56, 59, 60, 61, 62, 63, 64, 57, 48, 29, 7, 24, 33, 41, 39};
    private static final int[] DEFAULT_TYPE = {4, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 5, 6, 6, 6, 6, 6, 6, 5, 4, 5, 4, 4, 4, 4, 4};
    private static final int[] DEFAULT_ACTION = {0, 106, 10, 1, 12, 13, 18, 24, 8, 5, 4, 19, 14, 15, 2, 17, 11, 3, 20, 16, 9, 50, 51, 6, 7, 53, 100, 101, 102, 103, 104, 105, 54, 22, 52, 21, 25, 26, 23, 27};
    
    // HeavenMS custom keyset
    private static final int[] CUSTOM_KEY = {2, 3, 4, 5, 31, 56, 59, 32, 42, 6, 17, 29, 30, 41, 50, 60, 61, 62, 63, 64, 65, 16, 7, 9, 13, 8};
    private static final int[] CUSTOM_TYPE = {4, 4, 4, 4, 5, 5, 6, 5, 5, 4, 4, 4, 5, 4, 4, 6, 6, 6, 6, 6, 6, 4, 4, 4, 4, 4};
    private static final int[] CUSTOM_ACTION = {1, 0, 3, 2, 53, 54, 100, 52, 51, 19, 5, 9, 50, 7, 22, 101, 102, 103, 104, 105, 106, 8, 17, 26, 20, 4};
    
    public static int[] getCustomKey(boolean customKeyset) {
        return(customKeyset ? CUSTOM_KEY : DEFAULT_KEY);
    }
    
    public static int[] getCustomType(boolean customKeyset) {
        return(customKeyset ? CUSTOM_TYPE : DEFAULT_TYPE);
    }
    
    public static int[] getCustomAction(boolean customKeyset) {
        return(customKeyset ? CUSTOM_ACTION : DEFAULT_ACTION);
    }
    
    private static final int[] mobHpVal = {0, 15, 20, 25, 35, 50, 65, 80, 95, 110, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
        375, 405, 435, 465, 495, 525, 580, 650, 720, 790, 900, 990, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800,
        1900, 2000, 2100, 2200, 2300, 2400, 2520, 2640, 2760, 2880, 3000, 3200, 3400, 3600, 3800, 4000, 4300, 4600, 4900, 5200,
        5500, 5900, 6300, 6700, 7100, 7500, 8000, 8500, 9000, 9500, 10000, 11000, 12000, 13000, 14000, 15000, 17000, 19000, 21000, 23000,
        25000, 27000, 29000, 31000, 33000, 35000, 37000, 39000, 41000, 43000, 45000, 47000, 49000, 51000, 53000, 55000, 57000, 59000, 61000, 63000,
        65000, 67000, 69000, 71000, 73000, 75000, 77000, 79000, 81000, 83000, 85000, 89000, 91000, 93000, 95000, 97000, 99000, 101000, 103000,
        105000, 107000, 109000, 111000, 113000, 115000, 118000, 120000, 125000, 130000, 135000, 140000, 145000, 150000, 155000, 160000, 165000, 170000, 175000, 180000,
        185000, 190000, 195000, 200000, 205000, 210000, 215000, 220000, 225000, 230000, 235000, 240000, 250000, 260000, 270000, 280000, 290000, 300000, 310000, 320000,
        330000, 340000, 350000, 360000, 370000, 380000, 390000, 400000, 410000, 420000, 430000, 440000, 450000, 460000, 470000, 480000, 490000, 500000, 510000, 520000,
        530000, 550000, 570000, 590000, 610000, 630000, 650000, 670000, 690000, 710000, 730000, 750000, 770000, 790000, 810000, 830000, 850000, 870000, 890000, 910000};
    
    public static String getJobName(int jobid) {
        String name = jobNames.get(jobid);
        
        if(name == null) {
            MapleJob job = MapleJob.getById(jobid);
            
            if(job != null) {
                name = job.name().toLowerCase();
                name = name.replaceAll("[*0-9]", "");
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
            } else {
                name = "";
            }
        
            jobNames.put(jobid, name);
        }
        
        return name;
    }
    
    public static int getJobUpgradeLevelRange(int jobbranch) {
        return jobUpgradeBlob[jobbranch];
    }
    
    public static int getChangeJobSpUpgrade(int jobbranch) {
        return jobUpgradeSpUp[jobbranch];
    }
    
    public static boolean isHallOfFameMap(int mapid) {
        switch(mapid) {
            case 102000004:     // warrior
            case 101000004:     // magician
            case 100000204:     // bowman
            case 103000008:     // thief
            case 120000105:     // pirate
            case 130000100:     // cygnus
            case 130000101:     // other cygnus
            case 130000110:     // cygnus 2nd floor
            case 130000120:     // cygnus 3rd floor (beginners)
            case 140010110:     // aran
                return true;
                
            default:
                return false;
        }
    }
    
    public static boolean isPodiumHallOfFameMap(int mapid) {
        switch(mapid) {
            case 102000004:     // warrior
            case 101000004:     // magician
            case 100000204:     // bowman
            case 103000008:     // thief
            case 120000105:     // pirate
                return true;
                
            default:
                return false;
        }
    }
    
    public static byte getHallOfFameBranch(MapleJob job, int mapid) {
        if(!isHallOfFameMap(mapid)) {
            return (byte) (26 + 4 * (mapid / 100000000));   // custom, 400 pnpcs available per continent
        }
        
        if(job.isA(MapleJob.WARRIOR)) {
            return 10;
        } else if(job.isA(MapleJob.MAGICIAN)) {
            return 11;
        } else if(job.isA(MapleJob.BOWMAN)) {
            return 12;
        } else if(job.isA(MapleJob.THIEF)) {
            return 13;
        } else if(job.isA(MapleJob.PIRATE)) {
            return 14;
        } else if(job.isA(MapleJob.DAWNWARRIOR1)) {
            return 15;
        } else if(job.isA(MapleJob.BLAZEWIZARD1)) {
            return 16;
        } else if(job.isA(MapleJob.WINDARCHER1)) {
            return 17;
        } else if(job.isA(MapleJob.NIGHTWALKER1)) {
            return 18;
        } else if(job.isA(MapleJob.THUNDERBREAKER1)) {
            return 19;
        } else if(job.isA(MapleJob.ARAN1)) {
            return 20;
        } else if(job.isA(MapleJob.EVAN1)) {
            return 21;
        } else if(job.isA(MapleJob.BEGINNER)) {
            return 22;
        } else if(job.isA(MapleJob.NOBLESSE)) {
            return 23;
        } else if(job.isA(MapleJob.LEGEND)) {
            return 24;
        } else {
            return 25;
        }
    }
    
    public static int getOverallJobRankByScriptId(int scriptId) {
        int branch = (scriptId / 100) % 100;
        
        if(branch < 26) {
            return (scriptId % 100) + 1;
        } else {
            return ((scriptId - 2600) % 400) + 1;
        }
    }
    
    public static boolean canPnpcBranchUseScriptId(byte branch, int scriptId) {
        scriptId /= 100;
        scriptId %= 100;
        
        if(branch < 26) {
            return branch == scriptId;
        } else {
            return scriptId >= branch && scriptId < branch + 4;
        }
    }
    
    public static int getHallOfFameMapid(MapleJob job) {
        int jobid = job.getId();
        
        if(isCygnus(jobid)) {
            return 130000100;
        } else if(isAran(jobid)) {
            return 140010110;
        } else {
            if(job.isA(MapleJob.WARRIOR)) {
                return 102000004;
            } else if(job.isA(MapleJob.MAGICIAN)) {
                return 101000004;
            } else if(job.isA(MapleJob.BOWMAN)) {
                return 100000204;
            } else if(job.isA(MapleJob.THIEF)) {
                return 103000008;
            } else if(job.isA(MapleJob.PIRATE)) {
                return 120000105;
            } else {
                return 130000110;   // beginner explorers are allotted with the Cygnus, available map lul
            }
        }
    }
    
    public static int getJobBranch(MapleJob job) {
        int jobid = job.getId();
        
        if(jobid % 1000 == 0) {
            return 0;
        } else if(jobid % 100 == 0) {
            return 1;
        } else {
            return 2 + (jobid % 10);
        }
    }
    
    public static int getJobMaxLevel(MapleJob job) {
        int jobBranch = getJobBranch(job);
        
        switch(jobBranch) {
            case 0:
                return 10;   // beginner
                
            case 1:
                return 30;   // 1st job
                
            case 2:
                return 70;   // 2nd job
                
            case 3:
                return 120;   // 3rd job
                
            default:
                return (job.getId() / 1000 == 1) ? 120 : 200;   // 4th job: cygnus is 120, rest is 200
        }
    }
    
    public static int getHiddenSkill(final int skill) {
        switch (skill) {
            case Aran.HIDDEN_FULL_DOUBLE:
            case Aran.HIDDEN_FULL_TRIPLE:
                return Aran.FULL_SWING;
            case Aran.HIDDEN_OVER_DOUBLE:
            case Aran.HIDDEN_OVER_TRIPLE:
                return Aran.OVER_SWING;
        }
        return skill;
    }
    
    public static int getSkillBook(final int job) {
        if (job >= 2210 && job <= 2218) {
             return job - 2209;
        }
        return 0;
    }
    
    public static boolean isAranSkills(final int skill) {
    	return Aran.FULL_SWING == skill || Aran.OVER_SWING == skill || Aran.COMBO_TEMPEST == skill || Aran.COMBO_FENRIR == skill || Aran.COMBO_DRAIN == skill 
    			|| Aran.HIDDEN_FULL_DOUBLE == skill || Aran.HIDDEN_FULL_TRIPLE == skill || Aran.HIDDEN_OVER_DOUBLE == skill || Aran.HIDDEN_OVER_TRIPLE == skill
    			|| Aran.COMBO_SMASH == skill || Aran.DOUBLE_SWING  == skill || Aran.TRIPLE_SWING == skill;
    }
    
    public static boolean isHiddenSkills(final int skill) {
    	return Aran.HIDDEN_FULL_DOUBLE == skill || Aran.HIDDEN_FULL_TRIPLE == skill || Aran.HIDDEN_OVER_DOUBLE == skill || Aran.HIDDEN_OVER_TRIPLE == skill;
    }
    
    public static boolean isCygnus(final int job) {
        return job / 1000 == 1;
    }
    
    public static boolean isAran(final int job) {
        return job == 2000 || (job >= 2100 && job <= 2112);
    }
    
    private static boolean isInBranchJobTree(int skillJobId, int jobId, int branchType) {
        int branch = (int)(Math.pow(10, branchType));
        
        int skillBranch = (int)(skillJobId / branch) * branch;
        int jobBranch = (int)(jobId / branch) * branch;
        
        return skillBranch == jobBranch;
    }
    
    private static boolean hasDivergedBranchJobTree(int skillJobId, int jobId, int branchType) {
        int branch = (int)(Math.pow(10, branchType));
        
        int skillBranch = (int)(skillJobId / branch);
        int jobBranch = (int)(jobId / branch);
        
        return skillBranch != jobBranch && skillBranch % 10 != 0;
    }
    
    public static boolean isInJobTree(int skillId, int jobId) {
        int skillJob = skillId / 10000;
        
        if(!isInBranchJobTree(skillJob, jobId, 0)) {
            for(int i = 1; i <= 3; i++) {
                if(hasDivergedBranchJobTree(skillJob, jobId, i)) return false;
                if(isInBranchJobTree(skillJob, jobId, i)) return (skillJob <= jobId);
            }
        } else {
            return (skillJob <= jobId);
        }
        
        return false;
    }
    
    public static boolean isPqSkill(final int skill) {
    	return (skill >= 20000014 && skill <= 20000018) || skill == 10000013 || skill == 20001013 || (skill % 10000000 >= 1009 && skill % 10000000 <= 1011) || skill % 10000000 == 1020;
    }
    
    public static boolean bannedBindSkills(final int skill) {
    	return isAranSkills(skill) || isPqSkill(skill);
    }

    public static boolean isGMSkills(final int skill) {
    	return skill >= 9001000 && skill <= 9101008 || skill >= 8001000 && skill <= 8001001; 
    }
    
    public static boolean isFreeMarketRoom(int mapid) {
        return mapid > 910000000 && mapid < 910000023;
    }
    
    public static boolean isMerchantLocked(MapleMap map) {
        if(FieldLimit.CANNOTMIGRATE.check(map.getFieldLimit())) {   // maps that cannot access cash shop cannot access merchants too (except FM rooms).
            return true;
        }
        
        switch(map.getId()) {
            case 910000000:
                return true;
        }
        
        return false;
    }
    
    public static boolean isBossRush(int mapid) {
        return mapid >= 970030100 && mapid <= 970042711;
    }
    
    public static boolean isDojo(int mapid) {
        return mapid >= 925020000 && mapid < 925040000;
    }
    
    public static boolean isPyramid(int mapid) {
    	return mapid >= 926010010 & mapid <= 930010000;
    }
    
    public static boolean isAriantColiseumLobby(int mapid) {
        int mapbranch = mapid / 1000;
    	return mapbranch == 980010 && mapid % 10 == 0;
    }
    
    public static boolean isAriantColiseumArena(int mapid) {
        int mapbranch = mapid / 1000;
    	return mapbranch == 980010 && mapid % 10 == 1;
    }
    
    public static boolean isPqSkillMap(int mapid) {
    	return isDojo(mapid) || isPyramid(mapid);
    }
    
    public static boolean isFishingArea(int mapid) {
    	return mapid == 120010000 || mapid == 251000100 || mapid == 541010110;
    }
    
    public static boolean isFinisherSkill(int skillId) {
        return skillId > 1111002 && skillId < 1111007 || skillId == 11111002 || skillId == 11111003;
    }
    
    public static boolean isMedalQuest(short questid) {
        return MapleQuest.getInstance(questid).getMedalRequirement() != -1;
    }
    
    public static boolean hasSPTable(MapleJob job) {
        switch (job) {
            case EVAN:
            case EVAN1:
            case EVAN2:
            case EVAN3:
            case EVAN4:
            case EVAN5:
            case EVAN6:
            case EVAN7:
            case EVAN8:
            case EVAN9:
            case EVAN10:
                return true;
            default:
                return false;
        }
    }
        
    public static int getMonsterHP(final int level) {
        if (level < 0 || level >= mobHpVal.length) {
            return Integer.MAX_VALUE;
        }
        return mobHpVal[level];
    }
    
    public static String ordinal(int i) {
        String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
                
            default:
                return i + sufixes[i % 10];
        }
    }
    
    public synchronized static String numberWithCommas(int i) {
        if(!ServerConstants.USE_DISPLAY_NUMBERS_WITH_COMMA) {
            return nfFormatter.format(i);   // will display number on whatever locale is currently assigned on NumberFormat
        } else {
            return NumberFormat.getNumberInstance(Locale.UK).format(i);
        }
    }
    
    public synchronized static Number parseNumber(String value) {
        try {
            return nfParser.parse(value);
        } catch(Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }
}
