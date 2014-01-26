package com.rollyourpuzzle.comparaisonxml;

import java.util.regex.Pattern;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

public class MyDifferenceListener implements DifferenceListener {


	public int differenceFound(Difference pDifference) {
		boolean lNotAnDifference = false;
		lNotAnDifference = pDifference.getId() == DifferenceConstants.ATTR_VALUE_ID
				&& pDifference.getControlNodeDetail().getXpathLocation()
						.contains("/Instances[1]/Head[1]/Key[1]/meta")
				&& pDifference.getControlNodeDetail().getXpathLocation()
						.contains("name")
				&& Pattern
						.matches(
								"[0-z]{8}[-]{1}[0-z]{4}[-]{1}[0-z]{4}[-]{1}[0-z]{4}[-]{1}[0-z]{12}",
								pDifference.getControlNodeDetail().getValue());
		int lRetour = 0;
				
		if (lNotAnDifference) {
			lRetour = RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
		}

		return lRetour;
	}


	public void skippedComparison(Node pNode1, Node pNode2) {
	}

}
