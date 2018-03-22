Revolut "Java/Scala Test" solution.

There were almost no requirments other than:
- Simple code
- No spring (Good!)
- No beefy containers (run as standalone)
- A webservice that mimics money transfer from account A to account B

Therefore I have not implemented any logic other than dummy account implementation. This code only shows that the web service works.

to run the service, type:

gradle run

and then run:

curl "http://localhost:9090/transfer/transfer?fromAccount=16&toAccount=3&amount=1"
