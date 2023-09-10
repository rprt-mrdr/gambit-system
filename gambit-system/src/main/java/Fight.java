public class Fight {

    Fighter f1;
    Fighter f2;

    Fight() {
        f1 = new Fighter("Soju");
        f1.print();
        f2 = new Fighter("Bones");
        f2.print();
        while (f1.alive && f2.alive) {
            f1.meleeAttack(f2);
            f2.meleeAttack(f1);
        }
    }

}
