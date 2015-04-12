package dmillerw.author.client.data;

import dmillerw.author.client.data.widget.Widget;

import java.util.List;
import java.util.Map;

/**
 * @author dmillerw
 */
public class Page {

    public String ident;
    public String type;
    public Map<String, Object> variables;

    public Template template;

    public List<Widget> widgets;
}
