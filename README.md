# NFCforeCommerce
This is an application for integrating eCommerce with NFC tags. It is the first application in my NFC tutorial series. The flow is to register a customer with the nfc tag's unique id and then use that as the means to identify that user.

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  dependencies {
	        implementation 'com.github.OganBelema:NFCforeCommerce:0.1.0'
	}
