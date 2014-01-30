c24-example-fpml
================

Use a C24 Transform to split out FpML trades, trade legs and cashflows

This is a simple example transform that reads in a file containing 25 FpML5-4 FX Swaps, and
extracts the trade details, the individual trade legs, and the cashflows into 3 separate files.

To build:

mvn clean install

To run:

mvn exec:java -Dexec.mainClass="biz.c24.io.examples.fpml.SplitTradesLegsAndCashflows"

This will produce 3 files in the project root:

trades.txt
legs.txt
cashflows.txt

The C24 models and transforms implementing this are found in src/main/c24/demoware/FpML/SplitTradesLegsAndCashflows

The simple main class that runs the transform is found in src/main/java/biz/c24/io/examples/fpml/SplitTradesLegsAndCashflows.java
