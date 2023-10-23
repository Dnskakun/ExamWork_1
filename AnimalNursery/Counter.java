package AnimalNursery;

public class Counter implements AutoCloseable{
    static int count;

    {
        count = 0;
    }

    public void add() {
        count++;
    }

    @Override
    public void close() {
        System.out.println("Счетчик закрыт");
    }

}
