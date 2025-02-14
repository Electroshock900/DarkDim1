# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

            # This function runs every time the world is loaded! #

# ----------------------------------------------------------------------------- #

# Check if the player used what's needed to activate the portal

scoreboard objectives add death_dim_portal_activation_check minecraft.used:voidless.blood_bucket

# Check if raycasts have exceeded the player's reach range yet

scoreboard objectives add player_reach_range dummy

# Make a scoreboard for the timer function

scoreboard objectives add wabportals_timer dummy

# Make a scoreboard to store an entity's coordinates

scoreboard objectives add wabportals_cooldown dummy