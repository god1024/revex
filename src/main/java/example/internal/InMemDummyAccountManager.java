package example.internal;

public class InMemDummyAccountManager
{
    public static InMemDummyAccountManager instance = new InMemDummyAccountManager();

    public Account getAccount(int accNo)
    {
        return new Account()
        {
            @Override
            public void add(double balance)
            {

            }

            @Override
            public double getBalance()
            {
                return 0;
            }

            @Override
            public int getAccountNumber()
            {
                return 0;
            }
        };
    }
}
