package com.company.main.util;

import com.company.main.business.IThing;
import com.company.main.business.Thing;
import com.company.main.resource.Transaction;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class MyStreams {

    private static MyStreams INSTANCE;

    private MyStreams() {}

    public static MyStreams getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new MyStreams();
        }
        return INSTANCE;
    }

    public static List getSortedTransactions(List<Transaction> groceryTransactions) {
        /*
        Let’s say we need to find all transactions of type grocery
        and return a list of transaction IDs sorted
        in decreasing order of transaction value.
        In Java SE 7, we’d do that as shown in Listing 1.
        */

        List<Transaction> transactions = new ArrayList<>();
        List<Integer> transactionsIds = new ArrayList<>();

        for (Transaction t : groceryTransactions) {
            if (t.getType().equals(Transaction.GROCERY)) {
                transactions.add(t);
            }
        }

        Collections.sort(transactions);

        for (Transaction t : transactions) {
            transactionsIds.add(t.getId());
        }

        return transactionsIds;
    }

    public static List getSortedTransactionsStream(List<Transaction> groceryTransactions) {
        //In Java SE 8, we’d do it as shown in Listing 2.
        return groceryTransactions.stream()
                .filter(t -> t.getType().equals(Transaction.GROCERY))
                //.sorted(comparing(Transaction::getId).reversed())
                .sorted(comparing(Transaction::getId))
                .map(Transaction::getId)
                .collect(Collectors.toList());

    }

    public static List summarizedList(List<Transaction> groceryTransactions) {
        //In Java SE 8, we do it as shown in Listing 2.
        return groceryTransactions.stream()
                .filter(t -> t.getType().equals(Transaction.GROCERY))
                //.sorted(comparing(Transaction::getId).reversed())
                .sorted(comparing(Transaction::getId))
                .map(Transaction::getId)
                .collect(Collectors.toList());
    }

    public static Collection<IThing> getSummarized(Collection<IThing> thingList) {

        List<IThing> summarizedList = new ArrayList<>();
        Map<String, Long> summarizedMap = new HashMap<>();

        for (IThing m : thingList) {
            if (summarizedMap.get(m.getName()) != null) {
                Long sum = summarizedMap.get(m.getName());
                Long sumValue = sum + m.getValue();
                summarizedMap.put(m.getName(), sumValue);
            } else {
                summarizedMap.put(m.getName(), m.getValue());
            }
        }
        summarizedMap.forEach((k, v) -> summarizedList.add(new Thing((String) k, (Long) v)));
        return summarizedList;
    }

    public static Collection<IThing> getSummarized2(Collection<IThing> thingList) {

        Map<String, IThing> summarizedSet = new HashMap<>();

        for (IThing m : thingList) {
            Long sumValue = thingList
                    .stream()
                    .filter(t -> t.getName().equals(m.getName()))
                    .mapToLong(IThing::getValue)
                    .sum();

            summarizedSet.put(m.getName(), new Thing(m.getName(), sumValue));
        }

        return summarizedSet.values();

    }

}
