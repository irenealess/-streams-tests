package com.company.main.util;

import com.company.main.business.IThing;
import com.company.main.business.Thing;
import com.company.main.resource.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class CollectionGenerator {

    private static Random rand = new Random();

    public static List<Transaction> getLargeList(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> new Transaction(rand.nextInt()))
                .collect(toList());
    }

    public static List<IThing> getBBTheoryList() {

        List<IThing> thingsList = new ArrayList<>();
        thingsList.add(new Thing("Sheldon Lee Cooper", 1L));
        thingsList.add(new Thing("Sheldon Lee Cooper", 1L));
        thingsList.add(new Thing("Leonard Leakey Hofstadter", 5L));
        thingsList.add(new Thing("Leonard Leakey Hofstadter", 3L));
        thingsList.add(new Thing("Penny", 1L));
        thingsList.add(new Thing("Howard Joel Wolowitz", 3L));
        thingsList.add(new Thing("Howard Joel Wolowitz", 3L));

        return thingsList;
    }


}
