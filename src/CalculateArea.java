class CalculateArea {
    void area(int length){
        System.out.print(length*2);
    }
    void area(int length , int width) {
        System.out.println(length*width);
    }
    public static void main(String args[]){
        CalculateArea obj=new CalculateArea();
        obj.area(10);
        obj.area(20,20);
    }
}