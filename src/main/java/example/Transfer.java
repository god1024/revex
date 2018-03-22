package example;


import example.internal.Account;
import example.internal.InMemDummyAccountManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("transfer")
public class Transfer
{
    @GET
    @Path("transfer")
    @Produces(MediaType.APPLICATION_JSON)
    public Result transfer(@QueryParam("fromAccount") int fromAccount, @QueryParam("toAccount") int toAccount , @QueryParam("amount") double amount)
    {
        final Account from = InMemDummyAccountManager.instance.getAccount(fromAccount);
        final Account to = InMemDummyAccountManager.instance.getAccount(toAccount);

        final Object lock1;
        final Object lock2;

        if (from.getAccountNumber() < to.getAccountNumber())
        {
            lock1 = from;
            lock2 = to;
        }
        else
        {
            lock1 = to;
            lock2 = from;
        }
        synchronized (lock1)
        {
            synchronized (lock2)
            {
                from.add(-amount);
                to.add(amount);
            }
        }

        Result result = new Result();
        result.done = true;
        return result;
    }


    static class Result
    {
        boolean done;

        public boolean isDone()
        {
            return done;
        }

        public void setDone(boolean done)
        {
            this.done = done;
        }
    }
}
