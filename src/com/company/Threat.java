package com.company;

/**
 * Created by owenryan on 27/03/2017.
 */
public class Threat
{
    private int distanceToTarget;
    private int targetIndex;
    private boolean isInSight;

    public Threat(int distanceToTargetin)
    {
        distanceToTarget = distanceToTargetin;
        targetIndex = 0; //the front of the group
        isInSight = true;
    }

    public Threat(int distanceToTargetin, int targetIndexin, boolean isInSightin)
    {
        distanceToTarget = distanceToTargetin;
        targetIndex = targetIndexin;
        isInSight = isInSightin;
    }

}
