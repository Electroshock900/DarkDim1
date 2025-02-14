# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

             # This funtion runs every tick! (20 times a second) #

# ----------------------------------------------------------------------------- #

# Check if the player used what's needed to activate the portal

scoreboard players set @a player_reach_range 13


execute as @a[scores={death_dim_portal_activation_check=1..},predicate=wabportals:dimensions/overworld] at @s rotated as @s anchored eyes run function wabportals:activate/locate_block/death_dim
execute as @a[scores={death_dim_portal_activation_check=1..},predicate=wabportals:dimensions/death_dim] at @s rotated as @s anchored eyes run function wabportals:activate/locate_block/death_dim

scoreboard players set @a death_dim_portal_activation_check 0

function wabportals:run/main/death_dim

execute as @e[predicate=wabportals:travellers/all_mobs] unless score @s wabportals_cooldown = @s wabportals_cooldown run scoreboard players set @s wabportals_cooldown 0
execute as @e[predicate=wabportals:travellers/all_mobs,scores={wabportals_cooldown=1..}] unless entity @e[type=armor_stand,tag=wabportals_portal_stand,distance=...5] run scoreboard players remove @s wabportals_cooldown 1
