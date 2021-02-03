package inner;

/**
 * 内部类：
 * 1、实例内部类
 * 2、静态内部类
 * 3、匿名内部类
 * 4、本地内部类
 */
/*class OutClass { //实例内部类
    public int data1 = 100;
    public int data2;

    class innerClass {
        public int data1 = 10;
        public int data2 = 20;
        public void Teat() {
            System.out.println(data1);// 10
            System.out.println(OutClass.this.data1);// 100 产生了额外的开销
            System.out.println(data2);// 20
        }
    }
} */

//静态内部类
/*class OuterClass {
    public int data1 = 100;
    public int data2;

    static class innerClass {
        public int data1 = 10;
        public int data2 = 20;
        OuterClass outerClass;
        public innerClass(OuterClass out ) {
            this.outerClass = out;
        }

        public void Teat() {
            System.out.println(data1);// 10
            //System.out.println(OutClass.this.data1); x
            System.out.println(data2);// 20
            System.out.println(outerClass.data2);// 100
        }
    }
}*/


class OutClass {
    public void test() {
        System.out.println("holler world");
    }
}
public class TeatDemo {
    public static void main(String[] args) {
        new OutClass(){ // 匿名内部类
            @Override
            public void test() {
                System.out.println("hahhahahaha");
            }
        }.test();
    }
    /*public static void main(String[] args) {
        OuterClass out = new OuterClass();
        OuterClass.innerClass innerClass = new OuterClass.innerClass(out);
        innerClass.Teat();
    }*/

    /*public static void main(String[] args) {
        OutClass outClass = new OutClass();
        OutClass.innerClass innerClass = outClass.new innerClass();
        innerClass.Teat();

    }*/
}
