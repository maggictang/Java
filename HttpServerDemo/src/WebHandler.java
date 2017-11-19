
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class WebHandler extends DefaultHandler {
	private String tag;
	private Entity entity;
	private Mapping mapping;
	private boolean isMap;
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	
	
	
	public List<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Entity> entityList) {
		this.entityList = entityList;
	}

	
	public List<Mapping> getMappingList() {
		return mappingList;
	}

	public void setMappingList(List<Mapping> mappingList) {
		this.mappingList = mappingList;
	}

	@Override
	public void startDocument() throws SAXException {
		entityList = new ArrayList<Entity>();
		mappingList = new ArrayList<Mapping>();
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		if(null != arg2) {
			tag = arg2;
			if("servlet".equals(arg2)) {
				entity =new Entity();
			}
			if("servlet-mapping".equals(arg2)) {
				mapping = new Mapping();
				isMap = true;
			}
		}
		
	}

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {	
		if(null != tag) {
			String str = new String(arg0,arg1,arg2);
			if(isMap == false) {
				if("servlet-name".equals(tag)) {
					entity.setName(str);
				}
				if("servlet-class".equals(tag)) {
					entity.setClz(str);
				}
			}
			else {
				if("servlet-name".equals(tag)) {
					mapping.setName(str);
				}
				if("url-pattern".equals(tag)) {
					mapping.setUrl(str);
				}		
			}
		}
	}
	
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		if(null != arg2) {
			if("servlet".equals(arg2)) {
				entityList.add(entity);
			}
			if("servlet-mapping".equals(arg2)) {
				mappingList.add(mapping);
			}
		}
		tag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
	
	public void getUrlPattern() {
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parse = factory.newSAXParser();
		WebHandler  web = new WebHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), web);
		
		System.out.println(web.getEntityList().get(0).getName());
	}
		
}
