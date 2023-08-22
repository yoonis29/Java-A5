import com.sun.source.tree.TryTree;

import java.util.Optional;

import static java.util.Comparator.comparing;

public class TransactionTest {
    public static void main(String[] args) {
        //1- Find all transaction in 2011 and sort by value
        TransactionData.getAll().stream()
                .filter(transaction -> transaction.getYear()==2011 )
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        //2 - What are all the unique cities where the traders work?

        System.out.println("*************************");
        TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        //3- find all trader from Cambrdige and sort them by name
        System.out.println("************Task3***********");
        TransactionData.getAll().stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);

        //4- Return a string of all trader's names sorted alphabetically
        System.out.println("***************Task-4************");
        String result = TransactionData.getAll().stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(name1,name2)-> name1+name2 + " ");

        System.out.println(result);

        //5- Are any trader based in Milan?
        System.out.println("***********Task 5**************");
        boolean milanBased = TransactionData.getAll().stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //6-Print the values of all transaction from the traders living in Cambridge
        TransactionData.getAll().stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7- What is the highest value of all tranactions
        Optional<Integer> high =TransactionData.getAll().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(high.get());

        //8* find the Transaction with the smallest value
        System.out.println("***********Task -8 ***************");
        Optional<Transaction> smvalue = TransactionData.getAll().stream()
                .reduce((t1,t2)-> t1.getValue()<t2.getValue() ? t1: t2);

        System.out.println(smvalue.get());

        Optional<Transaction> smallestValue = TransactionData.getAll().stream()
                .min(comparing(Transaction::getValue));
        System.out.println(smallestValue.get());


    }
}
