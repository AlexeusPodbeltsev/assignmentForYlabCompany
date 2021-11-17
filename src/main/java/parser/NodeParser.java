package parser;

import comparator.AbstractComparator;
import constant.Constant;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NodeParser extends DefaultHandler {
    private String name;
    private boolean isActiveNode;
    private final AbstractComparator comparator;

    public NodeParser(AbstractComparator comparator) {
        this.comparator = comparator;
    }

    private boolean checkElement(Attributes attributes) {
        return attributes.getLength() > 0 && attributes.getLocalName(0).equals(Constant.IS_FILE);
    }

    private boolean isFile(Attributes attributes) {
        return attributes.getValue(Constant.IS_FILE).equals(Constant.TRUE);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        comparator.start();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isActiveNode = qName.equals(Constant.ACTIVE_NODE);
        if (checkElement(attributes)) {
            comparator.setIsFile(isFile(attributes));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isActiveNode) {
            name = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (name != null && !name.isEmpty()) {
            comparator.storeItem(name);
            if (comparator.compare(name)) {
                comparator.printFile(name);
            }
            name = null;
        }
        if (qName.equals(Constant.ACTIVE_NODE)) {
            isActiveNode = false;
        }
        if (qName.equals(Constant.INCLUDE_NODE)) {
            comparator.closeDirectory();
        }
    }


}

