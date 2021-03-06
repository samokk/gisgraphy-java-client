package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;
import static com.gisgraphy.client.commons.NameProviderObjectMother.twoPartsNameProvider;

import org.junit.Assert;
import org.junit.Test;

public class LongUsStyleNamesExtractorTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotAllowExtractingNamesWithLessThanThreeParts() {
		new ShortQualifiedNamesExtractor().extractNames(
			twoPartsNameProvider().getFullyQualifiedNameParts()).toString();
    }
    
    @Test public void shouldExtractAdm1CodeAndCity() {
	Assert.assertEquals("[California, Los Angeles]", 
		new LongUsStyleNamesExtractor().extractNames(
			losAngelesNameProvider().getFullyQualifiedNameParts()).toString());
    }
}
