function reset_animation_flags {
	scoreboard players set .aj.animation aj.peary_java.animating 0
	scoreboard players set .aj.anim_loop aj.peary_java.animating 0
	scoreboard players set .noScripts aj.i 0
}
function assert_animation_flags {
	scoreboard players add .aj.animation aj.peary_java.animating 0
	scoreboard players add .aj.anim_loop aj.peary_java.animating 0
	scoreboard players add .noScripts aj.i 0
}
function install {
	scoreboard objectives add aj.i dummy
	scoreboard objectives add aj.id dummy
	scoreboard objectives add aj.frame dummy
	scoreboard objectives add aj.peary_java.animating dummy
	scoreboard objectives add aj.peary_java.animation.peary.idle.loopMode dummy
	scoreboard objectives add aj.peary_java.animation.peary.flying.loopMode dummy
	scoreboard objectives add aj.peary_java.animation.peary.walk.loopMode dummy
	scoreboard objectives add aj.peary_java.animation.peary.holding.loopMode dummy
	scoreboard objectives add aj.peary_java.animation.peary.cheer.loopMode dummy
	function peary_java:reset_animation_flags
	scoreboard players set #uninstall aj.i 0
	scoreboard players set .aj.peary_java.framerate aj.i 1
	tellraw @a [{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"aqua"},{"text":" → ","color":"gray"},{"text":"Install ⊻","color":"green"},{"text":" ]","color":"dark_gray"},"\n",{"text":"Installed ","color":"gray"},{"text":"armor_stand","color":"gold"},{"text":" rig.","color":"gray"},"\n",{"text":"◘ ","color":"gray"},{"text":"Included Scoreboard Objectives:","color":"green"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.i","color":"aqua"},{"text":" (Internal)","color":"dark_gray"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.id","color":"aqua"},{"text":" (ID)","color":"dark_gray"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.frame","color":"aqua"},{"text":" (Frame)","color":"dark_gray"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animating","color":"aqua"},{"text":" (Animation Flag)","color":"dark_gray"},[["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.idle.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.flying.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.walk.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.holding.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.cheer.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}]]]
}
function uninstall {
	scoreboard objectives remove aj.peary_java.animating
	scoreboard objectives remove aj.peary_java.animation.peary.idle.loopMode
	scoreboard objectives remove aj.peary_java.animation.peary.flying.loopMode
	scoreboard objectives remove aj.peary_java.animation.peary.walk.loopMode
	scoreboard objectives remove aj.peary_java.animation.peary.holding.loopMode
	scoreboard objectives remove aj.peary_java.animation.peary.cheer.loopMode
	scoreboard players set #uninstall aj.i 1
	tellraw @a [{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"aqua"},{"text":" → ","color":"gray"},{"text":"Uninstall ⊽","color":"red"},{"text":" ]","color":"dark_gray"},"\n",{"text":"Uninstalled ","color":"gray"},{"text":"armor_stand","color":"gold"},{"text":" rig specific scoreboards","color":"gray"},"\n",{"text":"◘ ","color":"gray"},{"text":"Included Scoreboard Objectives:","color":"green"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animating","color":"aqua"},{"text":" (Animation Flag)","color":"dark_gray"},[["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.idle.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.flying.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.walk.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.holding.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}],["\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.peary_java.animation.peary.cheer.loopMode","color":"aqua"},{"text":" (Loop Mode)","color":"dark_gray"}]],"\n","\n",{"text":"◘ ","color":"gray"},{"text":"Do you wish to uninstall all AJ related scoreboard objectives added by this rig?","color":"green"},"\n",{"text":"[Yes]","color":"green","clickEvent":{"action":"run_command","value":"/function peary_java:uninstall/remove_aj_related"}},{"text":" [No]","color":"red","clickEvent":{"action":"run_command","value":"/function peary_java:uninstall/keep_aj_related"}}]
}
dir uninstall {
	function keep_aj_related {
		execute if score #uninstall aj.i matches 0 run tellraw @a [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"Uninstall not in-progress. Please run","color":"gray"},"\n",{"text":" function peary_java:uninstall","color":"red"},"\n",{"text":" to start the uninstallation process.","color":"gray"}]
		execute if score #uninstall aj.i matches 1 run {
			scoreboard players set #uninstall aj.i 0
			tellraw @a [{"text":"Keeping AJ specific scoreboard objectives.","color":"green"}]
		}
	}
	function remove_aj_related {
		execute if score #uninstall aj.i matches 0 run tellraw @a [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"Uninstall not in-progress. Please run","color":"gray"},"\n",{"text":" function peary_java:uninstall","color":"red"},"\n",{"text":" to start the uninstallation process.","color":"gray"}]
		execute if score #uninstall aj.i matches 1 run {
			scoreboard players set #uninstall aj.i 0
			scoreboard objectives remove aj.i
			scoreboard objectives remove aj.id
			scoreboard objectives remove aj.frame
			tellraw @a [{"text":"Removed AJ specific scoreboard objectives:","color":"green"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.i","color":"aqua"},{"text":" (Internal)","color":"dark_gray"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.id","color":"aqua"},{"text":" (ID)","color":"dark_gray"},"\n",{"text":"   ◘ ","color":"gray"},{"text":"aj.frame","color":"aqua"},{"text":" (Frame)","color":"dark_gray"}]
		}
	}
}
entities bone_entities {
	minecraft:area_effect_cloud
	minecraft:armor_stand
}
dir remove {
	function all {
		kill @e[type=minecraft:marker,tag=aj.peary_java]
		kill @e[type=#peary_java:bone_entities,tag=aj.peary_java]
	}
	function this {
		execute (if entity @s[tag=aj.peary_java.root] at @s) {
			scoreboard players operation # aj.id = @s aj.id
			execute as @e[type=#peary_java:bone_entities,tag=aj.peary_java,distance=..3.203] if score @s aj.id = # aj.id run kill @s
			kill @s
		} else {
			tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:remove/this ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
		}
	}
}
dir summon {
	function default {
		# Summon Root Entity
		summon minecraft:marker ~ ~ ~ {Tags:['new','aj.peary_java','aj.peary_java.root']}
		# Execute as summoned root
		execute as @e[type=minecraft:marker,tag=aj.peary_java.root,tag=new,distance=..1,limit=1] rotated ~ 0 run {
			# Copy the execution position and rotation onto the root
			tp @s ~ ~ ~ ~ ~
			# Get an ID for this rig
			execute store result score @s aj.id run scoreboard players add .aj.last_id aj.i 1
			# Execute at updated location
			execute at @s run {
				# Summon all bone entities
				summon minecraft:area_effect_cloud ^0.125 ^-1.53175 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.897'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.897','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:1}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^0 ^-1.563 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.body'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.body','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:2}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^0 ^-1.4255 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.flower'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.flower','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:3}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^-0.03125 ^-1.4255 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal4'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal4','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:7}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^-0.125 ^-1.53175 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.leftarm'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.leftarm','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:8}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^-0.0625 ^-1.688 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.leftleg'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.leftleg','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:9}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^0.0625 ^-1.688 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.rightleg'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.rightleg','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:10}}],Pose:{Head:[0f,0f,0f]}}]}
				summon minecraft:area_effect_cloud ^0 ^-1.4255 ^-0.03125 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal1'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal1','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:4}}],Pose:{Head:[0f,-90f,0f]}}]}
				summon minecraft:area_effect_cloud ^0.04687 ^-1.4255 ^0 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal2'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal2','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:5}}],Pose:{Head:[-180f,0f,180f]}}]}
				summon minecraft:area_effect_cloud ^0 ^-1.4255 ^0.03125 {Age:-2147483648,Duration:-1,WaitTime:-2147483648,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal3'],Passengers:[{id:'minecraft:armor_stand',Invisible:true,Marker:true,NoGravity:true,DisabledSlots:4144959,Tags:['new','aj.peary_java','aj.peary_java.bone','aj.peary_java.bone.petal3','aj.peary_java.bone_display'],ArmorItems:[{},{},{},{id:'minecraft:white_dye',Count:1b,tag:{CustomModelData:6}}],Pose:{Head:[0f,90f,0f]}}]}
				# Update rotation and ID of bone entities to match the root entity
				execute as @e[type=#peary_java:bone_entities,tag=aj.peary_java,tag=new,distance=..3.203] positioned as @s run {
					scoreboard players operation @s aj.id = .aj.last_id aj.i
					tp @s ~ ~ ~ ~ ~
					tag @s remove new
				}
			}
			tag @s remove new
			# Set all animation modes to configured default
			scoreboard players set @s aj.peary_java.animation.peary.idle.loopMode 0
			scoreboard players set @s aj.peary_java.animation.peary.flying.loopMode 2
			scoreboard players set @s aj.peary_java.animation.peary.walk.loopMode 2
			scoreboard players set @s aj.peary_java.animation.peary.holding.loopMode 0
			scoreboard players set @s aj.peary_java.animation.peary.cheer.loopMode 2
			scoreboard players set @s aj.frame 0
			scoreboard players set @s aj.peary_java.animating 0
		}
		# Assert animation flags
		function peary_java:assert_animation_flags
	}
}
# Resets the model to it's initial summon position/rotation and stops all active animations
function reset {
	# Make sure this function has been ran as the root entity
	execute(if entity @s[tag=aj.peary_java.root] at @s rotated ~ 0) {
		# Remove all animation tags
		tag @s remove aj.peary_java.anim.animation.peary.idle
		tag @s remove aj.peary_java.anim.animation.peary.flying
		tag @s remove aj.peary_java.anim.animation.peary.walk
		tag @s remove aj.peary_java.anim.animation.peary.holding
		tag @s remove aj.peary_java.anim.animation.peary.cheer
		# Reset animation time
		scoreboard players set @s aj.frame 0
		scoreboard players operation .this aj.id = @s aj.id
		execute as @e[type=minecraft:area_effect_cloud,tag=aj.peary_java.bone,distance=..3.203] if score @s aj.id = .this aj.id run {
			tp @s[tag=aj.peary_java.bone.897] ^0.125 ^-1.532 ^0
			tp @s[tag=aj.peary_java.bone.body] ^0 ^-1.563 ^0
			tp @s[tag=aj.peary_java.bone.flower] ^0 ^-1.425 ^0
			tp @s[tag=aj.peary_java.bone.petal4] ^-0.031 ^-1.425 ^0
			tp @s[tag=aj.peary_java.bone.leftarm] ^-0.125 ^-1.532 ^0
			tp @s[tag=aj.peary_java.bone.leftleg] ^-0.062 ^-1.688 ^0
			tp @s[tag=aj.peary_java.bone.rightleg] ^0.063 ^-1.688 ^0
			tp @s[tag=aj.peary_java.bone.petal1] ^0 ^-1.425 ^-0.031
			tp @s[tag=aj.peary_java.bone.petal2] ^0.047 ^-1.425 ^0
			tp @s[tag=aj.peary_java.bone.petal3] ^0 ^-1.425 ^0.031
			execute store result score .calc aj.i run data get entity @s Air
			execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
		}
		execute as @e[type=minecraft:armor_stand,tag=aj.peary_java.bone,distance=..3.203] if score @s aj.id = .this aj.id run {
			data modify entity @s[tag=aj.peary_java.bone.897] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.body] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.flower] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.petal4] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.leftarm] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.leftleg] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.rightleg] Pose.Head set value [0f,0f,0f]
			data modify entity @s[tag=aj.peary_java.bone.petal1] Pose.Head set value [0f,-90f,0f]
			data modify entity @s[tag=aj.peary_java.bone.petal2] Pose.Head set value [-180f,0f,180f]
			data modify entity @s[tag=aj.peary_java.bone.petal3] Pose.Head set value [0f,90f,0f]
			tp @s ~ ~ ~ ~ ~
		}
		# If this entity is not the root
	} else {
		tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:reset ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
	}
}
function move {
	# Make sure this function has been ran as the root entity
	execute(if entity @s[tag=aj.peary_java.root] rotated ~ 0) {
		tp @s ~ ~ ~ ~ ~
		scoreboard players operation .this aj.id = @s aj.id
		scoreboard players operation .this aj.frame = @s aj.frame
		# Split based on animation name
		scoreboard players set # aj.i 0
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.idle] run {
			scoreboard players set # aj.i 1
			# Select bone entities
			execute at @s as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run {
				# Split based on bone entity type
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					# Run root animation frame tree
					function peary_java:animations/animation.peary.idle/tree/root_bone_name
					execute store result score .calc aj.i run data get entity @s Air
					execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
				}
				execute if entity @s[type=minecraft:armor_stand] run tp @s ~ ~ ~ ~ ~
			}
		}
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.flying] run {
			scoreboard players set # aj.i 1
			# Select bone entities
			execute at @s as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run {
				# Split based on bone entity type
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					# Run root animation frame tree
					function peary_java:animations/animation.peary.flying/tree/root_bone_name
					execute store result score .calc aj.i run data get entity @s Air
					execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
				}
				execute if entity @s[type=minecraft:armor_stand] run tp @s ~ ~ ~ ~ ~
			}
		}
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.walk] run {
			scoreboard players set # aj.i 1
			# Select bone entities
			execute at @s as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run {
				# Split based on bone entity type
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					# Run root animation frame tree
					function peary_java:animations/animation.peary.walk/tree/root_bone_name
					execute store result score .calc aj.i run data get entity @s Air
					execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
				}
				execute if entity @s[type=minecraft:armor_stand] run tp @s ~ ~ ~ ~ ~
			}
		}
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.holding] run {
			scoreboard players set # aj.i 1
			# Select bone entities
			execute at @s as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run {
				# Split based on bone entity type
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					# Run root animation frame tree
					function peary_java:animations/animation.peary.holding/tree/root_bone_name
					execute store result score .calc aj.i run data get entity @s Air
					execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
				}
				execute if entity @s[type=minecraft:armor_stand] run tp @s ~ ~ ~ ~ ~
			}
		}
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.cheer] run {
			scoreboard players set # aj.i 1
			# Select bone entities
			execute at @s as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run {
				# Split based on bone entity type
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					# Run root animation frame tree
					function peary_java:animations/animation.peary.cheer/tree/root_bone_name
					execute store result score .calc aj.i run data get entity @s Air
					execute store result entity @s Air short 1 run scoreboard players add .calc aj.i 2
				}
				execute if entity @s[type=minecraft:armor_stand] run tp @s ~ ~ ~ ~ ~
			}
		}
		execute if score # aj.i matches 0 run {
			execute at @s as @e[type=minecraft:area_effect_cloud,tag=aj.peary_java.bone] if score @s aj.id = .this aj.id run tp @s ~ ~ ~
			function peary_java:reset
		}
		# If this entity is not the root
	} else {
		tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:move ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
	}
}
function animation_loop {
	# Schedule clock
	schedule function peary_java:animation_loop 1t
	# Set anim_loop active flag to true
	scoreboard players set .aj.anim_loop aj.peary_java.animating 1
	# Reset animating flag (Used internally to check if any animations have ticked during this tick)
	scoreboard players set .aj.animation aj.peary_java.animating 0
	# Run animations that are active on the entity
	execute as @e[type=minecraft:marker,tag=aj.peary_java.root] run{
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.idle] at @s run function peary_java:animations/animation.peary.idle/next_frame
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.flying] at @s run function peary_java:animations/animation.peary.flying/next_frame
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.walk] at @s run function peary_java:animations/animation.peary.walk/next_frame
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.holding] at @s run function peary_java:animations/animation.peary.holding/next_frame
		execute if entity @s[tag=aj.peary_java.anim.animation.peary.cheer] at @s run function peary_java:animations/animation.peary.cheer/next_frame
		scoreboard players operation @s aj.peary_java.animating = .aj.animation aj.peary_java.animating
	}
	# Stop the anim_loop clock if no models are animating
	execute if score .aj.animation aj.peary_java.animating matches 0 run {
		# Stop anim_loop shedule clock
		schedule clear peary_java:animation_loop
		# Set anim_loop active flag to false
		scoreboard players set .aj.anim_loop aj.peary_java.animating 0
	}
}
dir animations {
	dir animation.peary.idle {
		# Starts the animation from the first frame
		function play {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s add aj.peary_java.anim.animation.peary.idle
				# Reset animation time
				execute if score .aj.peary_java.framerate aj.i matches ..-1 run scoreboard players set @s aj.frame 21
				execute if score .aj.peary_java.framerate aj.i matches 1.. run scoreboard players set @s aj.frame 0
				# Assert that .noScripts is tracked properly
				scoreboard players add .noScripts aj.i 0
				# Start the animation loop if not running
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.idle/play ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Stops the animation and resets to first frame
		function stop {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s remove aj.peary_java.anim.animation.peary.idle
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# load initial animation frame without running scripts
				scoreboard players operation .oldValue aj.i = .noScripts aj.i
				scoreboard players set .noScripts aj.i 1
				function peary_java:animations/animation.peary.idle/next_frame
				scoreboard players operation .noScripts aj.i = .oldValue aj.i
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.idle/stop ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Pauses the animation on the current frame
		function pause {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Remove animation tag
				tag @s remove aj.peary_java.anim.animation.peary.idle
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.idle/pause ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Resumes the animation from the current frame
		function resume {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root]) {
				# Remove animation tag
				tag @s add aj.peary_java.anim.animation.peary.idle
				# Start the animation loop
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.idle/resume ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Plays the next frame in the animation
		function next_frame {
			scoreboard players operation .this aj.id = @s aj.id
			scoreboard players operation .this aj.frame = @s aj.frame
			execute rotated ~ 0 as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone,distance=..1.49] if score @s aj.id = .this aj.id run {
				name tree/trunk
				# Bone Roots
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					name tree/root_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/897_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/body_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/body_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/body_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.563 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/leftarm_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/rightleg_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/rightleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/rightleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0.063 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/leftleg_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/flower_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/flower_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/flower_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal4_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal4_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal4_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal1_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal1_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal1_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal2_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal2_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal2_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0.047 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_root_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal3_root_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal3_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal3_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^0.031 ~ ~
						}
					}
					execute store result entity @s Air short 1 run scoreboard players get .this aj.frame
				}
				# Bone Displays
				execute if entity @s[type=minecraft:armor_stand] run {
					name tree/display_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/897_display_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-17.5f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [-14.5f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-11.5f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [-8.5f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [-5.5f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [-2.5f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [0.5f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [3.5f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [6.5f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [9.5f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [12.5f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [9.5f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [6.5f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [3.5f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [0.5f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [-2.5f,0f,0f]
							}
							execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [-5.5f,0f,0f]
							execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [-8.5f,0f,0f]
							execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [-11.5f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-14.5f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-17.5f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/body_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/leftarm_display_0-20
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [12.5f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [10.25f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [8f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [5.75f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [3.5f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [1.25f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-1f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-3.25f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-5.5f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-7.75f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-10f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-7.75f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-5.5f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-3.25f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-1f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [1.25f,0f,0f]
							}
							execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [3.5f,0f,0f]
							execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [5.75f,0f,0f]
							execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [8f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [10.25f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [12.5f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/rightleg_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/leftleg_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/flower_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal4_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal1_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,-90f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,-90f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal2_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-180f,0f,180f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-180f,0f,180f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_display_top
						execute if score .this aj.frame matches 0..20 run {
							name tree/petal3_display_0-20
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,90f,0f]
							execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,90f,0f]
						}
					}
					# Make sure rotation stays aligned with root entity
					execute positioned as @s run tp @s ~ ~ ~ ~ ~
				}
			}
			# Increment frame
			scoreboard players operation @s aj.frame += .aj.peary_java.framerate aj.i
			# Let the anim_loop know we're still running
			scoreboard players set .aj.animation aj.peary_java.animating 1
			# If (the next frame is the end of the animation) perform the necessary actions for the loop mode of the animation
			execute unless score @s aj.frame matches 0..21 run function peary_java:animations/animation.peary.idle/edge
		}
		# Performs a loop mode action depending on what the animation's configured loop mode is
		function edge {
			# Play Once
			execute if score @s aj.peary_java.animation.peary.idle.loopMode matches 0 run function peary_java:animations/animation.peary.idle/stop
			# Hold on last frame
			execute if score @s aj.peary_java.animation.peary.idle.loopMode matches 1 run function peary_java:animations/animation.peary.idle/pause
			# loop
			execute if score @s aj.peary_java.animation.peary.idle.loopMode matches 2 run {
				execute (if score @s aj.frame matches ..1) {
					scoreboard players set @s aj.frame 21
				} else {
					scoreboard players set @s aj.frame 0
				}
			}
		}
	}
	dir animation.peary.flying {
		# Starts the animation from the first frame
		function play {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s add aj.peary_java.anim.animation.peary.flying
				# Reset animation time
				execute if score .aj.peary_java.framerate aj.i matches ..-1 run scoreboard players set @s aj.frame 41
				execute if score .aj.peary_java.framerate aj.i matches 1.. run scoreboard players set @s aj.frame 0
				# Assert that .noScripts is tracked properly
				scoreboard players add .noScripts aj.i 0
				# Start the animation loop if not running
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.flying/play ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Stops the animation and resets to first frame
		function stop {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s remove aj.peary_java.anim.animation.peary.flying
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# load initial animation frame without running scripts
				scoreboard players operation .oldValue aj.i = .noScripts aj.i
				scoreboard players set .noScripts aj.i 1
				function peary_java:animations/animation.peary.flying/next_frame
				scoreboard players operation .noScripts aj.i = .oldValue aj.i
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.flying/stop ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Pauses the animation on the current frame
		function pause {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Remove animation tag
				tag @s remove aj.peary_java.anim.animation.peary.flying
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.flying/pause ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Resumes the animation from the current frame
		function resume {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root]) {
				# Remove animation tag
				tag @s add aj.peary_java.anim.animation.peary.flying
				# Start the animation loop
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.flying/resume ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Plays the next frame in the animation
		function next_frame {
			scoreboard players operation .this aj.id = @s aj.id
			scoreboard players operation .this aj.frame = @s aj.frame
			execute rotated ~ 0 as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone,distance=..1.49] if score @s aj.id = .this aj.id run {
				name tree/trunk
				# Bone Roots
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					name tree/root_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/897_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/897_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/897_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/897_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/body_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/body_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/body_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/body_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/body_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/body_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0 ^-1.563 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/leftarm_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftarm_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftarm_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftarm_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/rightleg_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/rightleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/rightleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/rightleg_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/rightleg_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/rightleg_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0.063 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/leftleg_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftleg_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftleg_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftleg_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/flower_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/flower_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/flower_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/flower_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/flower_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/flower_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal4_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal4_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.03 ^-1.425 ^-0.01 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.025 ^-1.425 ^-0.019 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.017 ^-1.425 ^-0.026 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.007 ^-1.425 ^-0.03 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.003 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.013 ^-1.425 ^-0.028 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.022 ^-1.425 ^-0.023 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal4_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.028 ^-1.425 ^-0.014 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.031 ^-1.425 ^-0.004 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.031 ^-1.425 ^0.006 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.027 ^-1.425 ^0.016 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.02 ^-1.425 ^0.024 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.012 ^-1.425 ^0.029 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.001 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.009 ^-1.425 ^0.03 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal4_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.018 ^-1.425 ^0.025 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.026 ^-1.425 ^0.018 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.03 ^-1.425 ^0.009 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.031 ^-1.425 ^-0.002 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.029 ^-1.425 ^-0.012 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.024 ^-1.425 ^-0.021 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.016 ^-1.425 ^-0.027 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.006 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal4_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.005 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.014 ^-1.425 ^-0.028 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.023 ^-1.425 ^-0.021 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.028 ^-1.425 ^-0.013 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.031 ^-1.425 ^-0.003 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.03 ^-1.425 ^0.008 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.026 ^-1.425 ^0.017 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.019 ^-1.425 ^0.025 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal4_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.01 ^-1.425 ^0.03 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.01 ^-1.425 ^0.029 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.019 ^-1.425 ^0.024 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.026 ^-1.425 ^0.017 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.03 ^-1.425 ^0.007 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.031 ^-1.425 ^-0.003 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.028 ^-1.425 ^-0.013 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^-0.022 ^-1.425 ^-0.022 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal1_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal1_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.01 ^-1.425 ^-0.03 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.019 ^-1.425 ^-0.025 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.026 ^-1.425 ^-0.017 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.03 ^-1.425 ^-0.007 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.031 ^-1.425 ^0.003 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.028 ^-1.425 ^0.013 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.023 ^-1.425 ^0.022 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal1_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.014 ^-1.425 ^0.028 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.004 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.006 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.016 ^-1.425 ^0.027 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.024 ^-1.425 ^0.02 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.029 ^-1.425 ^0.012 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.031 ^-1.425 ^0.001 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.03 ^-1.425 ^-0.009 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal1_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.025 ^-1.425 ^-0.018 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.018 ^-1.425 ^-0.026 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.009 ^-1.425 ^-0.03 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.002 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.012 ^-1.425 ^-0.029 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.021 ^-1.425 ^-0.024 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.027 ^-1.425 ^-0.016 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.031 ^-1.425 ^-0.006 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal1_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.031 ^-1.425 ^0.005 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.028 ^-1.425 ^0.014 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.021 ^-1.425 ^0.023 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.013 ^-1.425 ^0.028 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.003 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.008 ^-1.425 ^0.03 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.017 ^-1.425 ^0.026 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.025 ^-1.425 ^0.019 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal1_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.03 ^-1.425 ^0.01 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.029 ^-1.425 ^-0.01 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.024 ^-1.425 ^-0.019 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.017 ^-1.425 ^-0.026 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.007 ^-1.425 ^-0.03 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.003 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.013 ^-1.425 ^-0.028 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0.022 ^-1.425 ^-0.022 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal2_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal2_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.044 ^-1.425 ^0.015 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.037 ^-1.425 ^0.029 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.025 ^-1.425 ^0.039 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.011 ^-1.425 ^0.046 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.004 ^-1.425 ^0.047 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.02 ^-1.425 ^0.043 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.032 ^-1.425 ^0.034 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal2_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.042 ^-1.425 ^0.021 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.046 ^-1.425 ^0.007 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.046 ^-1.425 ^-0.009 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.041 ^-1.425 ^-0.024 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.031 ^-1.425 ^-0.035 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.017 ^-1.425 ^-0.044 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.002 ^-1.425 ^-0.047 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.013 ^-1.425 ^-0.045 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal2_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.027 ^-1.425 ^-0.038 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.038 ^-1.425 ^-0.027 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.045 ^-1.425 ^-0.013 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.047 ^-1.425 ^0.002 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.043 ^-1.425 ^0.018 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.035 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.023 ^-1.425 ^0.041 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.009 ^-1.425 ^0.046 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal2_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.007 ^-1.425 ^0.046 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.022 ^-1.425 ^0.042 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.034 ^-1.425 ^0.032 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.043 ^-1.425 ^0.019 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.047 ^-1.425 ^0.004 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.045 ^-1.425 ^-0.011 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.039 ^-1.425 ^-0.026 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.029 ^-1.425 ^-0.037 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal2_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.015 ^-1.425 ^-0.044 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^-0.047 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.016 ^-1.425 ^-0.044 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.029 ^-1.425 ^-0.037 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.04 ^-1.425 ^-0.025 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.046 ^-1.425 ^-0.011 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.047 ^-1.425 ^0.005 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.042 ^-1.425 ^0.02 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^0.034 ^-1.425 ^0.033 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_root_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal3_root_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal3_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.01 ^-1.425 ^0.03 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.019 ^-1.425 ^0.025 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.026 ^-1.425 ^0.017 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.03 ^-1.425 ^0.007 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.031 ^-1.425 ^-0.003 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.028 ^-1.425 ^-0.013 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.023 ^-1.425 ^-0.022 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal3_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.014 ^-1.425 ^-0.028 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.004 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.006 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.016 ^-1.425 ^-0.027 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.024 ^-1.425 ^-0.02 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.029 ^-1.425 ^-0.012 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.031 ^-1.425 ^-0.001 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.03 ^-1.425 ^0.009 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal3_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.025 ^-1.425 ^0.018 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.018 ^-1.425 ^0.026 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.009 ^-1.425 ^0.03 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.002 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.012 ^-1.425 ^0.029 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.021 ^-1.425 ^0.024 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.027 ^-1.425 ^0.016 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.031 ^-1.425 ^0.006 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal3_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.031 ^-1.425 ^-0.005 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.028 ^-1.425 ^-0.014 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.021 ^-1.425 ^-0.023 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.013 ^-1.425 ^-0.028 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.003 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.008 ^-1.425 ^-0.03 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.017 ^-1.425 ^-0.026 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.025 ^-1.425 ^-0.019 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal3_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.03 ^-1.425 ^-0.01 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.029 ^-1.425 ^0.01 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.024 ^-1.425 ^0.019 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.017 ^-1.425 ^0.026 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.007 ^-1.425 ^0.03 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.003 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.013 ^-1.425 ^0.028 ~ ~
							}
							execute if score .this aj.frame matches 40 run tp @s ^-0.022 ^-1.425 ^0.022 ~ ~
						}
					}
					execute store result entity @s Air short 1 run scoreboard players get .this aj.frame
				}
				# Bone Displays
				execute if entity @s[type=minecraft:armor_stand] run {
					name tree/display_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/897_display_0-40
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/body_display_0-40
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/leftarm_display_0-40
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/rightleg_display_0-40
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/leftleg_display_0-40
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/flower_display_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/flower_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [0f,19.102f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,38.2041f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [0f,57.3061f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [0f,76.4082f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [-180f,84.4898f,180f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-180f,65.3878f,180f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-180f,46.2857f,180f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/flower_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-180f,27.1837f,180f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-180f,8.0816f,180f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-180f,-11.0204f,180f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-180f,-30.1224f,180f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-180f,-49.2245f,180f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-180f,-68.3265f,180f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-180f,-87.4286f,180f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,-73.4694f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/flower_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [0f,-54.3673f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [0f,-35.2653f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [0f,-16.1633f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,2.9388f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,22.0408f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [0f,41.1429f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [0f,60.2449f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [0f,79.3469f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/flower_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [-180f,81.551f,180f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [-180f,62.449f,180f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [-180f,43.3469f,180f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [-180f,24.2449f,180f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [-180f,5.1429f,180f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [-180f,-13.9592f,180f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [-180f,-33.0612f,180f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [-180f,-52.1633f,180f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/flower_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [-180f,-71.2653f,180f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [0f,-89.6327f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [0f,-70.5306f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,-51.4286f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [0f,-32.3265f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [0f,-13.2245f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [0f,5.8776f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,24.9796f,0f]
							}
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,44.0816f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal4_display_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal4_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [0f,19.102f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,38.2041f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [0f,57.3061f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [0f,76.4082f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [-180f,84.4898f,180f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-180f,65.3878f,180f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-180f,46.2857f,180f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal4_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-180f,27.1837f,180f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-180f,8.0816f,180f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-180f,-11.0204f,180f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-180f,-30.1224f,180f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-180f,-49.2245f,180f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-180f,-68.3265f,180f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-180f,-87.4286f,180f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,-73.4694f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal4_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [0f,-54.3673f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [0f,-35.2653f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [0f,-16.1633f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,2.9388f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,22.0408f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [0f,41.1429f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [0f,60.2449f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [0f,79.3469f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal4_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [-180f,81.551f,180f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [-180f,62.449f,180f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [-180f,43.3469f,180f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [-180f,24.2449f,180f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [-180f,5.1429f,180f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [-180f,-13.9592f,180f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [-180f,-33.0612f,180f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [-180f,-52.1633f,180f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal4_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [-180f,-71.2653f,180f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [0f,-89.6327f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [0f,-70.5306f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,-51.4286f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [0f,-32.3265f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [0f,-13.2245f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [0f,5.8776f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,24.9796f,0f]
							}
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,44.0816f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal1_display_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal1_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,-90f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [0f,-70.898f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,-51.7959f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [0f,-32.6939f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [0f,-13.5918f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,5.5102f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [0f,24.6122f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [0f,43.7143f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal1_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [0f,62.8163f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [0f,81.9184f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-180f,78.9796f,180f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-180f,59.8776f,180f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-180f,40.7755f,180f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-180f,21.6735f,180f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-180f,2.5714f,180f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [-180f,-16.5306f,180f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal1_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [-180f,-35.6327f,180f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [-180f,-54.7347f,180f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [-180f,-73.8367f,180f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,-87.0612f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [0f,-67.9592f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [0f,-48.8571f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [0f,-29.7551f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [0f,-10.6531f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal1_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [0f,8.449f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,27.551f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [0f,46.6531f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [0f,65.7551f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [0f,84.8571f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [-180f,76.0408f,180f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [-180f,56.9388f,180f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [-180f,37.8367f,180f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal1_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [-180f,18.7347f,180f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [-180f,-0.3673f,180f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [-180f,-19.4694f,180f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [-180f,-38.5714f,180f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [-180f,-57.6735f,180f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [-180f,-76.7755f,180f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [0f,-84.1224f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,-65.0204f,0f]
							}
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [0f,-45.9184f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal2_display_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal2_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-180f,0f,180f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [-180f,-19.102f,180f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-180f,-38.2041f,180f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [-180f,-57.3061f,180f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [-180f,-76.4082f,180f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,-84.4898f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [0f,-65.3878f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [0f,-46.2857f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal2_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [0f,-27.1837f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [0f,-8.0816f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [0f,11.0204f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [0f,30.1224f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [0f,49.2245f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [0f,68.3265f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [0f,87.4286f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [-180f,73.4694f,180f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal2_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [-180f,54.3673f,180f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [-180f,35.2653f,180f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [-180f,16.1633f,180f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-180f,-2.9388f,180f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-180f,-22.0408f,180f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [-180f,-41.1429f,180f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [-180f,-60.2449f,180f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [-180f,-79.3469f,180f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal2_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [0f,-81.551f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,-62.449f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [0f,-43.3469f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [0f,-24.2449f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [0f,-5.1429f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [0f,13.9592f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [0f,33.0612f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [0f,52.1633f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal2_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [0f,71.2653f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [-180f,89.6327f,180f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [-180f,70.5306f,180f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [-180f,51.4286f,180f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [-180f,32.3265f,180f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [-180f,13.2245f,180f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [-180f,-5.8776f,180f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [-180f,-24.9796f,180f]
							}
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [-180f,-44.0816f,180f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_display_top
						execute if score .this aj.frame matches 0..40 run {
							name tree/petal3_display_0-40
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal3_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,90f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [-180f,70.898f,180f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-180f,51.7959f,180f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [-180f,32.6939f,180f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [-180f,13.5918f,180f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [-180f,-5.5102f,180f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-180f,-24.6122f,180f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-180f,-43.7143f,180f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal3_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-180f,-62.8163f,180f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-180f,-81.9184f,180f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [0f,-78.9796f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [0f,-59.8776f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [0f,-40.7755f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [0f,-21.6735f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [0f,-2.5714f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,16.5306f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal3_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [0f,35.6327f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [0f,54.7347f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [0f,73.8367f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-180f,87.0612f,180f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-180f,67.9592f,180f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [-180f,48.8571f,180f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [-180f,29.7551f,180f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [-180f,10.6531f,180f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal3_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [-180f,-8.449f,180f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [-180f,-27.551f,180f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [-180f,-46.6531f,180f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [-180f,-65.7551f,180f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [-180f,-84.8571f,180f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [0f,-76.0408f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [0f,-56.9388f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [0f,-37.8367f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal3_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [0f,-18.7347f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [0f,0.3673f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [0f,19.4694f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,38.5714f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [0f,57.6735f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [0f,76.7755f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [-180f,84.1224f,180f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [-180f,65.0204f,180f]
							}
							execute if score .this aj.frame matches 40 run data modify entity @s Pose.Head set value [-180f,45.9184f,180f]
						}
					}
					# Make sure rotation stays aligned with root entity
					execute positioned as @s run tp @s ~ ~ ~ ~ ~
				}
			}
			# Increment frame
			scoreboard players operation @s aj.frame += .aj.peary_java.framerate aj.i
			# Let the anim_loop know we're still running
			scoreboard players set .aj.animation aj.peary_java.animating 1
			# If (the next frame is the end of the animation) perform the necessary actions for the loop mode of the animation
			execute unless score @s aj.frame matches 0..41 run function peary_java:animations/animation.peary.flying/edge
		}
		# Performs a loop mode action depending on what the animation's configured loop mode is
		function edge {
			# Play Once
			execute if score @s aj.peary_java.animation.peary.flying.loopMode matches 0 run function peary_java:animations/animation.peary.flying/stop
			# Hold on last frame
			execute if score @s aj.peary_java.animation.peary.flying.loopMode matches 1 run function peary_java:animations/animation.peary.flying/pause
			# loop
			execute if score @s aj.peary_java.animation.peary.flying.loopMode matches 2 run {
				execute (if score @s aj.frame matches ..1) {
					scoreboard players set @s aj.frame 41
				} else {
					scoreboard players set @s aj.frame 0
				}
			}
		}
	}
	dir animation.peary.walk {
		# Starts the animation from the first frame
		function play {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s add aj.peary_java.anim.animation.peary.walk
				# Reset animation time
				execute if score .aj.peary_java.framerate aj.i matches ..-1 run scoreboard players set @s aj.frame 40
				execute if score .aj.peary_java.framerate aj.i matches 1.. run scoreboard players set @s aj.frame 0
				# Assert that .noScripts is tracked properly
				scoreboard players add .noScripts aj.i 0
				# Start the animation loop if not running
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.walk/play ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Stops the animation and resets to first frame
		function stop {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s remove aj.peary_java.anim.animation.peary.walk
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# load initial animation frame without running scripts
				scoreboard players operation .oldValue aj.i = .noScripts aj.i
				scoreboard players set .noScripts aj.i 1
				function peary_java:animations/animation.peary.walk/next_frame
				scoreboard players operation .noScripts aj.i = .oldValue aj.i
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.walk/stop ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Pauses the animation on the current frame
		function pause {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Remove animation tag
				tag @s remove aj.peary_java.anim.animation.peary.walk
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.walk/pause ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Resumes the animation from the current frame
		function resume {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root]) {
				# Remove animation tag
				tag @s add aj.peary_java.anim.animation.peary.walk
				# Start the animation loop
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.walk/resume ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Plays the next frame in the animation
		function next_frame {
			scoreboard players operation .this aj.id = @s aj.id
			scoreboard players operation .this aj.frame = @s aj.frame
			execute rotated ~ 0 as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone,distance=..1.49] if score @s aj.id = .this aj.id run {
				name tree/trunk
				# Bone Roots
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					name tree/root_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/897_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/897_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/897_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/897_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/body_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/body_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/body_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/body_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/body_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/body_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/leftarm_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftarm_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftarm_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftarm_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/rightleg_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/rightleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/rightleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/rightleg_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/rightleg_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/rightleg_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/leftleg_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftleg_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftleg_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftleg_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/flower_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/flower_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/flower_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/flower_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/flower_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/flower_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal4_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal4_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal4_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal4_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal4_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal4_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal1_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal1_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal1_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal1_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal1_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal1_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal2_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal2_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal2_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal2_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal2_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal2_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_root_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal3_root_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal3_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal3_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/petal3_root_16-23
								execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 20 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 21 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 22 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 23 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/petal3_root_24-31
								execute if score .this aj.frame matches 24 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 25 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 26 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 27 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 28 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 29 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 30 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 31 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/petal3_root_32-39
								execute if score .this aj.frame matches 32 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 33 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 34 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 35 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 36 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 37 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 38 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 39 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
						}
					}
					execute store result entity @s Air short 1 run scoreboard players get .this aj.frame
				}
				# Bone Displays
				execute if entity @s[type=minecraft:armor_stand] run {
					name tree/display_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/897_display_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [18f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/897_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [-18f,0f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/897_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [36f,0f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/897_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [-10.2f,0f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [-20.4f,0f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [-30.6f,0f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [-40.8f,0f,0f]
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/body_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/leftarm_display_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-18f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftarm_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [18f,0f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftarm_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [-36f,0f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftarm_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [10.2f,0f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [20.4f,0f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [30.6f,0f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [40.8f,0f,0f]
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/rightleg_display_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/rightleg_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [-18f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/rightleg_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/rightleg_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [8.25f,0f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [16.5f,0f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [24.75f,0f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [33f,0f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [41.25f,0f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [33f,0f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [24.75f,0f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [16.5f,0f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/rightleg_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [8.25f,0f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [-36f,0f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/rightleg_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [8.25f,0f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [16.5f,0f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [24.75f,0f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [33f,0f,0f]
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/leftleg_display_0-39
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftleg_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-45f,0f,0f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [-36f,0f,0f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-27f,0f,0f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [-18f,0f,0f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [-9f,0f,0f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [18f,0f,0f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftleg_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,0f]
							}
							execute if score .this aj.frame matches 16..23 run {
								name tree/leftleg_display_16-23
								execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [-8.25f,0f,0f]
								execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [-16.5f,0f,0f]
								execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [-24.75f,0f,0f]
								execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-33f,0f,0f]
								execute if score .this aj.frame matches 20 run data modify entity @s Pose.Head set value [-41.25f,0f,0f]
								execute if score .this aj.frame matches 21 run data modify entity @s Pose.Head set value [-33f,0f,0f]
								execute if score .this aj.frame matches 22 run data modify entity @s Pose.Head set value [-24.75f,0f,0f]
								execute if score .this aj.frame matches 23 run data modify entity @s Pose.Head set value [-16.5f,0f,0f]
							}
							execute if score .this aj.frame matches 24..31 run {
								name tree/leftleg_display_24-31
								execute if score .this aj.frame matches 24 run data modify entity @s Pose.Head set value [-8.25f,0f,0f]
								execute if score .this aj.frame matches 25 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 26 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 27 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 28 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 29 run data modify entity @s Pose.Head set value [36f,0f,0f]
								execute if score .this aj.frame matches 30 run data modify entity @s Pose.Head set value [45f,0f,0f]
								execute if score .this aj.frame matches 31 run data modify entity @s Pose.Head set value [36f,0f,0f]
							}
							execute if score .this aj.frame matches 32..39 run {
								name tree/leftleg_display_32-39
								execute if score .this aj.frame matches 32 run data modify entity @s Pose.Head set value [27f,0f,0f]
								execute if score .this aj.frame matches 33 run data modify entity @s Pose.Head set value [18f,0f,0f]
								execute if score .this aj.frame matches 34 run data modify entity @s Pose.Head set value [9f,0f,0f]
								execute if score .this aj.frame matches 35 run data modify entity @s Pose.Head set value [0f,0f,0f]
								execute if score .this aj.frame matches 36 run data modify entity @s Pose.Head set value [-8.25f,0f,0f]
								execute if score .this aj.frame matches 37 run data modify entity @s Pose.Head set value [-16.5f,0f,0f]
								execute if score .this aj.frame matches 38 run data modify entity @s Pose.Head set value [-24.75f,0f,0f]
								execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [-33f,0f,0f]
							}
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/flower_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal4_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal1_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,-90f,0f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,-90f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal2_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-180f,0f,180f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [-180f,0f,180f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_display_top
						execute if score .this aj.frame matches 0..39 run {
							name tree/petal3_display_0-39
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,90f,0f]
							execute if score .this aj.frame matches 39 run data modify entity @s Pose.Head set value [0f,90f,0f]
						}
					}
					# Make sure rotation stays aligned with root entity
					execute positioned as @s run tp @s ~ ~ ~ ~ ~
				}
			}
			# Increment frame
			scoreboard players operation @s aj.frame += .aj.peary_java.framerate aj.i
			# Let the anim_loop know we're still running
			scoreboard players set .aj.animation aj.peary_java.animating 1
			# If (the next frame is the end of the animation) perform the necessary actions for the loop mode of the animation
			execute unless score @s aj.frame matches 0..40 run function peary_java:animations/animation.peary.walk/edge
		}
		# Performs a loop mode action depending on what the animation's configured loop mode is
		function edge {
			# Play Once
			execute if score @s aj.peary_java.animation.peary.walk.loopMode matches 0 run function peary_java:animations/animation.peary.walk/stop
			# Hold on last frame
			execute if score @s aj.peary_java.animation.peary.walk.loopMode matches 1 run function peary_java:animations/animation.peary.walk/pause
			# loop
			execute if score @s aj.peary_java.animation.peary.walk.loopMode matches 2 run {
				execute (if score @s aj.frame matches ..1) {
					scoreboard players set @s aj.frame 40
				} else {
					scoreboard players set @s aj.frame 0
				}
			}
		}
	}
	dir animation.peary.holding {
		# Starts the animation from the first frame
		function play {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s add aj.peary_java.anim.animation.peary.holding
				# Reset animation time
				execute if score .aj.peary_java.framerate aj.i matches ..-1 run scoreboard players set @s aj.frame 3
				execute if score .aj.peary_java.framerate aj.i matches 1.. run scoreboard players set @s aj.frame 0
				# Assert that .noScripts is tracked properly
				scoreboard players add .noScripts aj.i 0
				# Start the animation loop if not running
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.holding/play ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Stops the animation and resets to first frame
		function stop {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s remove aj.peary_java.anim.animation.peary.holding
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# load initial animation frame without running scripts
				scoreboard players operation .oldValue aj.i = .noScripts aj.i
				scoreboard players set .noScripts aj.i 1
				function peary_java:animations/animation.peary.holding/next_frame
				scoreboard players operation .noScripts aj.i = .oldValue aj.i
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.holding/stop ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Pauses the animation on the current frame
		function pause {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Remove animation tag
				tag @s remove aj.peary_java.anim.animation.peary.holding
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.holding/pause ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Resumes the animation from the current frame
		function resume {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root]) {
				# Remove animation tag
				tag @s add aj.peary_java.anim.animation.peary.holding
				# Start the animation loop
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.holding/resume ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Plays the next frame in the animation
		function next_frame {
			scoreboard players operation .this aj.id = @s aj.id
			scoreboard players operation .this aj.frame = @s aj.frame
			execute rotated ~ 0 as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone,distance=..1.49] if score @s aj.id = .this aj.id run {
				name tree/trunk
				# Bone Roots
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					name tree/root_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/897_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/body_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.563 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/leftarm_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/rightleg_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0.063 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/leftleg_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/flower_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal4_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal1_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal2_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0.047 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_root_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal3_root_0-2
							execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0.031 ~ ~
						}
					}
					execute store result entity @s Air short 1 run scoreboard players get .this aj.frame
				}
				# Bone Displays
				execute if entity @s[type=minecraft:armor_stand] run {
					name tree/display_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/897_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-90f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-90f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/body_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/leftarm_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-90f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-90f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/rightleg_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/leftleg_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/flower_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal4_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal1_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,-90f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,-90f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal2_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-180f,0f,180f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [-180f,0f,180f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_display_top
						execute if score .this aj.frame matches 0..2 run {
							name tree/petal3_display_0-2
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,90f,0f]
							execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,90f,0f]
						}
					}
					# Make sure rotation stays aligned with root entity
					execute positioned as @s run tp @s ~ ~ ~ ~ ~
				}
			}
			# Increment frame
			scoreboard players operation @s aj.frame += .aj.peary_java.framerate aj.i
			# Let the anim_loop know we're still running
			scoreboard players set .aj.animation aj.peary_java.animating 1
			# If (the next frame is the end of the animation) perform the necessary actions for the loop mode of the animation
			execute unless score @s aj.frame matches 0..3 run function peary_java:animations/animation.peary.holding/edge
		}
		# Performs a loop mode action depending on what the animation's configured loop mode is
		function edge {
			# Play Once
			execute if score @s aj.peary_java.animation.peary.holding.loopMode matches 0 run function peary_java:animations/animation.peary.holding/stop
			# Hold on last frame
			execute if score @s aj.peary_java.animation.peary.holding.loopMode matches 1 run function peary_java:animations/animation.peary.holding/pause
			# loop
			execute if score @s aj.peary_java.animation.peary.holding.loopMode matches 2 run {
				execute (if score @s aj.frame matches ..1) {
					scoreboard players set @s aj.frame 3
				} else {
					scoreboard players set @s aj.frame 0
				}
			}
		}
	}
	dir animation.peary.cheer {
		# Starts the animation from the first frame
		function play {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s add aj.peary_java.anim.animation.peary.cheer
				# Reset animation time
				execute if score .aj.peary_java.framerate aj.i matches ..-1 run scoreboard players set @s aj.frame 20
				execute if score .aj.peary_java.framerate aj.i matches 1.. run scoreboard players set @s aj.frame 0
				# Assert that .noScripts is tracked properly
				scoreboard players add .noScripts aj.i 0
				# Start the animation loop if not running
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.cheer/play ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Stops the animation and resets to first frame
		function stop {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Add animation tag
				tag @s remove aj.peary_java.anim.animation.peary.cheer
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# load initial animation frame without running scripts
				scoreboard players operation .oldValue aj.i = .noScripts aj.i
				scoreboard players set .noScripts aj.i 1
				function peary_java:animations/animation.peary.cheer/next_frame
				scoreboard players operation .noScripts aj.i = .oldValue aj.i
				# Reset animation time
				scoreboard players set @s aj.frame 0
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.cheer/stop ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Pauses the animation on the current frame
		function pause {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root] at @s) {
				# Remove animation tag
				tag @s remove aj.peary_java.anim.animation.peary.cheer
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.cheer/pause ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Resumes the animation from the current frame
		function resume {
			# Make sure this function has been ran as the root entity
			execute(if entity @s[tag=aj.peary_java.root]) {
				# Remove animation tag
				tag @s add aj.peary_java.anim.animation.peary.cheer
				# Start the animation loop
				execute if score .aj.anim_loop aj.peary_java.animating matches 0 run function peary_java:animation_loop
				# If this entity is not the root
			} else {
				tellraw @s [["",{"text":"[ ","color":"dark_gray"},{"text":"AJ","color":"green"},{"text":" → ","color":"light_purple"},{"text":"Error ☠","color":"red"},{"text":" ]","color":"dark_gray"},"\n"],{"text":"→ ","color":"red"},{"text":"The function ","color":"gray"},{"text":"peary_java:animations/animation.peary.cheer/resume ","color":"yellow"},{"text":"must be","color":"gray"},"\n",{"text":"executed as @e[tag=aj.peary_java.root]","color":"light_purple"}]
			}
		}
		# Plays the next frame in the animation
		function next_frame {
			scoreboard players operation .this aj.id = @s aj.id
			scoreboard players operation .this aj.frame = @s aj.frame
			execute rotated ~ 0 as @e[type=#peary_java:bone_entities,tag=aj.peary_java.bone,distance=..1.49] if score @s aj.id = .this aj.id run {
				name tree/trunk
				# Bone Roots
				execute if entity @s[type=minecraft:area_effect_cloud] run {
					name tree/root_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/897_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/body_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/body_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/body_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.563 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.563 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.563 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.563 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/leftarm_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.125 ^-1.532 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/rightleg_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/rightleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/rightleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.063 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.063 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.063 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/leftleg_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftleg_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftleg_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.062 ^-1.688 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/flower_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/flower_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/flower_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal4_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal4_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal4_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^-0.031 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal1_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal1_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal1_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^-0.031 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal2_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal2_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal2_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0.047 ^-1.425 ^0 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0.047 ^-1.425 ^0 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0.047 ^-1.425 ^0 ~ ~
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_root_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal3_root_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/petal3_root_0-7
								execute if score .this aj.frame matches 0 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 1 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 2 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 3 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 4 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 5 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 6 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 7 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/petal3_root_8-15
								execute if score .this aj.frame matches 8 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 9 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 10 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 11 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 12 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 13 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 14 run tp @s ^0 ^-1.425 ^0.031 ~ ~
								execute if score .this aj.frame matches 15 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							}
							execute if score .this aj.frame matches 16 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 17 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 18 run tp @s ^0 ^-1.425 ^0.031 ~ ~
							execute if score .this aj.frame matches 19 run tp @s ^0 ^-1.425 ^0.031 ~ ~
						}
					}
					execute store result entity @s Air short 1 run scoreboard players get .this aj.frame
				}
				# Bone Displays
				execute if entity @s[type=minecraft:armor_stand] run {
					name tree/display_bone_name
					execute if entity @s[tag=aj.peary_java.bone.897] run {
						name tree/897_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/897_display_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/897_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,-135f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [0f,0f,-133f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,-131f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [0f,0f,-129f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [0f,0f,-127f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,-125f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [0f,0f,-127f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [0f,0f,-129f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/897_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [0f,0f,-131f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [0f,0f,-133f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [0f,0f,-135f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [0f,0f,-133f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [0f,0f,-131f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [0f,0f,-129f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [0f,0f,-127f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,-125f]
							}
							execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [0f,0f,-127f]
							execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [0f,0f,-129f]
							execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [0f,0f,-131f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,-133f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.body] run {
						name tree/body_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/body_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftarm] run {
						name tree/leftarm_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/leftarm_display_0-19
							execute if score .this aj.frame matches 0..7 run {
								name tree/leftarm_display_0-7
								execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,135f]
								execute if score .this aj.frame matches 1 run data modify entity @s Pose.Head set value [0f,0f,130f]
								execute if score .this aj.frame matches 2 run data modify entity @s Pose.Head set value [0f,0f,125f]
								execute if score .this aj.frame matches 3 run data modify entity @s Pose.Head set value [0f,0f,120f]
								execute if score .this aj.frame matches 4 run data modify entity @s Pose.Head set value [0f,0f,115f]
								execute if score .this aj.frame matches 5 run data modify entity @s Pose.Head set value [0f,0f,110f]
								execute if score .this aj.frame matches 6 run data modify entity @s Pose.Head set value [0f,0f,115f]
								execute if score .this aj.frame matches 7 run data modify entity @s Pose.Head set value [0f,0f,120f]
							}
							execute if score .this aj.frame matches 8..15 run {
								name tree/leftarm_display_8-15
								execute if score .this aj.frame matches 8 run data modify entity @s Pose.Head set value [0f,0f,125f]
								execute if score .this aj.frame matches 9 run data modify entity @s Pose.Head set value [0f,0f,130f]
								execute if score .this aj.frame matches 10 run data modify entity @s Pose.Head set value [0f,0f,135f]
								execute if score .this aj.frame matches 11 run data modify entity @s Pose.Head set value [0f,0f,130f]
								execute if score .this aj.frame matches 12 run data modify entity @s Pose.Head set value [0f,0f,125f]
								execute if score .this aj.frame matches 13 run data modify entity @s Pose.Head set value [0f,0f,120f]
								execute if score .this aj.frame matches 14 run data modify entity @s Pose.Head set value [0f,0f,115f]
								execute if score .this aj.frame matches 15 run data modify entity @s Pose.Head set value [0f,0f,110f]
							}
							execute if score .this aj.frame matches 16 run data modify entity @s Pose.Head set value [0f,0f,115f]
							execute if score .this aj.frame matches 17 run data modify entity @s Pose.Head set value [0f,0f,120f]
							execute if score .this aj.frame matches 18 run data modify entity @s Pose.Head set value [0f,0f,125f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,130f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.rightleg] run {
						name tree/rightleg_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/rightleg_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.leftleg] run {
						name tree/leftleg_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/leftleg_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.flower] run {
						name tree/flower_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/flower_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal4] run {
						name tree/petal4_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal4_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,0f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,0f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal1] run {
						name tree/petal1_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal1_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,-90f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,-90f,0f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal2] run {
						name tree/petal2_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal2_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [-180f,0f,180f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [-180f,0f,180f]
						}
					}
					execute if entity @s[tag=aj.peary_java.bone.petal3] run {
						name tree/petal3_display_top
						execute if score .this aj.frame matches 0..19 run {
							name tree/petal3_display_0-19
							execute if score .this aj.frame matches 0 run data modify entity @s Pose.Head set value [0f,90f,0f]
							execute if score .this aj.frame matches 19 run data modify entity @s Pose.Head set value [0f,90f,0f]
						}
					}
					# Make sure rotation stays aligned with root entity
					execute positioned as @s run tp @s ~ ~ ~ ~ ~
				}
			}
			# Increment frame
			scoreboard players operation @s aj.frame += .aj.peary_java.framerate aj.i
			# Let the anim_loop know we're still running
			scoreboard players set .aj.animation aj.peary_java.animating 1
			# If (the next frame is the end of the animation) perform the necessary actions for the loop mode of the animation
			execute unless score @s aj.frame matches 0..20 run function peary_java:animations/animation.peary.cheer/edge
		}
		# Performs a loop mode action depending on what the animation's configured loop mode is
		function edge {
			# Play Once
			execute if score @s aj.peary_java.animation.peary.cheer.loopMode matches 0 run function peary_java:animations/animation.peary.cheer/stop
			# Hold on last frame
			execute if score @s aj.peary_java.animation.peary.cheer.loopMode matches 1 run function peary_java:animations/animation.peary.cheer/pause
			# loop
			execute if score @s aj.peary_java.animation.peary.cheer.loopMode matches 2 run {
				execute (if score @s aj.frame matches ..1) {
					scoreboard players set @s aj.frame 20
				} else {
					scoreboard players set @s aj.frame 0
				}
			}
		}
	}
}