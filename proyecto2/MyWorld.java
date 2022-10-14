import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {  
        buildPared();
        addItems();
        buildPacman();
    }
    
    private void addItems(){
        addObject(new pumpkin(),177,102);
        addObject(new pumpkin(),177,202);
        addObject(new pumpkin(),177,302);
        addObject(new Cherry(),347,102);
        addObject(new Cherry(),347,202);
        addObject(new StrawBerry(),542,102);
        addObject(new StrawBerry(),542,202);
        addObject(new StrawBerry(),542,302);
    }
    
    private void buildPacman(){
        Pacman pacman = new Pacman();
        addObject(pacman,60,95);
    }
    
    private void buildPared(){
         for(int y = 40; y < 300; y+=50){
            Pared pared = new Pared();
            addObject(pared,291,y);   
        }

        for(int x = 24; x < 600; x+=50){
            Pared paredx = new Pared();
            addObject(paredx,x,40);
        }

        for(int x = 24; x < 600; x+=50){
            Pared paredx = new Pared();
            addObject(paredx,x,394);
        }

        for(int y = 90; y < 500; y+=50){
            Pared pared = new Pared();
            addObject(pared,0,y);   
        }

        for(int y = 90; y < 500; y+=50){
            Pared pared = new Pared();
            addObject(pared,700,y);   
        }
    }
}
