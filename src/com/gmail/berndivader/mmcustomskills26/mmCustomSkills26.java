package com.gmail.berndivader.mmcustomskills26;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMechanicLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;

public class mmCustomSkills26 implements Listener {
	
	private String MechName;
	private SkillMechanic skill;
	
	@EventHandler
	public void onMMSkillLoad(MythicMechanicLoadEvent e) {
		MechName = e.getMechanicName().toLowerCase();
		if (MechName.equals("damagearmor")) {
			skill = new mmDamageArmorSkill(e.getContainer(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("grenade")) {
			skill = new mmGrenadeSkill(e.getContainer(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("setrandomlevel")) {
			skill = new mmRandomLevelSkill(e.getContainer(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("steal")) {
			skill = new mmStealSkill(e.getContainer(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("dropstolenitems")) {
			skill = new mmDropStolenItems(e.getContainer(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("equipskull")) {
			skill = new mmEquipFix(e.getContainer().getConfigLine(),e.getConfig());
			e.register(skill);
		} else if (MechName.equals("endereffect")) {
			skill = new mmEnderEffect(e.getContainer().getConfigLine(),e.getConfig());
			e.register(skill);
		} else if (MechName.equals("customdamage")) {
			skill = new mmCustomDamage(e.getContainer().getConfigLine(),e.getConfig());
			e.register(skill);
		} else if (MechName.equals("cure") || MechName.equals("removepotion")) {
			skill = new mmRemovePotionEffect(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("feed")) {
			skill = new mmFeedSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("oxygen")) {
			skill = new mmOxygenSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("customsummon")) {
			skill = new mmCustomSummonSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("stun")) {
			skill = new mmStunSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("customteleport")) {
			skill = new mmCustomTeleportSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("swap")) {
			skill = new mmSwapSkill(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("setthreattarget")) {
			skill=new mmSetThreatTableTarget(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("clearthreattarget")) {
			skill=new mmClearThreatTableTarget(e.getContainer().getConfigLine(), e.getConfig());
			e.register(skill);
		} else if (MechName.equals("customparticleline")) {
			skill=new mmCustomParticleLineEffect(e.getContainer().getConfigLine(),e.getConfig());
			e.register(skill);
		}
	}
	
}
