class Foo {
    
    private volatile int runStatus = 1;

    public Foo() { }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        runStatus = runStatus + 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(runStatus != 2) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        runStatus = runStatus + 1;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(runStatus != 3) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
        runStatus = runStatus + 1; 
    }
}