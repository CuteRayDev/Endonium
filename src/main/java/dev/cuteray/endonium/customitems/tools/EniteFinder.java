package dev.cuteray.endonium.customitems.tools;

import dev.cuteray.endonium.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EniteFinder extends Item {


    public EniteFinder(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.enite_finder.1").formatted(Formatting.AQUA));
        tooltip.add(new TranslatableText("tooltip.enite_finder.2").formatted(Formatting.AQUA));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient && (hand == Hand.MAIN_HAND))
        {
            BlockPos playerPos = user.getBlockPos();
            List<Integer> oreLocs = GetOreLoc(user.getBlockPos(), world);
            List<String> results = new ArrayList<String>();
            if (oreLocs.size() != 0){
                String textColor = "§f";
                String Advice = "";
                for(int i : oreLocs) {
                    int eniteClose = HowCloseIsEnite(user.getBlockY(), i);
                    switch (eniteClose) {
                        case 0:
                            textColor = "§a";
                            Advice = "You are really close to an Enite ore!";
                            break;
                        case 1:
                            textColor = "§e";
                            Advice = "An Enite ore is not very far!";
                            break;
                        case 2:
                            textColor = "§6";
                            Advice = "An Enite ore is down there, kinda far!";
                            break;
                        case 3:
                            textColor = "§c";
                            Advice = "Dig veryyyy deep to get an Enite block below!";
                            break;
                    }
                    results.add(textColor + Advice + " (" + user.getBlockX() + ", " + i + ", " + user.getBlockZ() + ")");

                }
            }
            else
            {
                results.add("§7There are no Enite below.");
            }
            for(String s : results)
            {
                user.sendMessage(new LiteralText(s), false);
            }
        }
        return super.use(world, user, hand);
    }

    List<Integer> GetOreLoc(BlockPos playerPos, World world)
    {
        List<Integer> oreLocs = new ArrayList<Integer>();
        int playerXLoc = playerPos.getX();
        int playerZLoc = playerPos.getZ();
        for (int y = 0; y<= 100; y++) {
            BlockPos searchBlockPos = new BlockPos(playerXLoc, y, playerZLoc);
            Block searchBlock = world.getBlockState(searchBlockPos).getBlock();
            if (searchBlock == ModBlocks.ENITE_ORE)
            {
                oreLocs.add(y);
            }
        }
        return oreLocs;
    }

    int HowCloseIsEnite(int playerYPos, int eniteYPos)
    {
        int dif = playerYPos - eniteYPos;
        if (dif < 0) dif = -dif;
        if (dif > 10){
            if (dif > 20){
                if (dif > 40){
                     return 3;
                }
                else{
                    return 2;
                }
            }
            else{
                return 1;
            }
        }
        else{
            return 0;
        }
    }
}
