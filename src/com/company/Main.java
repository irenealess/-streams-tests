package com.company;

import com.company.main.resource.Transaction;
import com.company.main.util.Chronometer;
import com.company.main.util.CollectionGenerator;
import com.company.main.util.MyStreams;

import java.util.List;

/**
 * Created by i.alessandrello on 4/9/2018.
 * https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
 */
public class Main {

    public static void main(String[] args) {
        //Call Java 7 style method


        System.out.println("\nTest method getSummarized2:");
        MyStreams.getSummarized2(CollectionGenerator.getBBTheoryList()).stream().forEach(t -> System.out.println(t.getName() + " " + t.getValue()));

        int n1 = 10000000;
        List<Transaction> transactions = CollectionGenerator.getLargeList(n1);

        System.out.println("\nTest method getSortedTransactions:");
        Chronometer responseTime1 = new Chronometer().start();
        MyStreams.getSortedTransactions(transactions);
        System.out.println(responseTime1.end() + " milliseconds");

        System.out.println("\nTest method getSortedTransactionsStream:");
        Chronometer responseTime2 = new Chronometer().start();
        MyStreams.getSortedTransactionsStream(transactions);
        System.out.println(responseTime2.end() + " milliseconds");

    }
}
