package com.gmail.berndivader.mmcustomskills26;

import java.util.concurrent.ThreadLocalRandom;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import io.lumine.xikage.mythicmobs.mobs.MobManager;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillCaster;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.mechanics.CustomMechanic;

public class mmRandomLevelSkill extends SkillMechanic implements ITargetedEntitySkill {
	protected MobManager mobmanager;
	protected int min;
	protected int max;
	protected boolean self;

	public mmRandomLevelSkill(CustomMechanic skill, MythicLineConfig mlc) {
		super(skill.getConfigLine(), mlc);
		this.ASYNC_SAFE = false;
		this.mobmanager = Main.getPlugin().getMobManager();
		this.min = mlc.getInteger("min", 1);
		this.max = mlc.getInteger("max", 3);
		this.self = mlc.getBoolean(new String[] { "self", "s" }, true);
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
		int lvl = ThreadLocalRandom.current().nextInt(min, max + 1);

		if (this.self) {
			SkillCaster caster = data.getCaster();
			if (!(caster instanceof ActiveMob)) {
				return false;
			}
			ActiveMob am = (ActiveMob) caster;
			am.setLevel(lvl);
			return true;
		}
		if (target instanceof ActiveMob) {
			ActiveMob am = mobmanager.getMythicMobInstance(target);
			am.setLevel(lvl);
			return true;
		}
		return false;
	}
}
