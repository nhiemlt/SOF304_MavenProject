package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

public class UIMap {
	private Properties properties;

	public UIMap(String filePath) {
		try (FileInputStream locatorStream = new FileInputStream(filePath)) {
			properties = new Properties();
			properties.load(locatorStream);
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file: " + filePath, e);
		}
	}

	public String getData(String elementName) {
		return properties.getProperty(elementName);
	}

	public By getLocator(String elementName) {
		String locator = properties.getProperty(elementName);
		if (locator == null) {
			throw new IllegalArgumentException("Locator for '" + elementName + "' not found in properties file.");
		}

		String[] locatorParts = locator.split(":");
		if (locatorParts.length != 2) {
			throw new IllegalArgumentException("Locator format for '" + elementName + "' is incorrect.");
		}

		String locatorType = locatorParts[0].toLowerCase();
		String locatorValue = locatorParts[1];

		switch (locatorType) {
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "classname":
		case "class":
			return By.className(locatorValue);
		case "tagname":
		case "tag":
			return By.tagName(locatorValue);
		case "linktext":
		case "link":
			return By.linkText(locatorValue);
		case "partiallinktext":
			return By.partialLinkText(locatorValue);
		case "cssselector":
		case "css":
			return By.cssSelector(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		default:
			throw new IllegalArgumentException("Unknown locator type: '" + locatorType + "'");
		}
	}
}
