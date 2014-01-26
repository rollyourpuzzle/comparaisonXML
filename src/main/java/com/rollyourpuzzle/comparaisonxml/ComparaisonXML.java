package com.rollyourpuzzle.comparaisonxml;

import java.io.FileReader;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;

public class ComparaisonXML {

	public static StringBuffer comparaison(String pFile1, String pFile2)
			throws Exception {
		FileReader fr1 = null;
		int countofdifferences = 0;
		FileReader fr2 = null;

		fr1 = new FileReader(pFile1);
		fr2 = new FileReader(pFile2);

		Diff lDiff = new Diff(fr1, fr2);
		MyDifferenceListener lListener = new MyDifferenceListener();
		lDiff.overrideDifferenceListener(lListener);
		// System.out.println("Similar? " + lDiff.similar());
		// System.out.println("Identical? " + lDiff.identical());

		DetailedDiff detDiff = new DetailedDiff(lDiff);

		@SuppressWarnings("unchecked")
		List<Difference> differences = detDiff.getAllDifferences();
		
		StringBuffer lResultat = new StringBuffer();

		for (Object object : differences) {

			Difference difference = (Difference) object;

			lResultat.append("------------------------");
			lResultat.append("\n");
			lResultat.append(difference.toString());
			lResultat.append("\n");
			lResultat.append("------------------------");
			lResultat.append("\n");
			countofdifferences++;
		}
		lResultat.append("\n");
		lResultat.append("Nombre total de différence : " + countofdifferences);
		
		return lResultat;
	}

}
