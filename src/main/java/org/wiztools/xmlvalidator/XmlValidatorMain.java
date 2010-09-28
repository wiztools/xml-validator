package org.wiztools.xmlvalidator;

import com.sampullara.cli.Args;
import com.sampullara.cli.Argument;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.validation.Schema;
import org.xml.sax.SAXException;

/**
 *
 * @author subWiz
 */
public class XmlValidatorMain {
    @Argument(value="s", alias="wxs")
    private String wxsSchema;

    @Argument(value="r", alias="rng")
    private String rngSchema;

    @Argument(value="h", alias="help")
    boolean isHelp;

    public static void main(String[] arg) throws IOException {
        XmlValidatorMain parser = new XmlValidatorMain();
        List<String> extras = Args.parse(parser, arg);

        if(parser.isHelp) {
            Args.usage(parser);
            System.exit(0);
        }

        if(parser.rngSchema == null && parser.wxsSchema == null) {
            System.err.println("Needs atleast -s or -r parameter.");
            Args.usage(parser);
            System.exit(1);
        }

        // Compile the schemas:
        Schema wxs = null;
        try{
            wxs = parser.wxsSchema!=null? SchemaUtil.getWXSSchema(new File(parser.wxsSchema)): null;
        }
        catch(SAXException ex) {
            System.err.println("Error compiling schema: " + parser.wxsSchema);
            ex.printStackTrace(System.err);
        }
        Schema rng = null;
        try{
            rng = parser.rngSchema!=null? SchemaUtil.getRNGSchema(new File(parser.rngSchema)): null;
        }
        catch(SAXException ex) {
            System.err.println("Error compiling schema: " + parser.rngSchema);
            ex.printStackTrace(System.err);
        }

        // Validate the XML files against the schemas:
        for(String f: extras) {
            try{
                if(wxs != null) SchemaUtil.validate(wxs, new File(f));
            }
            catch(SAXException ex) {
                System.err.println("Error validating [" + f + "] against [" + parser.wxsSchema + "]");
                ex.printStackTrace(System.err);
            }
            try{
                if(rng != null) SchemaUtil.validate(rng, new File(f));
            }
            catch(SAXException ex) {
                System.err.println("Error validating [" + f + "] against [" + parser.rngSchema + "]");
                ex.printStackTrace(System.err);
            }
        }
     }
}
