package micdoodle8.mods.galacticraft.api.world;

import micdoodle8.mods.galacticraft.api.entity.IRocketType;

public interface IGalacticraftWorldProvider
{
    /**
     * gets additional gravity to add to players in this dimension. Typical
     * values range from 0.040 to 0.065
     * 
     * @return additional gravity for this provider
     */
    public float getGravity();

    /**
     * Determines the rate to spawn meteors in this planet. Lower means MORE
     * meteors.
     * 
     * Typical value would be about 7. Return 0 for no meteors.
     * 
     * @return
     */
    public double getMeteorFrequency();

    /**
     * Depending on gravity, different fuel depletion rates will occur in
     * spacecraft (less force required to lift)
     * 
     * @return multiplier of fuel usage, relative to the earth. Lower gravity =
     *         Lower fuel usage (multiplier less than zero)
     */
    public double getFuelUsageMultiplier();

    /**
     * Whether or not the spaceship tier from {@link IRocketType} can enter this
     * dimension
     * 
     * @param tier
     *            The tier of the spaceship entering this dimension
     * @return Whether or not the spaceship with given tier can enter this
     *         dimension
     */
    public boolean canSpaceshipTierPass(int tier);
}
