package biz.c24.io.examples.fpml;

import biz.c24.io.api.data.IOXPath;
import biz.c24.io.api.data.IOXPathException;
import biz.c24.io.api.data.IOXPathFactory;
import biz.c24.io.api.data.saxon.DocumentNode;
import biz.c24.io.api.data.saxon.IoSaxonUtils;
import biz.c24.io.api.presentation.XMLSource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

import org.fpml.x2012.fpml54.rec20121210.confirmation.Fpmlconfirmationprocesses54DocumentRoot;
import org.fpml.x2012.fpml54.rec20121210.confirmation.Fpmlconfirmationprocesses54DocumentRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: stevemiller
 * Date: 30/01/2014
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class XSLTDemo {
	
	/**
	 * Sample lookup function to show calling back from XSLT to Java
	 * @param code
	 * @return
	 */
	public static String lookup(String code) {
		if("DEUTDEFF".equals(code)) {
			return "Deutsche Bank (DEUTDEFF)";
		} else {
			return code;
		}
	}

    public static void main(String[] args) {

        try {
        	
        	// Load the FpML document

            FileReader fr = new FileReader("src/main/resources/valid-fx-ex26-fxswap-single-USI.xml");
            XMLSource xmls = new XMLSource();
            xmls.setReader(fr);
            Fpmlconfirmationprocesses54DocumentRoot fpml = (Fpmlconfirmationprocesses54DocumentRoot)xmls.readObject(Fpmlconfirmationprocesses54DocumentRootElement.getInstance());

            
            // Run a sample XPath query over the document tree
 
            IOXPath xpath = IOXPathFactory.getInstance("//*");
            List list = xpath.getList(fpml);          
            System.out.println("Number of elements matched: " + list.size());
            
            
            // Run an existing XSLT file over the loaded FpML document
            
            Processor processor = new Processor(IoSaxonUtils.getDefaultConfiguration());
            XsltCompiler compiler = processor.newXsltCompiler();
            XsltExecutable exe = compiler.compile(new StreamSource(new File("src/main/resources/reqConf.xslt")));
            
            XsltTransformer xform = exe.load();
            xform.setSource(new DocumentNode(IoSaxonUtils.getDefaultConfiguration(), fpml, false, true));
            xform.setDestination(new Serializer(System.out));
            
            xform.transform();           

        } catch (IOException | IOXPathException | SaxonApiException e) {
            System.err.println("Problem: "+e.getMessage());
        }

    }
}
