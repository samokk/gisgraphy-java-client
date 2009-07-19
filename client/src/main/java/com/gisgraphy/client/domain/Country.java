package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;

import com.ibm.icu.util.Currency;

/**
 * A Country as defined by ISO 3166. 
 * 
 * A country always has an ISO 3166 alpha2, alpha3 and numeric code, but may, or may not have 
 * other names (FIPS, ..). The list of countries has been imported from Geonames Country List.
 * 
 * Pay attention, as some countries do not have any currency !!! (ex: antarctica)
 * @see <a
 *      href="http://www.iso.org/iso/en/prods-services/popstds/countrynamecodes.html">Country Name Codes</a>
 * 
 */
public final class Country {
    public static class CountryBuilder {
	private IsoCountryCode isoCountryCode;
	private String name;
	private GisFeature gisFeature;
	private Continent continent;
	
	public CountryBuilder(String name) {
	    this.name = name;
	}
	
	public CountryBuilder withIsoCountryCode(IsoCountryCode isoCountryCode) {
	    this.isoCountryCode = isoCountryCode;
	    return this;
	}
	
	public CountryBuilder withContinent(Continent continent) {
	    this.continent = continent;
	    return this;
	}
	
	public Country andGisFeature(GisFeature gisFeature) {
	    this.gisFeature = gisFeature;
	    return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeature);
	}
    }
    
    
    private IsoCountryCode isoCountryCode;
    private String name;
    private GisFeature gisFeature;
    private Continent continent;
    
    private Currency currency;
    private FipsCountryCode fipsCountryCode;
    private AdministrativeCountryInformation administrativeCountryInformation = AdministrativeCountryInformation.administrativeCountryInformation();
    private GeographicCountryInformation geographicCountryInformation = GeographicCountryInformation.geographicCountryInformation();
    
    private Country(IsoCountryCode isoCountryCode, String name, Continent continent, GisFeature gisFeature) {
	super();
	
	Validate.notNull(isoCountryCode);
	Validate.notEmpty(name);
	Validate.notNull(continent);
	Validate.notNull(gisFeature);
	
	this.isoCountryCode = isoCountryCode;
	this.name = name;
	this.gisFeature = gisFeature;
	this.continent = continent;
    }
    
    private Country(IsoCountryCode isoCountryCode, String name, Continent continent, GisFeature gisFeature, Currency currency, FipsCountryCode fipsCountryCode, AdministrativeCountryInformation administrativeCountryInformation, GeographicCountryInformation geographicCountryInformation) {
	this(isoCountryCode, name, continent, gisFeature);
	this.currency = currency;
	this.fipsCountryCode = fipsCountryCode;
	this.administrativeCountryInformation = administrativeCountryInformation;
	this.geographicCountryInformation = geographicCountryInformation;
    }
    
    public static CountryBuilder countryName(String name)  {
	return new CountryBuilder(name);
    }
    
    public Country withCurrency(Currency currency) {
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeature, currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withFipsCountryCode(FipsCountryCode fipsCountryCode) {
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeature, this.currency, fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withAdministrativeCountryInformation(AdministrativeCountryInformation administrativeCountryInformation) {
	Validate.notNull(administrativeCountryInformation);
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeature, this.currency, this.fipsCountryCode, administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withGeographicCountryInformation(GeographicCountryInformation geographicCountryInformation) {
	Validate.notNull(geographicCountryInformation);
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeature, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, geographicCountryInformation);
    }

    public IsoCountryCode getIsoCountryCode() {
        return isoCountryCode;
    }

    public String getName() {
        return name;
    }

    public GisFeature getGisFeature() {
        return gisFeature;
    }

    public Continent getContinent() {
        return continent;
    }

    public Currency getCurrency() {
        return currency;
    }

    public FipsCountryCode getFipsCountryCode() {
        return fipsCountryCode;
    }

    public AdministrativeCountryInformation getAdministrativeCountryInformation() {
        return administrativeCountryInformation;
    }

    public GeographicCountryInformation getGeographicCountryInformation() {
        return geographicCountryInformation;
    }
    
    
}
