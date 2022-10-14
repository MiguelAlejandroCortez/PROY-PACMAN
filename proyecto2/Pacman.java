import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 5;
    private static final int LEFT_DIRECTION = 1;
    private static final int RIGHT_DIRECTION = 0;
    
    private String [][]images;
    
    private int currentImage = 0;
    private int delayboca = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    private int score;
    private int currentDirection=RIGHT_DIRECTION;
    
    Pacman(){
        images = new String[2][];
        
        images[RIGHT_DIRECTION] = new String[]{
            "images/pacman-close.png",
            "images/pacman-open-right.png"
        };
        images[LEFT_DIRECTION] = new String[]{
            "images/pacman-close.png",
            "images/pacman-open-left.png"
        };
        setImage(images[RIGHT_DIRECTION][currentImage]);
    }
    public void act()
    {
        moverBoca();
        handleKeys();
        
        moveIfNoCollision(offsetX, offsetY);
        showHud();
        eatItems();
    }
    
    private void eatItems(){
        Item item = (Item)getOneIntersectingObject(Item.class); 
        
        if(item != null){
            score+= item.getScore();
            getWorld().removeObject(item);
        }
    }
    
    private void showHud(){
        getWorld().showText(Integer.toString(score),500,30);
    }
    
    private void handleKeys(){
        if(Greenfoot.isKeyDown("Right")){
            offsetY = 0;
            offsetX = OFFSET;
            currentDirection = RIGHT_DIRECTION;
        }else if(Greenfoot.isKeyDown("Left")){
            offsetY = 0;
            offsetX = -OFFSET;
            currentDirection = LEFT_DIRECTION;
        }else if(Greenfoot.isKeyDown("Up")){
            offsetX = 0;
            offsetY  = -OFFSET;
        }else if(Greenfoot.isKeyDown("Down")){
            offsetX = 0;
            offsetY  = OFFSET;
        }
    }
    
    private void moveIfNoCollision(int dx, int dy){
        if(this.getOneObjectAtOffset(dx*6, dy*6, Pared.class) == null){
           setLocation(getX() + dx, getY() + dy);   
        }
    }
    
    private void moverBoca(){
     delayboca++;
        if(delayboca == 10){
            currentImage = (currentImage + 1) % images.length;
            setImage(images[currentDirection][currentImage]);
            delayboca = 0;
        }
    }
}
