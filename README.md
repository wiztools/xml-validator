# WizTools.org XML Validator

To verify if the Schema compiles:

    $ java -jar xml-validator-VERSION-jar-with-dependencies.jar -s /path/to/schema.xsd

To validate an XML (or a set of XMLs) against a schema:

    $ java -jar xml-validator-VERSION-jar-with-dependencies.jar -s /path/to/schema.xsd \
      /path/to/1.xml /path/to/2.xml

To view help:

    $ java -jar xml-validator-VERSION-jar-with-dependencies.jar -h

This tool is available as part of _"The Joy of Unix in Windows Tool Bundle"_:

[![](http://static.wiztools.org/wiztools-cli-tools.png)](http://cli-bundle.wiztools.org/)
