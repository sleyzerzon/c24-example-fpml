package biz.c24.io.examples.fpml;

import biz.c24.examples.fpml.bigfileoftrades.BigFileOfTradesDocumentRoot;
import biz.c24.examples.fpml.bigfileoftrades.BigFileOfTradesDocumentRootElement;
import biz.c24.examples.fpml.transforms.SplitTradesLegsAndCashflowsTransform;
import biz.c24.io.api.data.ValidationException;
import biz.c24.io.api.presentation.XMLSource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: stevemiller
 * Date: 30/01/2014
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class SplitTradesLegsAndCashflows {

    public static void main(String[] args) {

        try {

            FileReader fr = new FileReader("src/main/resources/valid-fx-ex26-fxswap-multiple-USIs.xml");
            XMLSource xmls = new XMLSource();
            xmls.setReader(fr);
            BigFileOfTradesDocumentRoot fpml = (BigFileOfTradesDocumentRoot)xmls.readObject(BigFileOfTradesDocumentRootElement.getInstance());
            SplitTradesLegsAndCashflowsTransform transform = new SplitTradesLegsAndCashflowsTransform();
            SplitTradesLegsAndCashflowsTransform.OutputWrapper ow = transform.transform(fpml);

            FileWriter fwt = new FileWriter("Trades.txt");
            FileWriter fwl = new FileWriter("Legs.txt");
            FileWriter fwc = new FileWriter("Cashflows.txt");
            fwt.write(ow.output1.toString());
            fwl.write(ow.output2.toString());
            fwc.write(ow.output3.toString());
            fwt.close();
            fwl.close();
            fwc.close();

        } catch (IOException|ValidationException e) {
            System.out.println("Problem: "+e.getMessage());
        }

    }
}
