package oop.differentThings.weapons;

public class Main {
    public static void main(String[] args) {
        Gun gun1 = new Gun(7);
        gun1.loadBullets(3);

        for (int i=0; i<5; i++) gun1.makeShot();
            gun1.loadBullets(8);

        for (int i=0; i<2; i++) gun1.makeShot();
            gun1.removeBullet();

        gun1.makeShot();
        MachineGun mg1 = new MachineGun(20, 5);
        mg1.loadBullets(19);
        mg1.makeShot(6);
    }
}
