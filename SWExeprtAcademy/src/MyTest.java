class A {
    public void x() {
        System.out.println("I'm public method x");
    }
    
    private void y() {
        System.out.println("I'm private method y");
    }
    
    public void z() {
        this.y();
    }
}

public class MyTest {
    public static void main(String[] args) {
        A a = new A();
        a.x();
        // a.y(); // 이 코드는 에러가 발생한다.
        a.z();
    }
}