abstract class A {
    int i;
    abstract void display();
}
class B extends A {
    int j;
    void display() {
        System.out.print(j + " ");
    }
}
class Main {
    public static void main(String args[]) {
        B obj1 = new B();
        obj1.j = 2;
        obj1.display();
        A obj2 = new B();
        obj2.i = 2;
        obj2.display();
    }
}
