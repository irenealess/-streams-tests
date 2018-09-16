package com.company.main.util;

/**
 * Used to take time measures.
 */

public class Chronometer {


        private long start, pause;

        public Chronometer start() {
            start = System.currentTimeMillis();
            return this;
        }

        public long end() {
            return System.currentTimeMillis() - start;
        }

        public Chronometer startPause() {
            pause = System.currentTimeMillis();
            return this;
        }

        public Chronometer endPause() {
            start += System.currentTimeMillis() - pause;
            return this;
        }

        public boolean restartIfPassed(long limit) {
            if (limit < end()) {
                start();
                return true;
            }
            return false;
        }
}
