# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

# This function checks if there's a complete nether portal shaped portal frame! #

# ----------------------------------------------------------------------------- #

                             # Look for a frame #

# ----------------------------------------------------------------------------- #


## Check in case the portal was activated a block up from the bottom

# North
execute if block ~ ~-2 ~ #wabportals:frame/death_dim if block ~ ~-2 ~1 #wabportals:frame/death_dim if block ~ ~-1 ~-1 #wabportals:frame/death_dim if block ~ ~-1 ~2 #wabportals:frame/death_dim if block ~ ~ ~-1 #wabportals:frame/death_dim if block ~ ~ ~2 #wabportals:frame/death_dim if block ~ ~1 ~-1 #wabportals:frame/death_dim if block ~ ~1 ~2 #wabportals:frame/death_dim if block ~ ~2 ~ #wabportals:frame/death_dim if block ~ ~2 ~1 #wabportals:frame/death_dim if block ~ ~-1 ~ #wabportals:air if block ~ ~-1 ~1 #wabportals:air if block ~ ~ ~1 #wabportals:air if block ~ ~1 ~ #wabportals:air if block ~ ~1 ~1 #wabportals:air positioned ~ ~-1 ~ align xyz run function wabportals:activate/create/death_dim/z

# South
execute if block ~ ~-2 ~ #wabportals:frame/death_dim if block ~ ~-2 ~-1 #wabportals:frame/death_dim if block ~ ~-1 ~-2 #wabportals:frame/death_dim if block ~ ~-1 ~1 #wabportals:frame/death_dim if block ~ ~ ~-2 #wabportals:frame/death_dim if block ~ ~ ~1 #wabportals:frame/death_dim if block ~ ~1 ~-2 #wabportals:frame/death_dim if block ~ ~1 ~1 #wabportals:frame/death_dim if block ~ ~2 ~ #wabportals:frame/death_dim if block ~ ~2 ~-1 #wabportals:frame/death_dim if block ~ ~-1 ~ #wabportals:air if block ~ ~-1 ~-1 #wabportals:air if block ~ ~ ~-1 #wabportals:air if block ~ ~1 ~ #wabportals:air if block ~ ~1 ~-1 #wabportals:air positioned ~ ~-1 ~-1 align xyz run function wabportals:activate/create/death_dim/z

# East
execute if block ~ ~-2 ~ #wabportals:frame/death_dim if block ~-1 ~-2 ~ #wabportals:frame/death_dim if block ~1 ~-1 ~ #wabportals:frame/death_dim if block ~-2 ~-1 ~ #wabportals:frame/death_dim if block ~1 ~ ~ #wabportals:frame/death_dim if block ~-2 ~ ~ #wabportals:frame/death_dim if block ~1 ~1 ~ #wabportals:frame/death_dim if block ~-2 ~1 ~ #wabportals:frame/death_dim if block ~ ~2 ~ #wabportals:frame/death_dim if block ~-1 ~2 ~ #wabportals:frame/death_dim if block ~ ~-1 ~ #wabportals:air if block ~-1 ~-1 ~ #wabportals:air if block ~-1 ~ ~ #wabportals:air if block ~ ~1 ~ #wabportals:air if block ~-1 ~1 ~ #wabportals:air positioned ~-1 ~-1 ~ align xyz run function wabportals:activate/create/death_dim/x

# West
execute if block ~ ~-2 ~ #wabportals:frame/death_dim if block ~1 ~-2 ~ #wabportals:frame/death_dim if block ~2 ~-1 ~ #wabportals:frame/death_dim if block ~-1 ~-1 ~ #wabportals:frame/death_dim if block ~2 ~ ~ #wabportals:frame/death_dim if block ~-1 ~ ~ #wabportals:frame/death_dim if block ~2 ~1 ~ #wabportals:frame/death_dim if block ~-1 ~1 ~ #wabportals:frame/death_dim if block ~ ~2 ~ #wabportals:frame/death_dim if block ~1 ~2 ~ #wabportals:frame/death_dim if block ~ ~-1 ~ #wabportals:air if block ~1 ~-1 ~ #wabportals:air if block ~1 ~ ~ #wabportals:air if block ~ ~1 ~ #wabportals:air if block ~1 ~1 ~ #wabportals:air positioned ~ ~-1 ~ align xyz run function wabportals:activate/create/death_dim/x
