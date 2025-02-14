# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

           # This function creates a nether portal shaped portal! #

# ----------------------------------------------------------------------------- #

# Fill the frame with the portal block

fill ~ ~ ~ ~1 ~2 ~ minecraft:moving_piston

# Summon armor stands for portal blocks (OPTIONAL)
summon armor_stand ~.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.5 ~1 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~1 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.5 ~2 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~2 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_death_dim_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"minecraft:snowball",Count:1b,tag:{CustomModelData:286000}}]}

summon marker ~.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,Tags:["wabportals_death_dim_marker","wabportals_death_dim_marker_x"]}

# Play a portal opening sound (OPTIONAL)

playsound minecraft:block.end_portal.spawn master @a ~ ~ ~ 15 1