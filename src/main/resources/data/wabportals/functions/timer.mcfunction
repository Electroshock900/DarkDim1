# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

          # This funtion sets up a timer that runs twice a second! #

# ----------------------------------------------------------------------------- #

# Check if the player used what's needed to activate the portal

scoreboard players add #wabportals_timer wabportals_timer 1
execute if score #wabportals_timer wabportals_timer matches 10.. run scoreboard players set #wabportals_timer wabportals_timer 0
