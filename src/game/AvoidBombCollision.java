//package game;
//
//import city.cs.engine.*;
//
///**
// * 'AvoidTankCollision - This class looks at the collision between the Tank
// * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
// * occur.
// */
//public class AvoidBombCollision implements CollisionListener {
//    private Tank tank;
//    
//    public AvoidBombCollision(Tank tank) {
//        this.tank = tank;
//    }
//
//    @Override
//    public void collide(CollisionEvent f) {
//        if (f.getOtherBody() instanceof DropBomb && f.getOtherBody() == tank) {
//            f.getOtherBody().destroy();
//        } 
//    }  
//}
