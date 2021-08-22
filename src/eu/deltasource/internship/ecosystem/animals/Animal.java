package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    protected List<Biomes> inhabitedBiomes = new ArrayList<>();
    protected int age;
    protected int maxAge;
    protected double weight;
    protected Habitat mainHabitat;
    protected int reproductionRate;
    protected LivingTypes livingType;
    protected boolean alive = true;

    public Animal reproduce(){
        try{
            return this.getClass().newInstance();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean checkInhabitedBiomes(String biome){
        for(int i = 0; i < this.inhabitedBiomes.size(); i++){
            if(biome.equalsIgnoreCase(String.valueOf(inhabitedBiomes.get(i)))){
                return true;
            }
        }
        return false;
    }

    public int getReproductionRate() {
        return reproductionRate;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void die(){
        this.alive = false;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public LivingTypes getLivingType() {
        return livingType;
    }
}
