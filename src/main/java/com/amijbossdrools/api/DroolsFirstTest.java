package com.amijbossdrools.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.amijbossdrools.model.Product;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class DroolsFirstTest {

//	public static void main(String[] args) throws DroolsParserException,
//			IOException {
//		DroolsFirstTest droolsFirstTest = new DroolsFirstTest();
//		droolsFirstTest.executeDrools();
//	}
//
//	public void executeDrools() throws DroolsParserException, IOException {
//
//		PackageBuilder packageBuilder = new PackageBuilder();
//
//		String ruleFile = "/com/rules/drools.drl";
//		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
//
//		Reader reader = new InputStreamReader(resourceAsStream);
//		packageBuilder.addPackageFromDrl(reader);
//		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
//		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
//		ruleBase.addPackage(rulesPackage);
//
//		WorkingMemory workingMemory = ruleBase.newStatefulSession();
//
//		Product product = new Product();
//		product.setType("platinum");
//
//		workingMemory.insert(product);
//		workingMemory.fireAllRules();
//
//		System.out.println("The discount for the product " + product.getType()
//				+ " is " + product.getDiscount());
//	}

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			
			// Get the session named kseesion-rule that we defined in kmodule.xml above.
			
			// Also by default the session returned is always stateful. 
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			product.setType("platinum");

			FactHandle fact1;

			fact1 = kSession.insert(product);
			kSession.fireAllRules();

			System.out.println(
					"The discount for the jewellery product " + product.getType() + " is " + product.getDiscount());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}