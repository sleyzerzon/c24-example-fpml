c24-example-fpml
================

Build the examples with:

mvn clean package

Use a C24 Transform to split out FpML trades, trade legs and cashflows
----------------------------------------------------------------------

This is a simple example transform that reads in a file containing 25 FpML5-4 FX Swaps, and
extracts the trade details, the individual trade legs, and the cashflows into 3 separate files.

To run:

mvn exec:java -Dexec.mainClass="biz.c24.io.examples.fpml.SplitTradesLegsAndCashflows"

This will produce 3 files in the project root:

trades.txt
legs.txt
cashflows.txt

The C24 models and transforms implementing this are found in src/main/c24/demoware/FpML/SplitTradesLegsAndCashflows

The simple main class that runs the transform is found in src/main/java/biz/c24/io/examples/fpml/SplitTradesLegsAndCashflows.java


Use an existing XSLT against a parsed FpML object tree
------------------------------------------------------

This example reads in a single FpML request confirmation and shows how to run an XSLT over
the in-memory result.

To run:

mvn exec:java -Dexec.mainClass="biz.c24.io.examples.fpml.XSLTDemo"

It uses the src/main/resources/reqConf.xslt file to extract a few fields from the source
document and writes the result to standard out. reqConf.xslt includes funcs.xsl which defines 
a simple function and itself calls out to a Java function to perform some of its work 
(a static method called 'lookup' in the XSLTDemo class).

The source code can be found in src/main/java/biz/c24/io/examples/fpml/XSLTDemo.java
