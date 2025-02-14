# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

            # This function checks where the portal was activated! #

# ----------------------------------------------------------------------------- #

# Check where the block the player placed is

execute if block ~ ~ ~ #wabportals:activation/death_dim if block ~ ~-1 ~ #wabportals:frame/death_dim run function wabportals:activate/check_frame/death_dim/bottom
execute if block ~ ~ ~ #wabportals:activation/death_dim if block ~ ~-2 ~ #wabportals:frame/death_dim run function wabportals:activate/check_frame/death_dim/mid
execute if block ~ ~ ~ #wabportals:activation/death_dim if block ~ ~-3 ~ #wabportals:frame/death_dim run function wabportals:activate/check_frame/death_dim/top
scoreboard players remove @s player_reach_range 1
execute if score @s player_reach_range matches 1.. if block ~ ~ ~ #wabportals:air positioned ^ ^ ^0.5 run function wabportals:activate/locate_block/death_dim